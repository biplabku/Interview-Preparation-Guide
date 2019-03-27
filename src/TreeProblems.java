import com.sun.source.tree.Tree;

import java.sql.Array;
import java.util.*;

public class TreeProblems {

    public TreeNode buildTree(int[] preorder, int [] inorder) {
        TreeNode root = addNode(preorder, 0, preorder.length - 1, inorder,
                0, inorder.length - 1);
        System.out.println(" Height of the tree is  -- > " + treeHeight(root));
        TreeNode t = greaterTree(root, 0);
        inOrder(t);
        return root;
    }

    public TreeNode greaterTree(TreeNode root, int sum) {
        if(root != null) {
            greaterTree(root.rightChild, sum);
            sum += root.data;
            root.data = sum;
            greaterTree(root.leftChild, sum);
        }
        return root;
    }


    public int treeHeight(TreeNode root) {
        if(root == null) {
            return -1;
        }
        int left = 1 + treeHeight(root.leftChild);
        int right = 1 + treeHeight(root.rightChild);
        return Math.max(left, right);
    }

    public void inOrder(TreeNode root) {
        if(root != null) {
            inOrder(root.leftChild);
            System.out.println(root.data);
            inOrder(root.rightChild);
        }
    }


    public boolean isUnivalued(TreeNode root) {
        boolean left = (root.leftChild == null || (root.data == root.leftChild.data
        && isUnivalued(root.leftChild)));
        boolean right = (root.rightChild == null || (root.data == root.rightChild.data
        && isUnivalued(root.rightChild)));

        return left && right;
    }


    public TreeNode addNode(int[] preorder, int prestart, int preend, int[]
            inorder, int instart, int inend) {
        if(prestart > preend) {
            return  null;
        }
        if(prestart == preend) {
            return new TreeNode(preorder[prestart]);
        }
        int idx = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[prestart]) {
                idx = i;
                break;
            }
        }
        TreeNode root = new TreeNode(inorder[idx]);
        root.leftChild = addNode(preorder, prestart + 1,
                idx - instart + prestart, inorder, instart, idx - 1);
        root.rightChild = addNode(preorder, idx - instart + prestart + 1, preend,
                inorder, idx + 1, inend);
        return root;
    }

    public int sum = 0;
    public int findTilt(TreeNode root) {
        getTilt(root);
        return sum;
    }

    public int getTilt(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = getTilt(root.leftChild);
        int right = getTilt(root.rightChild);

        sum += Math.abs(left - right);
        return left + right + root.data;
    }

    int depth = Integer.MAX_VALUE;
    public int minimumDepth(TreeNode root) {
        minDepth(root);
        return depth;
    }
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = 1 + minimumDepth(root.leftChild);
        int right = 1 + minimumDepth(root.rightChild);
        if(left == 1) {
            return right;
        }else if(right == 1) {
            return left;
        }
        depth = Math.min(left, right);
        return depth;
    }


    public int fibonacci(int number) {
        if(number == 0 || number == 1) {
            return 1;
        }
        return number * fibonacci(number - 1);
    }

    public int result = 0;
    public int evaluateBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.leftChild == null && root.rightChild != null) {
            return root.data;
        }
        int left = evaluateBinaryTree(root.leftChild);
        int right = evaluateBinaryTree(root.rightChild);
        if(root.data == '+') {
            result = left + right;
        }else if(root.data == '-') {
            result = left - right;
        }else if(root.data == '*') {
            result = left * right;
        }else if(root.data == '/') {
            result = left/ right;
        }
        return result;

    }


    public boolean isSymmetric(TreeNode root) {
        return checkSymetric(root, root);
    }

    public boolean checkSymetric(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        boolean left = checkSymetric(root1.leftChild, root2.rightChild);
        boolean right = checkSymetric(root1.rightChild, root2.leftChild);
        return (root1.data == root2.data) && left && right;
    }

    public boolean checkSameTree(TreeNode root1, TreeNode root2) {
        return isSameTree(root1, root2);
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if((root1 == null && root2 != null) || (root1 != null && root2 == null) ) {
            return false;
        }

        boolean left = isSameTree(root1.leftChild, root2.leftChild);
        boolean right = isSameTree(root1.rightChild, root2.rightChild);
        boolean value = root1.data == root2.data;
        return value && left && right;
    }

    public int res = 0;
    public int diameterBinary(TreeNode root) {
        getLength(root);
        return res;
    }

    public int getLength(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = 1 + getLength(root.leftChild);
        int right = 1 + getLength(root.rightChild);

        res = Math.max(left + right, res);
        return Math.max(left, right);
    }


    public boolean checkWord(char[][] grid, String word) {
        boolean isSeen = false;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(word.charAt(0) == grid[i][j]) {
                    isSeen = dfsSearch(grid, word, i, j, 0);
                    if(isSeen == true) {
                        return true;
                    }
                }
            }
        }
        return isSeen;
    }

    public boolean dfsSearch(char[][] grid, String word, int i, int j, int k) {
        int m = grid.length;
        int n = grid[0].length;

        if(i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }

        if(grid[i][j] == word.charAt(k)) {
            char temp = grid[i][j];
            grid[i][j] = '#';
            if(k == word.length() - 1) {
                return true;
            }else if(dfsSearch(grid, word, i - 1, j, k + 1)
                || dfsSearch(grid, word, i + 1, j, k  +1)
            || dfsSearch(grid, word, i,  j - 1, k + 1)
            || dfsSearch(grid, word, i, j + 1, k + 1)) {
                return true;
            }
            grid[i][j] = temp;
        }
        return false;
    }


    public TreeNode isIncreasing(TreeNode root) {
        TreeNode node = getIncrease(root);
        return node;
    }

    public TreeNode getIncrease(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode left = getIncrease(root.leftChild);
        TreeNode right = getIncrease(root.rightChild);

        TreeNode cur = left;
        while(cur != null && cur.rightChild != null) {
            cur = cur.rightChild;
        }
        if(cur != null) {
            cur.rightChild = root;
        }
        root.leftChild = null;
        root.rightChild = right;

        return left != null ? left:root;

    }

    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inOrder1(root);
        return ans.rightChild;
    }

    public void inOrder1(TreeNode root) {
        if(root == null) {
            return ;
        }
        inOrder1(root.leftChild);
        root.leftChild = null;
        cur.rightChild = root;
        cur = root;
        inOrder1(root.rightChild);
    }


    public int getMinTreeLevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int count = 0;
        hmap.put(count, root.data);
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int left = 0;
            int right = 0;

            int res = 0;
            for(int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if(temp.leftChild != null) {
                    left = temp.leftChild.data;
                    queue.offer(temp.leftChild);
                }
                if(temp.rightChild != null) {
                    right = temp.rightChild.data;
                    queue.offer(temp.rightChild);
                }
                res += left + right;
            }
            count += 1;
            hmap.put(count, res);
        }

        Iterator iter = hmap.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            int key = (int) pair.getKey();
            int value = (int) pair.getValue();

        }
        return 1;
    }

    // SFO, HKO -- YYZ, SFO -- YUL, YYZ -- HKO, ORD
    // YUL - starting point
    public List<List<String>> get_itinerary(List<List<String>> flights,
                                            List<List<String>> current_itinerary) {
        if(!flights.contains(current_itinerary)) {
            return current_itinerary;
        }
        List<String> last_stop = current_itinerary.get(current_itinerary.size() - 1);
        for(int i = 0; i < flights.size(); i++) {
            List<List<String>> flights_minus_current = flights;
            flights_minus_current.remove(i);
        }
        return flights;
    }


    public void reArrange(int[] array) {
        int currentIndex = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0) {
                swap(array, currentIndex, i);
                currentIndex += 2;
            }
        }
        display(array);
    }

    public void swap(int[] array, int start, int end) {
        int temp = array[end];
        array[end] = array[start];
        array[start] = temp;
    }

    public void display(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public ArrayList<Integer> searchRange(final List<Integer> list, int target) {
        return searchTarget(list, target, 0, list.size() - 1);
    }

    public ArrayList<Integer> searchTarget(final List<Integer> list, int target,
                                           int start, int end) {
        int mid = (start + end)/2;
        if(list.get(mid) < target) {
            start = mid + 1;
        }else if(list.get(mid) ==  target){
            end = mid -1;
        }else {
            end = mid - 1;
        }
        return new ArrayList<>();
    }

    int left = 1;
    int right = 1;
    public boolean isCousins(TreeNode root, int x, int y) {
        return true;
    }

    public TreeNode checkCousin(TreeNode root, int x, int y) {
        if(root == null) {
            return null;
        }
        if(root.data != x) {
            left++;
            checkCousin(root.leftChild, x, y);
            right++;
            checkCousin(root.rightChild, x, y);
        }else if(root.data == x) {
            
        }
        TreeNode left = checkCousin(root.leftChild, x, y);
        return left;
    }



    ArrayList<Integer> list = new ArrayList<>();
    public int findSecondMinimumValue(TreeNode root) {
        getSecondMin(root);
        Collections.sort(list);
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) != list.get(i + 1)) {
                return list.get(i + 1);
            }
        }
        return -1;
    }

    public void getSecondMin(TreeNode root) {
        if(root == null) {
            return ;
        }
        getSecondMin(root.leftChild);
        list.add(root.data);
        getSecondMin(root.rightChild);

    }

    public class LRUNode{
        int key;
        int value;
        LRUNode prev;
        LRUNode next;

        public LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public class LRUcacheGoogle{
        HashMap<Integer, LRUNode> hmap = new HashMap<>();
        public int size;
        public int currentSize;
        LRUNode head = null;
        LRUNode tail = null;

        public LRUcacheGoogle(int val) {
            size = val;
            currentSize = 0;
        }

        public void set(int key, int value) {
            if(hmap.containsKey(key)) {
                LRUNode t = hmap.get(key);
                t.value = value;

            }else { //  if it does not contain a key
                if(hmap.size() >= size) { // check size
                    hmap.remove(tail.key); // remove the key from the hashmap
                    remove(tail);         // remove the tail from the Node
                }
                LRUNode t = new LRUNode(key, value);
                setHead(t);   // set the new head as most recently used item
                hmap.put(key, t); // put it inside the hashmap
            }
        }


        public void setHead(LRUNode t) {
            if(head != null) {
                head.prev = t;
            }
            t.next = head;
            t.prev = null;
            head = t;

            if(tail == null) {
                tail = head;
            }
        }

        public void remove(LRUNode t) {
            if(t.prev != null) {
                t.prev.next = t.next;
            }else {
                head = t.next;
            }

            if(t.next != null) {
                t.next.prev = t.prev;
            }else {
                tail = t.prev;
            }
        }

        public int get(int key) {
            if(!hmap.containsKey(key)) {
                return -1;
            }
            LRUNode t = hmap.get(key);
            remove(t);
            setHead(t);

            return t.value;
        }
    }

    // 1 - 2 - 3 - 4 - 5 - 6
    // 2 - 1
    public void swapLinkNodes(LinkNode head) {
        LinkNode newHead = head.next;
        LinkNode cur = head;
        LinkNode prev = null;
        while(cur != null && cur.next != null) {
            LinkNode first = cur;
            LinkNode second = cur.next;
            if(prev == null) {
                newHead.next = new LinkNode(first.data);
                newHead = newHead.next;
                prev = new LinkNode(1);
            }else{
                newHead.next = new LinkNode(second.data);
                newHead = newHead.next;
            }
            first = second;
            first.next = second.next;
            cur = first.next;
        }

        while(newHead != null) {
            System.out.println(newHead.data);
        }
    }

    class Location{
        int x;
        int y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int robotInGrid(int[][] grid, int start, int end) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                visited[i][j] = false;
            }
        }
        HashSet<ArrayList<Location>> hset = new HashSet<>();
        int counter = 0;
        Location loc = new Location(0, 0);
        visited[0][0] = true;
        findPath(hset, grid, visited, loc, 4, 4);
        loc.x = 0;
        loc.y = 0;
        findPath(hset, grid, visited, loc, 4, 4);
        return hset.size();
    }

    public boolean findPath(HashSet<ArrayList<Location>> result, int[][] grid, boolean[][] visited, Location p, int row, int col) {
        int start = p.x;
        int end = p.y;
        if(start == row - 1 && end == col - 1) {
            return true;
        }
        if(start + 1 < row && end < col) {
            start = start + 1;
            p.x = start;
            if(visited[start][end] == false) {
                visited[start][end] = true;
                findPath(result, grid, visited, p, row, col);
            }
        }else if(start < row && end + 1 < col) {
            end = end + 1;
            p.y = end;
            if(visited[start][end] == false) {
                visited[start][end] = true;
                findPath(result, grid, visited, p, row, col);
            }
        }else {
            return false;
        }
        return true;
    }

    public boolean checkValidity(int row, int col, int x, int y) {
        return x < row && y < col;
    }

    public ArrayList<Location> getPath(boolean[][] maze){
        if(maze == null || maze.length == 0) {
            return null;
        }
        ArrayList<Location> path = new ArrayList<>();
        if(getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
            return path;
        }
        return null;
    }

    public boolean getPath(boolean[][] maze, int row, int col, ArrayList<Location> path)  {
        if(col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }

        boolean isAtOrgin = row == 0 && col == 0;
        if(isAtOrgin || getPath(maze, row, col - 1, path) ||
                getPath(maze, row - 1, col, path)) {
            Location p = new Location(row, col);
            path.add(p);
            return true;
        }
        return false;
    }

    List<String> serializeString = new ArrayList<>();

    public String serialize(TreeNode root) {
        doSerialize(root);
        return serializeString.toString();
    }

    public void doSerialize(TreeNode root) {
        if(root == null) {
            serializeString.add("null");
            return ;
        }
        serializeString.add(String.valueOf(root.data));
        doSerialize(root.leftChild);
        doSerialize(root.rightChild);
    }


    public TreeNode deSerializeString(List<String> list) {
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        doDeSerialize(root, list, 0);
        return root;
    }

    public void doDeSerialize(TreeNode root, List<String> list, int index) {
        if(index == list.size()) {
            return;
        }
    }


    public List<String> stringBreakup(String str, int k) {
        List<String> result = new ArrayList<>();
        String[] words = str.split(" ");
        List<String> theStack = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < words.length; i++) {
            String s = words[i];
            if(count + s.length() < k) {
                count += s.length();
                theStack.add(s);

            }else { // length is greater than k
                count = 0;
                if(!theStack.isEmpty()) {
                    result.add(formString(theStack));
                    i = i - 1;
                    theStack.clear();
                }
            }
        }
        result.add(formString(theStack));
        return result;
    }



    public String formString(List<String> stack) {
        int size = 0;
        StringBuilder sb = new StringBuilder();
        while(size < stack.size()) {
            sb.append(stack.get(size));
            sb.append(" ");
            size++;
        }
        if(sb == null) {
            return sb.toString();
        }
        return sb.substring(0, sb.length() - 1);
    }


    public int findIndexOfTarget(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = (left + right)/2;
            if(array[mid] == target) {
                return mid;
            }
            if(array[mid] < array[right]) {
                if(target > array[mid] && target <= array[right]) {
                    left = mid  + 1;
                }else {
                    right = mid - 1;
                }
            }else if(array[mid] > array[right]) {
                if(target < array[mid] && target >= array[left]) {
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeProblems ts = new TreeProblems();
        TreeNode root = new TreeNode(1);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(3);
        root.rightChild.leftChild = new TreeNode(4);
        root.rightChild.rightChild = new TreeNode(5);

        LinkNode l1 = new LinkNode(1);
        LinkNode l2 = new LinkNode(2);
        LinkNode l3 = new LinkNode(3);
        LinkNode l4 = new LinkNode(4);
        LinkNode l5 = new LinkNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        int[][] grid = {{1, 0, 0, 0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,1}};
        int[] array = {3,4,5,1,2};
        String str = "thequickdsdd brown fox jumps over the lazy dog";
        System.out.println(ts.stringBreakup(str, 10));
    }
}
