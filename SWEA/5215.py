t = int(input())
for tc in range(t):
    N, L = map(int, input().split())
    bugger_info = []
    for i in range(N):
        one_line = list(map(int, input().split()))
        bugger_info.append(one_line)
    bugger_info.sort(key=lambda x: x[1])

    print("#" + str(tc + 1))
