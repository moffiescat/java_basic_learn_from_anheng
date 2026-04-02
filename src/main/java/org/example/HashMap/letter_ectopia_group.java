package org.example.HashMap;

import java.util.*;

public class letter_ectopia_group {
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(String str:strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(key);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
