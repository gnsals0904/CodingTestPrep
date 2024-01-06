N = int(input())


def hanoi(n, a, b):
    if n == 1:
        print(a, b)
    else:
        hanoi(n - 1, a, 6 - a - b)
        hanoi(1, a, b)
        hanoi(n - 1, 6 - a - b, b)


print(2 ** N - 1)
hanoi(N, 1, 3)
