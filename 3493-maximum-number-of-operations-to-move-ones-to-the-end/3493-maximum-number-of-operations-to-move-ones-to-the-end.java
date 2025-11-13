class Solution {
    public int maxOperations(String s) {
        int count = 0;
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            // agar 1 ke baad 0 h too ek operation to lgega hi
            // prr hrr ek 1 k liye lagega jo piche the 
            // 1 ko count
            if(s.charAt(i)=='1') count++;
            // agar 1 nhi h too operation count krenge hrr ek 1 k liye
            else if(i>0 && s.charAt(i-1)=='1') ans+=count;
        }
        return ans;
    }
}