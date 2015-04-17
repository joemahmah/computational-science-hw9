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
        coreThread.start();
    }
    
    @Override
    public void run() {
        
        IOHelper<Data> in = new IOHelper<>();
        Data d = in.read("data/background.dat");
        
        int i = 0;
        
        for(Object e: d.getEvents()){
            for(double da: ((Homework9Event)e).getVars()){
                System.out.println(da);
            }
            System.out.println("");
            i++;
            if(i > 10){
                break;
            }
        }
        
    }
    
    
    
}
