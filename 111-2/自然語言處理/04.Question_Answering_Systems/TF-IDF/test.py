import json, jieba, math, time

print("loading...")

jieba.set_dictionary("data/jieba/dict.txt.big")  # 導入 Jieba 繁體中文辭典

with open("data/jieba/StopWords.txt", "r", encoding="utf-8") as s:  # 導入 Stop word
    StopWords = [i.replace("\n", "") for i in s.readlines()]
    StopWords[0] = "\n"

print("Jieba ready.")

with open("data/dataset.json", "r", encoding="utf-8") as d:
    dataset = json.load(d)

with open("data/word_dict.json", "r", encoding="utf-8") as wd:
    word_dict = json.load(wd)

with open("result/idf.json", "r", encoding="utf-8") as i:
    idf = json.load(i)

with open("result/tfidf.json", "r", encoding="utf-8") as ti:
    model_tfidf = json.load(ti)

with open("result/model_vector.json", "r", encoding="utf-8") as mv:
    model_vector = json.load(mv)

print("model ready.")


def ws(content):
    toStopWords = jieba.lcut(content)
    new_content = [] # 儲存分詞後的句子

    for word in toStopWords:
        if word not in StopWords:
            if word not in word_dict:
                word_dict[word] = str(len(word_dict))

            new_content.append(word_dict[word])

    return new_content


def TF(dataset):
    tf = {}
    for d in dataset.keys():
        tf[d] = {}

        data = dataset[d][0] # 取出第 d 筆資料的問題
        data_set = set(data) # 讓問題內所有詞出現一次，避免重複計算
        for i in data_set: # data = [1,2,3,3,4,5], data_set = (1,2,3,4,5)
            tf[d][i] = (data.count(i) / len(data))
        
    return tf


def TFIDF(tf, idf):
    tfidf = {}
    
    for d in tf.keys():
        tfidf[d] = {}
        for i in tf[d].keys():
            if (i in idf):
                tfidf[d][i] = tf[d][i] * idf[i]
    
    return tfidf


def Vector(tfidf):
    vector = {}
    for d in tfidf.keys():
        vector[d] = 0
        for i in tfidf[d].keys():
            vector[d] += math.pow(tfidf[d][i], 2)
        vector[d] = math.sqrt(vector[d])
    
    return vector


def similarity(model_vector, model_tfidf, question_tfidf):
    question_vector = Vector(question_tfidf)
    if (question_vector["question"] == 0.0):
        return "-1"
    
    predict = "-1"
    probability = 0

    for d in model_vector:
        if (model_vector[d] > 0):
            denominator = (model_vector[d] * question_vector["question"])
            molecular = 0
            for i in question_tfidf["question"].keys():
                if (i in model_tfidf[d]):
                    molecular += (model_tfidf[d][i] * question_tfidf["question"][i])

            if ((molecular / denominator) > probability):
                predict = d
                probability = (molecular / denominator)

    return predict


true = 0
false = 0
no_result = 0
num_of_docs = 0
with open("data/Gossiping-QA-Dataset.txt", "r", encoding="utf-8") as ds:
    start = time.time()
    while (num_of_docs < 1000):
        original = ds.readline()
        original = original.replace(" ", "") # 去除原始文章的空格
        original = original.split("	") # 將問題與答案切開
        
        question = "".join(original[0])
        
        question = {"question": [ws(question)]}

        question_tf = TF(question)

        question_tfidf = TFIDF(question_tf, idf)

        predict = similarity(model_vector, model_tfidf, question_tfidf)

        if (predict == "-1"):
            no_result += 1
        elif (dataset[predict][1] == original[1]):
            true += 1
        else:
            false += 1

        num_of_docs += 1

        if ((num_of_docs % 100) == 0):
            end = time.time()
            print(num_of_docs, "time:", (end-start))
            print("true:", true, ", false:", false, ", no result:", no_result)
    
    end = time.time()
