package algorithm.leetcode.string;

public class No344_reverseString {
    public static void reverseString(char[] s) {
        int half = s.length / 2;
        for (int i = 0; i < half; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        String str = "hello";
        char[] arr = str.toCharArray();

        reverseString(arr);
        for(char c :arr){
            System.out.print(c);

        }

    }
}
