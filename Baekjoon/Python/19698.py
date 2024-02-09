N, W, H, L = map(int, input().split())
r1 = W // L
r2 = H // L
result = r1 * r2
if result < N:
    print(result)
else:
    print(N)