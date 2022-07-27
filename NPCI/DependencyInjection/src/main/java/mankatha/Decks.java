package mankatha;

import java.util.*;

public class Decks {

	List<Cards> cardsOfMankatha;

	public Decks() {
		setCards();
	}

	public List<Cards> getCards() {
		return cardsOfMankatha;
	}

	public void setCards() {
		List<Cards> addCardOfMankatha = new ArrayList<Cards>();
		for (int p = 1; p < 14; p++) {
			for (int q = 1; q < 5; q++) {
				addCardOfMankatha.add(new Cards(p, q));
			}
		}
		this.cardsOfMankatha = addCardOfMankatha;
	}

	public List<Cards> shuffle() {
		List<Cards> shuffledCardOfMankatha = new ArrayList<Cards>(getCards());
		Collections.shuffle(shuffledCardOfMankatha);
		return shuffledCardOfMankatha;
	}

	public Cards deal(List<Cards> cards) {
		return cards.remove(0);
	}

}
