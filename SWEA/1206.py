for testcase in range(10):
    N = int(input())
    building_list = list(map(int, input().split()))
    result = 0
    building_value_list = []
    for i in range(2, N - 2):
        max_building = max(building_list[i - 2], building_list[i - 1], building_list[i + 1], building_list[i + 2])
        if building_list[i] < max_building:
            building_value_list.append(0)
        else:
            building_value_list.append(building_list[i] - max_building)
        result = sum(building_value_list)
    print("#" + str(testcase + 1), result)
