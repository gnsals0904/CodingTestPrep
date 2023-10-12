N = int(input())
for i in range(1, N + 1):
    i = str(i)
    sum_count = 0
    sum_count += i.count('3')
    sum_count += i.count('6')
    sum_count += i.count('9')
    if int(i) != N:
        if sum_count == 0:
            print(i, end=" ")
        elif sum_count == 1:
            print('-', end=" ")
        elif sum_count == 2:
            print('--', end=" ")
        else:
            print('---', end=" ")
    else:
        if sum_count == 0:
            print(i, end="")
        elif sum_count == 1:
            print('-', end="")
        elif sum_count == 2:
            print('--', end="")
        else:
            print('---', end="")
