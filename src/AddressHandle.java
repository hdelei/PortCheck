
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
    //private boolean isValidIP = true;
    
    /**
     * 
     * @return isValidIP do tipo Boolean caso o IP seja de formato válido.
     * A validação é executada pelo método portIsOpen().
     */
//    public boolean IsValidIP(){
//        System.out.println("Retornando: " + isValidIP);
//        return isValidIP;
//    }
    /**
     * 
     * @return _ip do tipo String caso não seja um objeto nulo
     */
    public String getIP(){
        if (_ip == null) {
            return "";
        }        
        else{
            return _ip;
        }
    }       
    
    /**
     * 
     * @param ip do tipo String
     * @param port do tipo int
     * Parametros que serão exigidos para a inicialização do construtor
     * 
     */
    public AddressHandle(String ip, int port) {
        _ip = ip;
        _port = port;        
    }
    /**
     * 
     * @return isOpen do tipo boolean
     * Este método instancia o objeto Socket com IP e Porta
     * e faz a checagem. O timeout da checagem é de 200 milissegundos
     * e poderá ser alterado na propriedade da classe caso necesário.
     * No caso de uma exceção por IP nulo, modifica isvalidIP para false
     */
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
                
        return isOpen;
    }
    
    /**
     * este método tem a função de traduzir o host para o formato
     * numérico. Exemplo: 192.168.1.1
     * Se o IP já está no formato numérico correto, apenas modifica
     * o campo _ip, caso não seja possível traduzir ou localizar
     * o endereço, faz com que _ip seja nulo - o que lançará uma 
     * excessão no método portIsOpen invalidando o IP.
     */
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
