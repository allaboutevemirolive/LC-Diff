import java.util.ArrayList;
import java.util.List;

class E93 {
    public List<String> restoreIpAddresses(String s) {
        var result = new ArrayList<String>();

        helper(result, s.toCharArray(), 0, new char[s.length() + 3], 0, 3);
        return result;
    }

    private void helper(List<String> result, char[] chs, int chsIdx, char[] cur, int curIdx, int dots) {
        if (dots == 0) {
            if (valid(chs, chsIdx, chs.length - chsIdx)) {
                System.arraycopy(chs, chsIdx, cur, curIdx, chs.length - chsIdx);
                result.add(new String(cur));
            }
            return;
        }
        for (int i = chsIdx, end = Math.min(chs.length, chsIdx + 3); i < end; ++i) {
            cur[curIdx++] = chs[i];
            if (valid(chs, chsIdx, i - chsIdx + 1)) {
                cur[curIdx] = '.';
                helper(result, chs, i + 1, cur, curIdx + 1, dots - 1);
            } else {
                return;
            }
        }
    }

    private boolean valid(char[] chs, int st, int len) {
        if (len == 1) { // 0 ~ 9
            return true;
        } else if (len == 2) {
            return chs[st] != '0'; // 10 ~ 99
        } else if (len == 3) {
            if (chs[st] == '1') { // 100 ~ 199
                return true;
            } else if (chs[st] == '2') { // 200 ~ 255
                return chs[st + 1] < '5' || chs[st + 1] == '5' && chs[st + 2] < '6';
            }
        }
        return false;
    }
}
