import sys

N = int(input())
for _ in range(N):
    s1, s2 = map(str, sys.stdin.readline().split())
    s1 = ''.join(sorted(s1))
    s2 = ''.join(sorted(s2))
    flag = True
    l_s1 = len(s1)
    if l_s1 != len(s2):
        print("Impossible")
        continue
    for i in range(l_s1):
        if s1[i] != s2[i]:
            flag = False
            break
    if not flag:
        print("Impossible")
    else:
        print("Possible")

