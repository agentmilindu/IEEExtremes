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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rumesh
 * Remarks Accepted
 */
public class GrandIntegerLottery {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            int S = Integer.parseInt(input.split(" ")[0]);
            int E = Integer.parseInt(input.split(" ")[1]);
            int P = Integer.parseInt(input.split(" ")[2]) - 1;  //{Index is zero based}
            int N = Integer.parseInt(input.split(" ")[3]);

            int userSelectedNumbers[] = new int[N];
            for (int i = 0; i < N; i++) {
                userSelectedNumbers[i] = Integer.parseInt(br.readLine());
            }

            ArrayList<String> generatedNumbers = new ArrayList<String>();

            for (int i = S; i <= E; i++) {
                String tmp = "" + i;
                for(int test:userSelectedNumbers){
                    String tmp2= ""+test;
                    if(tmp.contains(tmp2)){
                        generatedNumbers.add(tmp);
                        break;
                    }
                }
            }
            
            try{
                System.out.println(generatedNumbers.get(P));
            }catch(RuntimeException ex){
                System.out.println("DOES NOT EXIST");
            }
        } catch (IOException ex) {
            Logger.getLogger(GrandIntegerLottery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
