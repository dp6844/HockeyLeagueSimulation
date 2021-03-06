package com.datamodel.gameplayconfig;

public interface IAgingConfig {

	int getAverageRetirementAge();

	boolean setAverageRetirementAge(int averageRetirementAge);

	int getMaximumAge();

	boolean setMaximumAge(int maximumAge);

	int getAgingId();

	void setStatDecayChance(float statDecayChance);

	float getStatDecayChance();

	void setAgingId(int agingId);

	boolean isPlayerRetires(int playerAgeYear);

	boolean isStatDecayOnBirthDay();
}