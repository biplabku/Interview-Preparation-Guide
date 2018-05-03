public class rabinKarpStringMatching {


    public boolean NaiveSearch(String str, String pattern) {
        for(int i = 0; i < (str.length() - pattern.length() + 1); i++) {
            for(int j = 0; j < pattern.length(); j++) {
                
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "";
        String pattern = "";
        rabinKarpStringMatching rs = new rabinKarpStringMatching();
        System.out.println(rs.NaiveSearch(str, pattern));
    }
}
