def dfs(v, count, visit_graph):
    if not visit_graph[v]:
        count += 1
        visit_graph[v] = True
        for nv in graph[v]:
            dfs(nv, count, visit_graph)
        visit_graph[v] = False
    result.append(count)


T = int(input())
for test_case in range(T):
    N, M = map(int, input().split())
    vertex_list = [i for i in range(1, N + 1)]
    graph = [[] for _ in range(N + 1)]
    visited = [False for _ in range(N + 1)]
    for _ in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    # 답을 저장할 list
    result = []
    for i in range(1, N + 1):
        dfs(i, 0, visited)
    print(f"#{test_case + 1} {max(result)}")
