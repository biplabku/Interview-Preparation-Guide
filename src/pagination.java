import java.util.*;

public class pagination {

    public static List<String> getPagination(List<List<String>> items, int sortParameter, int sortOrder, int pageNumber, int itemsPerPage){
        List<List<String>> result = new ArrayList<>();
        String[] arry = new String[items.size()];
        HashMap<String, List<String>> hmap = new HashMap<>();
        for(int i =0; i < items.size(); i++) {
            List<String> item = items.get(i);
            String val = item.get(sortParameter);
            arry[i] = val;
            hmap.put(val, item);
        }
        if(sortOrder == 1) {
            Arrays.sort(arry, Collections.reverseOrder());
        }
        Arrays.sort(arry);
        int count = itemsPerPage;
        for(int i = 0; i < arry.length; i++) {
            List<String> temp = new ArrayList<>();
            while(count != 0 && i < arry.length) {
                count--;
                temp.add(hmap.get(arry[i]).get(0));
                i = i + 1;
            }
            i = i - 1;
            count = itemsPerPage;
            result.add(temp);
        }
        String str = String.valueOf(12);
        return result.get(pageNumber);
    }




    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list2.add("owjevtkuyv");
        list2.add("17");
        list2.add("8");
        List<String> list = new ArrayList<>();
        list.add("rpaqgbjxik");
        list.add("10");
        list.add("15");
        List<String> list1 = new ArrayList<>();
        list1.add("dfbkasyqcn");
        list1.add("3");
        list1.add("4");
        List<String> list3 = new ArrayList<>();
        list1.add("vjrrisdfxe");
        list1.add("3");
        list1.add("4");

        input.add(list);
        input.add(list1);
        input.add(list2);
        input.add(list3);
        String str = "p1";
        System.out.println(getPagination(input, 0, 0, 0, 2));
    }
}
