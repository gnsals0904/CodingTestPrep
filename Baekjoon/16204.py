N, M, K = map(int, input().split())
if K == M:
    print(N)
elif K > M:
    print(M + N - K)
else:
    print(K + N - M)