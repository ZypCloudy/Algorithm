package Code;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer stoi = solution.myAtoi("  123123131");
        System.out.println(stoi);

        Integer mtoi = solution.romanToInt("IV");
        System.out.println(mtoi);
    }
}
