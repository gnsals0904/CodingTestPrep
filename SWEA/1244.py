t = int(input())
for test_case in range(t):
    a, b = map(int, input().split())
    a = str(a)
    len_a = len(a)
    now_try = set([a])
    next_try = set()

    while b:
        b -= 1
        while now_try:
            now = now_try.pop()
            now = list(now)
            for i in range(len_a):
                for j in range(len_a):
                    if i == j:
                        continue
                    else:
                        now[i], now[j] = now[j], now[i]
                        next_try.add(''.join(now))
                        now[i], now[j] = now[j], now[i]
        now_try, next_try = next_try, now_try

    now_try = list(now_try)
    print("#" + str(test_case + 1), max(now_try))
