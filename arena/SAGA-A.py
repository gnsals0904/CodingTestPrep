N = int(input())
shirt = list(map(int, input().split()))
T, P = map(int, input().split())
t_result = 0
for i in range(6):
    if shirt[i] % T == 0:
        t_result += shirt[i] // T
    else:
        t_result += shirt[i] // T + 1
print(t_result)
print(N // P, N % P)
