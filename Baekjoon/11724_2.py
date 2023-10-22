import sys
sys.setrecursionlimit(1000000)


n, m = map(int, sys.stdin.readline().split())
relationship_list = [[] for _ in range(n + 1)]
for _ in range(m):
    u, v = map(int, sys.stdin.readline().split())
    relationship_list[v].append(u)
    relationship_list[u].append(v)
visited = [False] * (n + 1)


def dfs(x):
    if not visited[x]:
        visited[x] = True
        for y in relationship_list[x]:
            if not visited[y]:
                dfs(y)
        return 1
    else:
        return 0


result = []
for i in range(1, n + 1):
    result.append(dfs(i))
print(sum(result))
