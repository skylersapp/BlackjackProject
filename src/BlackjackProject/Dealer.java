package BlackjackProject;

public class Dealer {
	private BlackjackHand hand = new BlackjackHand();

	public BlackjackHand getHand() {
		return hand;
	}

	public void setHand(BlackjackHand hand) {
		this.hand = hand;
	}

	@Override
	public String toString() {
		//return "Dealer [hand=" + hand + ", getHand()=" + getHand() + "]";
		return  "[ " + hand + ", "+ getHand() + " ] ";

	}


}
