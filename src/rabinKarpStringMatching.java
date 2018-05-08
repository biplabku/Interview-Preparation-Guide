public class rabinKarpStringMatching {


    public boolean NaiveSearch(String str, String pattern) {
        for(int i = 0; i < (str.length() - pattern.length() + 1); i++) {
            for(int j = 0; j < pattern.length(); j++) {
                if(str.substring(j, i + j -1) == pattern.substring(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "pattern";
        String pattern = "ern";
        rabinKarpStringMatching rs = new rabinKarpStringMatching();
        System.out.println(rs.NaiveSearch(str, pattern));
    }
}