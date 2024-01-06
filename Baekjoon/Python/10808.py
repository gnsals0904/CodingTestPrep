s = input()
namelist = [0 for k in range(26)]
for i in range(len(s)):
    namelist[ord(s[i]) - 97] = namelist[ord(s[i]) - 97] + 1
print(*namelist)