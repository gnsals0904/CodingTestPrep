import sys


N, C = map(int, input().split())
num_list = list(map(int, sys.stdin.readline().split()))
num_list.sort()

result = []
count = 1
check = 1
s_value = num_list[0]
for i in range(1, N):
    if num_list[i] == s_value:
        count += 1
    else:
        result.append([s_value, count])
        check += 1
        count = 1
        s_value = num_list[i + 1]
result.append([s_value, count - 1])
result.sort(key=lambda x: x[1], reverse=True)
print(result)
for i in range(check):
    for j in range(result[i][1]):
        if i == check - 1 and j == result[1][1] - 1:
            print(result[i][0])
        else:
            print(result[i][0], end=" ")
