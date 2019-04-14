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
        if(prices.length <= 1) {
            return -1;
        }
        int maxProfit = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i] < prices[i + 1]) {
                maxProfit += prices[i + 1] - prices[i];
                i = i + 2;
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int[] stockPricesYesterday = new int[] {1,2,3,0,2};
        System.out.println(maxProfit(stockPricesYesterday));
    }
}

