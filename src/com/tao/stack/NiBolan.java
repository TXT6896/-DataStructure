package com.tao.stack;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * 逆波兰表达式，逆序表达式
 */
public class NiBolan {
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

        //中缀转后缀
        ArrayStack<String> s1 = new ArrayStack<>(String.class, formula.length());
        ArrayStack<String> s2 = new ArrayStack<>(String.class, formula.length());
        String[] arr = formula.split("");
        for (int i = 0; i < arr.length; i++) {
            if (numberStr.contains(arr[i])) {
                //操作数
                StringBuilder oprStr = new StringBuilder(arr[i]);
                //多位数判断
                while (i < arr.length - 1 && numberStr.contains(arr[++i])) {
                    oprStr.append(arr[i]);
                }
                //将操作数放入s2
                s2.push(oprStr.toString());
                if (i == arr.length - 1){
                    break;
                }
            }
            //符号
            if ("(".equals(arr[i])) {
                //左括号
                s1.push(arr[i]);
                continue;
            }
            if (")".equals(arr[i])) {
                while (!"(".equals(s1.getTop())) {
                    s2.push(s1.pop());
                }
                s1.pop();
                continue;
            }
            //运算符
            while (true) {
                if (s1.isEmpty() || "(".equals(s1.getTop()) || symbolStr.get(arr[i]) > symbolStr.get(s1.getTop())) {
                    s1.push(arr[i]);
                    break;
                }
                s2.push(s1.pop());
            }
        }
        System.out.println(s1.isEmpty());
        System.out.println(s2.isEmpty());
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!s2.isEmpty()) {
            sb.insert(0, s2.pop());
        }
        System.out.println(sb);

        //后缀表达式计算结果
        arr = sb.toString().split("");

        ArrayStack<String> stackNumber = new ArrayStack<>(String.class, arr.length);

        for (int i = 0; i < arr.length; i++) {
            if (numberStr.contains(arr[i])) {
                stackNumber.push(arr[i]);
                continue;
            }
            if (symbolStr.containsKey(arr[i])) {
                String num2 = stackNumber.pop();
                String num1 = stackNumber.pop();
                BigDecimal calculate = calculate(new BigDecimal(num1), new BigDecimal(num2), arr[i]);
                stackNumber.push(calculate.toString());
            }
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
