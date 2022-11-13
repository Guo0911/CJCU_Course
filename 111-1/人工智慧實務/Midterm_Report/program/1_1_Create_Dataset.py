import os, shutil

def clear_folder(paths):
    files = os.listdir(paths)
    for file in files:
        os.remove(paths + f"/{file}")

fold_path     = '../dataset/5fold'
train_path    = '../dataset/train'
test_path     = '../dataset/test'

fold_of_test = int(input()) # 要當測資的fold
print('fold_of_testset:', fold_of_test)


if os.path.isfile(f'{train_path}/labels.cache'):
    os.remove(f'{train_path}/labels.cache')

if os.path.isfile(f'{test_path}/labels.cache'):
    os.remove(f'{test_path}/labels.cache')

for class_ in os.listdir(train_path):
    clear_folder(f'{train_path}/{class_}')
    clear_folder(f'{test_path}/{class_}')


for i in range(1, 6):
    files = os.listdir(f'{fold_path}/{i}')

    if (i != fold_of_test):
        for file in files:
            if ('.txt' in file):
                continue
            file_txt = file.replace('.jpg', '.txt')
            shutil.copy(f'{fold_path}/{i}/{file}', f'{train_path}/images/{file}')
            shutil.copy(f'{fold_path}/{i}/{file_txt}', f'{train_path}/labels/{file_txt}')
    
    else:
        for file in files:
            if ('.txt' in file):
                continue
            file_txt = file.replace('.jpg', '.txt')
            shutil.copy(f'{fold_path}/{i}/{file}', f'{test_path}/images/{file}')
            shutil.copy(f'{fold_path}/{i}/{file_txt}', f'{test_path}/labels/{file_txt}')