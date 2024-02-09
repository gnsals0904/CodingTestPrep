N, K = map(int, input().split())
money_list = []
for _ in range(N):
    money_list.append(int(input()))
money_list.sort(reverse=True)
money_result = 0
for i in range(N):
    temp = K // money_list[i]
    if temp > 0:
        K = K - money_list[i] * temp
        money_result += temp
    if K == 0:
        break
print(money_result)
