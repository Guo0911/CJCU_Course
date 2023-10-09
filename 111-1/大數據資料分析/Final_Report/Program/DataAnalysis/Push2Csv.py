import pymysql, csv, numpy, time

db_settings = {
    "host": "localhost",
    "port": 3306,
    "user": "user",
    "password": "password",
    "db": "db_name",
    "charset": "utf8"
}
db = pymysql.connect(**db_settings)
cursor = db.cursor()

start = time.time()

cursor.execute("SELECT `a_id`, `time` FROM `article`")
temps = cursor.fetchall()

cursor.execute(f"SELECT `a_id`, `push-tag` FROM `comment`") # 改成全拿後再找就好
pushs = {}
for push in cursor.fetchall():
    if push[0] not in pushs:
        pushs[push[0]] = {}

    if push[1] not in pushs[push[0]]:
        pushs[push[0]][push[1]] = 1
    else:
        pushs[push[0]][push[1]] += 1


result = {i: {j: {'文章數量': 0, '推': [0], '→': [0], '噓': [0]} for j in range(1, 13)} for i in range(2001, 2023)}
for temp in temps:
    
    result[temp[1].year][temp[1].month]['文章數量'] += 1
    
    now = {'推': 0, '→': 0, '噓': 0}
    if temp[0] in pushs:
        for tag in pushs[temp[0]]:
            now[tag] += pushs[temp[0]][tag]
    
    result[temp[1].year][temp[1].month]['推'].append(now['推'])
    result[temp[1].year][temp[1].month]['→'].append(now['→'])
    result[temp[1].year][temp[1].month]['噓'].append(now['噓'])


for y in result.keys():
    for m in result[y].keys():
        result[y][m]['平均推數'] = round(numpy.average(result[y][m]['推']), 2)
        result[y][m]['推的標準差'] = round(numpy.std(result[y][m]['推']), 2)
        
        result[y][m]['平均➝數'] = round(numpy.average(result[y][m]['→']), 2)
        result[y][m]['➝的標準差'] = round(numpy.std(result[y][m]['→']), 2)
        
        result[y][m]['平均噓數'] = round(numpy.average(result[y][m]['噓']), 2)
        result[y][m]['噓的標準差'] = round(numpy.std(result[y][m]['噓']), 2)


data = [['', ''] + [f'{j}月' for j in range(1, 13)]]

for y in range(2001, 2023):
    now = [[f'{y}年', '推的總數'], ['', '推的平均'], ['', '推的標準差'],
           ['', '➝的總數'], ['', '➝的平均'], ['', '➝的標準差'],
           ['', '噓的總數'], ['', '噓的平均'], ['', '噓的標準差']]
    for m in range(1, 13):
        now[0].append(sum(result[y][m]['推']))
        now[1].append(result[y][m]['平均推數'])
        now[2].append(result[y][m]['推的標準差'])
        now[3].append(sum(result[y][m]['→']))
        now[4].append(result[y][m]['平均➝數'])
        now[5].append(result[y][m]['➝的標準差'])
        now[6].append(sum(result[y][m]['噓']))
        now[7].append(result[y][m]['平均噓數'])
        now[8].append(result[y][m]['噓的標準差'])
    for n in now:
        data.append(n)

with open('../../Result/Push.csv', 'w', newline='', encoding='utf-8-sig') as f:
    write = csv.writer(f, delimiter= ',') 
    write.writerows(data)
    
end = time.time()

print(round((end - start), 4))