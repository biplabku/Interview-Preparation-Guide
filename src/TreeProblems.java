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


    List<List<Integer>> totPaths = new ArrayList<>();
    List<Integer> listIn = new ArrayList<>();
    public List<List<Integer>> allPaths(TreeNode root) {
        inOrder2(root);
        System.out.println(listIn);
        return totPaths;
    }

    public void inOrder2(TreeNode root) {
        if(root == null) {
            listIn.add(0);
        }
        listIn.add(root.data);
        inOrder2(root.leftChild);
        inOrder2(root.rightChild);
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


    public TreeNode heightBalanced(int[] head) {
        return doHeightBalance( head, 0, head.length - 1);
    }

    public TreeNode doHeightBalance(int[] array, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = array[(start + end)/2];
        TreeNode node = new TreeNode(array[mid]);
        node.leftChild = doHeightBalance(array, start, mid - 1);
        node.rightChild = doHeightBalance(array, mid + 1, end);

        return node;
    }


    public TreeNode listToBST(LinkNode head) {
        return convertToBST(head, null);
    }

    public TreeNode convertToBST(LinkNode head, LinkNode tail){
        if(head == tail) {
            return  null;
        }
        int n = 0;
        LinkNode temp = head;
        while(temp != tail) {
            n++;
            temp = temp.next;
        }
        n = n/2;
        while(n != 0) {
            temp = temp.next;
        }
        TreeNode node = new TreeNode(temp.data);
        node.leftChild = convertToBST(head, temp);
        node.rightChild = convertToBST(temp.next, tail);
        return node;
    }


    public int firstMissingInteger(int[] array) {
        if(array.length < 1) {
            return 1;
        }
        // how to ignore the sorting part to come to a solution
        // can we minimize the time compexity to ignore the O(nlogn solution ?)
        Arrays.sort(array);
        HashSet<Integer> hset = new HashSet<>();
        int count = 1;
        for(int i = 0; i < array.length; i++) {
            if(array[i] < 0) {
                continue;
            }else if(array[i] > 0) {
                if(array[i] == count && !hset.contains(array[i])) {
                    count++;
                    hset.add(array[i]);
                }else if(hset.contains(array[i])) {
                    continue;
                }else {
                     break;
                }

            }
        }
        return count;
    }

    // start = "hit"
    // end = "cog"
    // dict = ["hot","dot","dog","lot","log"]

    int counter = 0;
    public ArrayList<String> wordLadderOne(ArrayList<String> dictionary, ArrayList<String> res, String start, String end) {
        // now find the route from the starting position to the end position ?
        // how do i select which word to pick next
        if(dictionary.size() == 0){
            return res;
        }
        // one way is to check the start sequence and then check the end sequence and from there
        // add both the sequences
        String str = dictionary.get(0);
        boolean check = isEditable(start, str);
        if(check == true) {
            dictionary.remove(0);
            res.add(str);
            counter++;
            if(dictionary.size() == 0) {
                if(isEditable(res.get(res.size() - 1), end)) {
                    res.add(end);
                }
            }
            wordLadderOne(dictionary,res, str, end);
        }
        return  res;
    }

    // how about implementing it in a an iterative way?
    public ArrayList<String> wordLadderOneIterative(ArrayList<String> dictionary, String start, String end) {
        ArrayList<String> result = new ArrayList<>();
        int counter = 0;
        result.add(start);
        for(String str:dictionary) {
            boolean check = isEditable(start, str);
            if(check) {
                result.add(str);
                start = str;
            }else{
                break;
            }
        }

        if(isEditable(result.get(result.size() - 1), end)) {
            result.add(end);
        }
        return result;
    }

    // how to check if two string are actually editable by one distance
    public boolean isEditable(String one, String two) {
        if(one.length() != two.length()) {
            return false;
        }
        HashSet<Character> hset = new HashSet<>();
        int count = 0;
        for(int i = 0; i < one.length(); i++) {
            if(!hset.contains(one.charAt(i))) {
                hset.add(one.charAt(i));
            }
        }

        for(int i = 0 ; i < two.length(); i++) {
            if(!hset.contains(two.charAt(i))) {
                count++;
            }
        }
        return count == 1;
    }


    public int finalWordLadderEfficient(ArrayList<String> dictionary, String start, String end) {
        if(start.equals(end)) {
            return 1;
        }
        ArrayList<String> result = new ArrayList<>(); // i still need to figure out a way to capture all the details
        Deque<String> queue = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        int counter = 1;
        visited.add(start);
        queue.add(start);
        while(!queue.isEmpty()) {
            int size = queue.size();
            counter++;

            for(int i = 0; i < size; i++) {
                String n = queue.removeFirst();
                for(String w:dictionary) {
                    if(!visited.contains(w) && isEditable(n, w)) {
                        if(w.equals(end)) {
                            return counter;
                        }
                        visited.add(w);
                        queue.add(w);
                    }
                }
            }
        }
        return counter;
    }

    // idea is to save the next pointer in some variable and reverse
    public LinkNode reverseKList(LinkNode head, int k) {
        LinkNode cur = head;
        LinkNode dummyHead = null;
        LinkNode newHead = null;
        if(head == null || head.next == null || k <= 1) {
            return cur;
        }
        while(cur != null) {
            LinkNode nxt = cur;
            int temp = k;
            while(temp != 0 && nxt != null) {
                nxt = nxt.next;
                temp--;
            }
            if(temp != 0) {
                LinkNode join = newHead;
                while(join.next != null) {
                    join = join.next;
                }
                join.next = cur;
                linkDisplay(newHead);
                return newHead;
            }
            dummyHead = reverse(cur, k);
            if(newHead == null) {
                newHead = dummyHead;
            }else {
                LinkNode join = newHead;
                while(join.next != null) {
                    join = join.next;
                }
                join.next = dummyHead;
            }
            cur = nxt;
        }
        linkDisplay(newHead);
        return newHead;
    }

    public LinkNode reverse(LinkNode head, int k) {
        LinkNode cur = head;
        LinkNode prev = null;
        LinkNode nxt = null;
        while(cur != null && k != 0) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
            k--;
        }
        return prev;
    }

    public LinkNode reverseKGroups(LinkNode head, int k) {
        LinkNode current = head;
        LinkNode next = null;
        LinkNode prev = null;

        int count = 0;
        while(count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        // prev is the new head now.
        // and next is the next linknode
        if(next != null) {
            head.next = reverseKGroups(next, k);
        }
        return prev;
    }



    public void linkDisplay(LinkNode head) {
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }


    public LinkNode reverseListMtoN(LinkNode head, int a, int b) {
        LinkNode cur = head;
        LinkNode prev = null;
        int count = b-a;

        LinkNode end = cur;
        while(b != 0) {
            end = end.next;
            b--;
        }

        while(cur != null && a != 0) {
            a--;
            prev = cur;// node before the reversing
            cur  = cur.next; // start to reverse node
        }

        LinkNode temp = reverse(cur, count);
        prev.next = temp; //  attach previous node to new reverse list

        LinkNode nxt = prev;
        while(count != 0) {
            nxt = nxt.next;
            count--;
        }

        nxt.next = end;
        linkDisplay(head);
        return head;
    }


    public LinkNode doMtoNreverse(LinkNode head, int m, int n) {
        LinkNode cur = head;
        LinkNode prev = null;
        LinkNode nxt = null;
        int start = 0;
        n = m + (m - n);
        int end = m + (m - n);
        while(cur != null) {
            nxt = cur.next;
            start++;
            if(start == m) {
                prev = cur;
            }
        }
        return head;
    }


    public LinkNode removeDuplicate(LinkNode head) {
        HashSet<Integer> hset = new HashSet<>();

        hset.add(head.data);
        LinkNode newHead = new LinkNode(head.data);
        LinkNode dummy = newHead;
        LinkNode cur = head;

        while(cur != null) {
            if(!hset.contains(cur.data)) {
                newHead.next = new LinkNode(cur.data);
                newHead = newHead.next;
                hset.add(cur.data);
                cur = cur.next;
            }else {
                cur = cur.next;
            }
        }

        linkDisplay(dummy);
        return dummy;
    }

    public LinkNode removeDuplicateMethod2(LinkNode head) {
        LinkNode cur = head;
        LinkNode newHead = new LinkNode(0);
        newHead.next = head;
        while(cur.next != null && cur.next.next != null) {
            if(cur.next.data == cur.next.next.data) {
                int dup = cur.next.data;
                while(cur.next != null && cur.next.data == dup) {
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }

        linkDisplay(newHead);
        return newHead;
    }

    public LinkNode removeDuplicateMethod3(LinkNode head) {
        LinkNode cur = head;
        LinkNode newHead = new LinkNode(0);
        newHead.next = head;
        LinkNode prev = newHead;
        newHead.next = head;
        while(cur != null) {
            while (cur.next != null && prev.next.data == cur.next.data) {
                cur = cur.next;
            }

            if(prev.next == cur) {
                prev = prev.next;
            }else {
                prev.next = cur.next;
            }
            cur = cur.next;
        }

        linkDisplay(newHead);
        return newHead.next;
    }

    public LinkNode removeDups(LinkNode head) {
        LinkNode dummy = new LinkNode(0);
        LinkNode cur = head;
        while(cur.next != null) {
            if(cur.data == cur.next.data) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        linkDisplay(head);
        return head;
    }


    public LinkNode reOrderList(LinkNode head) {
        LinkNode cur =head;
        List<Integer> list = new ArrayList<>();
        while(cur != null) {
            list.add(cur.data);
            cur = cur.next;
        }
        int pointer1 = 0;
        int pointer2 = list.size() - 1;
        LinkNode dummy = new LinkNode(0);
        LinkNode result = dummy;
        while(pointer1 < pointer2) {
            dummy.next = new LinkNode(list.get(pointer1));
            dummy = dummy.next;
            dummy.next = new LinkNode(list.get(pointer2));
            pointer1++;
            pointer2--;
            dummy = dummy.next;
        }
        if(list.size()% 2 == 0) {
            linkDisplay(result.next);
            return result;
        }
        return result.next;
    }

    public LinkNode reOrderMethod1(LinkNode head) {
        if(head == null || head.next == null) {
            return  head;
        }
        LinkNode slow = null, fast = null;
        fast = slow = head;
        LinkNode pre = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        // pre is middle element. Reverse the next element;
        pre.next = null;
        LinkNode newHead = new LinkNode(0);
        LinkNode temp = newHead, next;
        pre = null;

        while(slow != null) {
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        while(head != null && pre != null) {
            temp.next = head;
            temp = head;
            head = head.next;

            temp.next = pre;
            temp = pre;
            pre = pre.next;
        }

        if(head != null) {
            temp.next = head;
        }else {
            temp.next = pre;
        }

        return head.next;
    }

    // permute the array based on various character
    // 12
    // 1 2
    // 2 1
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> array) {

        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        doPermute(0, array, output);
        return output;
    }

    private void doPermute(int start, ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> result){
        if(start==nums.size() - 1){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num: nums){
                list.add(num);
            }
            result.add(list);
            return;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int i = start; i < nums.size(); i++){
            if(set.contains(nums.get(i))){
                continue;
            }
            set.add(nums.get(i));

            swap(nums, i, start);
            doPermute(start+1, nums, result);
            swap(nums, i, start);
        }
    }

    public ArrayList<String> generateParanthesis(int number) {
        ArrayList<String> list = new ArrayList<>();
        generateParans("", list, number, number);
        Collections.sort(list);
        return list;
    }

    public void generateParans(String str, ArrayList<String> list, int openBracks, int closeBracks) {
        if(openBracks == 0 && closeBracks == 0) {
            list.add(str);
        }
        if(openBracks > 0) {
            str += '(';
            generateParans(str, list,openBracks - 1, closeBracks);
        }
        if(openBracks < closeBracks) {
            str += ')';
            generateParans(str,list, openBracks, closeBracks - 1);
        }
    }

    private void swap(ArrayList<Integer> nums, int i, int j){
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    int numOfPalindromes = 0;
    ArrayList<ArrayList<String>> pal = new ArrayList<>();
    public ArrayList<ArrayList<String>> palindromicPartition(String str) {
        ArrayList<String> list = new ArrayList<>();
        generatePalindromes(list, str, 0);
        return pal;
    }

    public void generatePalindromes(ArrayList<String> list, String str, int index) {
        if(index == str.length()) {
            pal.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < str.length(); i++) {
            String sub = str.substring(index, i + 1);
            if(isPaldinrome(sub)) {
                list.add(sub);
                generatePalindromes(list, str, i + 1);
                list.remove(list.size() - 1);
            }
        }

    }

    public boolean isPaldinrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString().equalsIgnoreCase(str);
    }

    public int numberOfPaths(int m, int n) {
        // Create a 2D table to store results
        // of subproblems
        int count[][] = new int[m][n];

        // Count of paths to reach any cell in
        // first column is 1
        for (int i = 0; i < m; i++)
            count[i][0] = 1;

        // Count of paths to reach any cell in
        // first column is 1
        for (int j = 0; j < n; j++)
            count[0][j] = 1;

        // Calculate count of paths for other
        // cells in bottom-up manner using
        // the recursive solution
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)

                // By uncommenting the last part the
                // code calculatest he total possible paths
                // if the diagonal Movements are allowed
                count[i][j] = count[i-1][j] + count[i][j-1]; //+ count[i-1][j-1];

        }
        return count[m-1][n-1];
    }

    static class TreeLinkNode{
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        int val;

        public TreeLinkNode(int data) {
            val = data;
        }
    }

    public void connect(TreeLinkNode root) {
        root.next = null;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode cur = null, next = null;
            for(int i = 0; i < size; i++) {
                cur = queue.poll();
                if(i < size - 1) {
                    next = queue.peek();
                    cur.next = next;
                }
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }

    }

    public TreeLinkNode connectNodes(TreeLinkNode root) {
        TreeLinkNode levelStart = root;
        while (levelStart != null) {
            TreeLinkNode cur = levelStart;
            while(cur != null) {
                if(cur.left != null) {
                    cur.left.next = cur.right;
                }
                if(cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            levelStart = levelStart.left;
        }
        return root;
    }

    ArrayList<ArrayList<Integer>> sumList = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int number) {
        pathSum(root, number, new ArrayList<>(), 0);
        return sumList;
    }

    public void pathSum(TreeNode root, int number, ArrayList<Integer> list, int sum) {
        if(root == null) {
            return;
        }
        sum += root.data;
        list.add(root.data);
        if(sum == number) {
            ArrayList<Integer> t = new ArrayList<>(list);
            sumList.add(t);
        }
        pathSum(root.leftChild, number, list, sum);
        pathSum(root.rightChild, number, list, sum);
        list.remove(list.size() - 1);
        return ;
    }




    public static void main(String[] args) {
        TreeProblems ts = new TreeProblems();
        TreeNode root = new TreeNode(5);
        root.leftChild = new TreeNode(4);
        root.rightChild = new TreeNode(8);
        root.rightChild.leftChild = new TreeNode(13);
        root.rightChild.rightChild = new TreeNode(4);
        root.rightChild.rightChild.leftChild = new TreeNode(5);
        root.rightChild.rightChild.rightChild = new TreeNode(1);

        root.leftChild.leftChild = new TreeNode(11);
        root.leftChild.leftChild.leftChild = new TreeNode(7);
        root.leftChild.leftChild.rightChild = new TreeNode(2);


        LinkNode l1 = new LinkNode(1);
        LinkNode l2 = new LinkNode(2);
        LinkNode l3 = new LinkNode(3);
        LinkNode l4 = new LinkNode(4);
        LinkNode l5 = new LinkNode(5);
        LinkNode l6 = new LinkNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;


        TreeLinkNode r = new TreeLinkNode(1);
        r.right = new TreeLinkNode(3);
        r.left = new TreeLinkNode(2);
        r.left.left = new TreeLinkNode(4);
        r.left.right = new TreeLinkNode(5);
        r.right.left = new TreeLinkNode(6);
        r.right.right = new TreeLinkNode(7);


        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1);
        list1.add(3);

        System.out.println(ts.allPaths(root));
    }
}
