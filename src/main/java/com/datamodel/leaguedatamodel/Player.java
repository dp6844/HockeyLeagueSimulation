package com.datamodel.leaguedatamodel;

import java.sql.Date;

public class Player implements IPlayer {

    private int playerId;
    private String playerName;
    private String playerPosition;
    private boolean playerCaptain;
    private boolean playerIsInjured;
    private boolean playerWasInjured;

    private int playerAgeYear;
    private int playerAgeDays;
    private int playerSkating;
    private int playerShooting;
    private int playerChecking;
    private int playerSaving;
    private Date recoveryDate;

    public Player() {
        playerName = null;
        playerPosition = null;
        playerCaptain = false;
        playerIsInjured = false;
        playerWasInjured = false;
        recoveryDate = null;
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
    public int getPlayerAgeYear() {
        return playerAgeYear;
    }

    @Override
    public int getPlayerAgeDays() {
        return playerAgeDays;
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

    enum Position {
        FORWARD, DEFENSE, GOALIE
    }

    @Override
    public double getPlayerStrength() {
        String playerPosition = getPlayerPosition().toUpperCase();
        double playerStrength = 0.0;
        Position position = Position.valueOf(playerPosition);
        if (position == Position.FORWARD) {
            playerStrength = getPlayerSkating() + getPlayerShooting() + (getPlayerChecking() / 2.0);
        } else if (position == Position.DEFENSE) {
            playerStrength = getPlayerSkating() + getPlayerChecking() + (getPlayerShooting() / 2.0);
        } else if (position == Position.GOALIE) {
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
    public boolean setPlayerAgeYear(int playerAgeYear) {
        this.playerAgeYear = playerAgeYear;
        return true;
    }

    @Override
    public boolean setPlayerAgeDays(int playerAgeDays) {
        this.playerAgeDays = playerAgeDays;
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
    public Date getRecoveryDate() {
        return recoveryDate;
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
    public void checkPlayerInjury(float randomInjuryChance, Date recoveryDate, Date currentDate) {
        if (isPlayerInjured() || wasPlayerInjured()) {
            if (currentDate.compareTo(getRecoveryDate()) == 0) {
                setPlayerIsInjured(false);
            }
        } else {
            if (Math.random() < randomInjuryChance) {
                setPlayerIsInjured(true);
                setPlayerWasInjured(true);
                setRecoveryDate(recoveryDate);
            }
        }
    }

    @Override
    public boolean wasPlayerInjured() {
        return playerWasInjured;
    }

    @Override
    public boolean setRecoveryDate(Date recoveryDate) {
        this.recoveryDate = recoveryDate;
        return true;
    }

    @Override
    public void agePlayer(int days) {
        int playerAgeDays = getPlayerAgeDays();
        int playerAgeYear = getPlayerAgeYear();
        if (playerAgeDays + days < 365) {
            setPlayerAgeDays(playerAgeDays + days);
        } else if (playerAgeDays + days > 365) {
            setPlayerAgeDays(playerAgeDays + days - 365);
            setPlayerAgeYear(playerAgeYear + 1);
        }
    }

    @Override
    public int getMaxPlayerStatValue() {
        int MAX_PLAYER_STAT_VALUE = 20;
        return MAX_PLAYER_STAT_VALUE;
    }

}