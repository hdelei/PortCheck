
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vanderlei
 */
public class AddressHandle {
    
    private String _ip;
    private int _port;
    private final int timeout = 200; //milisseconds
    private boolean isValidIP = true;
    
    public boolean IsValidIP(){
        return isValidIP;
    }
    
    public String getIP(){
        if (_ip == null) {
            return "";
        }        
        else{
            return _ip;
        }
    }       
    

    public AddressHandle(String ip, int port) {
        _ip = ip;
        _port = port;        
    }
    
    public boolean portIsOpen() {
        boolean isOpen = false;
        hostToIP();
        if (_ip != null && _port > 0) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(_ip, _port), timeout);
                socket.close();
                isOpen = true;
            } catch (Exception ex) {
                isOpen = false;
            }
        }
        else{
            isValidIP = false;
        }
        return isOpen;
    }
    
    
    private void hostToIP(){
        try {
            InetAddress address; 
            address = InetAddress.getByName(_ip);            
            _ip = address.getHostAddress();
        } catch (UnknownHostException ex) {
            _ip = null;
        }        
    }
    
    
    
}
