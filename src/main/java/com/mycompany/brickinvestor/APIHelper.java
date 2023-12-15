/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.brickinvestor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author davidpicariello
 */
public class APIHelper {
    static String key = "?key=8a1ca704a9cebf339819b785df15b9e7";
    
   public static String getAPIDescription(String url){
       // modified code from: https://docs.oracle.com/javase/tutorial/networking/urls/readingWriting.html
        URL oracle;
        try {
            oracle = new URL(url+key);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                                        yc.getInputStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
//                jTextArea1.append(inputLine);
                sb.append(inputLine);
            }
            in.close();

            return sb.toString();

        } catch (MalformedURLException ex) {
            Logger.getLogger(AddOrderJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddOrderJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        // end code from above URL  
        return null;
    }
       
   }

    


