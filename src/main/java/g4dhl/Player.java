package g4dhl;

public class Player implements IPlayer {

	private int playerId;
	private String playerName;
	private String playerPosition;
	private boolean playerCaptain;
	private boolean playerIsInjured;
	private boolean playerWasInjured;

	private int playerAge;
	private int playerSkating;
	private int playerShooting;
	private int playerChecking;
	private int playerSaving;

	public Player() {
		playerName = null;
		playerPosition = null;
		playerCaptain = false;
		playerIsInjured = false;
		playerWasInjured = false;
	}

	private boolean checkIfPlayerNameIsNullOrEmpty(String playerName) {
		return playerName == null || playerName.trim().isEmpty();
	}

	private boolean checkIfPlayerPositionIsNullOrEmpty(String playerPosition) {
		return playerPosition == null || playerPosition.trim().isEmpty();
	}

	@Override
	public int getPlayerId() {
		return playerId;
	}

	@Override
	public String getPlayerName() {
		return playerName;
	}

	@Override
	public int getPlayerAge() {
		return playerAge;
	}

	@Override
	public int getPlayerSkating() {
		return playerSkating;
	}

	@Override
	public int getPlayerShooting() {
		return playerShooting;
	}

	@Override
	public int getPlayerChecking() {
		return playerChecking;
	}

	@Override
	public int getPlayerSaving() {
		return playerSaving;
	}

	@Override
	public double getPlayerStrength() {
		String position = getPlayerPosition();
		double playerStrength = 0.0;
		if (position.equalsIgnoreCase("forward")) {
			playerStrength = getPlayerSkating() + getPlayerShooting() + (getPlayerChecking() / 2);
		} else if (position.equalsIgnoreCase("defense")) {
			playerStrength = getPlayerSkating() + getPlayerChecking() + (getPlayerShooting() / 2);
		} else {
			playerStrength = getPlayerSkating() + getPlayerSaving();
		}
		if (playerIsInjured) {
			playerStrength = playerStrength / 2;
		}

		return playerStrength;
	}

	@Override
	public boolean setPlayerName(String playerName) {
		if (checkIfPlayerNameIsNullOrEmpty(playerName))
			return false;
		this.playerName = playerName;
		return true;
	}

	@Override
	public boolean setPlayerAge(int playerAge) {
		this.playerAge = playerAge;
		return true;
	}

	@Override
	public boolean setPlayerSkating(int playerSkating) {
		this.playerSkating = playerSkating;
		return true;
	}

	@Override
	public boolean setPlayerShooting(int playerShooting) {
		this.playerShooting = playerShooting;
		return true;
	}

	@Override
	public boolean setPlayerChecking(int playerChecking) {
		this.playerChecking = playerChecking;
		return true;
	}

	@Override
	public boolean setPlayerSaving(int playerSaving) {
		this.playerSaving = playerSaving;
		return true;
	}

	@Override
	public boolean setPlayerId(int playerId) {
		this.playerId = playerId;
		return true;
	}

	@Override
	public String getPlayerPosition() {
		return playerPosition;
	}

	@Override
	public boolean setPlayerPosition(String playerPosition) {
		if (checkIfPlayerPositionIsNullOrEmpty(playerPosition))
			return false;
		this.playerPosition = playerPosition;
		return true;
	}

	@Override
	public boolean isPlayerCaptain() {
		return playerCaptain;
	}

	@Override
	public boolean setPlayerCaptain(boolean playerCaptain) {
		this.playerCaptain = playerCaptain;
		return true;
	}

	@Override
	public boolean setPlayerIsInjured(boolean playerIsInjured) {
		this.playerIsInjured = playerIsInjured;
		return true;
	}

	@Override
	public boolean setPlayerWasInjured(boolean playerWasInjured) {
		this.playerWasInjured = playerWasInjured;
		return true;
	}

	@Override
	public boolean isPlayerInjured() {
		return playerIsInjured;
	}

	@Override
	public boolean checkPlayerInjury(float randomInjuryChance) {
		if (isPlayerInjured() || wasPlayerInjured()) {
			return false;
		} else {
			if (Math.random() < randomInjuryChance) {
				setPlayerIsInjured(true);
				setPlayerWasInjured(true);
				return true;
			}
		}
		return false;

	}

	@Override
	public boolean wasPlayerInjured() {
		return playerWasInjured;
	}
}
