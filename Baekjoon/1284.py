while True:
    N = input()
    result = 0
    if N == "0":
        break
    else:
        for i in range(len(N)):
            if N[i] == '1':
                result = result + 2
            elif N[i] == '0':
                result = result + 4
            else:
                result = result + 3
        if len(N) == 1:
            result = result + 2
        elif len(N) == 2:
            result = result + 3
        elif len(N) == 3:
            result = result + 4
        else:
            result = result + 5
    print(result)
