package com.tao.stack;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * 栈实现简单计算器
 */
public class Calculator {

    private static List<String> numberStr = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    private static Map<String, Integer> symbolStr;

    static {
        symbolStr = new HashMap<>(8);
        symbolStr.put("+", 1);
        symbolStr.put("-", 1);
        symbolStr.put("*", 2);
        symbolStr.put("/", 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入计算公式: ");
        String formula = sc.next();

        String[] arr = formula.split("");
        ArrayStack<String> stackNumber = new ArrayStack<>(String.class, arr.length);
        ArrayStack<String> stackSymbol = new ArrayStack<>(String.class, arr.length);

        for (int i = 0; i < arr.length; i++) {
            //数字直接放到数字栈
            if (numberStr.contains(arr[i])) {
                stackNumber.push(arr[i]);
                continue;
            }

            if (stackSymbol.isEmpty()) {
                stackSymbol.push(arr[i]);
                continue;
            }
            //符号进行优先级比较
            String symbol = stackSymbol.pop();
            Integer popLevel = symbolStr.get(symbol);
            Integer currLevel = symbolStr.get(arr[i]);
            if (popLevel < currLevel) {
                //栈中符号优先级小于当前符号，当前符号直接入栈
                stackSymbol.push(symbol);
                stackSymbol.push(arr[i]);
                continue;
            }
            //栈中符号优先级大于等于当前符号，从数字栈取出两位数，
            //从符号栈取出一位符号进行运算，将结果push进数字栈，最后将当前符号入栈
            String num2 = stackNumber.pop();
            String num1 = stackNumber.pop();
            BigDecimal calculate = calculate(new BigDecimal(num1), new BigDecimal(num2), symbol);
            stackNumber.push(calculate.toString());
            stackSymbol.push(arr[i]);
        }
        //最终结果计算
        while(!stackSymbol.isEmpty()){
            String num2 = stackNumber.pop();
            String num1 = stackNumber.pop();
            String symbol = stackSymbol.pop();
            BigDecimal calculate = calculate(new BigDecimal(num1), new BigDecimal(num2), symbol);
            stackNumber.push(calculate.toString());
        }
        System.out.println(stackNumber.pop());
        System.out.println(stackNumber.isEmpty());
    }

    public static BigDecimal calculate(BigDecimal num1, BigDecimal num2, String symbol) {
        if ("*".equals(symbol)) {
            return num1.multiply(num2);
        }
        if ("/".equals(symbol)) {
            return num1.divide(num2, 2, RoundingMode.HALF_UP);
        }
        if ("+".equals(symbol)) {
            return num1.add(num2);
        }
        return num1.subtract(num2);
    }
}
