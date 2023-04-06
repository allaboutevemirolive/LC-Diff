class D904 {
    public int totalFruit(int[] fruits) {
        if(fruits.length <= 2) {
            return fruits.length;
        }
        int ans = 2;
        int temp = 2;
        int another = 1;
        int check = 0;
        int f1 = fruits[0], f2 = f1;
        for(int i = 1; i < fruits.length; i++) {
            if(fruits[i]!=f1) {
                check++;
                f2 = fruits[i];
                break;
            }
            ans++;
        }
        if(check==0) return fruits.length;
        for(int i = 2; i < fruits.length; i++) {
            if(fruits[i]!=f1 && fruits[i]!=f2) {
                temp = 1 + another;
                if(fruits[i-1]==f1) f2 = fruits[i];
                else f1 = fruits[i];
            }
            else {
                temp++;
            }
            if(fruits[i]==fruits[i-1]) {
                another++;
            }
            else {
                another = 1;
            }
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}