package easy;

public class RomanToInt {
    public int romanToInt(String s) {
//        Symbol       Value
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
        int result = 0;
        char specialChar = 0;
        for(char each : s.toCharArray()){
            switch (each){
                case 'M':
                    result+=1000;
                    if(specialChar =='C')result-=200;
                    break;
                case 'D':
                    result+=500;
                    if(specialChar=='C') result-=200;
                        break;
                case 'C':
                    result+=100;
                    if(specialChar=='X')result-=20;
                    specialChar = 'C';
                    break;
                case 'L':
                    result+=50;
                    if(specialChar=='X')result-=20;
                    break;
                case 'X':
                    result+=10;
                    if(specialChar=='I')result-=2;
                    specialChar='X';
                    break;
                case 'V':
                    result+=5;
                    if(specialChar=='I')result-=2;
                    break;
                case 'I':
                    result+=1;
                    specialChar='I';
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        System.out.println(romanToInt.romanToInt("IX"));
    }
}
