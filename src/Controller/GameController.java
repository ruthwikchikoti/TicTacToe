package Controller;
import Exceptions.InvalidExceptions;
import Module.Game;
import Module.Player;
import Module.Move;
import java.util.List;
import Module.GameState;

public class GameController {

    public Game startGame(int dimension, List<Player> players) {
        //TODO:
        // we have to validate if 2 players having same symbol or not ?
        // if they have same symbol then we have to throw an exception
        return new Game(dimension, players);
    }
    public  void  makeMove(Game game) throws InvalidExceptions {
        game.makeMove();
    }
    public GameState checkState(Game game){
        return game.getGameState();
    }
    public Player getWinner(Game game){
        return game.getWinner();
    }

    public void printBoard(Game game){

       game.printBoard();
    }

}