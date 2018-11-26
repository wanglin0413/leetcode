public class HashSet {

    public HashSet() {
        this.values = new int[1000000];
        values[0] = -1;
    }

    private int[] values;



    public void add(int key) {
        values[key] = key;
    }

    public void remove(int key) {
        values[key] = -1;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return values[key] == key;
    }

}
