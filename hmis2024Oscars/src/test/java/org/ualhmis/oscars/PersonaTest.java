package org.ualhmis.oscars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonaTest {

	@Test
	void testEqualsObject() {
		Persona p1 = new Persona ("Pepe", "h", "01/01/2000");
		Persona p2 = new Persona ("Pepe", "h", "01/01/2000");
		Persona p3 = p1;
		Persona p4 = new Persona ("Pedro", "m", "01/01/2000");
		Persona p5 = new Persona ("Pepe", "m", "01/01/2000");
		Persona nula0 = new Persona(null, null, null);
		Persona nula1 = new Persona("Pedro", null, null);
		Persona nula2 = new Persona(null, "h", null);
		Persona nula3 = new Persona(null, null, "10/12/1985");
		Director d1 = new Director ("Dire", "m", "01/01/2000");
		Pelicula peli1 = new Pelicula("Maven mola !!!", d1);

		// comparación entre iguales personas
        assertEquals(p1, p2);
        assertEquals(p1, p3);

		// comparación entre distintas personas
		assertNotEquals(p1, p4);
		assertNotEquals(p1, p5);

		// comparación entre distinta clases
		assertNotEquals(p1, peli1);

		// comparación con parámetros nulos
		assertNotEquals(p1, nula1);
		assertNotEquals(p1, nula2);
		assertNotEquals(p1, nula3);
		assertNotEquals(nula0, nula1);
		assertNotEquals(nula0, nula2);
		assertNotEquals(nula0, nula3);
		assertNotEquals(p1, null);
	}

	@Test
	void testGetters() {
		Persona p1 = new Persona ("Pepe", "h", "01/01/2000");
		
		assertEquals("Pepe", p1.getNombre());
		assertEquals("h", p1.getSexo());
		assertEquals("01/01/2000", p1.getFechaNacimiento());
	}

	@Test
	void testHashCode() {
		Persona p1 = new Persona ("Pedro", "m", "02/02/1999");
		Persona p2 = new Persona ("Pedro", "m", "02/02/1999");

		assertEquals(p1.hashCode(), p2.hashCode());
	}
}
