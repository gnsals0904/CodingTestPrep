T = int(input())
for test_case in range(T):
    L, U, X = map(int, input().split())
    result = 0
    if L > X:
        result = L - X
    elif U < X:
        result = -1
    print(f"#{test_case + 1} {result}")
