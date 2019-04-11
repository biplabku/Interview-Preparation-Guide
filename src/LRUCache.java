import java.util.*;

// Implement an LRU cache
public class LRUCache {

    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head=null;
    Node end=null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            setHead(node);
            return node.value;
        }
        return -1;
    }

    public void remove(Node n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }

        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }

    }

    public void setHead(Node n){
        n.next = head;
        n.pre = null;

        if(head!=null)
            head.pre = n;
        head = n;
        if(end ==null)
            end = head;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            Node created = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end); /// remove the last element
                setHead(created); // Add the new element at the head

            }else{
                setHead(created);
            }
            map.put(key, created);
        }
    }

    // 1 - 2 -- 3
    // lets say that i want to inset 2 again
    public void insert(int key, int value) {
        if(map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            delete(old);
        }
    }
    // it will be the least recently used item when inserted.
    public void addAtfront(Node node) {
        node.next = head;
        node.pre = null;

        if(head != null) {
            head.pre = node;
        }
        head = node;
        if(end == null) {
            end = head;
        }
    }

    public void delete(Node node) {
        if(node.pre != null) {
            node.pre.next = node.next;
        }else {
            head = node.next;
        }
        if(node.next != null) {
            node.next.pre = node.next;
        }else {
            end = node.pre;
        }
    }

    public int largestProdAny3(int[] array) {
        int single = array[0];
        int prodOfTwo = array[0]  * array[1];
        int prodOfThree = prodOfTwo * array[2];
        int max_so_far = 0;
        for(int i = 2; i < array.length; i++) {
            single = Math.max(single, array[i - 1]);
            prodOfTwo = Math.max(prodOfTwo, single * array[i]);
            prodOfThree = Math.max(prodOfThree, prodOfTwo * array[i]);
            max_so_far = Math.max(max_so_far, prodOfThree);
        }
        return max_so_far;
    }

    // array[col][row]
    // 00
    // 01
    // 22
    // 11
    // 00
    public ArrayList<ArrayList<Integer>> antiDiagonals(int[][] array) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int size = array.length * 2 - 1;
        for(int i = 0; i < size; i++) {
            list.add(getAntiDiagonal(i, array));
        }
        return list;
    }

    public ArrayList<Integer> getAntiDiagonal(int index, int[][] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i <= index; i++) {
            int j = index - i;
            if(i < array.length && j < array.length) {
                list.add(array[i][j]);
            }
        }
        return list;
    }


    public int numOfIslands(int[][] grid) {
        int result = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                visited[i][j] = false;
            }
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && visited[i][j] == false ) {
                    visited[i][j] = true;
                    dfs(grid, visited, i, j);
                    result += 1;
                }
            }
        }
        return result;
    }


    class Points {
        int row;
        int col;
        public Points(int x, int y) {
            this.row = x;
            this.col = y;
        }
    }

    int row = 3;
    int col = 3;
    public void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        Stack<Points> thestack = new Stack<>();
        thestack.push(new Points(i, j));
        visited[i][j] = true;
        while(!thestack.isEmpty()) {
            Points p = thestack.peek();
            thestack.pop();
            int r = p.row;
            int c = p.col;
            if(checkValidity(r - 1, c) == true && visited[r - 1][c] == false && grid[r - 1][c] == 1) {
                visited[r - 1][c] = true;
                thestack.push(new Points(r - 1, c));
            }
            if(checkValidity(r + 1, c) == true && visited[r + 1][c] == false && grid[r + 1][c] == 1) {
                visited[r + 1][c] = true;
                thestack.push(new Points(r + 1, c));
            }
            if(checkValidity(r, c - 1) == true && visited[r][c - 1] == false && grid[r][c - 1] == 1) {
                visited[r][c - 1] = true;
                thestack.push(new Points(r, c - 1));
            }
            if(checkValidity(r, c + 1) == true && visited[r][c + 1] == false && grid[r][c + 1] == 1) {
                visited[r][c + 1] = true;
                thestack.push(new Points(r, c + 1));
            }
        }
    }

    public boolean checkValidity(int x, int y) {
       if(x < 0 || y < 0 || x >= row || y >= col ) {
           return false;
       }
       return true;
    }



    public void solve2DRegions(char[][] grid) {

    }





















    public int largestPrdofThree(int[] array) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;


        // i will have to store both the top negative values or the
        // minimum values and so forth for the
        // maximum values in the temporary varaibles.
        for(int i = 0; i < array.length; i++) {
            int number = array[i];
            if(number < min1) {

            }
        }
        return 1;
    }

    public static void main(String[] args) {
        LRUCache ls = new LRUCache(3);
        ls.set(1,0);
        ls.set(2,4);
        ls.set(3, 5);
        int[] array = {10, 3, 5, 6, 20};
        int[][] arr = {{1,1,1}, {0,1,0},{0,1,0}};
        System.out.println(ls.numOfIslands(arr));
    }
}