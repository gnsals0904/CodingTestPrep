import sys
from collections import deque

n, m = map(int, input().split())
graph = []
for _ in range(n):
    one_line = list(map(int, sys.stdin.readline().split()))
    graph.append(one_line)
visited = [[False for _ in range(m)] for _ in range(n)]
queue = deque()
painting_count = 0
painting_max = 0
vector = [[-1, 0], [1, 0], [0, -1], [0, 1]]


def bfs():
    temp = 0
    while queue:
        x, y = queue.popleft()
        temp += 1
        for v in vector:
            nx = x + v[0]
            ny = y + v[1]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if graph[nx][ny] == 1 and not visited[nx][ny]:
                queue.append((nx, ny))
                visited[nx][ny] = True
    return temp


for i in range(n):
    for j in range(m):
        if not visited[i][j] and graph[i][j] == 1:
            queue.append((i, j))
            visited[i][j] = True
            now_value = bfs()
            if now_value > painting_max:
                painting_max = now_value
            painting_count += 1
print(painting_count)
print(painting_max)
