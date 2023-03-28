public class AdaptiveArray {
    private String[] adaptiveArray;
    
    public AdaptiveArray() {
        adaptiveArray = new String[0];
    }
    public AdaptiveArray(String...strings) {
        adaptiveArray = strings;
    }
    
    public void add(String newValue) {
        String[] tempArray = new String[adaptiveArray.length + 1];
        System.arraycopy(adaptiveArray, 0, tempArray, 0, adaptiveArray.length);
        adaptiveArray = tempArray;
        
        adaptiveArray[adaptiveArray.length - 1] = newValue;
    }
    
    public String[] getArray() {
        return adaptiveArray;
    }
}
