N, M = map(int, input().split())
ball_list = [0 for _ in range(N + 1)]
for _ in range(M):
    input_list = list(map(int, input().split()))
    for i in range(input_list[0], input_list[1] + 1):
        ball_list[i] = input_list[2]
print(*ball_list[1:])
