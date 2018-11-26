public class JacocoTest {

    public JacocoTest(int p1) {
        this.p1 = p1;
    }

    int p1 = 1;

    public static void main(String[] args){
        JacocoTest test = new JacocoTest(99);
        if(test.p1 > 80){
            System.out.println("优");
        }else if(test.p1 > 60){
            System.out.println("良");
        }else{
            System.out.println("差");
        }
    }
}
