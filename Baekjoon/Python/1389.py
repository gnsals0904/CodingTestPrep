import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(N)]
for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    graph[a - 1].append(b - 1)
    graph[b - 1].append(a - 1)

queue = deque()
result = 0
min_result = (5000 + 5001) * 2500
for i in range(N):
    visited = [0 for _ in range(N)]
    queue.append(i)
    visited[i] = 1
    while queue:
        now_check = queue.popleft()
        for next_check in graph[now_check]:
            if visited[next_check] == 0:
                queue.append(next_check)
                visited[next_check] = visited[now_check] + 1
    now_sum = sum(visited)
    if min_result > now_sum:
        min_result = now_sum
        result = i + 1
print(result)
