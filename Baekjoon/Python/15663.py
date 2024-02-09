N, M = map(int, input().split())
num_list = list(map(int, input().split()))
num_list.sort()
visited = [False for _ in range(N)]
result = []


def func(k):
    if k == M:
        print(*result)
        return
    temp = 0
    for i in range(N):
        if not visited[i] and num_list[i] != temp:
            visited[i] = True
            temp = num_list[i]
            result.append(num_list[i])
            func(k + 1)
            result.pop()
            visited[i] = False


func(0)
