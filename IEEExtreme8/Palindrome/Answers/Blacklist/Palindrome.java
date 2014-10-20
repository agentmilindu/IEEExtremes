/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xtreme2014;

/**
 *
 * @author Rumesh
 * Accepted
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Palindrome {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String x = palindrome(br.readLine());
            System.out.println(x.length());
        } catch (IOException ex) {
            Logger.getLogger(Palindrome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String palindrome(String source) {
        int n = source.length();
        int[][] LP = new int[n][n];

        for (int i = 0; i < n; i++) {
            LP[i][i] = 1;
        }

        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i < n - gap; i++) {
                int j = i + gap;
                if (source.charAt(i) == source.charAt(j) && gap == 1) {
                    LP[i][j] = 2;
                } else if (source.charAt(i) == source.charAt(j)) {
                    LP[i][j] = LP[i + 1][j - 1] + 2;
                } else {
                    LP[i][j] = Math.max(LP[i][j - 1], LP[i + 1][j]);
                }
            }
        }

        StringBuffer strBuff = new StringBuffer();
        int x = 0;
        int y = n - 1;
        while (x < y) {
            if (source.charAt(x) == source.charAt(y)) {
                strBuff.append(source.charAt(x));
                x++;
                y--;
            } else if (LP[x][y - 1] > LP[x + 1][y]) {
                y--;
            } else {
                x++;
            }
        }

        StringBuffer strBuffCopy = new StringBuffer(strBuff);
        String str = strBuffCopy.reverse().toString();
        if (x == y) {
            strBuff.append(source.charAt(x)).append(str);
        } else {
            strBuff.append(str);
        }
        return strBuff.toString();
    }
}
