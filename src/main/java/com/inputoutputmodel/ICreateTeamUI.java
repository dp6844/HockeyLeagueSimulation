package com.inputoutputmodel;

import java.util.ArrayList;
import java.util.Scanner;

import com.datamodeltest.leaguedatamodel.IConference;
import com.datamodeltest.leaguedatamodel.IDivision;
import com.datamodeltest.leaguedatamodel.IPlayer;
import com.datamodeltest.leaguedatamodel.IGeneralManager;
import com.datamodeltest.leaguedatamodel.IHeadCoach;

public interface ICreateTeamUI {
    void displayConferences(ArrayList<IConference> conferences);

    void displayDivisions(ArrayList<IDivision> divisions);

    void displayHeadCoaches(ArrayList<IHeadCoach> headCoaches);

    void displayGeneralManagers(ArrayList<IGeneralManager> generalManagers);

    void displayFreeAgents(ArrayList<IPlayer> freeAgents, int skaterCount, int goalieCount);

    void displayPlayers(ArrayList<IPlayer> players);

    void displayError(String errorMessage);

    void displayMessage(String message);

    void displaySuccess(String successMessage);

    int getUserChoiceFromList(Scanner scanner);
}