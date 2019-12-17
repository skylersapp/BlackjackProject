package BlackjackProject;

import com.skilldistillery.cards.common.AbstractHand;

public class BlackjackHand extends AbstractHand{

	
	public BlackjackHand() {
	}
	
	
	public boolean isBust1() {
		int value = this.getHandValue();
		
		System.out.println(this.getHandValue());
		if (value > 21){
			System.out.print("Bust ");
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public int getHandValue() {
		int totalVal = 0;
		for (int i = 0; i < cardsInHand.size(); i++) {
			totalVal += cardsInHand.get(i).getValue();
		}
		return totalVal;
	}
	
}

