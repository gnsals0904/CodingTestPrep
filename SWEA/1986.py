t = int(input())
for i in range(t):
    result = 0
    n = int(input())
    for j in range(n + 1):
        if j % 2 == 0:
            result -= j
        else:
            result += j
    print("#" + str(i + 1), result)

