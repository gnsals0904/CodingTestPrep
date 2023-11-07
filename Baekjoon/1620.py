import sys

N, M = map(int, input().split())
pocketmon_name = dict()
pocketmon_num = dict()
for i in range(1, N + 1):
    s1 = sys.stdin.readline().rstrip()
    pocketmon_name[i] = s1
    pocketmon_num[s1] = i
for j in range(M):
    s2 = sys.stdin.readline().rstrip()
    if s2.isdigit():
        print(pocketmon_name[int(s2)])
    else:
        print(pocketmon_num[s2])
