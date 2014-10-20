/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xtreme2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rumesh
 * Remark : Accepted
 */
public class MorganClaypoolPublishers {
    public static HashMap<String,Vector> subConstraints;
    
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            
            subConstraints = new HashMap<String,Vector>();
            int N = Integer.parseInt(input.split(" ")[0]);
            int M = Integer.parseInt(input.split(" ")[1]);
            String[] constraints = new String[M];
            for (int i = 0; i < M; i++) {
                constraints[i] = br.readLine();
                String tmp[] = constraints[i].split(" ");
                if(subConstraints.containsKey(tmp[1])){
                    subConstraints.get(tmp[1]).add(tmp[0]);
                }else{
                    Vector tV = new Vector();
                    tV.add(tmp[0]);
                    subConstraints.put(tmp[1], tV);
                }
            }
            
            String[] subs = br.readLine().split(" ");
            Vector completedSubs = new Vector();
            for (int i = 0; i < subs.length; i++) {
                String currentSub = subs[i];
                if(subConstraints.containsKey(currentSub)){
                    Vector v = subConstraints.get(currentSub);
                    if(!completedSubs.containsAll(v)){
                        System.out.println("NO");
                        return;
                    }
                    completedSubs.add(currentSub);
                }else{
                    completedSubs.add(currentSub);
                }
                if( i == subs.length -1){
                    System.out.println("YES");
                }
                
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(MorganClaypoolPublishers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
