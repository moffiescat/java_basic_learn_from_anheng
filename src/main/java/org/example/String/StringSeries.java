package org.example.String;

import java.lang.String;
import java.util.*;

public class StringSeries {
    public static void main(String[] args){
        StringBuilder kan = new StringBuilder();
        for(int i = 0; i < 10 ;i++){
            kan.append("_and_");
        }
        String kan_change = kan.toString();
        System.out.println(kan_change);
    }


}
