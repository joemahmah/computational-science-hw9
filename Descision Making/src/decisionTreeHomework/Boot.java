/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisionTreeHomework;

/**
 *
 * @author mhrcek
 */
public class Boot implements Runnable{
    
    private Thread coreThread;
    
    public static void main(String[] args){
        new Boot().init();
    }

    public void init(){
        coreThread = new Thread(this, "coreThread");
    }
    
    @Override
    public void run() {
        
    }
    
    
    
}
