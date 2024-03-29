import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.Circulo1;
package test;


class Circulo1Test {

    Circulo1 c1;

    @Test
    void alteraCentro() {
        c1.alteraCentro(3,4);
        assertEquals(3,c1.getPonto().getX(),"erro ao alterar x");
    }

}