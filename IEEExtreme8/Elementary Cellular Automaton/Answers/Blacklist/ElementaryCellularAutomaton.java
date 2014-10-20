/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xtreme2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rumesh 
 * Remark : accepted
 */
public class ElementaryCellularAutomaton {

    public static Dictionary dict;

    public static void main(String[] args) {

        try {
            dict = new Hashtable();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] input = br.readLine().split(" ");
            int rule = Integer.parseInt(input[0]);
            int maxIter = Integer.parseInt(input[1]);
            int cells = Integer.parseInt(input[2]);
            int initial = Integer.parseInt(input[3]);

            String ruleInBits = (String.format("%8s", Integer.toBinaryString(rule))).replace(' ', '0');
            dict.put("111", ruleInBits.charAt(0));
            dict.put("110", ruleInBits.charAt(1));
            dict.put("101", ruleInBits.charAt(2));
            dict.put("100", ruleInBits.charAt(3));
            dict.put("011", ruleInBits.charAt(4));
            dict.put("010", ruleInBits.charAt(5));
            dict.put("001", ruleInBits.charAt(6));
            dict.put("000", ruleInBits.charAt(7));
            String format = "%-4s";

            String initialInBits = (String.format("%" + cells + "s", Integer.toBinaryString(initial))).replace(' ', '0');
            String processingString = initialInBits;
            for (int i = 0; i < maxIter; i++) {

                String s = String.format(format, i + 1);
                System.out.println(s + "-" + bineryToStar(processingString) + "-");
                String tmp = processString(processingString);
                if (tmp.equalsIgnoreCase(processingString)) {
                    String s2 = String.format(format, i + 2);
                    System.out.println(s2 + "-" + bineryToStar(processingString) + "-");
                    break;
                }
                processingString = tmp;
            }
        } catch (IOException ex) {
            Logger.getLogger(ElementaryCellularAutomaton.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static String bineryToStar(String input) {
        return input.replace('1', '*').replace('0', ' ');
    }

    private static String processString(String processingString) {
        StringBuilder sb = new StringBuilder();
        int length = processingString.length();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                String s = "0" + processingString.substring(0, 2);
                sb.append(dict.get(s));
            } else if (i == length - 1) {
                String s = processingString.substring(length - 2, length) + "0";
                sb.append(dict.get(s));
            } else {
                String s = processingString.substring(i - 1, i + 2);
                sb.append(dict.get(s));
            }
        }

        return sb.toString();
    }
}
