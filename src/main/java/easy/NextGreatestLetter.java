package easy;

public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        char min = letters[0];
        int minInterval = 100;
        for(char each : letters){
            int interval = each - target > 0? each -target : 26 - (target - each) + 1;
            if(interval < minInterval){
                min = each;
                minInterval = interval;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        NextGreatestLetter ngl = new NextGreatestLetter();
        char[] letters = new char[]{'c','f','j'};
        System.out.println(ngl.nextGreatestLetter(letters, 'j'));
    }
}
