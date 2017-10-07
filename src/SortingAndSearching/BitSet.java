package SortingAndSearching;

public class BitSet {

    private int[] bitSet;

    public BitSet(int size){
        bitSet = new int[(size >> 1) + 1];
    }

    public boolean get(int pos){
        int indexNumber = pos >> 5;
        int bitNumber = (pos & 0x1F);
        return (bitSet[indexNumber] & (1 << bitNumber)) != 0;
    }

    public void set(int pos){
        int indexNumber = pos >> 5;
        int bitNumber = (pos & 0x1F);
        bitSet[indexNumber] |= 1 << bitNumber;
    }

}