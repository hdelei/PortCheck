
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
    public ButtonWait(JButton button){
        _button = button;
    }
    public void run(){
        _button.setText(waitString);
    }
    
}
