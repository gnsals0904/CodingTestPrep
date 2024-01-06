import sys


K, L = map(int, input().split())
cnt = 0
waiting = dict()
for _ in range(L):
    temp = sys.stdin.readline().rstrip()
    waiting[temp] = cnt
    cnt += 1
waiting_list = list(zip(waiting.keys(), waiting.values()))
waiting_list.sort(key=lambda x: x[1])
count = 1
for result in waiting_list:
    print(result[0])
    if count == K:
        break
    count += 1
