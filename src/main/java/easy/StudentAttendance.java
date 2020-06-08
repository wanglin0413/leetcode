package easy;

public class StudentAttendance {

    public boolean checkRecord(String s) {
        int A = 0;
        int L = 0;
        for(char each : s.toCharArray()){
            if(each == 'L'){
                L++;
                if(L >= 3)return false;
            }else{
                L = 0;
                if(each == 'A'){
                    A++;
                    if(A > 1)return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "PPALLA";
        StudentAttendance sa = new StudentAttendance();
        System.out.println(sa.checkRecord(s));
    }
}
