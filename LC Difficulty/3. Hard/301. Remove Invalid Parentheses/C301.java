import java.util.ArrayList;
import java.util.List;

class C301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        int[] rm = calRm(s);
        dfs(res, new StringBuilder(), s, 0, rm[0], rm[1], 0);
        return res;
    }
    private int[] calRm(String s){
        int rmL = 0; 
        int rmR = 0;
        for(char c : s.toCharArray()){
            if(c == '(') rmL++;
            else if(c == ')'){
                if(rmL > 0) rmL--;
                else rmR++;
            }
        }
        return new int[]{rmL, rmR};
    }
    private void dfs(List<String> res, StringBuilder path, String s, int idx, int rmL, int rmR, int delta){
        int len = s.length();
        if(idx == len && delta == 0 && rmL == 0 && rmR == 0){
            res.add(path.toString());
            return;
        }
        if(idx >= len || delta < 0 || rmL < 0 || rmR < 0) return;
        int curLen = path.length();
        char ch = s.charAt(idx);
        if(ch == '('){
            dfs(res, path, s, idx + 1, rmL - 1, rmR, delta);
            int count = 1;
            while(idx + count < len && s.charAt(idx + count) == '(') count++;
            path.append(s.substring(idx, idx + count));
            dfs(res, path, s, idx + count, rmL, rmR, delta + count);
            path.setLength(curLen);

        }else if(ch == ')'){
            dfs(res, path, s, idx + 1, rmL, rmR - 1, delta);
            int count = 1;
            while(idx + count < len && s.charAt(idx + count) == ')') count++;
            path.append(s.substring(idx, idx + count)); 
            dfs(res, path, s, idx + count, rmL, rmR, delta - count);
            path.setLength(curLen);

        }else{
            path.append(ch);
            dfs(res, path, s, idx + 1, rmL, rmR, delta);
            path.setLength(curLen);
        }
    }
}