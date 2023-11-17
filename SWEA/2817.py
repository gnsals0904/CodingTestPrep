def func(k, total):
    if total == K:
        result.append(1)
        return
    if k == N:
        return
    func(k + 1, total)
    func(k + 1, total + num_list[k])


T = int(input())
for test_case in range(T):
    result = []
    N, K = map(int, input().split())
    num_list = list(map(int, input().split()))
    func(0, 0)
    print(f"#{test_case + 1} {sum(result)}")
