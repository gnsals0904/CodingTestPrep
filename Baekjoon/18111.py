import sys


N, M, B = map(int, input().split())
block = []
block_number = [0 for _ in range(257)]
for _ in range(N):
    one_line = list(map(int, sys.stdin.readline().split()))
    block.append(one_line)
# 블럭 높이 세면서 최소길이 최대길이 저장
min_length = 256
max_length = 0
for i in range(N):
    for j in range(M):
        block_number[block[i][j]] += 1
        if block[i][j] > max_length:
            max_length = block[i][j]
        if block[i][j] < min_length:
            min_length = block[i][j]
# 최대 블록의 높이는 256이므로, 블록의 높이가 0일때부터 256일때까지를 전부 순회
result_length = 0
result_time = 500 * 500 * 256 * 2
for k in range(257):
    temp_result_time = 0
    temp_B = B
    # k의 높이로 블록 전부 평탄화하면 얼마의 시간이 걸릴까?
    for now in range(257):
        if k == now:
            continue
        # 캐야하는 경우
        elif k < now:
            mining_block_number = (now - k) * block_number[now]
            temp_result_time = temp_result_time + (mining_block_number * 2)
            temp_B += mining_block_number
        # 쌓아야 하는 경우
        else:
            stack_block_number = (k - now) * block_number[now]
            temp_B -= stack_block_number
            temp_result_time = temp_result_time + stack_block_number
    # 인벤토리의 블록보다 더 많이 쓴것이므로 안돼
    if temp_B < 0:
        continue
    # 최소시간과 최대 블록 높이 저장
    if result_time >= temp_result_time:
        result_time = temp_result_time
        result_length = k
print(result_time, result_length)
