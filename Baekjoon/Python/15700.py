n, m = map(int, input().split())
r1 = n // 2
a1 = n % 2
r2 = m // 2
result = 0
if a1 == 0:
    result = r1 * m
else:
    result = r1 * m + r2
print(result)
