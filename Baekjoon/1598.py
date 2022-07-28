n, m = map(int, input().split())
n1 = n // 4 + 1
n2 = 4 - n % 4
m1 = m // 4 + 1
m2 = 4 - m % 4
result = max(n2, m2) - min(n2, m2) + max(n1, m1) - min(m1, n1)
print(result)