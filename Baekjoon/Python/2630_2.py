import sys
sys.setrecursionlimit(1000000)


def cut_paper(x, y, n):
    global white_num
    global blue_num
    if n == 1:
        if graph[x][y] == 1:
            blue_num += 1
            return
        else:
            white_num += 1
            return
    for i in range(x, x + n):
        for j in range(y, y + n):
            if graph[x][y] != graph[i][j]:
                cut_paper(x, y, n // 2)
                cut_paper(x + n // 2, y, n // 2)
                cut_paper(x, y + n // 2, n // 2)
                cut_paper(x + n // 2, y + n // 2, n // 2)
                return
    if graph[x][y] == 1:
        blue_num += 1
    else:
        white_num += 1


N = int(sys.stdin.readline().rstrip())
graph = []
white_num = 0
blue_num = 0
for _ in range(N):
    one_line = list(map(int, sys.stdin.readline().split()))
    graph.append(one_line)
cut_paper(0, 0, N)
print(white_num)
print(blue_num)
