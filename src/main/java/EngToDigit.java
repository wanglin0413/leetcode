import java.util.*;

public class EngToDigit {
    //one two three four  five six seven eight nine zero
    //o 1-------------------2 4  0
    //n 1 7 9
    //e 1 3 5 7 ------------------------8 0
    //t 3 ----------------------2 8
                                  //-----w 2
    //h 3----------------------- 8
    //r 3 ----------------------4 0
    //f 5 ------------------------4
                                    //-----u 4
    //i 5 9---------------------6 8
    //v 5 7
    //s 7--------------------------6
                                    //x ----6
                                    //g ----8
                                    //z ----0
    public String originalDigits(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> count = new HashMap<>();
        count.put('o', 0);
        count.put('n',0);
        count.put('e',0);
        count.put('t',0);
        count.put('x',0);
        count.put('w',0);
        count.put('h',0);
        count.put('r',0);
        count.put('f',0);
        count.put('u',0);
        count.put('i', 0);
        count.put('v',0);
        count.put('s', 0);
        count.put('g',0);
        count.put('z',0);
        for(char each : s.toCharArray()){
            count.merge(each, 1, (x,y)->x+y);
//            if(count.get(each)!= null){
//                count.put(each, count.get(each)+1);
//            }else {
//                count.put(each, 1);
//            }
        }
        if(count.get('w') != null){
            for(int i =0; i<count.get('w') ; i++){
                result.add(2);
            }
            count.put('t', count.get('t')-count.get('w'));
            count.put('o', count.get('o') - count.get('w'));
        }

        if(count.get('u') != null){
            for(int i = 0; i< count.get('u'); i++){
                result.add(4);
            }
            count.put('f', count.get('f') - count.get('u'));
            count.put('o', count.get('o') - count.get('u'));
            count.put('r', count.get('r') - count.get('u'));
        }
        for(int i = 0;i< count.get('x');i++){
            result.add(6);
        }
        count.put('s', count.get('s') - count.get('x'));
        count.put('i', count.get('i') - count.get('x'));

        if(count.get('g') != null){
            for(int i = 0; i< count.get('g'); i++){
                result.add(8);
            }
            count.put('e', count.get('e') - count.get('g'));
            count.put('i', count.get('i') - count.get('g'));
            count.put('h', count.get('h') - count.get('g'));
            count.put('t', count.get('t') - count.get('g'));
        }

        if(count.get('z') != null){
            for(int i = 0; i< count.get('z'); i++){
                result.add(0);
            }
            count.put('e', count.get('e') - count.get('z'));
            count.put('r', count.get('r') - count.get('z'));
            count.put('o', count.get('o') - count.get('z'));
        }

        //2 4 6 8 0

        if(count.get('o') != null){
            for(int i = 0; i< count.get('o'); i++){
                result.add(1);
            }
            count.put('n', count.get('n') - count.get('o'));
            count.put('e', count.get('e') - count.get('o'));
        }

        if(count.get('t') != null){
            for(int i = 0; i< count.get('t'); i++){
                result.add(3);
            }
            count.put('h', count.get('h') - count.get('t'));
            count.put('r', count.get('r') - count.get('t'));
            count.put('e', count.get('e') - 2*count.get('t'));
        }

        if(count.get('f') != null){for(int i = 0; i< count.get('f'); i++){
            result.add(5);
        }
            count.put('i', count.get('i') - count.get('f'));
            count.put('v', count.get('v') - count.get('f'));
            count.put('e', count.get('e') - 2*count.get('f'));
        }

        if(count.get('s') != null){
            for(int i = 0; i< count.get('s'); i++){
                result.add(7);
            }
            count.put('n', count.get('n') - count.get('s'));
            count.put('v', count.get('v') - count.get('s'));
            count.put('e', count.get('e') - 2*count.get('s'));
        }

        if(count.get('n')!= null){
            int nine = count.get('n')>>1;
            for(int i = 0; i< nine; i++){
                result.add(9);
            }
            count.put('i', count.get('i') - nine);
            count.put('e', count.get('e') - nine);
        }

        result.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2)return 1;
                else return -1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int each:result){
            sb.append(each);
        }
        return sb.toString();
    }
}
