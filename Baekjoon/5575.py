A = list(map(int,input().split()))
B = list(map(int,input().split()))
C = list(map(int,input().split()))
result = list()
# if A[3] > A[0] and A[4] > A[1] and A[5] > A[2]:
#     print(A[3]-A[0], A[4]-A[1], A[5]-A[2])
print(A)
for i in range(2):
    if A[i+3] < A[i]:
        print(A[i])
        A[i] = A[i] + 60
        print(A[i])
        A[i + 1] = A[i + 1] - 1
        result[i] = (A[i + 3] - A[i])
print(A)
print(result)