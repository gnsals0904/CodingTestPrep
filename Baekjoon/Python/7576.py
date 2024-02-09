import sys
from collections import deque


def bfs():
    while queue:
        x, y = queue.popleft()
        for v in vector:
            nx = x + v[0]
            ny = y + v[1]
            # 범위 넘어가면 무시
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            # 토마토가 있을 때만
            if graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))


# m 상자의 가로 / n 상자의 세로수
m, n = map(int, input().split())
graph = []
for i in range(n):
    one_line = list(map(int, sys.stdin.readline().split()))
    graph.append(one_line)

# 방향 정의
vector = [[-1, 0], [1, 0], [0, -1], [0, 1]]

max_result = 0
check = False
queue = deque()

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            queue.append((i, j))

bfs()

for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            check = True
            break
    temp_max = max(graph[i])
    if max_result < temp_max:
        max_result = temp_max

if check:
    print(-1)
elif max_result == 1:
    print(0)
else:
    print(max_result - 1)

