t = int(input())
for test_case in range(t):
    N = int(input())
    block = list(map(int, input().split()))
    up_diff = 0
    down_diff = 0
    for i in range(N):
        if i == N - 1:
            continue
        temp = block[i] - block[i + 1]
        if temp >= 0:
            if up_diff < temp:
                up_diff = temp
        else:
            temp = temp * -1
            if down_diff < temp:
                down_diff = temp
    print(f"#{test_case + 1} {down_diff} {up_diff}")
