import json, math, time

with open("data/dataset.json", "r", encoding="utf-8") as d:
    dataset = json.load(d)


def TF(dataset):
    tf = {}
    for d in dataset.keys():
        tf[d] = {}

        data = dataset[d][0] # 取出第 d 筆資料的問題
        data_set = set(data) # 讓問題內所有詞出現一次，避免重複計算
        for i in data_set: # data = [1,2,3,3,4,5], data_set = (1,2,3,4,5)
            tf[d][i] = (data.count(i) / len(data))
        
    return tf


def IDF(dataset, num_of_class):
    idf = {}
    for d in dataset.keys():
        data = dataset[d][0]
        data_set = set(data)

        for i in data_set:
            if (i not in idf):
                idf[i] = 1
            else:
                idf[i] += 1
    
    for i in idf.keys():
        idf[i] = math.log(num_of_class / idf[i])

    return idf


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

start = time.time()
tf = TF(dataset)
print(f'tf time: {time.time() - start}')

start = time.time()
idf = IDF(dataset, len(tf))

print(f'idf time: {time.time() - start}')

start = time.time()
tfidf = TFIDF(tf, idf)

print(f'tfidf time: {time.time() - start}')

start = time.time()
model_vector = Vector(tfidf)

print(f'vector time: {time.time() - start}')

with open("result/tf.json", "w", encoding="utf-8") as t:
    json.dump(tf, t, indent=4)
with open("result/idf.json", "w", encoding="utf-8") as i:
    json.dump(idf, i, indent=4)
with open("result/tfidf.json", "w", encoding="utf-8") as ti:
    json.dump(tfidf, ti, indent=4)
with open("result/model_vector.json", "w", encoding="utf-8") as mv:
    json.dump(model_vector, mv, indent=4)
