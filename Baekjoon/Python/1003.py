import sys


t = int(input())
dp = [[] for _ in range(41)]
# 피보나치 수 답, 0의 개수, 1의 개수
dp[0] = [0, 1, 0]
dp[1] = [1, 0, 1]
# 피보나치 답 채워놓고
for i in range(2, 41):
    for j in range(3):
        dp[i].append(dp[i - 1][j] + dp[i - 2][j])

for _ in range(t):
    N = int(sys.stdin.readline().rstrip())
    print(dp[N][1], dp[N][2])

