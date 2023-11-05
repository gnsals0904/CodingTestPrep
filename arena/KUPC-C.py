N, L = map(int, input().split())
result = ''
if N == 0:
    result = result + str(1) * (L - 1) + str(0)
else:
    result = result + str(1) * (L - 1) + str(N)
print(result)
