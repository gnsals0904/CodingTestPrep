from collections import deque


def dfs(graph1, v, visited1):
    visited1[v] = True
    print(v, end=' ')
    for j in range(N + 1):
        graph1[j].sort()
    for i in graph1[v]:
        if not visited1[i]:
            dfs(graph1, i, visited1)


def bfs(graph2, started, visited2):
    queue = deque([started])
    visited2[started] = True
    for j in range(N + 1):
        graph2[j].sort()
    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for i in graph2[v]:
            if not visited2[i]:
                queue.append(i)
                visited[i] = True


N, M, V = map(int, input().split())
graph = [[] for i in range(N + 1)]
for _ in range(M):
    x, y = map(int, input().split())
    if y not in graph[x]:
        graph[x].append(y)
    if x not in graph[y]:
        graph[y].append(x)


visited = [False] * (N + 1)
dfs(graph, V, visited)
print("")
visited = [False] * (N + 1)
bfs(graph, V, visited)
