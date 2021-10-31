/*Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters. */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List <Integer> res = new ArrayList<Integer>();
        HashMap<Character, Integer> hm = new HashMap<>();
        
        int t= 0, count =0, k = p.length(), i=0, j=0;
        
        // Adding all the patterns char in hashmap
        while(t<k){
            char c = p.charAt(t);
            if(!hm.containsKey(c)){
                hm.put(c,1);
            }
            else{
                hm.put(c, hm.get(c)+1);
            }
            t++;
        }
        count = hm.size();
        
        while(j< s.length()){
            //each character of the string is checked is in pattern or not 
            char z = s.charAt(j);
            if(hm.containsKey(z)){
                hm.put(z, hm.get(z)-1);
                
                if(hm.get(z)== 0){
                count--;
                }
            }
            
            //window size not achieved
            if(j-i+1<k){
                j++;
            }
            //when window is achieved 
            else if(j-i+1==k){
                //when found anagram
                if(count==0){
                    res.add(i);
                }
                //Slide the window so j position element already taken care
                // need to work for the i position element 
                char y= s.charAt(i);
                if(hm.containsKey(y)){
                    hm.put(y, hm.get(y)+1);
                    
                    if(hm.get(y)==1){
                    count++;
                    }
                }
                
                i++;
                j++;
            }
            
        }
        return res;
    }
}
