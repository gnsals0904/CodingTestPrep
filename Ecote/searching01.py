N = int(input())
array = list(map(int, input().split()))
M = int(input())
array2 = list(map(int, input().split()))

for i in range(M):
    if array2[i] in array:
        print("yes", end=" ")
    else:
        print("no", end=" ")
