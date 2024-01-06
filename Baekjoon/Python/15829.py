N = int(input())
s = input()
s_sum = 0
# 제곱의 결과 저장
dp = [1, 31]
# 알파벳
for j in range(1, N - 1):
    dp.append(dp[j] * 31)
for i in range(N):
    s_sum += (ord(s[i]) - ord('a') + 1) * dp[i]
print(s_sum % 1234567891)
