def gcd(A, B):
    if A % B != 0:
        r = A % B
        return gcd(B, r % B)
    elif A == B:
        return A
    else:
        return B


a, b = map(int, input().split())
c = gcd(a, b)
print(c)
print(a * b // c)
