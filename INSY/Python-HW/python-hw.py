#!/bin/python

liste=['programmier', 'aufgaben', '.ch']

max_length = max([len(x) for x in liste])

for i in range(max_length):
    for y in liste:
        try:
            print(y[i] + ' ', end='')
        except:
            pass
    print()