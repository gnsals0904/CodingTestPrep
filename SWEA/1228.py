for tc in range(1, 11):
    N = int(input())
    pwd_list = list(map(str, input().split()))
    order_num = int(input())
    order_list = list(map(str, input().split()))
    start_pointer = 1
    fix_num_pointer = start_pointer + 1
    order_count = 0
    while order_count != order_num:
        start = int(order_list[start_pointer])
        fix_num = int(order_list[fix_num_pointer])
        order_start_num = fix_num_pointer + 1
        fix_list = order_list[order_start_num:order_start_num + fix_num]
        now_len = len(pwd_list)
        count = 0
        front_arr = pwd_list[:start]
        back_arr = pwd_list[start:]
        temp_list = front_arr + fix_list + back_arr
        pwd_list = temp_list.copy()
        start_pointer += (fix_num + 3)
        fix_num_pointer = start_pointer + 1
        order_count += 1
    result_list = pwd_list[0:10]
    print(f"#{tc}", *result_list)
