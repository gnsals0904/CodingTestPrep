import sys
from collections import deque

N = int(input())
graph = []
# 일반
visited = [[False] * N for _ in range(N)]
count = 0

# 색약
visited2 = [[False] * N for _ in range(N)]
count2 = 0
for _ in range(N):
    one_line = sys.stdin.readline().strip()
    graph.append(one_line)
# 방향
vector = [[1, 0], [-1, 0], [0, 1], [0, -1]]


# 일반
def bfs(x, y):
    visited[x][y] = True
    queue = deque()
    queue.append((x, y))
    while queue:
        nx, ny = queue.popleft()
        for v in vector:
            n_x = nx + v[0]
            n_y = ny + v[1]
            if n_x < 0 or n_x >= N or n_y < 0 or n_y >= N:
                continue
            if graph[n_x][n_y] != graph[nx][ny]:
                continue
            if not visited[n_x][n_y]:
                queue.append((n_x, n_y))
                visited[n_x][n_y] = True


# 색약
def bfs2(x, y):
    visited2[x][y] = True
    queue = deque()
    queue.append((x, y))
    while queue:
        nx, ny = queue.popleft()
        for v in vector:
            n_x = nx + v[0]
            n_y = ny + v[1]
            if n_x < 0 or n_x >= N or n_y < 0 or n_y >= N:
                continue
            if graph[nx][ny] == 'R' or graph[nx][ny] == 'G':
                if graph[n_x][n_y] == 'R' or graph[n_x][n_y] == 'G':
                    if not visited2[n_x][n_y]:
                        queue.append((n_x, n_y))
                        visited2[n_x][n_y] = True
            else:
                if graph[nx][ny] != graph[n_x][n_y]:
                    continue
                else:
                    if not visited2[n_x][n_y]:
                        queue.append((n_x, n_y))
                        visited2[n_x][n_y] = True


# 일반 BFS
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            bfs(i, j)
            count += 1

# 색약 BFS
for i in range(N):
    for j in range(N):
        if not visited2[i][j]:
            bfs2(i, j)
            count2 += 1

print(count, count2)
