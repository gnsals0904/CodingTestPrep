N = int(input())
graph = []
for _ in range(N):
    one_line = list(map(int, input()))
    graph.append(one_line)
ans = []


def quad_tree(start_i, start_j, size):
    half = size // 2
    num = graph[start_i][start_j]
    for i in range(start_i, start_i + size):
        for j in range(start_j, start_j + size):
            if num != graph[i][j]:
                ans.append("(")
                quad_tree(start_i, start_j, half)
                quad_tree(start_i, start_j + half, half)
                quad_tree(start_i + half, start_j, half)
                quad_tree(start_i + half, start_j + half, half)
                ans.append(")")
                return
    ans.append(num)
    return


quad_tree(0, 0, N)
print(*ans, sep="")
