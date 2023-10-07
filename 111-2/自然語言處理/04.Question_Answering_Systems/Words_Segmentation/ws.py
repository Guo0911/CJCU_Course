import json, jieba, time

jieba.set_dictionary("data/jieba/dict.txt.big")  # 導入 Jieba 繁體中文辭典

with open("data/jieba/StopWords.txt", "r", encoding="utf-8") as s:  # 導入 Stop word
    StopWords = [i.replace("\n", "") for i in s.readlines()]
    StopWords[0] = "\n"

start = time.time()

word_dict = {} # 儲存詞的編號
def ws(content):
    toStopWords = jieba.lcut(content)
    new_content = [] # 儲存分詞後的句子

    for word in toStopWords:
        if word not in StopWords:
            if word not in word_dict:
                word_dict[word] = str(len(word_dict))

            new_content.append(word_dict[word])

    return new_content


new_dataset = {}
with open("data/Gossiping-QA-Dataset.txt", "r", encoding="utf-8") as d:
    while True:
        data = d.readline()

        if(data == ""):
            break

        data = data.replace(" ", "") # 去除原始文章的空格
        data = data.split("	") # 將問題與答案切開

        new_dataset[len(new_dataset)] = [ws(data[0]), data[1]]


print(f'ws time: {time.time() - start}')

with open("result/dataset.json", "w", encoding="utf-8") as nd:
    json.dump(new_dataset, nd, ensure_ascii=False, indent=4)

with open("result/word_dict.json", "w" , encoding="utf-8") as wd:
    json.dump(word_dict, wd, ensure_ascii=False, indent=4)