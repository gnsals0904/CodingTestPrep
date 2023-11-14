N, M = map(int, input().split())
num_list = list(map(int, input().split()))
num_list.sort()
result = []
visited = [False for _ in range(N)]


def func(k):
    if k == M:
        print(*result)
        return
    start = 0
    if k != 0:
        start = num_list.index(result[k - 1]) + 1
    for i in range(start, N):
        visited[i] = True
        result.append(num_list[i])
        func(k + 1)
        result.pop()
        visited[i] = False


func(0)