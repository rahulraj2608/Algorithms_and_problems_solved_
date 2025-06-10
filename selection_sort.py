def selection_sort(arr):
    for i in range(len(arr)):
        min_idx = i
        for j in range(i + 1, len(arr)):
            if arr[j] < arr[min_idx]:
                min_idx = j
        # Swap the elements
        arr[i], arr[min_idx] = arr[min_idx], arr[i]

data = [1, 3, 2, 4, 65, 76, 4]
selection_sort(data)
print(data)