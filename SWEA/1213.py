for tc in range(10):
    t = int(input())
    search_s = input()
    s = input()
    result = s.count(search_s)
    print("#" + str(tc + 1), result)
