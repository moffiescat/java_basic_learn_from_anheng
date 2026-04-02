package org.example.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

class repeat_stack {
    public String decodeString(String s) {
        Deque<Integer> stack_num = new ArrayDeque<>();
        Deque<String> stack_res = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        int num = 0;

        for (Character x : s.toCharArray()) {
            if (x == '[') {
                stack_num.push(num);
                num = 0;
                stack_res.push(res.toString());
                res = new StringBuilder();
            } else if (x == ']') {
                int cur_num = stack_num.pop();
                String last_res = stack_res.pop();
                StringBuilder temp = new StringBuilder();
                for(int i = 0 ; i < cur_num ; i++){
                    temp.append(res);
                }
                res = new StringBuilder(last_res + temp);
            } else if (x >= '0' && x <= '9'){
                num = num * 10 + x - '0';
            }else{
                res.append(x);
            }
        }

        return res.toString();
    }

    public static void main(String[] args){
        String s = "bnm3[a2[c]]";
        repeat_stack  test= new repeat_stack();
        String result = test.decodeString(s);
        System.out.print(result);
    }
}