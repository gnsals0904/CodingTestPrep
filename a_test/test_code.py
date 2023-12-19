def gcd(a, b):
    if a % b == 0:
        return b
    return gcd(b, a % b)


A, B = map(int, input().split())
result = gcd(A, B)
print(result)
