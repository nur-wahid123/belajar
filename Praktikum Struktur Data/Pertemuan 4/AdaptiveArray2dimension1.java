public class AdaptiveArray2dimension {
    private String[][] adaptiveArray;
    
    public AdaptiveArray2dimension() {
        adaptiveArray = new String[0][4];
    }
    public AdaptiveArray2dimension(String strings[][]) {
        adaptiveArray = strings;
    }
    
    public void add(String newValue[]) {
        String[][] tempArray = new String[adaptiveArray.length + 1][4];
        System.arraycopy(adaptiveArray, 0, tempArray, 0, adaptiveArray.length);
        adaptiveArray = tempArray;
        
        adaptiveArray[adaptiveArray.length - 1] = newValue;
    }
    
    public String[][] getArray() {
        return adaptiveArray;
    }
}
