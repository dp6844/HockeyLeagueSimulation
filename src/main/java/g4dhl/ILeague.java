package g4dhl;

import java.sql.Date;
import java.util.ArrayList;

public interface ILeague {

	int getLeagueId();

	String getLeagueName();

	Date getCurrentDate();

	boolean setCurrentDate(Date currentDate);

	boolean setLeagueId(int leagueId);

	boolean setLeagueName(String leagueName);

	ArrayList<IConference> getConferences();

	boolean addConference(IConference conference);

	void setTeamStandings(ArrayList<ITeamStanding> teamStanding);
	ArrayList<ITeamStanding> getTeamStandings();

	ArrayList<IFreeAgent> getFreeAgents();

	boolean addFreeAgent(IFreeAgent freeAgent);

	IFreeAgent removeFreeAgent(IFreeAgent freeAgent);

	ArrayList<IGeneralManager> getManagers();

	boolean setManager(IGeneralManager manager);

	ArrayList<IHeadCoach> getCoaches();

	boolean setCoach(IHeadCoach coach);

	ArrayList<IGameSchedule> getGameSchedules();

	void setGameSchedules(ArrayList<IGameSchedule> gameSchedules);

	IGameplayConfig getGamePlayConfig();

	boolean setGamePlayConfig(IGameplayConfig gameplayConfig);
}
