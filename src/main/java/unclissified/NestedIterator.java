package unclissified;

import java.util.*;

/**
 * Created by wanglin03 on 2017/10/17.
 */
public class NestedIterator implements Iterator<Integer> {
    Queue<Integer> queue;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.queue = new LinkedList<>();
        Iterator<NestedInteger> listIterator = nestedList.iterator();
        while (listIterator.hasNext()){
            NestedInteger integer = listIterator.next();
            if(integer.isInteger()){
                queue.add(integer.getInteger());
            }else {
                List<NestedInteger> list = integer.getList();
                NestedIterator iterator = new NestedIterator(list);
                while (iterator.hasNext()){
                    queue.add(iterator.next());
                }
            }
        }
    }

    @Override
    public Integer next() {
        return this.queue.poll();
    }

    @Override
    public boolean hasNext() {
        if(queue.isEmpty()) return false;
        return true;
    }

    private class NestedInteger {
        public boolean isInteger(){
            return true;
        }
        public Integer getInteger(){
            return 0;
        }
        public List<NestedInteger> getList(){
            return new ArrayList<>();
        }
    }
}
