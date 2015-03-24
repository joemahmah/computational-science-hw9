package decisionTreeHomework;

public class Leaf<Type extends Event> {

	private Leaf<Type> output1 = null;
	private Leaf<Type> output2 = null;
	private double split;
	private int variable;
	
	private int nBackground;
	private int nSignal;
	
	public Leaf() {
		this(0, 0);
	}
	
	public Leaf(int variable, double split) {
		this.variable = variable;
		this.split = split;
	}
	
	public boolean isFinal() {
		return output1 == null || output2 == null;
	}
	
	public double getPurity() {
		return nSignal / (nSignal + nBackground);
	}
	
	public Leaf<Type> getLeftBranch() {
		return output1;
	}
	
	public Leaf<Type> getRightBranch() {
		return output2;
	}
	
	public Leaf<Type> runEvent(Type event) {
		if (isFinal()) {
			return null;
		}
		
		if (event.getVars()[variable] <= split) {
			return output1;
		} else {
			return output2;
		}
	}
	
	public void train(Data<Type> signal, Data<Type> background) {
		nSignal = signal.getEvents().size();
		nBackground = background.getEvents().size();
		
		boolean branch = chooseVariable(signal, background);
	
		if (branch) {
			output1 = new Leaf<Type>();
			output2 = new Leaf<Type>();
			
			Data<Type> signalLeft = new Data<>();
			Data<Type> signalRight = new Data<>();
			Data<Type> backgroundLeft = new Data<>();
			Data<Type> backgroundRight = new Data<>();
			
			for (Type event : signal.getEvents()) {
				if (runEvent(event) == output1) {
					signalLeft.addEvent(event);
				} else {
					signalRight.addEvent(event);
				}
			}
			
			for (Type event : background.getEvents()) {
				if (runEvent(event) == output1) {
					backgroundLeft.addEvent(event);
				} else {
					backgroundRight.addEvent(event);
				}
			}
			
			output1.train(signalLeft, backgroundLeft);
			output2.train(signalRight, backgroundRight);
		}		
	}
	
	private boolean chooseVariable(Data<Type> signal, Data<Type> background) {
		// TODO set the values of variable and split here		
		// Return true if you were able to find a useful variable, and false if you were not and want to stop calculation here

		return false;
	}

}
