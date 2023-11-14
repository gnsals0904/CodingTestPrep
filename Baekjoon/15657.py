N, M = map(int, input().split())
num_list = list(map(int, input().split()))
result = []
visited = [False for _ in range(N)]
num_list.sort()


def func(k):
    if k == M:
        print(*result)
        return
    start = 0
    if k != 0:
        start = num_list.index(result[k - 1])
    for i in range(start, N):
        result.append(num_list[i])
        func(k + 1)
        result.pop()


func(0)
