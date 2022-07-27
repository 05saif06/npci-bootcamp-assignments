package mankatha;

public class Player {
	private String name;
	private int coins;
	private String chosenCard;
	private String chosenOrientation;

	public Player() {

	}

	public Player(String name, int coins, String chosenCard, String chosenOrientation) {
		this.name = name;
		this.coins = coins;
		this.chosenCard = chosenCard;
		this.chosenOrientation = chosenOrientation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public String getChosenCard() {
		return chosenCard;
	}

	public void setChosenCard(String chosenCard) {
		this.chosenCard = chosenCard;
	}

	public String getChosenOrientation() {
		return chosenOrientation;
	}

	public void setChosenOrientation(String chosenOrientation) {
		this.chosenOrientation = chosenOrientation;
	}

	public int betCoins(int coins) {
		if (coins > this.coins) {
			System.out.println("You cannot bet sorry");
		}
		this.coins -= coins;
		return coins;
	}

	public void addWinnings(int coins) {
		this.coins += coins;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", coins=" + coins + ", chosenCard=" + chosenCard + ", chosenOrientation="
				+ chosenOrientation + "]";
	}

}
