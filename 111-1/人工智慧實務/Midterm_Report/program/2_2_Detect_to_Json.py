import os, json


def search_max_data(folder_list, conf=-1): # 取指定的confidence(預設-1代表不限制)中最後一個產出的結果
    max_time = 0
    max_folder = ''
    for i in folder_list:
        folder_time = int("".join(i.split('_')[-2:]))
        if (max_time < folder_time):
            if (conf >= 0):
                if (f'conf{conf}' in i):
                    max_folder = i
            else:
                max_folder = i

    return max_folder

for conf in [10, 25, 50, 75]:
    path_detect = f"../result/Detect/{search_max_data(os.listdir('../result/Detect'), conf)}"
    path_json = '../result/PRF1/Detect'

    epochs = os.listdir(path_detect)
    for epoch in epochs:
        folds = os.listdir(f'{path_detect}/{epoch}')
        for fold in folds:
            now = {}

            files = os.listdir(f'{path_detect}/{epoch}/{fold}/labels')
            for file in files:
                Id = file.replace('.txt', '')
                now[Id] = {}

                f = open(f'{path_detect}/{epoch}/{fold}/labels/{file}')
                
                objs = f.readlines()
                for obj in objs:
                    obj = obj.replace('\n', '').split(',')
                    name, index = obj[0], obj[1:]
                    if name not in now[Id]:
                        now[Id][name] = [",".join(index)]
                    else:
                        now[Id][name].append(",".join(index))
                
                f.close()

            if not os.path.isdir(f'{path_json}/{epoch}'):
                os.mkdir(f'{path_json}/{epoch}')

            if not os.path.isdir(f'{path_json}/{epoch}/{conf}'):
                os.mkdir(f'{path_json}/{epoch}/{conf}')
            
            with open(f'{path_json}/{epoch}/{conf}/{fold}.json', 'w', encoding='utf-8') as j:
                json.dump(now, j, ensure_ascii=False, indent=4)