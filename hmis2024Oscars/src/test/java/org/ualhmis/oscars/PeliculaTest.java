package org.ualhmis.oscars;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PeliculaTest {
    Pelicula p1 = new Pelicula("Maven mola !!!", new Director("Dire", "m", "01/01/2000"));

    @Test
    void testProtagonistas() {
        ActorOActriz a1 = new Actor("Pepe", "h", "01/01/2000");
        ActorOActriz a2 = new Actriz("Pepa", "m", "01/01/2000");
        p1.setActorProtagonista((Actor) a1);
        p1.setActrizProtagonista((Actriz) a2);
        assertEquals(a1, p1.getActorProtagonista());
        assertEquals(a2, p1.getActrizProtagonista());
    }

    @Test
    void testAdders() {
        ActorOActriz secundario1 = new Actor("Actor Humano", "h", "02/05/1990");
        ActorOActriz secundario2 = new Actriz("Actriz Humana", "m", "02/05/1990");
        p1.addActorSecundario((Actor) secundario1);
        p1.addActrizSecundaria((Actriz) secundario2);
        assertEquals(1, p1.getActoresSecundarios().size());
        assertEquals(1, p1.getActricesSecundarias().size());
        assertTrue(p1.getActoresSecundarios().contains(secundario1));
        assertTrue(p1.getActricesSecundarias().contains(secundario2));
    }

    @Test
    void testGetters() {
        Pelicula p1 = new Pelicula("Maven mola !!!", new Director("Dire", "m", "01/01/2000"));
        assertEquals("Maven mola !!!", p1.getTitulo());
        assertEquals("Dire", p1.getDirector().getNombre());
    }
}
