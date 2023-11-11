import sys
from collections import deque

R, C = map(int, input().split())
graph = []
for _ in range(R):
    one_line = list(map(str, sys.stdin.readline().rstrip()))
    graph.append(one_line)
j_visited = [[False for _ in range(C)] for _ in range(R)]
f_visited = [[False for _ in range(C)] for _ in range(R)]
# 탐색할 방향
vector = [[-1, 0], [1, 0], [0, -1], [0, 1]]
queue = deque()
count = 0

for i in range(R):
    for j in range(C):
        if graph[i][j] == 'F':
            queue.append((i, j, count, 'F'))
            f_visited[i][j] = True


def f_bfs():
    while queue:
        x, y, now_count, s = queue.popleft()
        # 큐에서 빼서 몇번째에 불이 번지는지 기록
        graph[x][y] = now_count
        if s == 'F':
            for v in vector:
                nx = x + v[0]
                ny = y + v[1]
                if nx < 0 or ny < 0 or nx >= R or ny >= C:
                    continue
                if graph[nx][ny] == '#' or graph[nx][ny] == 'J':
                    continue
                if not f_visited[nx][ny]:
                    queue.append((nx, ny, now_count + 1, 'F'))
                    f_visited[nx][ny] = True


f_bfs()
# 지훈의 위치 탐색
for i in range(R):
    for j in range(C):
        if graph[i][j] == 'J':
            queue.append((i, j, count, 'J'))
            j_visited[i][j] = True

# 남아있는 불에 안탄 길은 갈 수 있으므로 최대값으로 초기화 해버림
for i in range(R):
    for j in range(C):
        if graph[i][j] == '.':
            graph[i][j] = 1000 * 10000


def bfs():
    result = 0
    # 출구를 찾으면 반복문 탈출하기위해 check
    check = False
    while queue:
        if check:
            break
        x, y, now_count, s = queue.popleft()
        if s == 'J':
            for v in vector:
                nx = x + v[0]
                ny = y + v[1]
                if nx < 0 or ny < 0 or nx >= R or ny >= C:
                    # 출구
                    result = now_count + 1
                    check = True
                    break
                # 불이 있는 위치와 벽과 원래 자리로 되돌아가는건 막기
                if graph[nx][ny] == 'F' or graph[nx][ny] == '#' or graph[nx][ny] == 'J':
                    continue
                # 지훈이 가려고 하는 위치가 이미 불에 타고 있으면 못감
                if graph[nx][ny] <= now_count + 1:
                    continue
                if not j_visited[nx][ny]:
                    queue.append((nx, ny, now_count + 1, 'J'))
                    j_visited[nx][ny] = True
    # 출구를 찾았으면
    if check:
        return result
    else:
        return -1


r_result = bfs()
# 출구를 찾았으면 그 값 출력 아니면 불가능 출력
if r_result > 0:
    print(r_result)
else:
    print('IMPOSSIBLE')
