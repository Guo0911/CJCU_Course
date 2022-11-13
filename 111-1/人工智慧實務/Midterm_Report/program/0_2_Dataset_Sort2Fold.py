import os, shutil

def clear_folder(paths):
    files = os.listdir(paths)
    for file in files:
        os.remove(paths + f"/{file}")

original_path = '../dataset/original'
fold_path = '../dataset/5fold'

for i in range(1, 6):
    if os.path.isdir(f'{fold_path}/{i}'):
        clear_folder(f'{fold_path}/{i}') # 清空資料夾內的檔案
    else:
        os.makedirs(f'{fold_path}/{i}')

files = os.listdir(original_path)
for i, file in enumerate(files):
    if ('.txt' in file):
        continue
    
    i //= 2 # 因為有txt檔，所以會導致i變成0, 2, 4, 6.....

    fold = ((i % 5) + 1)
    file_txt = file.replace('.jpg', '.txt')
    shutil.copy(f'{original_path}/{file}', f'{fold_path}/{fold}/{file}')
    shutil.copy(f'{original_path}/{file_txt}', f'{fold_path}/{fold}/{file_txt}')