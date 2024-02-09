import sys
sys.setrecursionlimit(10000)

def dfs(x, y):
    if x <= -1 or x >= M or y <= -1 or y >= N:
        return False
    if graph[y][x] == 1:
        graph[y][x] = 0
        dfs(x - 1, y)
        dfs(x, y - 1)
        dfs(x + 1, y)
        dfs(x, y + 1)
        return True
    return False

T = int(input())
while T != 0:
    M, N, K = map(int, input().split())
    graph = [[0] * M for _ in range(N)]
    for i in range(K):
        X, Y = map(int, input().split())
        graph[Y][X] = 1
    result = 0
    for x in range(M):
        for y in range(N):
            if dfs(x, y):
                result += 1
    print(result)
    T -= 1
