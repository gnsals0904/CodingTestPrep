t = int(input())
for test_case in range(t):
    n = int(input())
    money = list(map(int, input().split()))
    result = 0
    avg_money = sum(money) / n
    for i in range(n):
        if money[i] <= avg_money:
            result += 1
    print(f"#{test_case + 1} {result}")