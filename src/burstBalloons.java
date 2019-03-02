import java.util.HashMap;

public class burstBalloons {


    public boolean wordPattern(String str, String pattern) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if(!hmap.containsKey(ch)) {
                hmap.put(ch, i);
                sb.append(i);
            }else {
                sb.append(hmap.get(ch));
            }
        }
        str.trim();
        hmap.clear();
        HashMap<String, Integer> hmap1 = new HashMap<>();
        StringBuilder sb1= new StringBuilder();

        String[] ar = str.split("\\s+");
        for(int i = 0; i < ar.length; i++) {
            String st = ar[i];
            if(!hmap1.containsKey(st)) {
                hmap1.put(st, i);
                sb1.append(i);
            }else {
                sb1.append(hmap1.get(st));
            }
        }
        return sb.toString().equals(sb1.toString());
    }


    public static void main(String[] args) {
        burstBalloons bs = new burstBalloons();
        String str = "dog cat cat og";
        String pattern = "abba";
        System.out.println(bs.wordPattern(str, pattern));
    }
}
