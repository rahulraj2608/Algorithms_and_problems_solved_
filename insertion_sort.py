
def insertion_sort(arr):
    for i in range(1,len(arr)):
        key = arr[i]
        j=i-1;
        
        while j>=0 and key>arr[j]:
            arr[j+1]=arr[j]
            j=j-1
            
        arr[j+1]=key
        
data = [1,7,4,3,9,6] 
insertion_sort(data)
print(data);
        