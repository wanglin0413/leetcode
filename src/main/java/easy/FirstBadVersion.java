package easy;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        long good = 0;
        long bad = n;
        long mid = (bad + good) >> 1;
        while(true){
            if(isBadVersion((int)mid)){
                bad = mid;
            }else{
                good = mid;
            }
            if(bad - good == 1)return (int)bad;
            mid = (good + bad) >>1;
        }
    }

    private boolean isBadVersion(int mid) {
        return mid >=1702766719;
    }

    public static void main(String[] args) {
        FirstBadVersion fbv = new FirstBadVersion();
        System.out.println(fbv.firstBadVersion(2126753390));
    }
}
