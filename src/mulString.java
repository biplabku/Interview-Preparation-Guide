public class mulString {


    public String multiplyString(String str1, String str2) {
        str1 = str1.trim();
        str2 = str2.trim();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int counter = 0;
        // 000
        while(str1.charAt(counter) == '0') {
            counter++;
            if(counter == str1.length()) {
                return "0";
            }
        }
        sb1.append(str1.substring(counter, str1.length()));
        counter = 0;
        while(str2.charAt(counter) == '0') {
            counter++;
            if(counter == str2.length()) {
                return "0";
            }
        }
        sb2.append(str2.substring(counter, str2.length() ));
        long a = Long.parseLong(sb1.toString());
        long b = Long.parseLong(sb2.toString());
        String res = Long.toString(a * b);
        return res;
    }

    public String mulString( String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }

    public static void main(String[] args) {
        mulString ms = new mulString();
        String str1 = "5131848155574784703269632922904933776792735241197982102373370";
        String str2 = "56675688419586288442134264892419611145485574406534291250836";
        System.out.println(ms.multiplyString(str1, str2));
    }
}
