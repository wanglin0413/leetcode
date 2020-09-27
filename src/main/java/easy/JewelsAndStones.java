package easy;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for(char each: J.toCharArray()){
            for(char SEach : S.toCharArray()){
                if(each == SEach)count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        JewelsAndStones js = new JewelsAndStones();
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(js.numJewelsInStones(J, S));
    }
}
