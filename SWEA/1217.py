def recursion1(n, m):
    if m == 1:
        return n
    if m % 2 == 0:
        return recursion1(n, m // 2) * recursion1(n, m // 2)
    else:
        return recursion1(n, m // 2) * recursion1(n, m - m // 2)


for tc in range(10):
    t = int(input())
    N, M = map(int, input().split())
    result = recursion1(N, M)
    print("#" + str(tc + 1), result)
