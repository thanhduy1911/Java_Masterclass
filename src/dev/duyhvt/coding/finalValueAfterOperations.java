package dev.duyhvt.coding;

public class finalValueAfterOperations {
    private static int solution(String[] operations) {
        int res = 0;
        for (String operation : operations)
        {
            switch (operation)
            {
                case "X++", "++X" -> res += 1;
                case "X--", "--X" -> res -= 1;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"X++", "X--", "X++"}));
        System.out.println(solution(new String[]{"X++","++X","--X","X--"}));
    }
}
