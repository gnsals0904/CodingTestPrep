sum, minus = map(int, input().split())
a = (sum + minus) // 2
b = (sum - minus) // 2
if sum == 0 and minus == 0:
    print("0 0")
elif sum <= minus:
    print("-1")
elif (sum + minus) % 2 != 0 and (sum - minus) % 2:
    print("-1")
else:
    print(a,b)