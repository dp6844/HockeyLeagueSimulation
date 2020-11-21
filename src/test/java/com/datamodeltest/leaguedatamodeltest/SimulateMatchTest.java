package com.datamodeltest.leaguedatamodeltest;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

import com.datamodel.leaguedatamodel.AbstractDataModelFactory;
import com.datamodel.leaguedatamodel.Game;
import com.datamodel.leaguedatamodel.GameSchedule;
import com.datamodel.leaguedatamodel.IDataModelFactory;
import com.datamodel.leaguedatamodel.IGameSchedule;
import com.datamodel.leaguedatamodel.ISimulateMatch;
import com.datamodel.leaguedatamodel.SimulateMatch;
import com.statemachine.IStateMachine;
import com.statemachine.StateMachine;

public class SimulateMatchTest {

	@Test
	public void simulateMatchTest() {
		simulateMatchTest(2, 3, 5);
	}

	public void simulateMatchTest(int conferenceSize, int divisionSize, int teamSize) {
		IStateMachine stateMachine = new StateMachine(null);
		Game game = MockGame.mockGame(conferenceSize, divisionSize, teamSize);
		IDataModelFactory dataModelFactory = AbstractDataModelFactory.getNewInstance();
		IGameSchedule schedule = dataModelFactory.getGameSchedule();
		ArrayList<IGameSchedule> matchSchedules = schedule.scheduleRegularSeason(game, stateMachine);
		String str = "2020-10-12";
		game.getLeagues().get(0).setCurrentDate(Date.valueOf(str));
		ISimulateMatch simulateMatch = dataModelFactory.getSimulateMatch();
		double teamStrength = Math.random();
		double oppositionTeamStrength = Math.random();
		float randomWinChance = (float) 0.23;
		for (IGameSchedule gameSchedule : matchSchedules) {
			Date curreDate = game.getLeagues().get(0).getCurrentDate();
			Date matchDate = gameSchedule.getMatchDate();
			if (curreDate.compareTo(matchDate) == 0) {
				simulateMatch.simulateMatchResult(gameSchedule.getTeamA(), teamStrength, gameSchedule.getTeamB(),
						oppositionTeamStrength, randomWinChance, game);
			}
		}
		schedule.schedulePlayoff(game, stateMachine);
	}
}
