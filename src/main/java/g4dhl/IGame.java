package g4dhl;

import java.util.ArrayList;

public interface IGame {
    ArrayList<ILeague> getLeagues();
    void setLeagues(ArrayList<ILeague> leagues);
}
