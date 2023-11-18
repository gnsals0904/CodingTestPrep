def func(k):
    # 다 놓은 경우
    if k == N:
        result.append(1)
        return
    for i in range(N):
        if not is_used1[i] and not is_used2[k + i] and not is_used3[i - k + N - 1]:
            is_used1[i] = True
            is_used2[k + i] = True
            is_used3[i - k + N - 1] = True
            func(k + 1)
            is_used1[i] = False
            is_used2[k + i] = False
            is_used3[i - k + N - 1] = False


T = int(input())
for test_case in range(T):
    N = int(input())
    # 체스판
    graph = [[0 for _ in range(N)] for _ in range(N)]
    # 세로
    is_used1 = [False for _ in range(N)]
    # / 방향
    is_used2 = [False for _ in range(N * 2 - 1)]
    # \ 방향
    is_used3 = [False for _ in range(N * 2 - 1)]
    # 결과 저장
    result = []
    # 백트래킹 진행
    func(0)
    print(f"#{test_case + 1} {sum(result)}")
