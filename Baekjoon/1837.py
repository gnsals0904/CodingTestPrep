P, K = map(int, input().split())
n = K - 1
check = False
a = [False, False] + [True] * (n - 1)
primes = []
for i in range(2, n + 1):
    if a[i]:
        primes.append(i)
        for j in range(2 * i, n + 1, i):
            a[j] = False
for n1 in primes:
    if P % n1 == 0:
        print("BAD", n1)
        check = True
        break
if not check:
    print("GOOD")


