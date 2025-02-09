package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class NumberContainers {

     Map<Integer, Integer> indexNumMap;
    Map<Integer, TreeSet<Integer>> numVsIndexList;

    public NumberContainers() {
        // index vs number
        // number vs treeset index
        indexNumMap = new HashMap<>();
        numVsIndexList = new HashMap<>();
    }

    public void change(int index, int num) {
        if (indexNumMap.containsKey(index)) {
            int prevnum = indexNumMap.get(index);
            removeidx(prevnum, index);
        }
        add(index, num);
    }

    private void removeidx(int num, int index) {
        TreeSet<Integer> indexList = numVsIndexList.get(num);
        System.out.println("removed " + index + " " + num);
        indexList.remove(index);
    }

    private void add(int index, int num) {
         indexNumMap.put(index, num);
        TreeSet<Integer> indexList = numVsIndexList.get(num);
        if (indexList == null) {
            indexList = new TreeSet<Integer>();
            numVsIndexList.put(num, indexList);
        }
        indexList.add(index);
    }

    public int find(int num) {
        TreeSet<Integer> indexList = numVsIndexList.get(num);

        return (indexList == null || indexList.first() == null) ? -1 : indexList.first();
    }

    public static void main(String[] args) {

//        ["NumberContainers","find","change","change","change","change","find","change","find"]
//        [[],[10],[2,10],[1,10],[3,10],[5,10],[10],[1,20],[10]]

        NumberContainers nc = new NumberContainers();
        int res = nc.find(10); // There is no index that is filled with number 10. Therefore, we return -1.
        nc.change(2, 10); // Your container at index 2 will be filled with number 10.
        nc.change(1, 10); // Your container at index 1 will be filled with number 10.
        nc.change(3, 10); // Your container at index 3 will be filled with number 10.
        nc.change(5, 10); // Your container at index 5 will be filled with number 10.
        res = nc.find(10); // Number 10 is at the indices 1, 2, 3, and 5. Since the smallest index that is filled with 10 is 1, we return 1.
        nc.change(1, 20); // Your container at index 1 will be filled with number 20. Note that index 1 was filled with 10 and then replaced with 20.
        res = nc.find(10); // Number 10 is at the indices 2, 3, and 5. The smallest index that is filled with 10 is 2. Therefore, we return 2.

    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
