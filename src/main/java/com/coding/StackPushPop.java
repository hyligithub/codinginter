package com.coding;

import java.util.Stack;

/**
 * Created by lihuiyan on 2015/12/28.
 *
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class StackPushPop {
    public  static void main(String[] args){
//        String[] tokens=  {"2","3","+","3","*"};
        String[] tokens=  {"4","13","5","/","+"};
        int result = evalRRN(tokens);
        System.out.println(result);
    }

    public static Integer evalRRN(String[] tokens){
        Integer resultValue = null;
        String opreator = "+-*/";
        Stack<String> stack = new Stack<String>();
        for(int i = 0;i<tokens.length;i++){
            if(opreator.indexOf(tokens[i])<0){
                stack.push(tokens[i]);
            }else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int index = opreator.indexOf(tokens[i]);
                switch (index){
                    case 0:
                        stack.push(String.valueOf(a+b));
                        break;
                    case 1:
                        stack.push(String.valueOf(a-b));
                        break;
                    case 2:
                        stack.push(String.valueOf(a*b));
                        break;
                    case 3:
                        stack.push(String.valueOf(b/a));
                        break;
                }
            }
        }
        resultValue = Integer.valueOf(stack.pop());
        return resultValue;
    }
}
