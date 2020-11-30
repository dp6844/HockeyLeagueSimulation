package com.persistencemodel;

import org.json.simple.JSONObject;

import com.datamodel.gameplayconfig.IGamePlayConfig;
import com.datamodel.gameplayconfig.ITrainingConfig;
import com.datamodel.gameplayconfig.TrainingConfig;

public class TrainingDB implements ITrainingDB {

    @Override
    public void loadTraining(JSONObject trainingObject, IGamePlayConfig gameplayConfig) {
        ITrainingConfig training = new TrainingConfig();
        training.setTrainingId((int) (long) trainingObject.get("trainingId"));
        training.setDaysUntilStatIncreaseCheck((int) (long) trainingObject.get("daysUntilStatIncreaseCheck"));
        training.setNoOfDaysTrained((int) (long) trainingObject.get("noOfDaysTrained"));
        gameplayConfig.setTraining(training);
    }
}
