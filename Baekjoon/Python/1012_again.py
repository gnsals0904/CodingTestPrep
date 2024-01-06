import sys
sys.setrecursionlimit(1000000)


def dfs(x, y):
    if x <= -1 or x >= M or y <= -1 or y >= N:
        return False
    if cabbage[y][x] == 1:
        cabbage[y][x] = 0
        dfs(x - 1, y)
        dfs(x, y - 1)
        dfs(x + 1, y)
        dfs(x, y + 1)
        return True
    return False


T = int(input())
for _ in range(T):
    M, N, K = map(int, input().split())
    cabbage = [[0] * M for _ in range(N)]
    for i in range(K):
        X, Y = map(int, input().split())
        cabbage[Y][X] = 1
    result = 0
    for x in range(M):
        for y in range(N):
            if dfs(x, y):
                result += 1
    print(result)
