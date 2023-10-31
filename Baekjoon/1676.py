n = int(input())
dp = [1, 1]


def fac():
    for i in range(2, n + 1):
        dp.append(dp[i - 1] * i)


fac()
s = str(dp[n])
count = 0
s = s[::-1]
for x in s:
    if x != '0':
        print(count)
        break
    else:
        count += 1
