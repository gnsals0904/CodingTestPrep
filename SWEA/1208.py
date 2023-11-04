for test_case in range(10):
    dump_num = int(input())
    # 계수정렬, 최대 높이가 100 이니까
    height_list = [0 for _ in range(101)]
    value_list = list(map(int, input().split()))

    # 가로 길이는 항상 100 이므로
    for i in range(100):
        height_list[value_list[i]] += 1

    count = 0
    start = 0
    end = 100
    while dump_num != count:
        # 찾으면
        if height_list[start] > 0 and height_list[end] > 0:
            height_list[start] -= 1
            height_list[start + 1] += 1
            height_list[end] -= 1
            height_list[end - 1] += 1
            count += 1
        if height_list[start] == 0:
            start += 1
        if height_list[end] == 0:
            end -= 1
    print("#" + str(test_case + 1), end - start)
