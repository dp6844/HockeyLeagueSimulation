package com.dal.dhl.states;

import com.dal.dhl.stateMachine.DHLStateMachine;

public class AdvanceTime implements IStateTransistion{
	DHLStateMachine stateMachine;



	public AdvanceTime(DHLStateMachine stateMachine) {

		this.stateMachine = stateMachine;
	}

	@Override
	public void entry() {
		// TODO Auto-generated method stub
		//increment Day by 1
		//is today end of regular season 
		//if yes 
		stateMachine.setCurrState(stateMachine.getGeneratePlayoffSchedule());
		stateMachine.getCurrState().entry();
		//if no 
		stateMachine.setCurrState(stateMachine.getTraining());
		stateMachine.getCurrState().entry();
		//post training
		doTask();


	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		stateMachine.getCurrState().entry();
	}



	@Override
	public void doTask() {

		//check if any unplayed games scheduled 
		//if yes
			stateMachine.setCurrState(stateMachine.getSimulateGame());
			stateMachine.getCurrState().entry();
		//if no
		//check if trade deadline passed
			//if yes
				stateMachine.setCurrState(stateMachine.getAging());
				stateMachine.getCurrState().entry();
				// is stanley cup winner determined
					// if yes
						stateMachine.setCurrState(stateMachine.getAdvanceNextSeason());
						stateMachine.getCurrState().entry();
						stateMachine.setCurrState(stateMachine.getPersist());
						stateMachine.getCurrState().entry();
				
					//if no
						stateMachine.setCurrState(stateMachine.getPersist());
						stateMachine.getCurrState().entry();
						stateMachine.setCurrState(stateMachine.getAdvanceTime());
						stateMachine.getCurrState().entry();
			//if no
				stateMachine.setCurrState(stateMachine.getExecuteTrades());
				stateMachine.getCurrState().entry();
		
	}

}