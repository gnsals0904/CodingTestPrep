import sys

N, M, Q = map(int, input().split())
graph = []
for _ in range(N):
    one_line = list(map(int, sys.stdin.readline().split()))
    graph.append(one_line)

for i in range(1, N):
    for j in range(1, M):
        graph[i][j] = graph[i - 1][j - 1] + graph[i][j]

dp = [[-1 for _ in range(M)] for _ in range(N)]

for i in range(Q):
    a, b = map(int, sys.stdin.readline().split())
    if dp[a - 1][b - 1] != -1:
        print(dp[a - 1][b - 1])
    else:
        result = 0
        for k in range(a):
            result += graph[k][b - 1]
            dp[a - 1][b - 1] = result
        print(result)
