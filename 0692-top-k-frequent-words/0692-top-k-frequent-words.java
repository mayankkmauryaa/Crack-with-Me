class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer>map=new HashMap<>();
        List<String> list = new ArrayList<>();
        for(String s : words){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        List<Map.Entry<String, Integer>> entry = new ArrayList<>(map.entrySet());
        entry.sort((a,b) -> {
            // sorts by frequency descending.
            if(!b.getValue().equals(a.getValue())) return b.getValue()-a.getValue();
            // breaks ties alphabetically ascending.
            return a.getKey().compareTo(b.getKey());
        });

        for(int i=0; i<k; i++){
            list.add(entry.get(i).getKey());
        }
        return list;
    }
}