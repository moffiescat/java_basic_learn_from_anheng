package org.example.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

//leetcode 739
public class Monotonic_Stack {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < length ;i++){
            int temperature = temperatures[i];
            while(!stack.isEmpty() && temperature > temperatures[stack.peek()]){
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args){
        Monotonic_Stack test = new Monotonic_Stack();
        int[] temp = {73,74,75,71,69,72,76,73};
        int[] answer = test.dailyTemperatures(temp);
        System.out.print(answer);
    }
}

