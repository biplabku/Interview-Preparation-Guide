public class islandPerimeter {

    public static int[][] array = new int[][] {{0, 0 ,0, 0, 0 ,0}, {0, 0, 1, 0, 0, 0},{0, 0, 1, 1, 1, 0},{0, 0, 1, 0, 0, 0},{0, 1, 1, 0, 0 ,0 },{0, 0 ,0, 0, 0 ,0}};

    public static int getPerimeter() {
        int count = 0;
        for(int  i  = 0 ; i < array.length; i++) {
            for(int j = 0; j < array.length; j++) {
                if(array[i][j] == 1) {
                    count = count + calcPerimeter(i, j);
                }
            }
        }
        return count;
    }

    public static int calcPerimeter(int i, int j) {
        int c = 0;
        if(array[i - 1][j]  == 0){
            ++c;
        }
        if(array[i+1][j] == 0) {
            ++c;
        }
        if(array[i][j - 1] == 0) {
            ++c;
        }
        if(array[i][j +1] == 0) {
            ++c;
        }
        return c;
    }

    public static void main(String[ ] args) {

        System.out.println(getPerimeter());
    }
}
