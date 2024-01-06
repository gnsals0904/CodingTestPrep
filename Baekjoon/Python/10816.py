import sys
from collections import deque

N = int(input())
num_list = list(map(int, sys.stdin.readline().split()))
n_list = deque(num_list)
M = int(input())
qa_list = list(map(int, sys.stdin.readline().split()))
q_list = deque(qa_list)
visited = [False for _ in range(N)]
num_zip_dic = dict()
while n_list:
    v = n_list.popleft()
    if v in num_zip_dic:
        num_zip_dic[v] += 1
    else:
        num_zip_dic[v] = 1
for _ in range(M):
    now_value = q_list.popleft()
    if now_value in num_zip_dic:
        print(num_zip_dic[now_value], end=' ')
    else:
        print(0, end=' ')
