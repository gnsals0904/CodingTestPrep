t = int(input())
for test_case in range(t):
    n = int(input())
    whole_string = ''
    for _ in range(n):
        ci, ki = map(str, input().split())
        temp_string = ci * int(ki)
        whole_string = whole_string + temp_string
    print("#" + str(test_case + 1))
    for i in range(len(whole_string)):
        if i % 10 == 0 and i != 0:
            print()
        print(whole_string[i], end='')
    print()
