package Module;

import Exceptions.InvalidExceptions;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private int nextPlayerMoveIndex;
    private Player winner;
    private List<Move> moves;
    private GameState gameState;

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public GameState getGameState() {
        return gameState;
    }
    public Game(int dimension, List<Player> players) {
        this.board = board;
        this.players = players;
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
        this.winner = winner;
        this.moves = moves;
        this.gameState = gameState;
    }



    public void makemove(Game game){
        Player currentPlayer = players.get(nextPlayerMoveIndex);
        // get the move from the player
        Move move = currentPlayer.makeMove(board);

        // game class will validate the move before making it
        if(!validateMove(move)){
          throw  new InvalidExceptions("Invalid Move made by " + currentPlayer.getName());
        }
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cellTOChange = board.getBoard().get(row).get(col);
        cellTOChange.setPlayer(currentPlayer);
        cellTOChange.setCellState(CellState.FILLED);



    }
    public GameState checkGameState(Game game) {
        //TODO
        return game.getGameState();
    }
    public void setWinner(Player winner){
        this.winner = winner;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex){
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }


    public void printBoard() {
        this.board.printBoard();

    }
    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if (row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()) {
            return false;
        }
        return board.getBoard().get(row).get( col).getCellState().equals(CellState.EMPTY);
    }

}
