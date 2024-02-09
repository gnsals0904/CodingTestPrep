import sys
sys.setrecursionlimit(1000000)


vertex_num = int(input())
edge_num = vertex_num - 1
relation_list = [[] for _ in range(vertex_num + 1)]
result_list = [[] for _ in range(vertex_num + 1)]
for i in range(edge_num):
    v1, v2 = map(int, input().split())
    relation_list[v1].append(v2)
    relation_list[v2].append(v1)
visited = []
for j in range(vertex_num + 1):
    visited.append(False)


def dfs(v, previous_v):
    if len(result_list[v]) == 0 and v != 1:
        result_list[v].append(previous_v)
    for x in relation_list[v]:
        if len(result_list[x]) == 0:
            dfs(x, v)


dfs(1, 0)
for k in range(2, vertex_num + 1):
    print(result_list[k][0])

