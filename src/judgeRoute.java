public class judgeRoute {


    public static boolean findRoute(String str) {
        int x = 0;
        int y = 0;
        for(int  i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'L') {
                x--;
            }else if(str.charAt(i) == 'R'){
                x++;
            }else if(str.charAt(i) == 'U') {
                y++;
            }else {
                y--;
            }
        }

        if(x == 0 && y == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "UDLRL";
        System.out.println(findRoute(str));
    }
}
