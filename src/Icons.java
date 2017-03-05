
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vanderlei
 * 
 */
public class Icons {
    
    private ArrayList<Image> list = new ArrayList<>();     
   
    /**
     * 
     * @return retorna uma lista de objetos Image
     */
    public ArrayList<Image> getList(){
        for(ImageIcon icon : getIcons()){
            list.add(icon.getImage());
        }
         
        return list;
    }
     
    /**
     * 
     * @return retorna uma lista obejtos ImageIcon 
     */
    private ArrayList<ImageIcon> getIcons(){
        ArrayList<ImageIcon> aux = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            aux.add(new ImageIcon(getClass().
                    getClassLoader().getResource("img/rj45-"+ i + ".png")));
        }
         
        return aux;         
    }     
}
