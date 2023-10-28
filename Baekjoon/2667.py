def dfs(x, y):
    if 0 <= x < N and 0 <= y < N:
        if not visited[x][y] and graph[x][y] != 0:
            visited[x][y] = True
            graph[x][y] = all_count
            for z in vector:
                dfs(x + z[0], y + z[1])


N = int(input())
graph = []
visited = []
house_count = []
all_count = 1
vector = [[-1, 0], [0, -1], [0, +1], [+1, 0]]
# graph input
for i in range(N):
    one_line = list(map(int, input()))
    visited_line = [False] * N
    visited.append(visited_line)
    graph.append(one_line)


# search all
for i in range(N):
    for j in range(N):
        if not visited[i][j] and graph[i][j] != 0:
            dfs(i, j)
            all_count += 1


for i in range(1, all_count):
    temp = 0
    for j in range(N):
        temp += graph[j].count(i)
    house_count.append(temp)

house_count.sort()
print(all_count - 1)
for x in house_count:
    print(x)
