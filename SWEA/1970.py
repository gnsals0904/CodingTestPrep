t = int(input())
for i in range(t):
    n = int(input())
    change_money_list = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
    result = []
    for x in change_money_list:
        if n // x > 0:
            result.append(n // x)
            n -= n // x * x
        else:
            result.append(0)
    print("#" + str(i + 1))
    print(*result)
