import json, time
import pandas as pd
import matplotlib.pyplot as plt

start = time.time() # 紀錄開始的時間


# -------------------------------讀取無聲調注音辭典並記錄每個字的注音------------------------------
zhuyin = {} # 用於對應所有字與無聲調注音的 dict，例如：{"我":"ㄨㄛ"}
with open('./data/Word2Phoneme.dic', 'r', encoding='utf-8') as d:
    word = d.readlines() # 讀取所有資料，並存入陣列，將每行分開存放
    for w in word: # 依序執行陣列中每個元素
        w_z = w.replace('\n', '').split(',') # 將 \n 去除後，以「,」隔成陣列
        if len(w_z) > 1: # 如果 len(a) > 1 代表該字有注音，len(a) == 1 代表沒有對應注音
            zhuyin[w_z[0]] = w_z[1] # 將字與其注音存入字典中
# ----------------------------------------------------------------------------------------------


# ------------------------------------------------計算注音出現的次數------------------------------------------------
phoneme = {} # 用於存放所有注音出現次數的 dict
for i in range(12549, 12586): # ㄅ的ascii為12549；ㄦ的ascii為12583
    phoneme[chr(i)] = 0

times = 0 # 計算執行的筆數，以利判斷程式是否正常執行
with open('./data/GigaWord_text_lm', 'r', encoding='utf-8') as f:
    c = f.readline().replace('\n', '').replace(' ', '') # 把已經斷好的詞變回句子 : 「萬國 商業 集團」 → 「萬國商業集團」

    while(c != ''): # 若已經做完檔案裡所有的資料，則最後 readline() 會得到空字串，因此若是空字串就不進入 while 內
        times += 1

        for w in c: # 如果對 string 做 for 迴圈，則會依序將字串每個字放入變數中
            w_zhuyin = zhuyin[w] # 將當前文字的注音放入 w_zhuyin 內，假如 w 為「我」，則 w_zhuyin 為「ㄨㄛ」
            for w_z in w_zhuyin: # 將當前文字的每個注音依序放入 w_z
                phoneme[w_z] += 1 # 將當前注音在 phoneme 的次數增加1次

        c = f.readline().replace('\n', '').replace(' ', '') # 當前句子完成，因此需要更新下一句的句子

end = time.time() # 紀錄結束時間

with open('./result/phoneme/count.json', 'w', encoding='utf-8') as c:
    json.dump(phoneme, c, ensure_ascii=False, indent=4) # 將所有注音出現的次數存為 json 檔
# -----------------------------------------------------------------------------------------------------------------


#-------------------------計算詞出現的頻率-------------------------
frequency = {} # 宣告一個儲存注音出現頻率的 dict 型態變數

total = 0
for i in phoneme.keys():
    total += phoneme[i]

for i in phoneme.keys():
    frequency[i] = (phoneme[i] / total) # 計算頻率

with open('./result/phoneme/frequency.json', 'w', encoding='utf-8') as j:
    json.dump(frequency, j, ensure_ascii=False, indent=4)
#-----------------------------------------------------------------


#--------用於調整 plt 的字體，否則中文字無法正常顯示--------
plt.rcParams['font.sans-serif'] = ['Microsoft JhengHei']
plt.rcParams['axes.unicode_minus'] = False
#--------------------------------------------------------


#-------------------------------繪製注音出現次數的曲線圖--------------------------------------
phoneme = sorted(phoneme.items(), key=lambda x: x[1], reverse=True) # 將次數由大到小排序
phoneme = pd.DataFrame(list(phoneme), columns=['zhuyin', 'times'])
# 將 list 轉為 DataFrame 型態，後續才可繼續繪製

plt.title('所有注音出現的次數') # 圖表標題
plt.plot(phoneme['zhuyin'], phoneme['times'], color='blue') # 圖表的 X 軸數值、Y 軸數值、曲線顏色
plt.xticks(phoneme['zhuyin']) # X 軸的刻度
plt.savefig('./result/phoneme/painting/count.png') # 儲存曲線圖
plt.close() # 關閉 plt 否則下方會重疊
#-------------------------------------------------------------------------------------------


#-------------------------------繪製注音出現頻率的曲線圖--------------------------------------
frequency = sorted(frequency.items(), key=lambda x: x[1], reverse=True) # 將頻率由大到小排序
frequency = pd.DataFrame(list(frequency), columns=['zhuyin', 'percent'])
# 將 list 轉為 DataFrame 型態，後續才可繼續繪製

plt.title('所有注音出現的頻率') # 圖表標題
plt.plot(frequency['zhuyin'], frequency['percent'], color='red') # 圖表的 X 軸數值、Y 軸數值、曲線顏色
plt.xticks(frequency['zhuyin']) # X 軸的刻度
plt.savefig('./result/phoneme/painting/frequency.png') # 儲存曲線圖
plt.close() # 關閉 plt
#-------------------------------------------------------------------------------------------

print("總共計算", times, "句")
print("使用時間", (end - start), "秒")