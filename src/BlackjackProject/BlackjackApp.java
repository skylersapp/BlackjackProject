package BlackjackProject;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {
	Player player = new Player();
	Dealer dealer = new Dealer();
	Deck deck = new Deck();
	Scanner sc = new Scanner(System.in);
	BlackjackHand bjhand = new BlackjackHand();

	public static void main(String[] args) {
		BlackjackApp blackjackapp = new BlackjackApp();

		blackjackapp.runApp();
	}

	public void runApp() {
		
		introAndDealing();
		newHand();
		isBlackjack();
		playerMenu();
		dealerUnder();
		checkPlayerHand();

	}
	
	private void introAndDealing() {
		System.out.println("Welcome to the Blackjack Table!\n");
		System.out.println("\t\t....Shuffling....\n");
		System.out.println("The goal is to get closer than the Dealer to 21 without going over.\n");
		System.out.println("\t\t....Shuffling....\n");
		System.out.println("You both start with two cards, and you add their face values for your total.\n");
		System.out.println("\t\t....Shuffling....\n");
		System.out.println("J, Q, and K are worth 10, and at this table A is a hard 11.\n");
		System.out.println("\t\t....Shuffling....\n");
		System.out.println("You'll choose to either |HIT| or |STAY| based on your total.");
		System.out.println("The Dealer will always |HIT| below 17, and |STAY| if above.\n");
		System.out.println("\t\t....Shuffling....\n");
		System.out.println("Getting exactly 21 is Blackjack and a winning hand!");
		System.out.println("Got it? Lets play!\n");
		System.out.println("\t\t....Dealing....\n\t\t....Dealing....\n\t\t....Dealing....\n");





	}

	private void checkPlayerHand() {
		while (player.getHand().getHandValue() <= 21) {

			if (dealer.getHand().getHandValue() == player.getHand().getHandValue()) {
				System.out.println("Dealer and Player have the same total. Push");
				break;
			}
			if (isBust()) {
				System.out.println("Dealer busts!!!");
				System.out.println("Player *WINS*!");
				break;
			} else if (dealer.getHand().getHandValue() > player.getHand().getHandValue()) {
				System.out.println("Dealer *WINS*!");
				break;

			} else {
				System.out.println("Player *WINS*!");
				break;
			}

		}
	}

	private void dealerUnder() {
		while (dealer.getHand().getHandValue() < 17 && isBust() == false && isBlackjack() == false) {
			System.out.println("Dealer --> " + dealer.getHand().getHandValue());
			dealer.getHand().addCard(deck.dealCard());
			System.out.println("Dealer takes a card and...");
			System.out.println("Dealer --> " + dealer.getHand().getHandValue());
		}
	}

	private void playerMenu() {
		while (player.getHand().getHandValue() <= 21 && isBust() == false && isBlackjack() == false) {
			System.out.println("\nWhat would you like to do?\n\t(please select a number) \n\n1: |HIT| \n\n2: |STAY| ");
			int userInput = sc.nextInt();

			if (userInput == 1) {
				player.getHand().addCard(deck.dealCard());
				System.out.println("Player --> " + player.getHand().getHandValue());
				System.out.println("Player takes a card and...");
				System.out.println("Player --> " + player.getHand().toString() +player.getHand().getHandValue());
				System.out.println("Dealer has " + dealer.getHand().getHandValue());
			}

			else if (userInput == 2){
				System.out.println("Player --> " + player.getHand().toString() + player.getHand().getHandValue());
				System.out.println("Dealer --> " + dealer.getHand().getHandValue());
				break;
			}
			else {
				System.out.println("That is not an option. \nPlease select \"HIT(1)\" or \"STAY(2)\"");
				continue;
			}
		}
	}

	private void newHand() {

		deck.createDeck();

		player.getHand().addCard(deck.dealCard());
		player.getHand().addCard(deck.dealCard());

		dealer.getHand().addCard(deck.dealCard());
		dealer.getHand().addCard(deck.dealCard());

		System.out.println("Player --> " + player.getHand().toString() + player.getHand().getHandValue());
		System.out.println("Dealer --> " + dealer.getHand().toString() + dealer.getHand().getHandValue());
	}

	public boolean isBlackjack() {
		if (player.getHand().getHandValue() == 21) {
			System.out.println("Player has Blackjack!! (21)");
			System.out.println("Player *WINS*!!");
			return true;
			
		}
		if (dealer.getHand().getHandValue() == 21) {
			System.out.println("Dealer has Blackjack... (21)");
			System.out.println("Dealer *WINS*!");
			return true;
			
		} else {
			return false;
		}
	}

	public boolean isBust() {
		if (player.getHand().getHandValue() > 21) {
			System.out.println("Player busts.... (>21)");
			System.out.println("Dealer *WINS*! ");
			return true;
		}
		if (dealer.getHand().getHandValue() > 21) {
			System.out.println("Dealer busts... (>21)");
			return true;
		} else {
			return false;
		}
	}
}
