package section_6;

public class FlourPacker {
    public static void main(String[] args) {
        System.out.println(canPack(1,0,4));
        System.out.println(canPack(1,0,5));
        System.out.println(canPack(0,5,4));
        System.out.println(canPack(2,2,11));
        System.out.println(canPack(-3,2,12));
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (goal < 0 || bigCount < 0 || smallCount < 0) return false;

        while (goal >= 5 && bigCount > 0) {
            goal -= 5;
            bigCount--;
        }
        while (goal > 0 && smallCount > 0) {
            goal--;
            smallCount--;
        }
        return goal == 0;
    }
}
