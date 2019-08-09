
public class OnlyInMaster {
    public static void main(String[] args) {
//        String projectNameInParenthesis  ="ABCD(）";
        String projectNameInParenthesis = "";
        projectNameInParenthesis=escapeExprSpecialWord(projectNameInParenthesis);
        String otherPart = "1ABC1";
        String res = otherPart.replaceFirst(projectNameInParenthesis, "");
        System.out.println(res);
    }

    public static String escapeExprSpecialWord(String keyword) {
        String[] fbsArr = {"\\", "$", "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", "|"};
        for (String key : fbsArr) {
            if (keyword.contains(key)) {
                keyword = keyword.replace(key, "\\" + key);
            }
        }
        return keyword;
    }
}
