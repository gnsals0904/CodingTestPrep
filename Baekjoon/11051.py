N, K = map(int, input().split())
dp = [[-1 for _ in range(K + 1)] for _ in range(N + 1)]
for i in range(N + 1):
    dp[i][1] = i
for j in range(K + 1):
    dp[j][j] = 1
for j in range(1, K + 1):
    for i in range(1, N + 1):
        if dp[i][j] == -1:
            dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]
print(dp[N][K] % 10007)
