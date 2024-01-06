num = int(input())
dp = [0, 0, 1, 1]
pre = [0, 0, 1, 1]
for i in range(4, num + 1):
    a = dp[i - 1] + 1
    b = 10 ** 6 + 1
    c = 10 ** 6 + 1
    if i % 2 == 0:
        b = dp[i // 2] + 1
    if i % 3 == 0:
        c = dp[i // 3] + 1
    d = min(a, b, c)
    if d == a:
        dp.append(a)
        pre.append(i - 1)
    elif d == b:
        dp.append(b)
        pre.append(i // 2)
    else:
        dp.append(c)
        pre.append(i // 3)
print(dp[num])
result = [num]
while pre[num] != 0:
    result.append(pre[num])
    num = pre[num]
print(*result)
