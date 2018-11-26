import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SummaryRanges {

    List<Interval> intervals;

    public SummaryRanges() {
        intervals = new ArrayList<>();
    }

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

    public void addNum(int val) {
        boolean newVal = true;
        int index = 0;
        for(Interval each : intervals){
            if(each.start - val > 1){
                break;
            }
            if(each.start - val == 1 || each.start - val == 0){
                each.start = val;
                newVal = false;
                break;
            }
            if(val - each.end == 1 || val - each.end == 0){
                each.end = val;
                newVal = false;
                break;
            }
            if(val <= each.end && val >= each.start){
                newVal = false;
                break;
            }
            index++;
        }
        if(newVal){
            intervals.add(index, new Interval(val, val));
        }else {
            Iterator<Interval> it = intervals.iterator();
            Interval current = null;
            if(it.hasNext()){
                current = it.next();
            }
            while (it.hasNext()){
                Interval next  = it.next();
                if(next.start - current.end <= 1){
                    current.end = next.end;
                    it.remove();
                }else {
                    current = next;
                }
            }
        }


    }

    public List<Interval> getIntervals() {
        return intervals;
    }

}
