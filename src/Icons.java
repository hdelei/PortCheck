
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
/**
 *
 * @author vanderlei
 * 
 */
public class Icons {
    
    private ArrayList<Image> list = new ArrayList<>();     
   
    /**
     * 
     * @return retorna uma lista com 10 objetos Image
     * provenientes do package "img" e que tenha o padrão de nomes
     * rj45-0.png, rj45-1.png...
     */
    public ArrayList<Image> getList(){         
        for(ImageIcon icon : getIcons()){
            list.add(icon.getImage());
        }
         
        return list;
    }
     
    /**
     * 
     * @return retorna uma lista com 10 objetos ImageIcon 
     * provenientes do package "img" e que tenha o padrão de nomes
     * rj45-0.png, rj45-1.png... 
     * Este método é privado porque é utilizado como auxiliar do método
     * <strong>getList()</strong>
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
