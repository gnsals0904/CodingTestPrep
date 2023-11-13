for tc in range(1, 11):
    N = int(input())
    # 암호문
    pwd_list = list(map(str, input().split()))
    # 명령문 수
    order_num = int(input())
    # 명령문 리스트
    order_list = list(map(str, input().split()))
    for i in range(len(order_list)):
        if order_list[i] == 'I':
            insert_start_num = int(order_list[i + 1])
            insert_num = int(order_list[i + 2])
            insert_list = order_list[i + 3:i + 3 + insert_num]
            front_arr = pwd_list[:insert_start_num]
            back_arr = pwd_list[insert_start_num:]
            temp_list = front_arr + insert_list + back_arr
            pwd_list = temp_list.copy()
        elif order_list[i] == 'A':
            add_num = int(order_list[i + 1])
            for j in range(i + 2, i + 2 + add_num):
                pwd_list.append(order_list[j])
        elif order_list[i] == 'D':
            delete_start_num = int(order_list[i + 1])
            delete_num = int(order_list[i + 2])
            front_arr = pwd_list[:delete_start_num]
            back_arr = pwd_list[delete_start_num + delete_num:]
            temp_list = front_arr + back_arr
            pwd_list = temp_list.copy()
    result_list = pwd_list[:10]
    print(f"#{tc}", *result_list)
