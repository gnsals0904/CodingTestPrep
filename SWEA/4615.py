# 1이 흑돌 2가 백돌
def put_doll(cor_x, cor_y, doll_color):
    graph[cor_x][cor_y] = doll_color
    # 놓는 돌 기준 좌측 확인
    for i in range(cor_y - 1, -1, -1):
        # 비었으므로 더 확인 x
        if graph[cor_x][i] == 0:
            break
        # 다른 돌이면 일단 넘어감
        elif graph[cor_x][i] != doll_color:
            continue
        # 사이의 돌 색 전부 바꿔야함
        elif graph[cor_x][i] == doll_color:
            for j in range(cor_y - 1, i, -1):
                graph[cor_x][j] = doll_color
            # 다 했으면 break
            break
    # 놓는 돌 기준 우측 확인
    for i in range(cor_y + 1, N):
        # 비었으므로 더 확인 x
        if graph[cor_x][i] == 0:
            break
        # 다른 돌이면 일단 넘어감
        elif graph[cor_x][i] != doll_color:
            continue
        # 사이의 돌 색 전부 바꿔야함
        elif graph[cor_x][i] == doll_color:
            for j in range(cor_y + 1, i):
                graph[cor_x][j] = doll_color
            # 다 했으면 break
            break
    # 놓는 돌 기준 아래 확인
    for i in range(cor_x + 1, N):
        # 비었으므로 더 확인 x
        if graph[i][cor_y] == 0:
            break
        # 다른 돌이면 일단 넘어감
        elif graph[i][cor_y] != doll_color:
            continue
        # 사이의 돌 색 전부 바꿔야함
        elif graph[i][cor_y] == doll_color:
            for j in range(cor_x + 1, i):
                graph[j][cor_y] = doll_color
            # 다 했으면 break
            break
    # 놓는 돌 기준 위 확인
    for i in range(cor_x - 1, -1, -1):
        # 비었으므로 더 확인 x
        if graph[i][cor_y] == 0:
            break
        # 다른 돌이면 일단 넘어감
        elif graph[i][cor_y] != doll_color:
            continue
        # 사이의 돌 색 전부 바꿔야함
        elif graph[i][cor_y] == doll_color:
            for j in range(cor_x - 1, i, -1):
                graph[j][cor_y] = doll_color
            # 다 했으면 break
            break
    # 놓는 돌 기준 좌측 상단 확인
    for i in range(1, N):
        nx = cor_x - i
        ny = cor_y - i
        # graph 밖으로 나가면 다 확인한 것
        if nx < 0 or ny < 0:
            break
        # 비었으므로 더 확인 x
        if graph[nx][ny] == 0:
            break
        # 다른 돌이면 일단 넘어감
        elif graph[nx][ny] != doll_color:
            continue
        # 사이의 돌 색 전부 바꿔야함
        elif graph[nx][ny] == doll_color:
            for j in range(1, i):
                graph[cor_x - j][cor_y - j] = doll_color
            # 다 했으면 break
            break
    # 놓는 돌 기준 우측 하단 확인
    for i in range(1, N):
        nx = cor_x + i
        ny = cor_y + i
        # graph 밖으로 나가면 다 확인한 것
        if nx >= N or ny >= N:
            break
        # 비었으므로 더 확인 x
        if graph[nx][ny] == 0:
            break
        # 다른 돌이면 일단 넘어감
        elif graph[nx][ny] != doll_color:
            continue
        # 사이의 돌 색 전부 바꿔야함
        elif graph[nx][ny] == doll_color:
            for j in range(1, i):
                graph[cor_x + j][cor_y + j] = doll_color
            # 다 했으면 break
            break
    # 놓는 돌 기준 우측 상단 확인
    for i in range(1, N):
        nx = cor_x - i
        ny = cor_y + i
        # graph 밖으로 나가면 다 확인한 것
        if nx < 0 or nx >= N or ny < 0 or ny >= N:
            break
        # 비었으므로 더 확인 x
        if graph[nx][ny] == 0:
            break
        # 다른 돌이면 일단 넘어감
        elif graph[nx][ny] != doll_color:
            continue
        # 사이의 돌 색 전부 바꿔야함
        elif graph[nx][ny] == doll_color:
            for j in range(1, i):
                graph[cor_x - j][cor_y + j] = doll_color
            # 다 했으면 break
            break
    # 놓는 돌 기준 좌측 하단 확인
    for i in range(1, N):
        nx = cor_x + i
        ny = cor_y - i
        # graph 밖으로 나가면 다 확인한 것
        if nx < 0 or nx >= N or ny < 0 or ny >= N:
            break
        # 비었으므로 더 확인 x
        if graph[nx][ny] == 0:
            break
        # 다른 돌이면 일단 넘어감
        elif graph[nx][ny] != doll_color:
            continue
        # 사이의 돌 색 전부 바꿔야함
        elif graph[nx][ny] == doll_color:
            for j in range(1, i):
                graph[cor_x + j][cor_y - j] = doll_color
            # 다 했으면 break
            break


T = int(input())
for test_case in range(T):
    N, M = map(int, input().split())
    graph = [[0 for _ in range(N)] for _ in range(N)]
    # 기본 세팅
    graph[N // 2][N // 2] = 2
    graph[N // 2 - 1][N // 2] = 1
    graph[N // 2][N // 2 - 1] = 1
    graph[N // 2 - 1][N // 2 - 1] = 2
    for _ in range(M):
        x, y, color = map(int, input().split())
        put_doll(x - 1, y - 1, color)
    result_1 = 0
    result_2 = 0
    for i1 in range(N):
        for j1 in range(N):
            if graph[i1][j1] == 1:
                result_1 += 1
            elif graph[i1][j1] == 2:
                result_2 += 1
    print(f"#{test_case + 1} {result_1} {result_2}")
