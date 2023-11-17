from collections import deque

N = int(input())
graph = []
num_max = 0
for _ in range(N):
    one_line = list(map(int, input().split()))
    temp = max(one_line)
    if temp > num_max:
        num_max = temp
    graph.append(one_line)
vector = [[1, 0], [-1, 0], [0, -1], [0, 1]]
result = 0


def bfs():
    while queue:
        x, y = queue.popleft()
        for v in vector:
            nx = x + v[0]
            ny = y + v[1]
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if graph[nx][ny] <= i:
                continue
            if not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx, ny))


for i in range(num_max + 1):
    queue = deque()
    temp_result = 0
    visited = [[False for _ in range(N)] for _ in range(N)]
    for i1 in range(N):
        for j1 in range(N):
            if not visited[i1][j1]:
                if graph[i1][j1] > i:
                    queue.append((i1, j1))
                    visited[i1][j1] = True
                    bfs()
                    temp_result += 1
    if temp_result > result:
        result = temp_result
print(result)


