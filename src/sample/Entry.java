package sample;

public class Entry<k, v> {

    protected String key;
    protected Double value;
    Entry<k, v> next = null;

    public Entry(String key, Double value) {
        super();
        this.key = key;
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Entry<k, v> getNext() {
        return next;
    }

}
