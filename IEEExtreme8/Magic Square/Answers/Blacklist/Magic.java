/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xtreme2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rumesh
 */
public class Magic {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[N][N];

            int[] colSums = new int[N];
            int[] rowSums = new int[N];

            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().trim().split(" ");
                int tot = 0;
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(line[j]);
                    tot += arr[i][j];

                }
                rowSums[i] = tot;
            }

            //get main diagonal
            int mainDiagonalTot = 0;
            for (int i = 0; i < arr.length; i++) {

                mainDiagonalTot += arr[i][i];

            }

            int otherDiagonelTot = 0;

            for (int i = 0; i < N; i++) {

                otherDiagonelTot += arr[N - i - 1][i];

            }

            //get column count;
            for (int i = 0; i < N; i++) {
                int tot = 0;
                for (int j = 0; j < N; j++) {
                    tot += arr[j][i];
                }
                colSums[i] = tot;

            }
            //calculating differences
            ArrayList v = new ArrayList();
            if (mainDiagonalTot != otherDiagonelTot) {
                v.add(0);
            }

            for (int i = 0; i < colSums.length; i++) {
                if (mainDiagonalTot != colSums[i]) {
                    v.add((i + 1) * (-1));
                }

            }

            for (int i = 0; i < rowSums.length; i++) {
                if (mainDiagonalTot != rowSums[i]) {
                    v.add((i + 1));
                }

            }

            if (v.size() == 0) {
                System.out.println("0");
            }else{
                Collections.sort(v);
                System.out.println(v.size());
                for (int i = 0; i < v.size(); i++) {
                    System.out.println(v.get(i));
                    
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Magic.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
