A = list(map(int,input().split()))
B = list(map(int,input().split()))
A_sum = 0
B_sum = 0
for i in range(len(A)):
    A_sum = A_sum + A[i]
for i in range(len(B)):
    B_sum = B_sum + B[i]
if A_sum > B_sum:
    print(A_sum)
else:
    print(B_sum)