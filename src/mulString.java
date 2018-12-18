public class mulString {


    public String multiplyString(String str1, String str2) {
        str1 = str1.trim();
        str2 = str2.trim();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int counter = 0;
        while(str1.charAt(counter) == '0' && counter < str1.length()) {
            counter++;
        }
        sb1.append(str1.substring(counter, str1.length()));
        counter = 0;
        while(str2.charAt(counter) == '0' && counter < str2.length()) {
            counter++;
        }
        sb2.append(str2.substring(counter, str2.length() ));
        long a = Long.parseLong(sb1.toString());
        long b = Long.parseLong(sb2.toString());
        String res = Long.toString(a * b);
        return res;
    }

    public static void main(String[] args) {
        mulString ms = new mulString();
        String str1 = "31243242535342";
        String str2 = "0";
        System.out.println(ms.multiplyString(str1, str2));
    }
}
