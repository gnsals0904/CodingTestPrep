import sys


N, S = map(int, sys.stdin.readline().split())
num_list = list(map(int, sys.stdin.readline().split()))
sum_num = 0
result = 100000
length = 1
start = 0
start_sum = 0
end = 0
end_sum = 0
flag = False
end_sum += num_list[end]
while start < N:
    sum_num = end_sum - start_sum
    if sum_num < S:
        end += 1
        if end == N:
            if result == 100000:
                result = 0
            break
        end_sum += num_list[end]
        length += 1
    else:
        if length < result:
            result = length
        if not flag:
            flag = True
            start_sum += num_list[start]
            length -= 1
        else:
            start += 1
            length -= 1
            start_sum += num_list[start]
    if start > end:
        result = 1
        break
print(result)
