class Main {
    public static void main(String[] args) {
        int[] arr = {1,4,3,2,5,9,7,0,8};
        mergeSort(arr);
        
        printArray(arr);
    }
    
        public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }

    }
    
    public static void mergeSort(int[] arr){
        int length = arr.length;
        
        if(length<=1) return;
        
        int mid= length/2;
         int[] leftArray = new int[mid];
        int[] rightArray = new int[length - mid];
        int j=0; // Right array index
        
        for(int i=0;i<length;i++){
            if(i<mid){
                leftArray[i]=arr[i];
            }else{
                rightArray[j]=arr[i];
                j++;
            }
        }
        
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray,rightArray,arr);
        
    }
    
    public static void merge(int[] left,int[] right, int[] arr){
        int leftSize = arr.length/2;
        int rightSize = arr.length-leftSize;
        
        int i=0,l=0,r=0;
        
        // conditions for merging
        
        while(l<leftSize && r<rightSize){
            if(left[l]<right[r]){
                arr[i]=left[l];
                l++;
                i++;
                }
            else{
                arr[i]=right[r];
                i++;
                r++;
            }
        }
        
        while(l<leftSize){
               arr[i]=left[l];
                l++;
                i++;
        }
        
              while(r<rightSize){
               arr[i]=right[r];
                r++;
                i++;
        }
    }  
}