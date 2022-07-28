while True:
    n_list = [3, 3, 3]
    N = int(input())
    str_n = str(N)
    if N == 0:
        break
    else:
        for i in n_list:
            if i == '1':
                i = 2
            elif i == '0':
                i = 4
    print(4+sum(n_list))
