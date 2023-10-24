t = int(input())
for test_case in range(t):
    n = int(input())
    check = []
    ans = []
    for _ in range(10):
        check.append(False)
    for _ in range(10):
        ans.append(True)
    result = 0
    i = 1
    while check != ans:
        str_n = str(n * i)
        for k in str_n:
            if not check[int(k)]:
                check[int(k)] = True
        i += 1
    print("#" + str(test_case + 1), (i - 1) * n)
