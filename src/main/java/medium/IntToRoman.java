package medium;

public class IntToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int qian = num / 1000;
        for (int i = 0; i < qian; i++) {
            sb.append("M");
        }
        String[] s5 = new String[]{"D","L","V"};
        String[] s1 = new String[]{"M","C","X","I"};
        int divider = 1000;
        for(int i =0; i< 3; i++){
            int qianyu = num % divider;
            divider /= 10;
            int bai = qianyu / divider;
            if(bai == 9){
                sb.append(s1[i+1]).append(s1[i]);
                bai = 0;
            } else if(bai >= 5){
                bai-=5;
                sb.append(s5[i]);

            }else if(bai == 4){
                sb.append(s1[i+1]).append(s5[i]);
                bai = 0;
            }
            for(int j =0; j < bai; j++){
                sb.append(s1[i+1]);
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntToRoman ir = new IntToRoman();
        System.out.println(ir.intToRoman(58));
    }
}
