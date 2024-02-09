A, B = map(int, input().split())
C = int(input())
sum = A + B
if sum < 2 * C:
    print(sum)
elif sum == 2 * C:
    print(0)
else:
    print(sum - 2 * C)
