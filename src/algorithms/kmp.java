class KMP {
    public void search(string text, string pattern) {

    }

    private int[] preprocessPattern(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int i=1;
        int len = 0;
        while(i < m) {
            if  (pattern.charAt(i) == pattern.chatAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len--;
                } else {

                }
            }
        }

        return lps;
    }
}