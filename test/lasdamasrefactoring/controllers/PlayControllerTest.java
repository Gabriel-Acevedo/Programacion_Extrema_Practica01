package lasdamasrefactoring.controllers;

import lasdamasrefactoring.models.Color;
import lasdamasrefactoring.models.Coordinate;
import lasdamasrefactoring.models.Piece;
import lasdamasrefactoring.models.Session;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;



public class PlayControllerTest {

    @Test
    public void WhenMovementThenNotError() {
        PlayController playController = new PlayController(new Session());
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        assertNull(playController.move(origin, target));
        assertNull(playController.getPiece(origin));
        Piece pieceTarget = playController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }
}