package mankatha;

import java.util.*;

public class GameOfMankatha {

	Decks deck = new Decks();

	public Player addPlayer(int playerNumber) {

		Player player = new Player();

		Scanner sc = new Scanner(System.in);

		System.out.println("Player " + (playerNumber + 1) + " enter your name:");
		player.setName(sc.next());
		System.out.println("Player " + (playerNumber + 1) + " enter how much coins you have");
		player.setCoins(sc.nextInt());
		System.out.println("Player " + (playerNumber + 1) + " chose your card rank:" + "\n1 for Clubs"
				+ "\n2 for Spades" + "\n3 for Diamonds" + "\n4 for Hearts");
		int suit = sc.nextInt();
		System.out.println(
				"Player " + (playerNumber + 1) + " chose card rank from 1 to 13 where 1 is Ace and 13 is King:");
		int rank = sc.nextInt();
		player.setChosenCard(new Cards(rank, suit).toString());
		System.out.println("Player " + (playerNumber + 1) + " chose 1 for in or 2 for out:");
		if (sc.nextInt() == 1) {
			player.setChosenOrientation("in");
		} else {
			player.setChosenOrientation("out");
		}

		return player;
	}

	public void playGame() {
		Scanner in = new Scanner(System.in);
		List<Player> players = new ArrayList<Player>();
		System.out.println("Enter the number of players:");
		int numOfPlayer = in.nextInt();
		int betPool = 0;

		for (int i = 0; i < numOfPlayer; i++) {
			players.add(addPlayer(i));
			System.out.println("Player " + (i + 1) + " bet coins:");
			betPool += players.get(i).betCoins(in.nextInt());
		}

		List<Cards> shuffledCards = new ArrayList<Cards>(deck.shuffle());
		String winner = null;
		int counter = 1;

		while (winner == null) {

			Cards dealtCard = deck.deal(shuffledCards);
			if (counter % 2 == 1) {
				System.out.println("in:   " + dealtCard);
				for (int i = 0; i < numOfPlayer; i++) {
					if ((players.get(i).getChosenCard().equals(dealtCard.toString()))
							&& (players.get(i).getChosenOrientation().equals("in"))) {
						players.get(i).addWinnings(betPool);
						winner = "Congratulations " + players.get(i).getName() + " win the game and win " + betPool
								+ " coins.";
					}
				}
				counter++;
			} else {
				System.out.println("out:  " + dealtCard);
				for (int i = 0; i < numOfPlayer; i++) {
					if ((players.get(i).getChosenCard().equals(dealtCard.toString()))
							&& (players.get(i).getChosenOrientation().equals("out"))) {
						players.get(i).addWinnings(betPool);
						winner = "Congratulations " + players.get(i).getName() + " win the game and win " + betPool
								+ " coins.";
					}
				}
				counter++;
			}

			if (shuffledCards.isEmpty()) {
				winner = "Host Win the game";
			}
		}
		System.out.println(players);
		System.out.println(winner);
	}

}
