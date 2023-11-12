import sys

T = int(input())
count = 0
e_l = -2
e_r = -2
for i in range(T):
    l1, r = map(int, sys.stdin.readline().split())
    if l1 == 0 and r == 0:
        e_l = l1
        e_r = r
        continue
    if i == 0:
        if l1 == r:
            count += 1
    else:
        if l1 == e_l and l1 != 0:
            count += 1
        if r == e_r and r != 0:
            count += 1
        if l1 == r:
            count += 1
    e_l = l1
    e_r = r
print(count)
