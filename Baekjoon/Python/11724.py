import sys
sys.setrecursionlimit(1000000)


def dfs(x):
    visited[x] = True
    for j in range(len(relationship_list)):
        if not visited[relationship_list[j][1]] and relationship_list[j][0] == x:
            new_x = relationship_list[j][1]
            dfs(new_x)
        elif not visited[relationship_list[j][0]] and relationship_list[j][1] == x:
            new_x = relationship_list[j][0]
            dfs(new_x)


n, m = map(int, sys.stdin.readline().split())
relationship_list = []
for _ in range(m):
    u, v = map(int, sys.stdin.readline().split())
    relationship_list.append([u, v])
visited = []
for i in range(n + 1):
    visited.append(False)
result = 0
for i in range(1, n + 1):
    if not visited[i]:
        dfs(i)
        result += 1
print(result)
