
package composite.modelo;


public class MyException extends Exception{
    
    private String msg;
    
    public MyException(String msg){
        super(msg);
    }
}
