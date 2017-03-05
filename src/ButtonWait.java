
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class ButtonWait extends Thread{
    String waitString = "Checking...";
    JButton _button;
    /**
     * 
     * @param button do tipo Button proveniente da classe Window
     * permite a classe ter controle sobre o Button do frame chamador
     */
    public ButtonWait(JButton button){
        _button = button;
    }
    /**
     * Este método permite renomear o botão em outra Thread diferente da
     * thread que o invocou.
     * 
     */
    public void run(){
        _button.setText(waitString);
    }
    
}
