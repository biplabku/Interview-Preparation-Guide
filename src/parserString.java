import java.util.*;

public class parserString {

    TreeMap<String, String> hmap = new TreeMap<>();
    List<String> result = new ArrayList<>();
    public void parseTheString(String[] input) {
        for(int i = 0; i < input.length; i++) {
            result.add(input[i]);
            proceesString(input[i]);
        }
        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public void proceesString(String str) {
        String[] array = str.split(" ");
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        // create a hashmap of the related data set;
        // it will show that one part depends on the other

        if(array[0].equals("DEPEND")) {
            processTheMap(array);
            System.out.println(hmap);

        }else if(array[0].equals("REMOVE")) {
            String key = array[1];
            if(hmap.containsValue(key)) {
                String st = key + " is still needed";
                result.add(st);
            }else {
                String st = "Removing " + key;
                result.add(st);
                hmap.remove(key);
            }
        }else if(array[0].equals("INSTALL")) {
            String key = array[1];
            while(hmap.containsKey(key)) {
                String temp = hmap.get(key);
                if(!hmap.containsKey(temp)) {
                    String st = "Installing " + temp;
                }
                key = hmap.get(temp);
            }
            result.add(array[1]);
        }else if(array[0].equals("LIST")) {
            Iterator iter = hmap.entrySet().iterator();
            while(iter.hasNext()) {
                Map.Entry pair = (Map.Entry)iter.next();
                result.add(pair.getKey().toString());
            }
        }else { // "END"
            result.add("END");
        }
    }

    public void processTheMap(String[] array) {
        for(int i = 1; i < array.length-1; i++) {
            String key = array[i];
            String value = array[i + 1];
            if(!hmap.containsKey(key)) {
                hmap.put(key, value);
            }else if(hmap.containsKey(value)) { // if its already there then create a new string and append it
                if(result.size() != 0) {
                    // result.remove(result.size() - 1);
                    String str = key + " depends on " + value + " , " + "Ignoring command";
                    result.add(str);
                }
            }
        }
    }

    public static void main(String[] args){
        parserString ps = new parserString();
        String[] array = new String[19];
        array[0] = "DEPEND TELNET TCIP NETCARD";
        array[1] = "DEPEND TCIP NETCARD";
        array[2] = "DEPEND NETCARD TCIP";
        array[3] = "DEPEND DNS TCIP NETCARD";
        array[4] = "DEPEND BROWSER TCIP HTML";
        array[5] = "INSTALL NETCARD";
        array[6] = "INSTALL NETCARD TCIP";
        array[7] = "INSTALL foo";

        array[8] = "REMOVE NETCARD";
        array[9] = "INSTALL BROWSER";
        array[10] = "INSTALL DNS";
        array[11] = "REMOVE TELNET";
        array[12] = "REMOVE NETCARD";
        array[13] = "REMOVE DNS";
        array[14] = "REMOVE NETCARD";
        array[15] = "REMOVE TCIP";
        array[16] = "REMOVE BROWSER";
        array[17] = "LIST";
        array[18] = "END";
        ps.parseTheString(array);
    }
}
