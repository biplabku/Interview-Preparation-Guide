public class ConvertToInt {

    public int converToInt(final String str){
        if(str == null) {
            return 0;
        }
        int result = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                break;
            }else if(Integer.valueOf(str.charAt(i)) > 46 || Integer.valueOf(str.charAt(i)) < 57) {
                sb.append(str.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        ConvertToInt conve = new ConvertToInt();
        String str = "";
        System.out.println(conve.converToInt(str));
    }

}
