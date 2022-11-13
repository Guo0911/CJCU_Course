# **Program**

以下為各個程式碼的用途說明:

1. Rename_Datset.py:  
依照資料集中檔案所讀取順序進行編號命名，並將編號對應原始檔名的對應表儲存至**result**資料夾的**id2name.json**

2. Dataset_Sort2Fold.py:  
將原始資料集按照編號順序分類至5份資料集中

3. Count_of_Fold.py:  
計算每份資料集中的物件數量，並將該資訊儲存至**result**資料夾的**count_of_fold.json**

4. Create_Dataset.py:  
提供使用者輸入要當testset的資料集編號，並自動分配至**dataset/train**\* 及**dataset/test**\* 中

5. Ground_to_Json.py:  
計算原始資料集的每份檔案所包含的物件類別及座標，並儲存至**result/PRF1/Ground**的**Ground.json**\* 

6. Detect_to_Json.py:  
計算模型所辨識的檔案中所包含的物件類別及座標<sup>!</sup>，並儲存至**result/PRF1/Detect**\*中按照編號命名的json檔案\*

7. Json_to_PRF1.py:  
計算模型辨識結果的Precision、Recall、F1-score，並儲存至**result/PRF1/Result**\*的csv檔案\*

>>\*已被隱藏的目錄或檔案  
>><sup>!</sup>辨識結果之資料未公開，若有需求請以mail聯繫109B30612@mailst.cjcu.edu.tw