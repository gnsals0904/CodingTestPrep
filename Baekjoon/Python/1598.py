n, m = map(int, input().split())
if n % 4 == 0:
    n1 = n // 4
    n2 = 0
else:
    n1 = n // 4 + 1
    n2 = 4 - n % 4
if m % 4 == 0:
    m1 = m // 4
    m2 = 0
else:
    m1 = m // 4 + 1
    m2 = 4 - m % 4
result = max(n2, m2) - min(n2, m2) + max(n1, m1) - min(m1, n1)
print(result)
