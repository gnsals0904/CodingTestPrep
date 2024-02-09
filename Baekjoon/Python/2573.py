import sys
from collections import deque


def bfs(xp, yp):
    queue = deque()
    queue.append([xp, yp])
    visited[xp][yp] = True
    while queue:
        temp_v = queue.popleft()
        x = temp_v[0]
        y = temp_v[1]
        for nv in vector:
            n_x = x + nv[0]
            n_y = y + nv[1]
            if n_x < 0 or n_x >= N or n_y < 0 or n_y >= M:
                continue
            if r_graph[n_x][n_y] != 0:
                if not visited[n_x][n_y]:
                    queue.append([n_x, n_y])
                    visited[n_x][n_y] = True
            else:
                t_graph[x][y] += 1


N, M = map(int, sys.stdin.readline().split())
r_graph = []
for _ in range(N):
    one_line = list(map(int, sys.stdin.readline().split()))
    r_graph.append(one_line)
vector = [[1, 0], [-1, 0], [0, -1], [0, 1]]
flag = False
result = 0
while True:
    t_graph = [[0] * M for _ in range(N)]
    count = 0
    visited = [[False for _ in range(M)] for _ in range(N)]
    for i in range(N):
        for j in range(M):
            if r_graph[i][j] != 0:
                if not visited[i][j]:
                    count += 1
                    bfs(i, j)
    if count >= 2:
        break
    if count == 0:
        flag = True
        break

    for i in range(N):
        for j in range(M):
            if t_graph[i][j] == 0:
                continue
            if r_graph[i][j] >= t_graph[i][j]:
                r_graph[i][j] -= t_graph[i][j]
            else:
                r_graph[i][j] = 0
    result += 1

if not flag:
    print(result)
else:
    print(0)
