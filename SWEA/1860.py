from collections import deque

T = int(input())
for test_case in range(T):
    N, M, K = map(int, input().split())
    customer = list(map(int, input().split()))
    customer.sort()
    queue = deque(customer)
    now_second = 0
    boong = 0
    flag = False
    while queue:
        temp = queue[0]
        if now_second <= temp < now_second + M:
            if boong == 0:
                print(f"#{test_case + 1} Impossible")
                flag = True
                break
            else:
                boong -= 1
                queue.popleft()
                continue
        now_second += M
        boong += K
    if not flag:
        print(f"#{test_case + 1} Possible")
