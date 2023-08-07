s = input()
result = 0
x = ord(s[0]) - 96
y = int(s[1])
dx = [2, 2, -2, -2, 1, 1, -1, -1]
dy = [1, -1, 1, -1, 2, -2, 2, -2]
for i in range(8):
    rx = x + dx[i]
    ry = y + dy[i]
    if 0 < rx < 9 and 0 < ry < 9:
        result += 1
print(result)