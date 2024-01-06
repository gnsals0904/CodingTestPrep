import sys


T = int(input())
for _ in range(T):
    N, M = map(int, sys.stdin.readline().split())
    A = list(map(int, sys.stdin.readline().split()))
    B = list(map(int, sys.stdin.readline().split()))
    A.sort()
    B.sort()
    result = 0
    j = 0
    count = 0
    flag = False
    for i in range(N):
        while j < M:
            if A[i] <= B[j]:
                result += count
                break
            else:
                count += 1
            j += 1
            if j == M:
                flag = True
        if flag:
            result += count
    print(result)
