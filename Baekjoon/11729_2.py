def func(a, b, k):
    if k == 1:
        print(a, b)
    else:
        func(a, 6 - a - b, k - 1)
        func(a, b, 1)
        func(6 - a - b, b, k - 1)


N = int(input())

print(2 ** N - 1)
func(1, 3, N)

