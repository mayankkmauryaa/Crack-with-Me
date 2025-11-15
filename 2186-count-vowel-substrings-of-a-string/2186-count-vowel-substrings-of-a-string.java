class Solution {
    public int countVowelSubstrings(String word) {
        int n = word.length();
        int count = 0;

        for(int i=0; i<n; i++){
            HashSet<Character> set = new HashSet<>();

            for(int j = i; j<n ; j++){
                char ch  = word.charAt(j);
                if(isVowel(ch)) {
                    set.add(ch);
                    if(set.size()==5) count ++;
                } else break;
            }
        }
        return count;
    }
    public boolean isVowel (char ch){
        return (ch == 'a' ||ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u');
    }
}