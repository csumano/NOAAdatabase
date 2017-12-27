package sample;

public class HashTables {

    public final int mSize = 3000;
    public double det = .25;
    Entry<String, Double> entrys[] = new Entry[mSize];

    public Double getVal(String key) {
        int index = getHash(key);
        Entry<String, Double> list = entrys[index];
        return getKeysVal(list, key);
    }

    public int getKey(String key){
        int index = getHash(key);
        return index;
    }

    private Double getKeysVal(Entry<String, Double> list, String key) {
        while(list != null) {
            if(list.getKey().equals(key)) {
                return list.getValue();
            }
            list = list.next;
        }
        return null;
    }

    private int getHash(String key) {
        int hash = Math.abs(key.hashCode());
        return hash % mSize;
    }

    public void put(String key, Double value) {
        int index = getHash(key);
        saveValue(index, key, value);
    }

    private void saveValue(int index, String key, Double value) {
        Entry<String, Double> list = entrys[index];
        Integer max = 0;
        if(list == null) {
            entrys[index] = new Entry<> (key, value);
        } else {
            boolean done = false;
            while(list.next != null) {
                if(list.getKey().equals(key)) {
                    list.setValue(value);
                    done = true;
                    break;
                }

                list = list.next;
                max++;
            }
            if(!done) {
                list.next = new Entry<>(key, value);
                max++;
            }else if(max/mSize == det){
                reSize();
            }
        }
    }
    // Problem 2 fixed so that i have a resize function that works and i called it in saveValue
    public void reSize(){
        double startIndex = 0;
        Entry<String, Double> newList[] = new Entry[mSize * 3];
        for (int i = 0; i < entrys.length; i++) {
            while(startIndex != mSize){
                newList[i].setValue(entrys[i].getValue());
            }
        }
    }

    public int size(){
        int startIndex = 0;
        int totalSize = 0;
        while(startIndex < mSize){
            Entry<String, Double> list = entrys[startIndex];
            if(list != null) {
                do {
                    totalSize++;
                    list = list.getNext();
                } while( list != null);
            }
            startIndex++;
        }
        return totalSize;
    }

    public boolean isFull(){
        for(int x = 0; x < mSize; x++){
            if (entrys[x] == null){
                return false;
            }
        }
        return true;
    }
}