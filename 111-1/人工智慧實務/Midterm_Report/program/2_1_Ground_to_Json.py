import os, json, cv2

txt_path = '../dataset/original'
json_path = '../result/PRF1/Ground'


def xywh2xyxy(xywh, size): # size = [height, width]
    x_min = str((xywh[0] - (xywh[2] / 2)) * size[1])
    y_min = str((xywh[1] - (xywh[3] / 2)) * size[0])
    x_max = str((xywh[0] + (xywh[2] / 2)) * size[1])
    y_max = str((xywh[1] + (xywh[3] / 2)) * size[0])

    return [x_min, y_min, x_max, y_max]


data = {}

files = os.listdir(txt_path)
for file in files:
    if ('.jpg' in file):
        continue

    Id = file.replace('.txt', '').split('-')[-1]
    data[Id] = {}

    file_jpg = file.replace('.txt', '.jpg')
    jpg = cv2.imread(f'{txt_path}/{file_jpg}')
    size = jpg.shape[:2] # [height, width] of image

    f = open(f'{txt_path}/{file}')
    
    objs = f.readlines()
    for obj in objs:
        obj = list(map(float, obj.replace('\n', '').split(' ')))
        name, index = str(int(obj[0])), xywh2xyxy(obj[1:], size)
        if name not in data[Id]:
            data[Id][name] = [",".join(index)]
        else:
            data[Id][name].append(",".join(index))
    
    f.close()

with open(f'{json_path}/Ground.json', 'w', encoding='utf-8') as j:
    json.dump(data, j, ensure_ascii=False, indent=4)