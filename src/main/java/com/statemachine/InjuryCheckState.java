package com.statemachine;

import com.datamodel.gameplayconfig.IInjuryConfig;
import com.datamodel.leaguedatamodel.IGame;
import com.datamodel.leaguedatamodel.IPlayer;
import com.datamodel.leaguedatamodel.ITeam;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;

public class InjuryCheckState implements IState {

	IStateMachine stateMachine;

	public InjuryCheckState(IStateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

	@Override
	public void entry() {
		IGame game = stateMachine.getGame();
		Date currentDate = game.getLeagues().get(0).getCurrentDate();
		IInjuryConfig injuryChance = game.getLeagues().get(0).getGamePlayConfig().getInjury();
		float randomInjuryChance = injuryChance.getRandomInjuryChance();
		HashSet<ITeam> teams = stateMachine.getGameDayTeams();
		for (ITeam team : teams) {
			List<IPlayer> players = team.getPlayers();
			for (IPlayer player : players) {
				Date recoveryDate = injuryChance.getRecoveryDate(currentDate);
				player.checkPlayerInjury(randomInjuryChance, recoveryDate, currentDate, team);
			}
			team.setActiveRoster();
		}
	}

	@Override
	public void exit() {
	}

	@Override
	public IState doTask() {
		return null;
	}
}