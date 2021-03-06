package com.datamodel.leaguedatamodel;

public class GeneralManager implements IGeneralManager {

	private int generalManagerId;
	private String generalManagerName;
	private String generalManagerPersonality;

	public GeneralManager() {
		generalManagerName = null;
	}

	private boolean checkIfGeneralManagerNameIsNullOrEmpty(String generalManagerName) {
		return generalManagerName == null || generalManagerName.trim().isEmpty();
	}

	@Override
	public int getGeneralManagerId() {
		return this.generalManagerId;
	}

	@Override
	public String getGeneralManagerName() {
		return this.generalManagerName;
	}

	@Override
	public boolean setGeneralManagerId(int generalManagerId) {
		this.generalManagerId = generalManagerId;
		return true;
	}

	@Override
	public boolean setGeneralManagerName(String generalManagerName) {
		if(checkIfGeneralManagerNameIsNullOrEmpty(generalManagerName)) {
			return false;
		}
		this.generalManagerName = generalManagerName;
		return true;
	}

	@Override
	public String getGeneralManagerPersonality() {
		return generalManagerPersonality;
	}

	@Override
	public boolean setGeneralManagerPersonality(String generalManagerPersonality) {
		this.generalManagerPersonality = generalManagerPersonality;
		return true;
	}
}