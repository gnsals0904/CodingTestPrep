M, N = map(int, input().split())
prime_list = [True for _ in range(N + 1)]
prime_list[0] = False
prime_list[1] = False
for i in range(2, N + 1):
    if not prime_list[i]:
        continue
    for j in range(i * i, N + 1, i):
        prime_list[j] = False
for k in range(M, N + 1):
    if prime_list[k]:
        print(k)
