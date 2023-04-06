class B71 {
    public String simplifyPath(String path) {
        int i = 0;
        String[] dq = new String[path.length() + 1];
        int idx = 0;
        while (i < path.length()) {
            i++;
            int l = i;
            while (i < path.length() && path.charAt(i) != '/') i++;
            String segment = path.substring(l, i);
            if (segment.equals(".") || segment.isEmpty()) continue;
            if (segment.equals("..")) {
                if (idx > 0) {
                    idx--;
                }
            } else {
                dq[idx++] = segment;
            }
        }
        if (idx == 0) return "/";
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < idx; j++) {
            result.append("/").append(dq[j]);
        }
        return result.toString();
    }
}