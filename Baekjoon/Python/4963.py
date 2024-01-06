import sys
sys.setrecursionlimit(1000000)


def dfs(x_index, y_index, visited_list):
    if 0 <= x_index < h and 0 <= y_index < w:
        if not visited_list[x_index][y_index] and map_list[x_index][y_index] == 1:
            visited_list[x_index][y_index] = True
            dfs(x_index - 1, y_index, visited_list)
            dfs(x_index + 1, y_index, visited_list)
            dfs(x_index, y_index - 1, visited_list)
            dfs(x_index, y_index + 1, visited_list)
            dfs(x_index + 1, y_index + 1, visited_list)
            dfs(x_index - 1, y_index + 1, visited_list)
            dfs(x_index - 1, y_index - 1, visited_list)
            dfs(x_index + 1, y_index - 1, visited_list)


while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        exit()
    else:
        map_list = [[] for _ in range(h)]
        for i in range(h):
            one_line = list(map(int, input().split()))
            map_list[i].extend(one_line)
        visited = [[False] * w for _ in range(h)]
        island_num = 0
        for j in range(h):
            for k in range(w):
                if not visited[j][k] and map_list[j][k] == 1:
                    dfs(j, k, visited)
                    island_num += 1
        print(island_num)
