import java.util.TreeMap;

class C352 {
    TreeMap<Integer, int[]> map;

    /** Initialize your data structure here. */
    public C352() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        int[] range = map.get(val);
        if (range == null) {
            Integer lowerKey = map.lowerKey(val);
            Integer higherKey = map.higherKey(val);
            if (lowerKey != null && higherKey != null && map.get(lowerKey)[1] + 1 == val && higherKey == val + 1) {
                map.get(lowerKey)[1] = map.get(higherKey)[1];
                map.remove(higherKey);
            } else if (lowerKey != null && map.get(lowerKey)[1] + 1 >= val) {
                map.get(lowerKey)[1] = Math.max(val, map.get(lowerKey)[1]);
            } else if (higherKey != null && higherKey == val + 1) {
                map.put(val, new int[] { val, map.get(higherKey)[1] });
                map.remove(higherKey);
            } else {
                map.put(val, new int[] { val, val });
            }
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[map.size()][2];
        int i = 0;
        for (int[] interval : map.values()) {
            res[i][0] = interval[0];
            res[i][1] = interval[1];
            i++;
        }
        return res;
    }
}