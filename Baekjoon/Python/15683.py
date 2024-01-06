N, M = map(int, input().split())
graph = []
temp_graph = []
for _ in range(N):
    one_line = list(map(int, input().split()))
    graph.append(one_line)
    temp_graph.append(one_line)


def cctv_check(x, y, direction):
    # 위 방향
    if direction == 0:
        for i1 in range(x - 1, -1, -1):
            # CCTV 면 넘어감
            if temp_graph[i1][y] == 1 or temp_graph[i1][y] == 2 or temp_graph[i1][y] == 3 or temp_graph[i1][y] == 4 or temp_graph[i1][y] == 5:
                continue
            # 감시할 수 있는 곳 체크
            if temp_graph[i1][y] == 0 or temp_graph[i1][y] == '#':
                temp_graph[i1][y] = '#'
            # 벽이면 더 이상은 x
            else:
                break
    # 아래 방향
    if direction == 2:
        for i1 in range(x + 1, N):
            # CCTV 면 넘어감
            if temp_graph[i1][y] == 1 or temp_graph[i1][y] == 2 or temp_graph[i1][y] == 3 or temp_graph[i1][y] == 4 \
                    or temp_graph[i1][y] == 5:
                continue
            # 감시할 수 있는 곳 체크
            if temp_graph[i1][y] == 0 or temp_graph[i1][y] == '#':
                temp_graph[i1][y] = '#'
            # 벽이면 더 이상은 x
            else:
                break
    # 왼쪽 방향
    if direction == 3:
        for i1 in range(y - 1, -1, -1):
            # CCTV 면 넘어감
            if temp_graph[x][i1] == 1 or temp_graph[x][i1] == 2 or temp_graph[x][i1] == 3 or temp_graph[x][i1] == 4 \
                    or temp_graph[x][i1] == 5:
                continue
            if temp_graph[x][i1] == 0 or temp_graph[x][i1] == '#':
                temp_graph[x][i1] = '#'
            else:
                # 0이 아니면 벽이거나 cctv
                break
    # 오른쪽 방향
    if direction == 1:
        for i1 in range(y + 1, M):
            # CCTV 면 넘어감
            if temp_graph[x][i1] == 1 or temp_graph[x][i1] == 2 or temp_graph[x][i1] == 3 or temp_graph[x][i1] == 4 \
                    or temp_graph[x][i1] == 5:
                continue
            if temp_graph[x][i1] == 0 or temp_graph[x][i1] == '#':
                temp_graph[x][i1] = '#'
            else:
                # 0이 아니면 벽이거나 cctv
                break


# cctv 개수 세기 및 위치 저장
cctv = []
cctv_num = 0
for i in range(N):
    for j in range(M):
        if 0 < graph[i][j] < 6:
            cctv_num += 1
            cctv.append((i, j))

# 답이 될 최소 값
result = N * M

# 모든 경우의 수에 대해서 진행
for case in range(4 ** cctv_num):
    # 원본 graph 복사
    for i in range(N):
        temp_graph[i] = graph[i][:]
    n_case = case
    for i in range(cctv_num):
        # cctv 한개씩 방향 지정해서 진행
        cctv_x = cctv[i][0]
        cctv_y = cctv[i][1]
        now_direction = n_case % 4
        n_case = n_case // 4
        # 1번 cctv 인 경우
        if graph[cctv_x][cctv_y] == 1:
            cctv_check(cctv_x, cctv_y, now_direction)
        # 2번 cctv 인 경우
        elif graph[cctv_x][cctv_y] == 2:
            # 상 하 진행
            if now_direction == 0 or now_direction == 2:
                cctv_check(cctv_x, cctv_y, 0)
                cctv_check(cctv_x, cctv_y, 2)
            # 좌 우 진행
            else:
                cctv_check(cctv_x, cctv_y, 1)
                cctv_check(cctv_x, cctv_y, 3)
        # 3번 cctv 인 경우
        elif graph[cctv_x][cctv_y] == 3:
            # 상 우
            if now_direction == 0:
                cctv_check(cctv_x, cctv_y, 0)
                cctv_check(cctv_x, cctv_y, 1)
            # 우 하
            elif now_direction == 1:
                cctv_check(cctv_x, cctv_y, 1)
                cctv_check(cctv_x, cctv_y, 2)
            # 하 좌
            elif now_direction == 2:
                cctv_check(cctv_x, cctv_y, 2)
                cctv_check(cctv_x, cctv_y, 3)
            # 좌 상
            elif now_direction == 3:
                cctv_check(cctv_x, cctv_y, 3)
                cctv_check(cctv_x, cctv_y, 0)
        # 4번 cctv 인 경우
        elif graph[cctv_x][cctv_y] == 4:
            # 상 우 하
            if now_direction == 0:
                cctv_check(cctv_x, cctv_y, 0)
                cctv_check(cctv_x, cctv_y, 1)
                cctv_check(cctv_x, cctv_y, 2)
            # 우 하 좌
            elif now_direction == 1:
                cctv_check(cctv_x, cctv_y, 1)
                cctv_check(cctv_x, cctv_y, 2)
                cctv_check(cctv_x, cctv_y, 3)
            # 하 좌 상
            elif now_direction == 2:
                cctv_check(cctv_x, cctv_y, 2)
                cctv_check(cctv_x, cctv_y, 3)
                cctv_check(cctv_x, cctv_y, 0)
            # 좌 상 우
            elif now_direction == 3:
                cctv_check(cctv_x, cctv_y, 3)
                cctv_check(cctv_x, cctv_y, 0)
                cctv_check(cctv_x, cctv_y, 1)
        # 5번 cctv 인 경우
        elif graph[cctv_x][cctv_y] == 5:
            cctv_check(cctv_x, cctv_y, 0)
            cctv_check(cctv_x, cctv_y, 1)
            cctv_check(cctv_x, cctv_y, 2)
            cctv_check(cctv_x, cctv_y, 3)
    temp_min = 0
    for i in range(N):
        for j in range(M):
            if temp_graph[i][j] == 0:
                temp_min += 1
    if result > temp_min:
        result = temp_min

print(result)



