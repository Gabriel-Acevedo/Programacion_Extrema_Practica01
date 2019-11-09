package lasdamasrefactoring.controllers;

import lasdamasrefactoring.models.Color;
import lasdamasrefactoring.models.Coordinate;
import lasdamasrefactoring.models.Session;


public abstract class Controller {

    protected Session session;

    protected Controller(Session session) {
        this.session = session;
    }

    public Color getColor(Coordinate coordinate) {
        return this.session.getColor(coordinate);
    }

    public int getDimension() {
        return this.session.getDimension();
    }

    abstract public void accept(ControllersVisitor controllersVisitor);
    
}
