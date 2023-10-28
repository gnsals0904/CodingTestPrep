import sys
from collections import deque

M, N, H = map(int, input().split())

# 3차원 공간에 넣기
graph = [[] for _ in range(H)]
visited = [[[False] * M for _ in range(N)] for _ in range(H)]
for k in range(H):
    for _ in range(N):
        one_line = list(map(int, sys.stdin.readline().split()))
        graph[k].append(one_line)
# 방향 벡터
vector = [[0, 1, 0], [0, -1, 0], [0, 0, 1], [0, 0, -1], [1, 0, 0], [-1, 0, 0]]


def bfs():
    while queue:
        z, x, y = queue.popleft()
        # 범위를 벗어나면 안돼
        for v in vector:
            vz = z + v[0]
            vx = x + v[1]
            vy = y + v[2]
            if vz < 0 or vz >= H or vx < 0 or vx >= N or vy < 0 or vy >= M:
                continue
            if graph[vz][vx][vy] == 0 and not visited[vz][vx][vy]:
                queue.append((vz, vx, vy))
                visited[vz][vx][vy] = True
                graph[vz][vx][vy] = graph[z][x][y] + 1


# 돌면서 1찾기 찾으면 큐에 넣기
queue = deque()
for k in range(H):
    for i in range(N):
        for j in range(M):
            if graph[k][i][j] == 1:
                queue.append((k, i, j))

# bfs 돌리기
bfs()

# 0이 남아있는지 체크 & result 값 체크
result = 0
check = False
for k in range(H):
    for i in range(N):
        for j in range(M):
            if graph[k][i][j] == 0:
                check = True
                break
            if graph[k][i][j] > result:
                result = graph[k][i][j]

# 정답 출력
if not check:
    print(result - 1)
else:
    print(-1)
