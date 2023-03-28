public class terbessar{
    public int CariTerbesar(int a[]){
        int maks = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i]>maks) {
                maks = a[i];
            }
        }
        return maks;
    }
}