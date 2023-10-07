import time
import pandas as pd
import matplotlib.pyplot as plt

with open('./data/GigaWord_text_lm', 'r', encoding='utf-8') as d:
    data = d.readlines()

with open('./data/lexicon1_raw_nosil.txt', 'r', encoding='utf-8') as d:
    lexicon_file = d.readlines()

    for i in range(len(lexicon_file)):
        lexicon_file[i] = lexicon_file[i].split(' ')[0]
    lexicon_file = set(lexicon_file)

word_times = {'</s>': 0}  # 紀錄詞出現的次數


def train(data):
    lexicon = {}
    MaxLen = 0

    for i in range(len(data)):
        data[i] = data[i].replace('\n', '')
        w = data[i].split(' ')
        w = ['<s>'] + w + ['</s>']

        for t in range(1, len(w)):
            if(w[t-1] not in lexicon):
                lexicon[w[t-1]] = [1, {w[t]: 1}]  # [總次數, {詞n: 出現次數}]
                word_times[w[t-1]] = 0
            else:
                lexicon[w[t-1]][0] += 1
                if(w[t] not in lexicon[w[t-1]][1]):
                    lexicon[w[t-1]][1][w[t]] = 1
                else:
                    lexicon[w[t-1]][1][w[t]] += 1

            if (len(w[t]) > MaxLen):
                MaxLen = len(w[t])

    for l in lexicon.keys():
        times = lexicon[l][0]
        temp = lexicon[l][1]

        for i in temp.keys():
            temp[i] = (temp[i]/times)
        lexicon[l] = temp

    return lexicon, MaxLen


def create_wordnet(content, lexicon, MaxLen):
    word_net = {}
    word_index = {}
    index = 0
    while (len(content) != 0):  # 若該句子還有字則繼續執行
        now = []
        w = content[:MaxLen]
        while (len(w) > 0):
            while (w not in lexicon):
                if len(w) == 1:
                    break
                else:
                    w = w[:-1]

            now.append(w)
            w = w[:-1]

        word_net[index] = now
        word_index[index] = content[0]
        index += 1
        content = content[1:]

    return word_net, word_index


def bigram(word_net, lexicon):
    paths = {0: ['<s>']}
    probability = {0: 1}
    prob_of_best = 0

    prob_low = {}  # 存放機率較低的句子，避免某句子機率較高，但後續沒有在辭典變成機率0
    while len(paths):

        new_path = {}
        for index in paths.keys():
            if index not in word_net:
                prob_of_best = max(prob_of_best, probability[index])
                path_of_best = paths[index] + ['</s>']
                continue

            nexts = word_net[index]
            for next in nexts:
                if (next in lexicon[paths[index][-1]]):
                    prob = (probability[index] *
                            lexicon[paths[index][-1]][next])

                    next_index = index + len(next)

                    if (next_index not in probability) or (prob > probability[next_index]):
                        if (next_index in new_path):
                            if (next_index in prob_low):
                                prob_low[next_index][probability[next_index]
                                                     ] = new_path[next_index]
                            else:
                                prob_low[next_index] = {
                                    prob: new_path[next_index]}

                        probability[next_index] = prob
                        new_path[next_index] = paths[index] + [next]
                    else:
                        if (next_index in prob_low):
                            prob_low[next_index][prob] = paths[index] + [next]
                        else:
                            prob_low[next_index] = {
                                prob: paths[index] + [next]}

                elif (index in prob_low):
                    new_path[index] = prob_low[index][max(
                        prob_low[index].keys())]
                    del prob_low[index][max(prob_low[index].keys())]

                    if (prob_low[index] == {}):
                        del prob_low[index]

        paths = new_path

        if (paths == {}) and (prob_of_best == 0) and (prob_low != {}):
            temp = list(prob_low.keys())
            for index in temp:
                paths[index] = prob_low[index][max(prob_low[index].keys())]
                del prob_low[index][max(prob_low[index].keys())]

                if (prob_low[index] == {}):
                    del prob_low[index]

    return path_of_best, prob_of_best


def word2ind(word_list):
    set1 = set()
    ind = 1
    for w in word_list:
        set1.add("[" + str(ind) + "," + str(ind + len(w) - 1) + "]")
        ind += len(w)
    return set1


run_time = time.time()
lexicon, MaxLen = train(data)
print("訓練花費: ", round((time.time() - run_time), 6), "秒")

tp = 0  # TP 初始化
fp = 0  # FP 初始化
fn = 0  # FN 初始化

run_time = time.time()
num_of_docs = 0
for content in data:
    num_of_docs += 1

    if (num_of_docs % 100000) == 0:
        print(f'{str(num_of_docs).zfill(8)}:  {time.time() - run_time}')

    original = ['<s>'] + content.split(' ') + ['</s>']

    content = content.replace(' ', '')

    word_net, word_index = create_wordnet(content, lexicon_file, MaxLen)

    path, prob = bigram(word_net, lexicon)

    for p in path:
        word_times[p] += 1

    A = word2ind(original)
    B = word2ind(path)
    TP = A.intersection(B)

    tp += len(TP)
    fp += (len(B) - len(TP))
    fn += (len(A) - len(TP))

run_time = (time.time() - run_time)
print("\n總計花費: ", round(run_time, 6), "秒")

print("執行筆數: ", num_of_docs)
p = round((tp / (tp + fp)), 6)
r = round((tp / (tp + fn)), 6)
f1 = round(((2 * p * r) / (p + r)), 6)
print("模型表現: P:", p, "R:", r, "F1:", f1)


word_times['<s>'] = 0
word_times['</s>'] = 0
# --------用於調整 plt 的字體，否則中文字無法正常顯示--------
plt.rcParams['font.sans-serif'] = ['Microsoft JhengHei']
plt.rcParams['axes.unicode_minus'] = False
# --------------------------------------------------------

# -------------------------------繪製詞出現次數前 100 名的曲線圖--------------------------------------
word_times = (sorted(word_times.items(),
              key=lambda x: x[1], reverse=True))  # 將次數由大到小排序
for i in range(1, 11):
    word_times_10 = pd.DataFrame(
        list(word_times[(10 * (i - 1)):(10 * i)]), columns=['words', 'times'])

    plt.title(f'詞出現的次數 No.{(10 * (i - 1)) + 1} ~ No.{10 * i}')  # 圖表標題
    plt.plot(word_times_10['words'], word_times_10['times'],
             color='blue')  # 圖表的 X 軸數值、Y 軸數值、曲線顏色
    plt.xticks(word_times_10['words'])  # X 軸的刻度
    plt.savefig(f'./result/{str(i).zfill(3)}.png')  # 儲存曲線圖
    plt.close()  # 關閉 plt 否則後續會錯誤
# ---------------------------------------------------------------------------------------------------
