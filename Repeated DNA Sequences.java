/*The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

 

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
 

Constraints:

1 <= s.length <= 105
s[i] is either 'A', 'C', 'G', or 'T'. */

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new LinkedList<String>();
        if (s == null || s.length() < 10)
            return result;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A',0);
        map.put('C',1);
        map.put('T',2);
        map.put('G',3);
        Set<Integer> appear = new HashSet<Integer>();
        Set<Integer> added = new HashSet<Integer>();
        int tmp = 0;
        for (int i = 0; i < s.length(); i ++){
            tmp = (tmp << 2) + map.get(s.charAt(i)); 
            if (i >= 9){
                tmp = tmp & ((1 << 20) - 1); 
                if (appear.contains(tmp) && !added.contains(tmp)){ 
                    added.add(tmp); 
                    result.add(s.substring(i - 9, i + 1)); 
                } 
                else{ 
                    appear.add(tmp); 
                } 
            }//if i >= 9
        }//for i
        return result;
    }
}
