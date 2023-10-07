import time
import pandas as pd
import matplotlib.pyplot as plt

def word2ind(word_list):
    set1 = set()
    ind = 1
    for w in word_list:
        set1.add("[" + str(ind) + "," + str(ind + len(w) - 1) + "]")
        ind += len(w)
    return set1

with open("./Data/lexicon1_raw_nosil.txt", "r", encoding="utf-8") as f:
    lines = f.readlines() # 讀取詞典檔案資料，並存入陣列，將每行分開儲存

lexicon = {} # 宣告詞典變數
MaxLen = 0

for i in range(len(lines)):
    word = lines[i].split(" ")[0] # 將每行的詞取出
    word = word.replace("\n", "")
    lexicon[word] = 0 # 將詞加入詞典，並設定出現次數為0次
    if(len(word) > MaxLen):
        MaxLen = len(word)

tp = 0 # TP 初始化
fp = 0 # FP 初始化
fn = 0 # FN 初始化

start = time.time() # 紀錄開始時間
num_of_docs = 0 # 計算執行筆數，以裡判斷程式是否執行所有資料
with open("./Data/GigaWord_text_lm", "r", encoding="utf-8") as f:
    
    while True:
        doc = f.readline().replace("\n", "")
        
        if doc == "":
            break
        
        num_of_docs += 1 # 將執行的筆數 + 1
        
        s1 = doc.replace(" ", "") # 儲存完整句子
        doc = doc.split(" ") # 儲存標準斷詞答案
        content_ws = [] # 儲存執行斷詞的結果

        while (len(s1) != 0): # 若該句子還有字則繼續執行
            w = s1[((MaxLen)*-1):]

            while (w not in lexicon):
                w = w[1:]
                if len(w) == 1:
                    break
            
            lexicon[w] += 1
            content_ws.append(w)
            s1 = s1[:(len(s1)-len(w))]

        content_ws = content_ws[::-1]
        A = word2ind(doc)
        B = word2ind(content_ws)
        TP = A.intersection(B)

        tp += len(TP)
        fp += (len(B) - len(TP))
        fn += (len(A) - len(TP))


print("已完成筆數: ", num_of_docs)
p  = round((tp / (tp + fp)), 4)
r  = round((tp / (tp + fn)), 4)
f1 = round(((2 * p * r) / (p + r)), 4)
print("P:", p, "R:", r, "F1:", f1)

end = time.time()
print("總計花費: ", round((end - start), 6), "秒")

#--------用於調整 plt 的字體，否則中文字無法正常顯示--------
plt.rcParams['font.sans-serif'] = ['Microsoft JhengHei']
plt.rcParams['axes.unicode_minus'] = False
#--------------------------------------------------------

#-------------------------------繪製詞出現次數前 100 名的曲線圖--------------------------------------
lexicon = (sorted(lexicon.items(), key=lambda x: x[1], reverse=True)) # 將次數由大到小排序
for i in range(1, 11):
    lexicon_10 = pd.DataFrame(list(lexicon[(10 * (i - 1)):(10 * i)]), columns=['words', 'times'])

    plt.title(f'詞出現的次數 No.{(10 * (i - 1)) + 1} ~ No.{10 * i}') # 圖表標題
    plt.plot(lexicon_10['words'], lexicon_10['times'], color='blue') # 圖表的 X 軸數值、Y 軸數值、曲線顏色
    plt.xticks(lexicon_10['words']) # X 軸的刻度
    plt.savefig(f'./Result/BMM/{str(i).zfill(3)}.png') # 儲存曲線圖
    plt.close() # 關閉 plt 否則後續會錯誤
#---------------------------------------------------------------------------------------------------