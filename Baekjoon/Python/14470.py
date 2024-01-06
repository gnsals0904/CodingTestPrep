A = int(input())
B = int(input())
C = int(input())
D = int(input())
E = int(input())
result = 0
if A < 0:
    result = result + abs(A) * C
    A = A + abs(A)
if A == 0:
    result = result + D
if A < B:
    result = result + (B - A) * E
    A = B
print(result)
