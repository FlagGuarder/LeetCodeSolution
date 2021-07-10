package design.Solution981;

import java.util.Comparator;

public class ValueItem implements Comparable<ValueItem> {
    private String value;
    private int timeStamp;

    public ValueItem(String value, int timeStamp) {
        this.value = value;
        this.timeStamp = timeStamp;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public String getValue() {
        return value;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }


    @Override
    public int compareTo(ValueItem o) {
        if (this.timeStamp != o.getTimeStamp()) {
            return this.timeStamp - o.getTimeStamp();
        } else {
            return this.value.compareTo(o.getValue());
        }

    }

    public int hashCode() {
        return timeStamp + value.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ValueItem) {
            ValueItem pair2 = (ValueItem) obj;
            return this.timeStamp == pair2.getTimeStamp() && this.value.equals(pair2.getValue());
        }
        return false;
    }


}
