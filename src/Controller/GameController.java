package Controller;
import Module.Game;
import Module.Player;
import Module.Move;
import java.util.List;
import Module.GameState;

public class GameController {

    public Game startGame(int dimension, List<Player> players) {
        //TODo
        // we have to validate if 2 players having same symbol or not ?
        // if they have same symbol then we have to throw an exception
        return new Game(dimension, players);
    }


}