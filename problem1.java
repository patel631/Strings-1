class customSortString {
    public String customSortString(String order, String s) {
        if(order == null || order.length() == 0) return s;
        
        StringBuilder str = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int cnt = map.get(c);
                while(cnt > 0){
                    str.append(c);
                    cnt--;
                }
            }
            map.remove(c);
        }
        
        for(char c : map.keySet()){
            int cnt = map.get(c);
            while(cnt > 0){
                str.append(c);
                cnt--;
            }
        }
        
        return str.toString();
    }
}

//time complexity O(m + n) where m is length of order and n is lenght of s string
//space complexity O(1)