package lasdamasrefactoring.models;

public class Game {

    private Board board;

    private Turn turn;

    private Checkers checkers;

    public Game() {
        this.turn = new Turn();
        this.board = new Board();
        this.checkers = new Checkers(board,turn);
        for (int i = 0; i < this.board.getDimension(); i++) {
            for (int j = 0; j < this.board.getDimension(); j++) {
                Coordinate coordinate = new Coordinate(i, j);
                Piece piece = this.getInitialPiece(coordinate);
                if (piece != null) {
                    this.board.put(coordinate, piece);
                }
            }
        }
    }

    private Piece getInitialPiece(Coordinate coordinate) {
        if (coordinate.isBlack()) {
            final int row = coordinate.getRow();
            Color color = null;
            if (row <= 2) {
                color = Color.BLACK;
            } else if (row >= 5) {
                color = Color.WHITE;
            }
            if (color != null) {
                return new Piece(color);
            }
        }
        return null;
    }

    public Error move(Coordinate origin, Coordinate target) {
        Error errorGen, ErrorPiece;
        errorGen = checkers.GeneralMovementCheck(origin, target);
        if (errorGen!=null){
           return errorGen;
        }
        ErrorPiece = checkers.PieceMovementCheck(origin, target);
        if (ErrorPiece!=null){
           return ErrorPiece;
        }            
        this.board.move(origin, target);
        this.turn.change();
        return null;
    }

    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    @Override
    public String toString() {
        return this.board + "\n" + this.turn;
    }

    public Color getColor() {
        return this.turn.getColor();
    }

    public Piece getPiece(Coordinate coordinate) {
        return this.board.getPiece(coordinate);
    }

    public boolean isBlocked() {
        return this.board.getPieces(this.turn.getColor()).isEmpty();
    }

    public int getDimension() {
        return this.board.getDimension();
    }

}