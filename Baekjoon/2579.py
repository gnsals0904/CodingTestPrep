import sys

N = int(input())
stairs = []
for _ in range(N):
    stairs.append(int(sys.stdin.readline().rstrip()))

if N >= 3:
    dp = [stairs[0], stairs[0] + stairs[1], max(stairs[0] + stairs[2], stairs[1] + stairs[2])]
    for i in range(3, N):
        dp.append(max(dp[i - 3] + stairs[i - 1] + stairs[i], dp[i - 2] + stairs[i]))
    print(dp[N - 1])
else:
    if N == 1:
        print(stairs[0])
    else:
        print(stairs[0] + stairs[1])
