/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Vanderlei
 */
public class MyClipboard {
    private String url = "Clipboard empty";
    //private String regex = "http:[/][/][a-zA-Z|.|:|//"+ "\\" + "d|-]+";
    private String nregex = "\\b(?:(https?|ftp|file)://|www\\.)?[-A-Z0-9+&#/%?" + //testing this new regex
            "=~_|$!:,.;]*[A-Z0-9+&@#/%=~_|$]\\.[-A-Z0-9+&@#/%?=~_|$!:,.;]*[A-Z" + 
            "0-9+&@#/%=~_|$]";
    
    private Pattern p;
    private Matcher matcher;
    private int port = 0;
    //String address = "Clipboard empty";
    
    public MyClipboard(){                   
        obtainClipboard();
        //p = Pattern.compile(nregex); //testing porpouse
        p = Pattern.compile(nregex,Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        matcher = p.matcher(url);        
        filterWithRegex();        
    }
    
    public String getURL(){
        return url;
    }
    
    public int getPort(){
        return port;
    }
    
    private void obtainClipboard(){        
        try {
            url = (String) Toolkit.getDefaultToolkit()
                .getSystemClipboard().getData(DataFlavor.stringFlavor);
            //System.out.println(url + " in obtaiClipboard");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void filterWithRegex(){
        String url_aux = "";
        
        if (matcher.find())
        {
            url_aux = matcher.group(0);            
            System.out.println("matcher found: " + matcher.group(0));
            
            if (url_aux.contains("http://")) {
                url_aux = url_aux.replace("http://", "");      
                System.out.println("contains http://");
            }
        
            if(url_aux.contains(":")){
                int position;
                String _port;            
                position = url_aux.indexOf(":");
                _port = url_aux.substring(position + 1);
                url_aux = url_aux.replace(":" + _port, "");            
            
                url = url_aux;
                port = Integer.parseInt(_port);
               //hjadha.dakdakjda.dsdsds.asdada("sdsdsa:");
                System.out.println("contem ':'");            
            }            
        }        
    }    
}
