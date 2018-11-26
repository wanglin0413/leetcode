public class Flowerbed {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 1 && flowerbed[0] == 0)return n<=1;
        if(flowerbed.length == 1 && flowerbed[0] == 1)return n <= 0;
        int result = 0;
        int tempCount = 0;
        boolean first = true;
        for(int i=0; i<flowerbed.length;i++){
            if(flowerbed[i] == 1 && first && tempCount != 0){
                result +=tempCount >>1;
                tempCount =0;
                first = false;
                continue;
            }
            if(i == flowerbed.length-1){
                if(flowerbed[i] == 1){
                    if(tempCount != 0){
                        result += (tempCount-1)>>1;
                    }
                }else {
                    tempCount++;
                    if(first){
                        result +=(tempCount+1) >> 1;
                    }else{
                        result += (tempCount) >>1;
                    }

                }
                continue;
            }
            if(flowerbed[i] == 1){
                first = false;
                if(tempCount != 0){
                    result+=(tempCount-1) >> 1;
                    tempCount = 0;
                }
            }else {
                tempCount++;
            }
        }
        return result >= n;
    }
}
