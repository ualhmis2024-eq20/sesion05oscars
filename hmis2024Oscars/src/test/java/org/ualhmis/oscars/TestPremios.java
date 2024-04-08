package org.ualhmis.oscars;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestPremios {
    @Test
    void testNominacionSinPremio() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        GestorPremios gp = new GestorPremios();
        assertFalse(gp.getPremios().containsKey("Oscar Animación"));
        Pelicula p1 = new Pelicula("Maven mola !!!", new Director("Dire", "m", "01/01/2000"));

        gp.nominarPelicula("Oscar Animación", p1);
        String salida = "El premio 'Oscar Animación' no existe." + System.lineSeparator();
        assertEquals(salida, bos.toString());

        gp.asignarGanadora("Oscar Animación", p1);
        salida += "El premio 'Oscar Animación' no existe." + System.lineSeparator();
        assertEquals(salida, bos.toString());
    }

    @Test
    void testGetters() {
        GestorPremios gp = new GestorPremios();
        gp.crearPremio("Oscar Animación");
        assertEquals("Oscar Animación", gp.getPremios().get("Oscar Animación").getNombre());

        Pelicula p1 = new Pelicula("Maven mola !!!", new Director("Dire", "m", "01/01/2000"));
        gp.nominarPelicula("Oscar Animación", p1);
        assertTrue(gp.getPremios().get("Oscar Animación").getNominadas().contains(p1));
    }
}
