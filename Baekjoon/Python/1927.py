import heapq
import sys

N = int(input())
heap_len = 0
heap = []
for _ in range(N):
    num_input = int(sys.stdin.readline().rstrip())
    if num_input == 0:
        if heap_len == 0:
            print(0)
        else:
            print(heapq.heappop(heap))
            heap_len -= 1
    else:
        heapq.heappush(heap, num_input)
        heap_len += 1


