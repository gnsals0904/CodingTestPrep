from collections import deque


def bfs(x, y):
    # 미로 밖은 안돼
    queue = deque()
    queue.append((x, y))
    while queue:
        now_x, now_y = queue.popleft()
        for v in vector:
            nx = now_x + v[0]
            ny = now_y + v[1]
            if not (0 <= nx < n and 0 <= ny < m):
                continue
            if maze[nx][ny] == 0:
                continue
            if maze[nx][ny] == 1:
                maze[nx][ny] = maze[now_x][now_y] + 1
                queue.append((nx, ny))
    return maze[n - 1][m - 1]


n, m = map(int, input().split())
maze = [[] for _ in range(n)]
for i in range(n):
    one_line = input()
    for j in range(m):
        maze[i].append(int(one_line[j]))
vector = [[-1, 0], [0, -1], [0, 1], [1, 0]]
result = bfs(0, 0)
print(result)
