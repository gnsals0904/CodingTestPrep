N = int(input())
A, B = map(int, input().split())
r1 = A // 2
r2 = B
if r1 + r2 <= N:
    print(r1 + r2)
else:
    print(N)
