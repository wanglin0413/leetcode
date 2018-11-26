package medium;

public class ChampionTower {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glasses = new double[101][101];
        glasses[0][0] = poured;
        for(int i = 0; i<= query_row; i++){
            for(int j = 0; j <= query_glass; j++){
                if(glasses[i][j] > 1){
                    double pourenext =(glasses[i][j] -1)/2;
                    glasses[i+1][j] += pourenext;
                    glasses[i+1][j+1] += pourenext;
                }
            }
        }
        return glasses[query_row][query_glass] >1?1:glasses[query_row][query_glass];
    }

    public static void main(String[] args) {
        ChampionTower ct  = new ChampionTower();
        System.out.println("result: " + ct.champagneTower(
                1000000000,99,99));
    }
}


