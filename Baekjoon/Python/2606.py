def dfs(graph, v, visited):
    visited[v] = True
    addict_vertex.append(v)
#    print(v, end=' ')
    for j in range(vertex_num + 1):
        graph[j].sort()
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)


vertex_num = int(input())
e = int(input())
addict_vertex = list()
graph = [[] for i in range(vertex_num + 1)]
for k in range(e):
    x, y = map(int, input().split())
    if y not in graph[x]:
        graph[x].append(y)
    if x not in graph[y]:
        graph[y].append(x)

visited = [False] * (vertex_num + 1)
dfs(graph, 1, visited)

print(len(addict_vertex) - 1)
