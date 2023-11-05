N = int(input())
student = list(map(int, input().split()))
height = [0 for _ in range(1001)]
for i in range(N):
    height[student[i]] += 1
front_line = []
back_line = []
for j in range(1001):
    if height[j] > 0:
        height[j] -= 1
        front_line.append(j)
for k in range(1000, 0, -1):
    if height[k] > 0:
        height[k] -= 1
        back_line.append(k)
print(len(front_line) + len(back_line))
