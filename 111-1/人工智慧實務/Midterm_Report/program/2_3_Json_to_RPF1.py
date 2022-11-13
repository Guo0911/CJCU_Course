import os, json, csv

num2obj = {'0': 'no_mask', '1': 'mask'}

confs = [10, 25, 50, 75]
epochs = [50, 100, 150]

class bb(): # bndbox of ground and detection
    with open(f'../result/PRF1/Ground/Ground.json', 'r', encoding='utf-8') as j:
        ground = json.load(j)
    detect = {}

    IoU_Gate = 0.3

    p = {}
    r = {}
    f1 = {}
    

    def load(self, d):
        self.detect = d
    

    def precision(self):
        t = {} # tp
        f = {} # fp
        
        for second in self.detect:
            if second not in self.ground:
                for name in self.detect[second]:
                    f = self.update(f, name, len(self.detect[second][name]))
                continue

            for name in self.detect[second]:
                if name not in self.ground[second]:
                    f = self.update(f, name, len(self.detect[second][name]))
                    continue

                for d_obj in self.detect[second][name]:
                    tp = False
                    d_obj = list(map(float, d_obj.split(',')))[:4]
                    for g_obj in self.ground[second][name]:
                        g_obj = list(map(float, g_obj.split(',')))
                        if (self.IoU(d_obj, g_obj) >= self.IoU_Gate): # if IoU > gate
                            tp = True
                            break

                    if tp:
                        t = self.update(t, name, 1)
                    else:
                        f = self.update(f, name, 1)
        
        result = self.computing(t, f)

        for i in result.keys():
            self.p[i] = "%.2f"%round(((result[i][0] / (result[i][0] + result[i][1])) * 100), 2)
        print('Precision:', self.p)


    def recall(self):
        t = {} # tp
        f = {} # fn
        
        for second in self.ground:
            if second not in self.detect:
                for name in self.ground[second]:
                    f = self.update(f, name, len(self.ground[second][name]))
                continue

            for name in self.ground[second]:
                if name not in self.detect[second]:
                    f = self.update(f, name, len(self.ground[second][name]))
                    continue

                for g_obj in self.ground[second][name]:
                    tp = False
                    g_obj = list(map(float, g_obj.split(',')))[:4]
                    for d_obj in self.detect[second][name]:
                        d_obj = list(map(float, d_obj.split(',')))
                        if (self.IoU(g_obj, d_obj) >= self.IoU_Gate): # if IoU > gate
                            tp = True
                            break

                    if tp:
                        t = self.update(t, name, 1)
                    else:
                        f = self.update(f, name, 1)
        
        result = self.computing(t, f)

        for i in result.keys():
            self.r[i] = "%.2f"%round(((result[i][0] / (result[i][0] + result[i][1]) * 100)), 2)
        print('Recall:', self.r)
    

    def f1_score(self):
        result = self.computing(self.p, self.r)

        for i in result.keys():
            try:
                self.f1[i] = "%.2f"%round(((2 * result[i][0] * result[i][1]) / (result[i][0] + result[i][1])), 2)
            except:
                self.f1[i] = "%.2f"%0.00
        print('F1-score:', self.f1)


    def IoU(self, bb1, bb2):
        area_of_bb1 = ((bb1[2] - bb1[0]) * (bb1[3] - bb1[1]))
        area_of_bb2 = ((bb2[2] - bb2[0]) * (bb2[3] - bb2[1]))
        
        Union = (area_of_bb1 + area_of_bb2)

        Xmin = max(bb1[0], bb2[0]) # min x of intersection
        Ymin = max(bb1[1], bb2[1])
        Xmax = min(bb1[2], bb2[2])
        Ymax = min(bb1[3], bb2[3])
        if ((Xmin < Xmax) and (Ymin < Ymax)):
            Intersection = ((Xmax - Xmin) * (Ymax - Ymin))
            Union -= Intersection # subtract the overlapping range
            
            bb_IoU = (Intersection / Union)
            return bb_IoU
        else:
            return 0


    def update(self, tf, name, num):
        if name not in tf:
            tf[name] = num
        else:
            tf[name] += num

        return tf


    def computing(self, t, f):
        result = {}

        for i in sorted(list(set(list(t.keys()) + list(f.keys())))):
            if i in t:
                tp = float(t[i])
            else:
                tp = 0
            
            if i in f:
                fp = float(f[i])
            else:
                fp = 0
            
            result[i] = [tp, fp]

        return result


main = bb()

path_detect = '../result/PRF1/Detect'

for conf in confs:
    data = {}
    for epoch in epochs:
        folds = os.listdir(f'{path_detect}/{epoch}/{conf}')
        for fold in folds:
            fold = fold.replace('.json', '')
            if fold not in data:
                data[fold] = {'no_mask': [], 'mask': []}
            
            with open(f'{path_detect}/{epoch}/{conf}/{fold}.json', 'r', encoding='utf-8') as j:
                json_of_detect = json.load(j)

            main.load(json_of_detect)

            print(fold)
            main.precision()
            main.recall()
            main.f1_score()
            
            for i in main.r.keys():
                name_of_obj = num2obj[i]
                data[fold][name_of_obj].append(f'{main.p[i]}%')
                data[fold][name_of_obj].append(f'{main.r[i]}%')
                data[fold][name_of_obj].append(f'{main.f1[i]}%')

            print('----------------------------------------')

    if not os.path.isdir(f'../result/PRF1/result/{conf}'):
        os.mkdir(f'../result/PRF1/result/{conf}')

    for folds in data.keys():
        with open(f'../result/PRF1/result/{conf}/conf{conf}_Fold{folds}.csv', 'w', newline= '') as f:
            writer = csv.writer(f, delimiter=',')
            writer.writerow(['', f'{epochs[0]}epochs', '', '', f'{epochs[1]}epochs', '', '', f'{epochs[2]}epochs', '', ''])
            writer.writerow(['', 'Precision', 'Recall', 'F1-score', 'Precision', 'Recall', 'F1-score', 'Precision', 'Recall', 'F1-score'])
            for obj in data[folds].keys():
                writer.writerow([obj] + data[folds][obj])
        
