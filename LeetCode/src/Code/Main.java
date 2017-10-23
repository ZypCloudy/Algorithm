package Code;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer stoi = solution.myAtoi("  123123131");
        System.out.println(stoi);

        Integer mtoi = solution.romanToInt("DCXXI");
        System.out.println(mtoi);

        int nums[] = {1,3,4,5};
        int searchInedx = solution.searchInsert(nums,2);
        System.out.println(searchInedx);
    }
}
