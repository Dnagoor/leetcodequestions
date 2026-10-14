class Solution {
    public String reverseVowels(String s1) {
        char[] ch = s1.toCharArray();
        int s = 0, e= s1.length()-1;
        String vowels = "aeiouAEIOU";
        while(s < e){
            while(s < e && vowels.indexOf(ch[s])==-1){
                s++;
            }
            while(s < e && vowels.indexOf(ch[e])==-1){
                e--;
            }
            char temp = ch[s];
            ch[s]=ch[e];
            ch[e]=temp;

            s++;
            e--;

        }
        String s_new = new String(ch);
        return s_new;
    }
}