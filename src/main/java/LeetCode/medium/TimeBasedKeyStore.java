package LeetCode.medium;

import java.util.*;

public class TimeBasedKeyStore {
    class TimeMap {

        Map<String, List<TimeValue>> mp;
        public TimeMap() {
            mp = new HashMap<>();
            // List<TimeValue> ll = new ArrayList<>();
            // ll.add(new TimeValue(-1, "dummy"));
            // mp.put(-1, ll);
            // List<TimeValue> ob = mp.get(-1);
            // System.out.println("value is  " + ob.get(0).value);
        }

        public void set(String key, String value, int timestamp) {
            if (mp.containsKey(key)) {
                List<TimeValue> list = mp.get(key);
                int pos = binSerachFind(list, timestamp);
                if (pos != -1) {
                    // found;
                    TimeValue tv = list.get(pos);
                    tv.value = value;
                } else {
                    // not found
                    pos = binSearchInsert(list, timestamp);
                    if (pos < list.size()) {
                        list.add(pos, new TimeValue(timestamp, value));
                    } else {
                        list.add(new TimeValue(timestamp, value));
                    }
                }

            } else {
                List<TimeValue> list = new ArrayList<>();
                list.add(new TimeValue(timestamp, value));
                mp.put(key, list);
            }
        }

        public String get(String key, int timestamp) {
            if (mp.containsKey(key)) {
                List<TimeValue> list = mp.get(key);
                int pos = binSerachFind(list, timestamp);
                if (pos != -1) return list.get(pos).value;
                pos = binSearchInsert(list, timestamp);
                if (pos != 0) return list.get(pos - 1).value;
            }
            return "";
        }

        public int binSerachFind(List<TimeValue> list,int timestamp) {
            int l = 0, h = list.size() - 1;
            int mid = 0;
            while (l <= h) {
                mid = (l + h) / 2;
                if (list.get(mid).time == timestamp) {
                    return mid;
                } else if (list.get(mid).time > timestamp) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return -1;
        }

        public int binSearchInsert(List<TimeValue> list,int timestamp) {
            int l = 0, h = list.size() - 1;
            int mid = 0;
            while (l <= h) {
                mid = (l + h) / 2;
                if (list.get(mid).time == timestamp) {
                    return mid;
                } else if (list.get(mid).time > timestamp) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            // if (list.get(mid).time > timestamp) mid--;
            return l;
        }

        class TimeValue {
            public int time;
            public String value;
            public TimeValue(int time, String value) {
                this.time = time;
                this.value = value;
            }
        }
    }

    public TimeMap timeMap = new TimeMap();
    public static void main(String[] args) {
        TimeBasedKeyStore ob = new TimeBasedKeyStore();
        ob.timeMap.set("foo","bar",1);
        final String s = ob.timeMap.get("foo", 1);
        final String s1 = ob.timeMap.get("foo", 3);
        ob.timeMap.set("foo","bar",4);
        final String s2 = ob.timeMap.get("foo", 5);
    }
}
