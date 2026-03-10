package org.example.HashTable;

public class isAnagram {
    public boolean isAnagram(String s,String t){
        int[] record = new int[26];

        for(int i=0;i<record.length;i++){
            record[s.charAt(i)-'a']++;
        }

        for(int i=0;i<record.length;i++){
            record[t.charAt(i)-'a']--;
        }

        for(int count:record){
            if(count != 0){
                return false;
            }
        }

        return true;
    }
}
