import sys
sys.setrecursionlimit(10 ** 6)


def dfs(node_num, count):
    visited[node_num] = True
    flag = False
    for v in graph[node_num]:
        if not visited[v]:
            flag = True
            dfs(v, count + 1)
    if not flag:
        result.append(count)


n = int(sys.stdin.readline().rstrip())
graph = [[] for _ in range(n + 1)]
visited = [False for _ in range(n + 1)]
result = []
for _ in range(n - 1):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)
dfs(1, 0)
result1 = sum(result)
if result1 % 2 == 0:
    print('No')
else:
    print('Yes')
