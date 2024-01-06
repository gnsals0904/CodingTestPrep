testcase = int(input())
stringlist = list()

for i in range(testcase):
    str = input()
    stringlist.append(str)

for k in range(testcase):
    print(stringlist[k][0], stringlist[k][len(stringlist[k])-1], sep="")
