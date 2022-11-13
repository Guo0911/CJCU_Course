import os, json

count = {}

path_fold = '../dataset/5fold'

folds = os.listdir(path_fold)
for fold in folds:
    count[fold] = {'no_mask': 0, 'mask': 0}
    files = os.listdir(f'{path_fold}/{fold}')
    for file in files:
        if ('.jpg' in file):
            continue

        f = open(f'{path_fold}/{fold}/{file}', 'r')
        for obj in f.readlines():
            name = (['no_mask', 'mask'])[int(obj.split(' ')[0])]
            count[fold][name] += 1

with open('../result/count_of_fold.json', 'w', encoding='utf-8') as j:
    json.dump(count, j, indent=4)
