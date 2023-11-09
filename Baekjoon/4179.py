import sys
from collections import deque

R, C = map(int, input().split())
graph = []
for _ in range(R):
    one_line = list(map(str, sys.stdin.readline().rstrip()))
    graph.append(one_line)
j_visited = [[False for _ in range(C)] for _ in range(R)]
f_visited = [[False for _ in range(C)] for _ in range(R)]
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
for i in range(R):
    for j in range(C):
        if graph[i][j] == 'J':
            queue.append((i, j, count, 'J'))
            j_visited[i][j] = True
for i in range(R):
    for j in range(C):
        if graph[i][j] == '.':
            graph[i][j] = 1000 * 10000


def bfs():
    result = 0
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
                    result = now_count + 1
                    check = True
                    break
                if graph[nx][ny] == 'F' or graph[nx][ny] == '#' or graph[nx][ny] == 'J':
                    continue
                if graph[nx][ny] <= now_count + 1:
                    continue
                if not j_visited[nx][ny]:
                    queue.append((nx, ny, now_count + 1, 'J'))
                    j_visited[nx][ny] = True
    if check:
        return result
    else:
        return -1


r_result = bfs()
if r_result > 0:
    print(r_result)
else:
    print('IMPOSSIBLE')
