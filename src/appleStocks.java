public class appleStocks {


    public static int getMaxProfitMethod1(int[] stockPrices) {
        int maxProfit = 0;
        for(int i = 0; i < stockPrices.length; i++) {
            for(int j = 0; j < stockPrices.length; j++) {
                int earlierIndex = Math.min(i, j);
                int laterIndex = Math.max(i, j);
                int buy = stockPrices[earlierIndex];
                int sell = stockPrices[laterIndex];

                int tempProfit = sell - buy;
                maxProfit = Math.max(tempProfit, maxProfit);
            }
        }
        return maxProfit;
    }

    public static int getMaxProfitMethod2(int[] stockPrices) {
        int maxProfit = 0;
        int laterSell = 0;
        int earlierBuy = 0;
        for(int i = 0; i < stockPrices.length; i++) {
            earlierBuy = stockPrices[i];
            for(int j = i + 1; j < stockPrices.length; j++) {
                laterSell = stockPrices[j];
                maxProfit = Math.max(maxProfit, (laterSell - earlierBuy));
            }
        }
        return maxProfit;
    }

    public static int getMaxProfitMethod3(int[] stockPrices) {
        int maxProfit = 0;
        int laterSell = 0;
        int earlierBuy = stockPrices[0];
        for(int i = 0; i < stockPrices.length; i++) {
            earlierBuy = Math.min(earlierBuy, stockPrices[i]);
            maxProfit = Math.max(maxProfit, (stockPrices[i] - earlierBuy));
        }
        return maxProfit;
    }

    public static int getMaxProfitMethod4(int[] stockPrices) {
        if(stockPrices.length < 2) {
            throw new IllegalArgumentException("Need atleast 2 entries for getting max profit");
        }
        int minPrice = stockPrices[0];
        int maxProfit = stockPrices[1] - stockPrices[0];
        for(int i = 1; i < stockPrices.length; i++) {
            int currentPrice = stockPrices[i];
            int currentMaxProfit = currentPrice - minPrice;
            maxProfit = Math.max(maxProfit, currentMaxProfit);
            minPrice = Math.min(currentPrice, minPrice);
        }
        return maxProfit;
    }

    public static int maxProfit(int[] prices) {
        int finalRes = 0;
        for(int i = 0; i < prices.length; i++) {
            int val = calculate(prices, i, prices[i], i);
            finalRes = Math.max(finalRes, val);
        }

        return finalRes;
    }

    static int res = 0;

    // this module works fine. now i have to find how to call this function recursively
    public static int calculate(int[] prices, int index, int val, int nextIndex) {
        int sum = 0;    
        boolean first = false;
        for(int i = index; i < prices.length; i++) {
            if(prices[i] > val) {
                if(first == false) {
                    first = true;
                    nextIndex = i + 1;
                }
                sum += prices[i] - val;
                res = Math.max(res, sum);
                i = i + 1;
                if(i >= prices.length) {
                    break;
                }else {
                    val = prices[i + 1];
                }
            }
        }
        if(nextIndex != -1) {
            calculate(prices, nextIndex, val, nextIndex);
        }
        if(first ==  true) {
            return -1;
        }
        return sum;
    }

    static class BSTNode {
        int size;
        int val;
        BSTNode right;
        BSTNode left;

        public BSTNode(int size, int val) {
            this.size = size;
            this.val = val;
        }
    }

    public static BSTNode kthNode(BSTNode root, int k) {
        if(root != null) {
            int val = Math.abs(root.size - k);
            if(root.left != null) {
                int temp = root.left.size;
                if(temp  == val) {
                    return root;
                }else if(temp > val) {
                    kthNode(root.left, val);
                }else {
                    kthNode(root.right, val);
                }
            }else if(root.right != null) {
                int temp = root.right.size;
                if(temp - 1 == val) {
                    return root;
                }else if(temp < val) {
                    kthNode(root.right, val);
                }else {
                    kthNode(root.left, val);
                }
            }
        }
        return null;
    }


    public static boolean isNonIncreasing(int[] array) {
        int counter = 0;
        for(int i = 0; i < array.length - 1; i++) {
            if(array[i] >= array[i + 1]) {
                if(i > 0) {
                    if(array[i - 1] <= array[i + 1]) {
                        array[i] = array[i - 1];
                    }else {
                        array[i + 1] = array[i];
                    }
                }
            }
            counter++;
        }
        return counter <= 1;
    }

    public static void main(String[] args) {

        BSTNode root = new BSTNode(6, 4);
        root.left = new BSTNode(3, 2);
        root.left.left = new BSTNode(1, 0);
        root.left.right = new BSTNode(1, 3);
        root.right = new BSTNode(2, 8);
        root.right.right = new BSTNode(1, 9);
        int[] array = {3,4,2,3};
        System.out.println(isNonIncreasing(array));
    }
}

