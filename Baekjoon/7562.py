import sys
from collections import deque


def bfs():
    while queue:
        x, y, count = queue.popleft()
        for v in vector:
            nx = x + v[0]
            ny = y + v[1]
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if graph[nx][ny] != 0:
                continue
            queue.append((nx, ny, count + 1))
            graph[nx][ny] = count + 1
            if nx == finish_x and ny == finish_y:
                return


t = int(input())
vector = [[-1, -2], [-2, -1], [-2, 1], [-1, 2], [1, 2], [2, 1], [2, -1], [1, -2]]
for _ in range(t):
    n = int(input())
    graph = [[0 for _ in range(n)] for _ in range(n)]
    start_x, start_y = map(int, sys.stdin.readline().split())
    finish_x, finish_y = map(int, sys.stdin.readline().split())
    queue = deque()
    queue.append((start_x, start_y, 0))
    if start_x == finish_x and start_y == finish_y:
        print(0)
    else:
        bfs()
        print(graph[finish_x][finish_y])
