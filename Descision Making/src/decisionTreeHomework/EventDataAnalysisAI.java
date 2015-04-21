/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisionTreeHomework;

import java.io.Serializable;

/**
 *
 * @author mhrcek
 */
public class EventDataAnalysisAI implements Serializable {

    EventDataAnalysisAIVarStore signal, background;

    public EventDataAnalysisAI() {
        signal = new EventDataAnalysisAIVarStore("signal");
        background = new EventDataAnalysisAIVarStore("background");
    }

    public void train(Data dataSet, String type) {
        for (Object event : dataSet.getEvents()) {
            if (type.equals("signal")) {
                signal.addEvent((Homework9Event) event);
            } else {
                background.addEvent((Homework9Event) event);
            }
        }
    }

    public void testData(Data dataSet) {

        for (Object event : dataSet.getEvents()) {
            double confidenceSignal = getConfidenceSignal((Homework9Event) event);
            double confidenceBackground = getConfidenceBackground((Homework9Event) event);
            double confidenceUnknown = getConfidenceUnknown(confidenceSignal, confidenceBackground);
            determineEventType(confidenceSignal, confidenceBackground, confidenceUnknown);
        }

    }

    private double getConfidenceSignal(Homework9Event event) {

        double confidence = 0;

        double cosTheta = event.getVars()[7];
        double hT = event.getVars()[4];
        double jet1ET = event.getVars()[2];
        double leptonpT = event.getVars()[3];
        double mET = event.getVars()[5];
        double mlnub = event.getVars()[0];
        double qEta = event.getVars()[6];
        double transverseMass = event.getVars()[1];

        double WEIGHT = 100d;
        
        for (int percentage = 96; percentage > 10; percentage -= 2) {
            if (signal.getProbableRange_cosTheta(percentage)[0] < cosTheta && signal.getProbableRange_cosTheta(percentage)[1] > cosTheta) {
                confidence += (100 - percentage) / WEIGHT;
            }
            if (signal.getProbableRange_hT(percentage)[0] < hT && signal.getProbableRange_hT(percentage)[1] > hT) {
                confidence += (100 - percentage) / WEIGHT;
            }
            if (signal.getProbableRange_jetlET(percentage)[0] < jet1ET && signal.getProbableRange_jetlET(percentage)[1] > jet1ET) {
                confidence += (100 - percentage) / WEIGHT;
            }
            if (signal.getProbableRange_leptonpT(percentage)[0] < leptonpT && signal.getProbableRange_leptonpT(percentage)[1] > leptonpT) {
                confidence += (100 - percentage) / WEIGHT;
            }
            if (signal.getProbableRange_mET(percentage)[0] < mET && signal.getProbableRange_mET(percentage)[1] > mET) {
                confidence += (100 - percentage) / WEIGHT;
            }
            if (signal.getProbableRange_mlnub(percentage)[0] < mlnub && signal.getProbableRange_mlnub(percentage)[1] > mlnub) {
                confidence += (100 - percentage) / WEIGHT;
            }
            if (signal.getProbableRange_qEta(percentage)[0] < qEta && signal.getProbableRange_qEta(percentage)[1] > qEta) {
                confidence += (100 - percentage) / WEIGHT;
            }
            if (signal.getProbableRange_transverseMass(percentage)[0] < transverseMass && signal.getProbableRange_transverseMass(percentage)[1] > transverseMass) {
                confidence += (100 - percentage) / WEIGHT;
            }
        }

        System.err.println(confidence);
        return confidence;
    }

    private double getConfidenceBackground(Homework9Event event) {
        
        double confidence = 0;

        double cosTheta = event.getVars()[7];
        double hT = event.getVars()[4];
        double jet1ET = event.getVars()[2];
        double leptonpT = event.getVars()[3];
        double mET = event.getVars()[5];
        double mlnub = event.getVars()[0];
        double qEta = event.getVars()[6];
        double transverseMass = event.getVars()[1];

        double WEIGHT = 100d;
        
        for (int percentage = 96; percentage > 10; percentage -= 2) {
            if (background.getProbableRange_cosTheta(percentage)[0] < cosTheta && background.getProbableRange_cosTheta(percentage)[1] > cosTheta) {
                confidence += (100 - percentage) / WEIGHT;
            }
            if (background.getProbableRange_hT(percentage)[0] < hT && background.getProbableRange_hT(percentage)[1] > hT) {
                confidence += (100 - percentage) / WEIGHT;
            }
            if (background.getProbableRange_jetlET(percentage)[0] < jet1ET && background.getProbableRange_jetlET(percentage)[1] > jet1ET) {
                confidence += (100 - percentage) / WEIGHT;
            }
            if (background.getProbableRange_leptonpT(percentage)[0] < leptonpT && background.getProbableRange_leptonpT(percentage)[1] > leptonpT) {
                confidence += (100 - percentage) / WEIGHT;
            }
            if (background.getProbableRange_mET(percentage)[0] < mET && background.getProbableRange_mET(percentage)[1] > mET) {
                confidence += (100 - percentage) / WEIGHT;
            }
            if (background.getProbableRange_mlnub(percentage)[0] < mlnub && background.getProbableRange_mlnub(percentage)[1] > mlnub) {
                confidence += (100 - percentage) / WEIGHT;
            }
            if (background.getProbableRange_qEta(percentage)[0] < qEta && background.getProbableRange_qEta(percentage)[1] > qEta) {
                confidence += (100 - percentage) / WEIGHT;
            }
            if (background.getProbableRange_transverseMass(percentage)[0] < transverseMass && background.getProbableRange_transverseMass(percentage)[1] > transverseMass) {
                confidence += (100 - percentage) / WEIGHT;
            }
        }

        System.err.println(confidence);
        return confidence;
    }

    private double getConfidenceUnknown(double signal, double background) {
        return 0;
    }

    private void determineEventType(double signal, double background, double unknown) {
        System.out.println("EVENT ID, CONFIDENCE SIGNAL, CONFIDENCE BACKGROUND, CONFIDENCE UNKNOWN, MOST LIKELY, REASON");

        String mostLikely, reason;

        if (unknown > .66) {
            mostLikely = "Unknown";
            if (signal > .66 && background > .66) {
                reason = "Signal and background confidence too similar - extreme overlap";
            } else if (signal < .33 && background < .33) {
                reason = "Signal and background confidence too simialr - possible outlier event";
            } else {
                if (signal >= background) {
                    reason = "Unwilling to determine - Signal more likely";
                } else {
                    reason = "Unwilling to determine - Background more likely";
                }
            }
        }
    }

}
