def dfs(graph, v, visited):
    global result
    result += 1
    visited[v] = True
#    print(v, end=' ')
    for j in range(2 * e + 1):
        graph[j].sort()
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)


v = int(input())
e = int(input())
result = 0
graph = [[] for i in range(e * 2 + 1)]
for k in range(e):
    x, y = map(int, input().split())
    if y not in graph[x]:
        graph[x].append(y)
    if x not in graph[y]:
        graph[y].append(x)

visited = [False] * (e * 2 + 1)
dfs(graph, 1, visited)

print(result - 1)
