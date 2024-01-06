t = int(input())
result = 1001
while t > 0:
    a, b = map(int, input().split())
    if a <= b:
        if result > b:
            result = b
    t = t - 1
if result == 1001:
    print("-1")
else:
    print(result)
