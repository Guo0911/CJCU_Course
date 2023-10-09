import pymysql, csv, time

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

cursor.execute("SELECT `time` FROM `article`")

result = []
temps = cursor.fetchall()
for temp in temps:
  result.append(temp[0])

data = [[''] + [f'{j}月' for j in range(1, 13)]]

count_ = {i: {j: 0 for j in range(1, 13)} for i in range(2001, 2023)}
for i in result:
    count_[i.year][i.month] += 1

for y in range(2001, 2023):
    now = [f'{y}年']
    for m in range(1, 13):
        now.append(count_[y][m])
    data.append(now)

with open('../../Result/Count.csv', 'w', newline='', encoding='utf-8-sig') as f:
    write = csv.writer(f, delimiter= ',') 
    write.writerows(data)
    
end = time.time()

print(round((end - start), 4))