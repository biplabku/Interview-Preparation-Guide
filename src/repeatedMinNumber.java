 public int repeatedNumber(final ArrayList<Integer> list) {
        int min = Integer.MAX_VALUE;
        HashSet<Integer> hset = new HashSet<>();
        for(int i = 0; i < list.size(); i++) {
            if(!hset.contains(list.get(i))) {
                hset.add(list.get(i));
            } else { //  lets say if it contains the smallest number then
                // it should reply with the least value in the array
                min = Math.min(min, list.get(i));
            }
        }
        return min == Integer.MAX_VALUE ? Integer.MAX_VALUE:min;
    }
