s = input()
slist = list()
nlist = list()
count = 0
for i in range(len(s)):
    if s[i].isdigit():
        nlist.append(s[i])
    else:
        slist.append(s[i])
slist.sort()
for j in range(len(nlist)):
    count = count + int(nlist[j])
slist.append(str(count))
for k in range(len(slist)):
    print(slist[k], end="")
