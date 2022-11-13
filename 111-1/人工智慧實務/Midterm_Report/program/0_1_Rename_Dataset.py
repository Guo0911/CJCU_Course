import os, json

original_path = '../dataset/original'

id2name = {} # {id: original filename}

files = os.listdir(original_path)
for file in files:
    if ('.txt' in file):
        continue

    Id = len(id2name)

    os.rename(f'{original_path}/{file}', f'{original_path}/{Id}.jpg')
    file = file.replace('.jpg', '').replace('.jpeg', '').replace('.png', '') # remove sub filenmae
    os.rename(f'{original_path}/{file}.txt', f'{original_path}/{Id}.txt')

    id2name[Id] = file

with open('../result/id2name.json', 'w', encoding='utf-8') as j:
    json.dump(id2name, j, ensure_ascii=False, indent=4)
