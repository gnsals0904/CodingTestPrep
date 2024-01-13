import sys
from collections import deque


def bfs():
    while queue:
        x, y = queue.popleft()
        for v in vector:
            nx = x + v[0]
            ny = y + v[1]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if graph[nx][ny] == 0:
                continue
            if not visited[nx][ny]:
                visited[nx][ny] = True
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))


n, m = map(int, sys.stdin.readline().split())
graph = []
start_x = 0
start_y = 0
for i in range(n):
    one_line = list(map(int, sys.stdin.readline().split()))
    for j in range(m):
        if one_line[j] == 2:
            start_x = i
            start_y = j
    graph.append(one_line)

vector = [[-1, 0], [1, 0], [0, -1], [0, 1]]
queue = deque()
queue.append((start_x, start_y))
graph[start_x][start_y] = 0
visited = [[False for _ in range(m)] for _ in range(n)]
bfs()
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            if not visited[i][j]:
                graph[i][j] = -1
for i in range(n):
    print(*graph[i])
