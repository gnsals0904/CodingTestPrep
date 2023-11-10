from collections import deque


def bfs():
    count = 1
    while queue:
        x, y = queue.popleft()
        for v in vector:
            nx = x + v[0]
            ny = y + v[1]
            if nx < 0 or nx >= M or ny < 0 or ny >= N:
                continue
            if visited[nx][ny]:
                continue
            if graph[nx][ny] == 0:
                queue.append((nx, ny))
                visited[nx][ny] = True
                count += 1
    return count


M, N, K = map(int, input().split())
graph = [[0 for _ in range(N)] for _ in range(M)]
visited = [[False for _ in range(N)] for _ in range(M)]
for _ in range(K):
    x1, y1, x2, y2 = map(int, input().split())
    for i in range(y1, y2):
        for j in range(x1, x2):
            graph[i][j] = 1

queue = deque()
area_num = 0
each_area_list = []
vector = [[1, 0], [-1, 0], [0, 1], [0, -1]]
for i1 in range(M):
    for j1 in range(N):
        if graph[i1][j1] == 0 and not visited[i1][j1]:
            queue.append((i1, j1))
            visited[i1][j1] = True
            each_area_list.append(bfs())
            area_num += 1
each_area_list.sort()
print(area_num)
print(*each_area_list)
