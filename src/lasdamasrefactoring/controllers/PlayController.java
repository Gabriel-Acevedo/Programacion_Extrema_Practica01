package lasdamasrefactoring.controllers;

import lasdamasrefactoring.models.Color;
import lasdamasrefactoring.models.Coordinate;
import lasdamasrefactoring.models.Piece;
import lasdamasrefactoring.models.Session;
import lasdamasrefactoring.models.Error;



public class PlayController extends Controller {

    public PlayController(Session session) {
		super(session);
	}

	public Error move(Coordinate origin, Coordinate target){
		Error error = this.session.move(origin, target);
		if (this.session.isBlocked()){
			this.session.next();
		}
		return error;
    }

	public Piece getPiece(Coordinate coordinate) {
		return session.getPiece(coordinate);
	}

	public Color getColor() {
		return session.getColor();
	}
	
	public boolean isBlocked() {
		return session.isBlocked();
	}	

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}