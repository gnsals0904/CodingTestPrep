N, M = map(int, input().split())
num_list = list(map(int, input().split()))
num_list.sort()
result = []


def func(k):
    if k == M:
        print(*result)
        return
    temp = 0
    start = 0
    if k != 0:
        start = num_list.index(result[k - 1])
    for i in range(start, N):
        if temp != num_list[i]:
            temp = num_list[i]
            result.append(num_list[i])
            func(k + 1)
            result.pop()


func(0)
