public class Sort {

    int arr[];
    int length;

    Sort(int a[]) {
        arr = a;
        length = a.length;
    }

    public void bubSort() {
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 1; i < arr.length - j; i++) {
                int last = arr[i];
                int first = arr[i - 1];
                if (last < first) {
                    arr[i] = first;
                    arr[i - 1] = last;
                }
            }
        }
    } 

    public void selSort(){
        for (int i = 0; i < arr.length-1; i++) {
            int imin =  i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<arr[imin]) {
                    imin = j;                    
                }
            }
            int temp = arr[i];
            arr[i] = arr[imin];
            arr[imin] = temp;
        }
    }

    public void tampil() {
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}