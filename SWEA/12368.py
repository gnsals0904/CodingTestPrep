T = int(input())
for test_case in range(T):
    A, B = map(int, input().split())
    result = (A + B) % 24
    print(f"#{test_case + 1} {result}")
