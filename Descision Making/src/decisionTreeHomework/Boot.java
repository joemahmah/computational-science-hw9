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
        Data background = in.read("data/background.dat");
        Data background2 = in.read("data/backgroundBig.dat");
        Data signal = in.read("data/signal.dat");
        Data signal2 = in.read("data/signalBig.dat");
        Data unknown = in.read("data/decisionTreeData.dat");
        
        EventDataAnalysisAI ai = new EventDataAnalysisAI();
        ai.train(background, "background");
//        ai.train(background2, "background");
        ai.train(signal, "signal");
//        ai.train(signal2, "signal");
        
        ai.testData(signal);
    }
    
    
    
}
