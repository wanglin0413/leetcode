package unclissified;

public class QuadTree {

    public Node construct(int[][] grid) {
        return construct(grid, 0,0,grid.length);
    }

    private Node construct(int[][] grid, int i, int j,  int size) {
        if(size == 1)return new Node(grid[i][j] == 1, true,null,null,null,null);
        int nodeVal = grid[i][j] ;
        for(int indexI = i; indexI < i+size; indexI++){
            for(int indexJ = j; indexJ < j+size;indexJ++){
                if(grid[indexI][indexJ] != nodeVal){
                    size >>= 1;
                    return new Node(false, false, construct(grid, i,j, size), construct(grid,i+size,j,size),construct(grid,i,j+size,size),construct(grid,i+size,j+size,size));
                }
            }
        }
        return new Node(nodeVal==1, true,null,null,null,null);
}
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }

};
