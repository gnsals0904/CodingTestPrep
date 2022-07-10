x = int(input())
n = int(input())
sum = 0
for i in range(n):
    n1, n2 = map(int, input().split())
    sum = sum + n1 * n2
if sum == x:
    print("Yes")
else:
    print("No")
