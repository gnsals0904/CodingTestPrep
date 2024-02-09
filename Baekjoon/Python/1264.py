list = ['a','e','i','o','u','A','E','I','O','U']
while(1):
    i = 0
    count = 0
    str = input()
    if(str == "#"):
        break
    else:
        for i in range(len(list)):
            count = count + str.count(list[i])
        print(count)