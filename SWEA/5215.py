def func(k):
    global max_f
    global sum_k
    global sum_f
    if k == N:
        return
    if max_f < sum_f:
        max_f = sum_f
    start = 0
    if k != 0:
        start = k
    for j in range(start, N):
        if not visited[j]:
            sum_k += bugger_info[j][1]
            visited[j] = True
            sum_f += bugger_info[j][0]
            func(k + 1)
            visited[j] = False
            sum_k -= bugger_info[j][1]
            sum_f -= bugger_info[j][0]


t = int(input())
for tc in range(t):
    N, L = map(int, input().split())
    bugger_info = []
    for i in range(N):
        one_line = list(map(int, input().split()))
        bugger_info.append(one_line)
    # [0] = F // [1] = K
    visited = [False for _ in range(N)]
    sum_k = 0
    max_f = 0
    sum_f = 0
    # back tracking
    func(0)
    print("#" + str(tc + 1), max_f)
