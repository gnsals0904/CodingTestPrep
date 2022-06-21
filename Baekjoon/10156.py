n, m, k = map(int, input().split())
need_money = n * m
if need_money < k:
    print("0")
else:
    print(need_money - k)