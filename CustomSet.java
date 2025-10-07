import java.util.Arrays;

public class CustomSet {
    private int[] data;
    private int size;

    public CustomSet(int[] data) {
        setCustomData(data);
    }

    public boolean contains(int number){
        for(int i = 0; i<size; i++){
            if(data[i] == number){
                return true;
            }
        }
        return false;
    }
    public CustomSet union(CustomSet secondSet){
        int[] combined = new int[this.size + secondSet.size];
        System.arraycopy(this.data, 0, combined, 0, this.size);
        System.arraycopy(secondSet.data, 0, combined, this.size, secondSet.size);
        return new CustomSet(combined);
    }

    public void setCustomData(int[] data) {
        this.data = Arrays.stream(data).distinct().toArray();
        this.size = this.data.length;
    }
    public int[] getCustomData() {
        return this.data;
    }
}
