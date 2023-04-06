class C132 {
    public int minCut(String s) {
        int n = s.length();
        int[] cutsDp = new int[n];
        
        for(int i=1;i<n;i++){
            cutsDp[i] = i;
        }
        
        for(int mid=0;mid<n;mid++){
            findMinCut(mid, mid, cutsDp, s);
            findMinCut(mid-1, mid, cutsDp, s);
        }
        
        return cutsDp[n-1];
    }
    
    public void findMinCut(int startIdx, int endIdx, int[] cutsDp, String s){
        for(int start=startIdx,end=endIdx; start>=0 && end<s.length() && s.charAt(start)==s.charAt(end); start--,end++){
            int newCut = start == 0 ? 0 : cutsDp[start - 1] + 1;
            cutsDp[end] = Math.min(newCut, cutsDp[end]);
        }
    }
}