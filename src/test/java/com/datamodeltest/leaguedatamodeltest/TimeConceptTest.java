package com.datamodeltest.leaguedatamodeltest;

import java.sql.Date;

import org.junit.Test;

import com.datamodel.leaguedatamodel.Game;
import com.datamodel.leaguedatamodel.ILeague;
import com.datamodel.leaguedatamodel.League;
import com.datamodel.leaguedatamodel.TimeConcept;

public class TimeConceptTest {

	@Test
	public void getNextDateTest() {
		Game game = mockGame();
		TimeConcept timeConcept = new TimeConcept();
	}

	private Game mockGame() {
		Game game = new Game();
		ILeague league = new League();
		league.setLeagueName("mock");
		String str = "2020-09-30";
		league.setCurrentDate(Date.valueOf(str));
		game.addLeague(league);
		return game;
	}
}