A = list(map(int, input().split()))
B = list(map(int, input().split()))
C = list(map(int, input().split()))
r1, r2, r3 = 0, 0, 0

if A[5] - A[2] < 0:
    A[4] = A[4] - 1
    A[5] = A[5] + 60
    r3 = A[5] - A[2]
else:
    r3 = A[5] - A[2]
if A[4] - A[1] < 0:
    A[3] = A[3] - 1
    A[4] = A[4] + 60
    r2 = A[4] - A[1]
else:
    r2 = A[4] - A[1]
r1 = A[3] - A[0]
print(str(r1) + " " + str(r2) + " " + str(r3))

if B[5] - B[2] < 0:
    B[4] = B[4] - 1
    B[5] = B[5] + 60
    r3 = B[5] - B[2]
else:
    r3 = B[5] - B[2]
if B[4] - B[1] < 0:
    B[3] = B[3] - 1
    B[4] = B[4] + 60
    r2 = B[4] - B[1]
else:
    r2 = B[4] - B[1]
r1 = B[3] - B[0]
print(str(r1) + " " + str(r2) + " " + str(r3))

if C[5] - C[2] < 0:
    C[4] = C[4] - 1
    C[5] = C[5] + 60
    r3 = C[5] - C[2]
else:
    r3 = C[5] - C[2]
if C[4] - C[1] < 0:
    C[3] = C[3] - 1
    C[4] = C[4] + 60
    r2 = C[4] - C[1]
else:
    r2 = C[4] - C[1]
r1 = C[3] - C[0]
print(str(r1) + " " + str(r2) + " " + str(r3))
