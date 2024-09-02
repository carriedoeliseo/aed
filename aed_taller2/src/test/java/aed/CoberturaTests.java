package aed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CoberturaTests {
    Cobertura cobertura = new Cobertura();

    @Test
    void testFizzBuzz() {
        assertEquals("FizzBuzz",cobertura.fizzBuzz(15));
        assertEquals("Fizz",cobertura.fizzBuzz(9));
        assertEquals("Buzz",cobertura.fizzBuzz(25));
        assertEquals("7",cobertura.fizzBuzz(7));
        assertEquals("FizzBuzz", cobertura.fizzBuzz(0));
    }

    @Test
    void testNumeroCombinatorio() {
        assertEquals(1, cobertura.numeroCombinatorio(1, 0));
        assertEquals(1, cobertura.numeroCombinatorio(1, 1));
        assertEquals(0, cobertura.numeroCombinatorio(1, 2));
        assertEquals(0, cobertura.numeroCombinatorio(0, 1));
        assertEquals(3, cobertura.numeroCombinatorio(3, 1));
        assertEquals(3, cobertura.numeroCombinatorio(3, 2));
        assertEquals(1, cobertura.numeroCombinatorio(0, 0));
    }

    @Test
    void testRepeticionesConsecutivas() {
        assertEquals(0, cobertura.repeticionesConsecutivas(new int[0])); // Está especificada?
        assertEquals(1, cobertura.repeticionesConsecutivas(new int[]{0})); // Está mal el código?
        assertEquals(1, cobertura.repeticionesConsecutivas(new int[]{1,2,3,4,5}));
        assertEquals(2, cobertura.repeticionesConsecutivas(new int[]{1,1,2,3}));
        assertEquals(3, cobertura.repeticionesConsecutivas(new int[]{1,2,2,2,3}));
        assertEquals(4, cobertura.repeticionesConsecutivas(new int[]{1,2,3,3,3,3}));
    }
}
