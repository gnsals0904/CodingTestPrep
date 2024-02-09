A, B = map(int, input().split())
result = []
if B > A:
    for i in range(A + 1, B):
        result.append(i)
    if A != B:
        print(B - A - 1)
    else:
        print(0)
    print(*result)
else:
    for i in range(B + 1, A):
        result.append(i)
    if A != B:
        print(A - B - 1)
    else:
        print(0)
    print(*result)
