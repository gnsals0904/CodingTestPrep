import sys


N, C = map(int, input().split())
num_list = list(map(int, sys.stdin.readline().split()))
num_list.sort()
num_dic = {}
count = 1
s_value = num_list[0]
for i in range(1, N):
    if num_list[i] == s_value:
        count += 1
    else:
        num_dic[s_value] = count
        count = 0
        s_value = num_dic[i + 1]
