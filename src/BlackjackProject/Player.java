package BlackjackProject;

public class Player {
private BlackjackHand hand = new BlackjackHand();

public BlackjackHand getHand() {
	return hand;
}

public void setHand(BlackjackHand hand) {
	this.hand = hand;
}

@Override
public String toString() {
	return "Player [hand=" + hand + ", getHand()=" + getHand() + "]";
}


}
