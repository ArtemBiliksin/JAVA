/*
package Solution2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Vector2DTestJUnit5 {


    @Test
    void prIsVector2D() {
        Vector2D a = new Vector2D(4,2);
        Vector2D b = new Vector2D(1, 0);
        assertEquals(new Vector2D(4, 0), a.prIsVector2D(b));
    }


    @Test
    void pcollin() {
        Vector2D a = new Vector2D(4,2);
        Vector2D b = new Vector2D(1, 0);
        assertEquals(false, a.pcollin(b));
    }

    @Test
    void decomposition() throws VcollinearException {
        Vector2D a = new Vector2D(1,0);
        Vector2D b = new Vector2D(4,2);
        Vector2D p = new Vector2D(4,2);
        Vector2D v = p.decomposition(a, b);
        assertEquals(new Vector2D(0,1), v);
    }


    @Test
    void symmetricalPoint() {
        Vector2D p = new Vector2D(0,0);
        Vector2D n = new Vector2D(0,1);
        Vector2D s = new Vector2D(4,2);
        Vector2D search = s.symmetricalPoint(p, n);
        assertEquals(new Vector2D(4, -2), search);
    }

    @Test
    void SearchX() throws VcollinearException, PointsLieOnOneSideOfAStraightLineException {
        Vector2D P = new Vector2D(0,0);
        Vector2D n = new Vector2D(0,1);
        Vector2D A = new Vector2D(1,1);
        Vector2D B = new Vector2D(3,-2);
        Vector2D searchX = Vector2D.SearchX(P, n, A, B);
        assertEquals(new Vector2D(-1,0), searchX);
    }
}

 */

