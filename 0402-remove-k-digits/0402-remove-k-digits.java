class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);

            while (!stk.isEmpty() && k > 0 && stk.peek() > ch) {
                stk.pop();
                k--;
            }
            stk.push(ch);
        }

        // If k still > 0, remove from end
        while (k > 0 && !stk.isEmpty()) {
            stk.pop();
            k--;
        }

        StringBuilder res = new StringBuilder();
        while (!stk.isEmpty()) {
            res.append(stk.pop());
        }
        res.reverse();

        // Remove leading zeros
        while (res.length() > 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        return res.length() == 0 ? "0" : res.toString();
    }
}