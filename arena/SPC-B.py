N = int(input())
result_list = [0 for i in range(1, N + 1)]
if N % 2 == 0:
    half_len = N // 2
    result_list[half_len] = N
    result_list[half_len - 1] = N - 1
    count = 1
    for i in range(half_len - 1):
        result_list[i] = 2 * count
        count += 1
    count -= 1
    for j in range(half_len + 1, N):
        result_list[j] = 2 * count - 1
        count -= 1
else:
    half_len = N // 2
    result_list[half_len] = N
    count = 1
    for i in range(half_len):
        result_list[i] = 2 * count
        count += 1
    count -= 1
    for j in range(half_len + 1, N):
        result_list[j] = 2 * count - 1
        count -= 1
print(*result_list)
