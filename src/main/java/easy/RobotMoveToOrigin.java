package easy;

public class RobotMoveToOrigin {
    public boolean judgeCircle(String moves) {
        int row = 0;
        int column = 0;
        for(char each : moves.toCharArray()){
            if(each == 'U'){
                row++;
            }else if(each == 'D'){
                row--;
            }else if(each == 'L'){
                column++;
            }else if(each == 'R'){
                column--;
            }
        }
        return row == 0 && column == 0;
    }

    public static void main(String[] args) {
        RobotMoveToOrigin rmto = new RobotMoveToOrigin();
        System.out.println(rmto.judgeCircle("UD"));
    }
}
