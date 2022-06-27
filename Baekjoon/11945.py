n, m = map(int, input().split())
revers = list()
ss = list()
if m == 0:
    exit()
for i in range(n):
    s = input()
    ss.append(s)
for k in range(n):
    if n-1 == k:
        print(ss[k][::-1], end='')
    else:
        print(ss[k][::-1])