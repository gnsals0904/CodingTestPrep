import sys
from itertools import combinations


def verify():
    for j in range(N):
        temp = ''
        for u in graph[j]:
            if u != 'X':
                temp += u
        if 'ST' in temp:
            return False
        if 'TS' in temp:
            return False
    for j in range(N):
        temp = ''
        for z in range(N):
            if graph[z][j] != 'X':
                temp += graph[z][j]
        if 'ST' in temp:
            return False
        if 'TS' in temp:
            return False
    return True


N = int(sys.stdin.readline().rstrip())
graph = []
blank = []
for _ in range(N):
    one_line = list(map(str, sys.stdin.readline().split()))
    graph.append(one_line)
for i in range(N):
    for c in range(N):
        if graph[i][c] == 'X':
            blank.append([i, c])

flag = False
for combi in combinations(blank, 3):
    for x, y in combi:
        graph[x][y] = 'O'
    if verify():
        flag = True
        break
    for x, y in combi:
        graph[x][y] = 'X'

if flag:
    print("YES")
else:
    print("NO")
