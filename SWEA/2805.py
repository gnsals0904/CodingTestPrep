t = int(input())
for tc in range(t):
    N = int(input())
    graph = []
    for _ in range(N):
        one_line = list(map(int, input()))
        graph.append(one_line)
    result = 0
    switch = False
    K = N // 2
    for i in range(N):
        for j in range(N):
            if K <= j < N - K:
                result += graph[i][j]
        if K == 0:
            switch = True
        if switch:
            K += 1
        else:
            K -= 1
    print("#" + str(tc + 1), result)

