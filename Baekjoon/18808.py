import sys


N, M, K = map(int, sys.stdin.readline().split())
graph = [[0 for _ in range(M)] for _ in range(N)]


# 스티커 붙이기
def put_sticker(x_k, y_k, height, width, sticker_graph):
    # x_k, y_k 는 스티커의 좌측 상단 시작 좌표
    for i1 in range(height):
        for j1 in range(width):
            if graph[i1 + x_k][j1 + y_k] == 1:
                continue
            graph[i1 + x_k][j1 + y_k] = sticker_graph[i1][j1]


# 스티커를 붙일 수 있는지?
def can_sticker(x_k, y_k, height, width, sticker_graph):
    # x_k, y_k 는 스티커의 좌측 상단 시작 좌표
    for i1 in range(height):
        for j1 in range(width):
            # 노트북에 스티커가 붙여져 있는 위치에 붙이려고 하는 경우
            if graph[i1 + x_k][j1 + y_k] == 1 and sticker_graph[i1][j1] == 1:
                return False
    # 다 돌았는데 False 를 출력하지 않았으면 붙일 수 있음
    return True


# 스티커 오른쪽으로 90도 돌리기
def rotate_sticker(height, width, sticker_graph):
    # 옆으로 돌렸으니 height => width 가 되고 그 역도 같음
    temp_graph = [[] for _ in range(width)]
    for i1 in range(width):
        for j1 in range(height - 1, -1, -1):
            temp_graph[i1].append(sticker_graph[j1][i1])
    return temp_graph


# 모든 스티커를 붙이는 중
for number in range(K):
    R, C = map(int, sys.stdin.readline().split())
    sticker = []
    flag = False
    # sticker input
    for _ in range(R):
        one_line = list(map(int, sys.stdin.readline().split()))
        sticker.append(one_line)
    # 스티커 붙이기
    for i in range(N):
        for j in range(M):
            # 범위를 벗어나면 안돼
            if i + R > N or j + C > M:
                continue
            # 스티커를 붙일 수 있나?
            if can_sticker(i, j, R, C, sticker):
                # 붙일 수 있다면
                put_sticker(i, j, R, C, sticker)
                # 붙이고 나면 더 진행할 필요가 없음
                flag = True
                break
        if flag:
            break
    if flag:
        continue
    # 여기 까지 왔다면, 전체를 돌았음에도 붙이지 못한것이므로, 스티커를 90도 돌린다
    sticker = rotate_sticker(R, C, sticker)
    # 90 도를 돌렸으므로 R과 C 가 서로 바뀐다.
    R, C = C, R
    # 90 돌린 스티커 붙이기
    for i in range(N):
        for j in range(M):
            # 범위를 벗어나면 안돼
            if i + R > N or j + C > M:
                continue
            # 스티커를 붙일 수 있나?
            if can_sticker(i, j, R, C, sticker):
                # 붙일 수 있다면
                put_sticker(i, j, R, C, sticker)
                # 붙이고 나면 더 진행할 필요가 없음
                flag = True
                break
        if flag:
            break
    if flag:
        continue
    # 여기 까지 왔다면, 전체를 돌았음에도 붙이지 못한것이므로, 스티커를 90도 돌린다 현재 180도 돌림
    sticker = rotate_sticker(R, C, sticker)
    # 90 도를 돌렸으므로 R과 C 가 서로 바뀐다.
    R, C = C, R
    # 180 돌린 스티커 붙이기
    for i in range(N):
        for j in range(M):
            # 범위를 벗어나면 안돼
            if i + R > N or j + C > M:
                continue
            # 스티커를 붙일 수 있나?
            if can_sticker(i, j, R, C, sticker):
                # 붙일 수 있다면
                put_sticker(i, j, R, C, sticker)
                # 붙이고 나면 더 진행할 필요가 없음
                flag = True
                break
        if flag:
            break
    if flag:
        continue
    # 여기 까지 왔다면, 전체를 돌았음에도 붙이지 못한것이므로, 스티커를 90도 돌린다 현재 270도 돌림
    sticker = rotate_sticker(R, C, sticker)
    # 90 도를 돌렸으므로 R과 C 가 서로 바뀐다.
    R, C = C, R
    # 270 돌린 스티커 붙이기
    for i in range(N):
        for j in range(M):
            # 범위를 벗어나면 안돼
            if i + R > N or j + C > M:
                continue
            # 스티커를 붙일 수 있나?
            if can_sticker(i, j, R, C, sticker):
                # 붙일 수 있다면
                put_sticker(i, j, R, C, sticker)
                # 붙이고 나면 더 진행할 필요가 없음
                flag = True
                break
        if flag:
            break
    if flag:
        continue
    # 여기 까지 왔다면, 전체를 돌았음에도 붙이지 못한것이므로 그냥 다음으로

# 스티커를 다 붙였다면, 스티커가 붙어진 칸의 개수 세기
result = 0
for i in range(N):
    for j in range(M):
        if graph[i][j] == 1:
            result += 1

print(result)
