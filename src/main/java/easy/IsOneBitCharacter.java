package easy;

public class IsOneBitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        if(bits.length == 1)return bits[0] == 0;
        //0, 11, 10
        for(int i = 0; i < bits.length; i++){
            if(bits[i] == 1){
                i++;
            }
            if(i == bits.length - 2){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsOneBitCharacter isOneBitCharacter = new IsOneBitCharacter();
        int[] bits = new int[]{1};
        System.out.println(isOneBitCharacter.isOneBitCharacter(bits));
    }
}
