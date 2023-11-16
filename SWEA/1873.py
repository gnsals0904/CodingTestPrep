# .	평지(전차가 들어갈 수 있다.)
# *	벽돌로 만들어진 벽
# 	강철로 만들어진 벽
# -	물(전차는 들어갈 수 없다.)
# ^	위쪽을 바라보는 전차(아래는 평지이다.)
# v	아래쪽을 바라보는 전차(아래는 평지이다.)
# <	왼쪽을 바라보는 전차(아래는 평지이다.)
# >	오른쪽을 바라보는 전차(아래는 평지이다.)

# U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
# D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
# L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
# R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
# S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
# 전차가 이동을 하려고 할 때, 만약 게임 맵 밖이라면 전차는 당연히 이동하지 않는다.
# 전차가 포탄을 발사하면, 포탄은 벽돌로 만들어진 벽 또는 강철로 만들어진 벽에 충돌하거나 게임 맵 밖으로 나갈 때까지 직진한다.
# 만약 포탄이 벽에 부딪히면 포탄은 소멸하고, 부딪힌 벽이 벽돌로 만들어진 벽이라면 이 벽은 파괴되어 칸은 평지가 된다.
# 강철로 만들어진 벽에 포탄이 부딪히면 아무 일도 일어나지 않는다.

T = int(input())
for test_case in range(T):
    H, W = map(int, input().split())
    map_graph = []
    for _ in range(H):
        one_line = list(map(str, input()))
        map_graph.append(one_line)
    N = input()
    order = input()
    now_x = 0
    now_y = 0
    # 전차 위치 찾기
    for i in range(H):
        for j in range(W):
            if map_graph[i][j] == '<' or map_graph[i][j] == '>' or map_graph[i][j] == 'v' or map_graph[i][j] == '^':
                now_x = i
                now_y = j
                break
    # 명령 진행
    for x in order:
        if x == 'U':
            now_x = now_x - 1
            if now_x < 0:
                now_x = now_x + 1
                map_graph[now_x][now_y] = '^'
                continue
            if map_graph[now_x][now_y] == '.':
                map_graph[now_x][now_y] = '^'
                map_graph[now_x + 1][now_y] = '.'
            else:
                now_x = now_x + 1
                map_graph[now_x][now_y] = '^'
        elif x == 'D':
            now_x = now_x + 1
            if now_x >= H:
                now_x = now_x - 1
                map_graph[now_x][now_y] = 'v'
                continue
            if map_graph[now_x][now_y] == '.':
                map_graph[now_x][now_y] = 'v'
                map_graph[now_x - 1][now_y] = '.'
            else:
                now_x = now_x - 1
                map_graph[now_x][now_y] = 'v'
        elif x == 'L':
            now_y = now_y - 1
            if now_y < 0:
                now_y = now_y + 1
                map_graph[now_x][now_y] = '<'
                continue
            if map_graph[now_x][now_y] == '.':
                map_graph[now_x][now_y] = '<'
                map_graph[now_x][now_y + 1] = '.'
            else:
                now_y = now_y + 1
                map_graph[now_x][now_y] = '<'
        elif x == 'R':
            now_y = now_y + 1
            if now_y >= W:
                now_y = now_y - 1
                map_graph[now_x][now_y] = '>'
                continue
            if map_graph[now_x][now_y] == '.':
                map_graph[now_x][now_y] = '>'
                map_graph[now_x][now_y - 1] = '.'
            else:
                now_y = now_y - 1
                map_graph[now_x][now_y] = '>'
        elif x == 'S':
            if map_graph[now_x][now_y] == '>':
                for k in range(now_y + 1, W):
                    if map_graph[now_x][k] == '#':
                        break
                    if map_graph[now_x][k] == '*':
                        map_graph[now_x][k] = '.'
                        break
            elif map_graph[now_x][now_y] == '<':
                for k in range(now_y - 1, -1, -1):
                    if map_graph[now_x][k] == '#':
                        break
                    if map_graph[now_x][k] == '*':
                        map_graph[now_x][k] = '.'
                        break
            elif map_graph[now_x][now_y] == 'v':
                for k in range(now_x + 1, H):
                    if map_graph[k][now_y] == '#':
                        break
                    if map_graph[k][now_y] == '*':
                        map_graph[k][now_y] = '.'
                        break
            elif map_graph[now_x][now_y] == '^':
                for k in range(now_x - 1, -1, -1):
                    if map_graph[k][now_y] == '#':
                        break
                    if map_graph[k][now_y] == '*':
                        map_graph[k][now_y] = '.'
                        break
    print(f"#{test_case + 1}", ''.join(map_graph[0]))
    for i in range(1, H):
        print(''.join(map_graph[i]))
