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


    public static void main(String[] args) {
        int[] stockPricesYesterday = new int[] {10, 7, 5, 8, 11, 9};
        System.out.println(getMaxProfitMethod1(stockPricesYesterday));
    }
}
