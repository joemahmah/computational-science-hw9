/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisionTreeHomework;

import java.util.ArrayList;

/**
 *
 * @author mhrcek
 */
public class EventDataAnalysisAIVarStore {

    //Can be made general if using ArrayList<Double>[]
    ArrayList<Double> mlnub, transverseMass, jet1ET, leptonpT, hT, mET, qEta, cosTheta;

    String associatedType;

    public EventDataAnalysisAIVarStore(String associatedType) {
        this.associatedType = associatedType;
        this.mlnub = new ArrayList<>();
        this.transverseMass = new ArrayList<>();
        this.jet1ET = new ArrayList<>();
        this.leptonpT = new ArrayList<>();
        this.hT = new ArrayList<>();
        this.mET = new ArrayList<>();
        this.qEta = new ArrayList<>();
        this.cosTheta = new ArrayList<>();
    }

    public String getAssociatedType() {
        return associatedType;
    }

    public void addEvent(Homework9Event event) {
        mlnub.add(event.getVars()[0]);
        transverseMass.add(event.getVars()[1]);
        jet1ET.add(event.getVars()[2]);
        leptonpT.add(event.getVars()[3]);
        hT.add(event.getVars()[4]);
        mET.add(event.getVars()[5]);
        qEta.add(event.getVars()[6]);
        cosTheta.add(event.getVars()[7]);
    }

    public double getAverage_mlnub() {
        double average = 0;

        for (Double value : mlnub) {
            average += value;
        }

        return average / (double) mlnub.size();
    }
    
    public double getAverage_transverseMass() {
        double average = 0;

        for (Double value : transverseMass) {
            average += value;
        }

        return average / (double) transverseMass.size();
    }
    
    public double getAverage_jet1ET() {
        double average = 0;

        for (Double value : jet1ET) {
            average += value;
        }

        return average / (double) jet1ET.size();
    }
    
    public double getAverage_leptonpT() {
        double average = 0;

        for (Double value : leptonpT) {
            average += value;
        }

        return average / (double) leptonpT.size();
    }
    
    public double getAverage_hT() {
        double average = 0;

        for (Double value : hT) {
            average += value;
        }

        return average / (double) hT.size();
    }
    
    public double getAverage_mET() {
        double average = 0;

        for (Double value : mET) {
            average += value;
        }

        return average / (double) mET.size();
    }
    
    public double getAverage_qEta() {
        double average = 0;

        for (Double value : qEta) {
            average += value;
        }

        return average / (double) qEta.size();
    }
    
    public double getAverage_cosTheta() {
        double average = 0;

        for (Double value : cosTheta) {
            average += value;
        }

        return average / (double) cosTheta.size();
    }

    public double[] getRange_mlnub(){
        double min = mlnub.get(0);
        double max = mlnub.get(0);
        
        for(double value: mlnub){
            min = Math.min(value, min);
            max = Math.max(value, max);
        }
        
        double[] range = {min,max};
        return range;
        
    }
    
    public double[] getRange_transverseMass(){
        double min = transverseMass.get(0);
        double max = transverseMass.get(0);
        
        for(double value: transverseMass){
            min = Math.min(value, min);
            max = Math.max(value, max);
        }
        
        double[] range = {min,max};
        return range;
        
    }
    
    public double[] getRange_jet1ET(){
        double min = jet1ET.get(0);
        double max = jet1ET.get(0);
        
        for(double value: jet1ET){
            min = Math.min(value, min);
            max = Math.max(value, max);
        }
        
        double[] range = {min,max};
        return range;
        
    }
    
    public double[] getRange_leptonpT(){
        double min = leptonpT.get(0);
        double max = leptonpT.get(0);
        
        for(double value: leptonpT){
            min = Math.min(value, min);
            max = Math.max(value, max);
        }
        
        double[] range = {min,max};
        return range;
        
    }
    
    public double[] getRange_hT(){
        double min = hT.get(0);
        double max = hT.get(0);
        
        for(double value: hT){
            min = Math.min(value, min);
            max = Math.max(value, max);
        }
        
        double[] range = {min,max};
        return range;
        
    }
    
    public double[] getRange_mET(){
        double min = mET.get(0);
        double max = mET.get(0);
        
        for(double value: mET){
            min = Math.min(value, min);
            max = Math.max(value, max);
        }
        
        double[] range = {min,max};
        return range;
        
    }
    
    public double[] getRange_qEta(){
        double min = qEta.get(0);
        double max = qEta.get(0);
        
        for(double value: qEta){
            min = Math.min(value, min);
            max = Math.max(value, max);
        }
        
        double[] range = {min,max};
        return range;
        
    }
    
    public double[] getRange_cosTheta(){
        double min = cosTheta.get(0);
        double max = cosTheta.get(0);
        
        for(double value: cosTheta){
            min = Math.min(value, min);
            max = Math.max(value, max);
        }
        
        double[] range = {min,max};
        return range;
        
    }
    
    public double[] getProbableRange_mlnub(int percent){
        return Stats.getPercentRange(mlnub, percent, Stats.getAverage(mlnub), (int)Math.ceil(Stats.getMaxValueInArray(mlnub)));
    }
    
    public double[] getProbableRange_transverseMass(int percent){
        return Stats.getPercentRange(transverseMass, percent, Stats.getAverage(transverseMass), (int)Math.ceil(Stats.getMaxValueInArray(transverseMass)));
    }
    
    public double[] getProbableRange_jetlET(int percent){
        return Stats.getPercentRange(jet1ET, percent, Stats.getAverage(jet1ET), (int)Math.ceil(Stats.getMaxValueInArray(jet1ET)));
    }
    
    public double[] getProbableRange_leptonpT(int percent){
        return Stats.getPercentRange(leptonpT, percent, Stats.getAverage(leptonpT), (int)Math.ceil(Stats.getMaxValueInArray(leptonpT)));
    }
    
    public double[] getProbableRange_hT(int percent){
        return Stats.getPercentRange(hT, percent, Stats.getAverage(hT), (int)Math.ceil(Stats.getMaxValueInArray(hT)));
    }
    
    public double[] getProbableRange_mET(int percent){
        return Stats.getPercentRange(mET, percent, Stats.getAverage(mET), (int)Math.ceil(Stats.getMaxValueInArray(mET)));
    }
    
    public double[] getProbableRange_qEta(int percent){
        return Stats.getPercentRange(qEta, percent, Stats.getAverage(qEta), (int)Math.ceil(Stats.getMaxValueInArray(qEta)));
    }
    
    public double[] getProbableRange_cosTheta(int percent){
        return Stats.getPercentRange(cosTheta, percent, Stats.getAverage(cosTheta), (int)Math.ceil(Stats.getMaxValueInArray(cosTheta)));
    }
    
    public double getOccurancePercentage_mlnub(double value){
        return Stats.getPercentageMatchingTargetValue(mlnub, value);
    }
    
    public double getOccurancePercentage_transverseMass(double value){
        return Stats.getPercentageMatchingTargetValue(transverseMass, value);
    }
    
    public double getOccurancePercentage_jet1ET(double value){
        return Stats.getPercentageMatchingTargetValue(jet1ET, value);
    }
    
    public double getOccurancePercentage_leptonpT(double value){
        return Stats.getPercentageMatchingTargetValue(leptonpT, value);
    }
    
    public double getOccurancePercentage_hT(double value){
        return Stats.getPercentageMatchingTargetValue(hT, value);
    }
    
    public double getOccurancePercentage_mET(double value){
        return Stats.getPercentageMatchingTargetValue(mET, value);
    }
    
    public double getOccurancePercentage_qEta(double value){
        return Stats.getPercentageMatchingTargetValue(qEta, value);
    }
    
    public double getOccurancePercentage_cosTheta(double value){
        return Stats.getPercentageMatchingTargetValue(cosTheta, value);
    }
    
    
}
