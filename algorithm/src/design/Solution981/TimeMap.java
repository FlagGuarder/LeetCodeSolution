package design.Solution981;


import java.util.*;

class TimeMap {

    /** Initialize your data structure here. */
    private Map<String, List<ValueItem>> kvMap;

    public TimeMap() {
        kvMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<ValueItem> valueItemList = kvMap.getOrDefault(key,new ArrayList<ValueItem>());
        valueItemList.add(new ValueItem(value,timestamp));
        kvMap.put(key,valueItemList);
    }

    public String get(String key, int timestamp) {
        List<ValueItem> valueItemList = kvMap.getOrDefault(key,new ArrayList<ValueItem>());
        ValueItem valueItem = new ValueItem(String.valueOf((char) 127),timestamp);
        int i = binarySearch(valueItemList,valueItem);
        if (i > 0){
            return valueItemList.get(i).getValue();
        }
        return "";
    }


    private int binarySearch(List<ValueItem> valueItemList,ValueItem target){
        int low = 0, high = valueItemList.size()-1;
        if (high < 0 || valueItemList.get(high).compareTo(target) <= 0){
            return high + 1;
        }
        while (low < high){
            int mid = (high - low) / 2 + low;
            ValueItem valueItem = valueItemList.get(mid);
            if (valueItem.compareTo(target) <= 0){
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return low;
    }


}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */