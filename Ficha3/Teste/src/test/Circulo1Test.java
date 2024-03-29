package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Circulo1;


class Circulo1Test {

    Circulo1 c1;

    @Test
    void alteraCentro() {
        c1 = new Circulo1();
        assertEquals(0,c1.getCentro().getX(),"erro ao alterar x");
    }

}