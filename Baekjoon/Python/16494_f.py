import sys


N, M = map(int, sys.stdin.readline().split())
num_list = list(map(int, sys.stdin.readline().split()))
used = [False for _ in range(N)]
prefix_sum_list = []
temp = 0
result_list = []
for i in range(N):
    temp += num_list[i]
    prefix_sum_list.append(temp)
    result_list.append([temp, 0, i])
for i in range(N):
    for j in range(i + 1, N):
        result_list.append([prefix_sum_list[j] - prefix_sum_list[i], i + 1, j])
result_list.sort(key=lambda x: x[0], reverse=True)
max_num = -9999
result = 0
count = 0
point = 0
while count != M:
    flag = False
    x = result_list[point][1]
    y = result_list[point][2]
    for i in range(x, y + 1):
        if used[i]:
            flag = True
            break
    if not flag:
        result += result_list[point][0]
        count += 1
        for i in range(x, y + 1):
            used[i] = True
    point += 1
print(result)
