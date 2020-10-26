package trading;

import g4dhl.IFreeAgent;
import g4dhl.IPlayer;
import g4dhl.Player;

public class FreeAgentToPlayer {

    private IPlayer player;
    private IFreeAgent freeAgent;

    public FreeAgentToPlayer(IFreeAgent freeAgent){
        this.freeAgent = freeAgent;
        player = new Player();
        setPlayerName();
        setPlayerAge();
        setPlayerSkating();
        setPlayerShooting();
        setPlayerChecking();
        setPlayerSaving();
        setPlayerPosition();
        setPlayerCaptain();
        setPlayerIsInjured();
        setPlayerWasInjured();
    }

    public IPlayer getPlayer(){
        return player;
    }

    private void setPlayerName(){
        player.setPlayerName(freeAgent.getFreeAgentName());
    }

    private void setPlayerAge(){
        player.setPlayerAge(freeAgent.getFreeAgentAge());
    }

    private void setPlayerSkating(){
        player.setPlayerSkating(freeAgent.getFreeAgentSkating());
    }

    private void setPlayerShooting(){
        player.setPlayerShooting(freeAgent.getFreeAgentShooting());
    }

    private void setPlayerChecking(){
        player.setPlayerChecking((freeAgent.getFreeAgentChecking()));
    }

    private void setPlayerSaving(){
        player.setPlayerSaving(freeAgent.getFreeAgentSaving());
    }

    private void setPlayerPosition(){
        player.setPlayerPosition(freeAgent.getFreeAgentPosition());
    }

    private void setPlayerCaptain(){
        player.setPlayerCaptain(false);
    }

    private void setPlayerIsInjured(){
        player.setPlayerIsInjured(false);
    }

    private void setPlayerWasInjured(){
        player.setPlayerWasInjured(false);
    }
}
