s = input()
for x in s:
    x = ord(x) - ord('A') + 1
    print(x, end=" ")
