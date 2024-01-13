import sys


n = int(sys.stdin.readline().rstrip())
for _ in range(n):
    dic = dict()
    t = int(sys.stdin.readline().rstrip())
    for _ in range(t):
        a, b = map(str, sys.stdin.readline().split())
        if dic.get(b) is None:
            dic[b] = set()
        dic[b].add(a)
        result = 1
    if t == 0:
        print(0)
        continue
    for x in dic.keys():
        result = result * (len(dic[x]) + 1)
    print(result - 1)
if n == 0:
    print(0)