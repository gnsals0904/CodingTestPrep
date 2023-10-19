t = int(input())
for i in range(t):
    s = input()
    if s == s[::-1]:
        print("#" + str(i + 1), 1)
    else:
        print("#" + str(i + 1), 0)
