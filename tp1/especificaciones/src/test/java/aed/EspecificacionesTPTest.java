package aed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EspecificacionesTPTest {
    EspecificacionesTP funciones = new EspecificacionesTP();

    @Test
    void trayectoriaExtrañaEscalera() {
        assertTrue(funciones.trayectoriaExtrañaEscalera(new double[]{1,3,5,4,2}));
        assertTrue(funciones.trayectoriaExtrañaEscalera(new double[]{0}));
        assertTrue(funciones.trayectoriaExtrañaEscalera(new double[]{2,1}));
        assertTrue(funciones.trayectoriaExtrañaEscalera(new double[]{1,4}));
        assertFalse(funciones.trayectoriaExtrañaEscalera(new double[]{1,2,5,3,4}));
        assertFalse(funciones.trayectoriaExtrañaEscalera(new double[]{1,1,1}));
        assertFalse(funciones.trayectoriaExtrañaEscalera(new double[]{1,3,3}));
        assertFalse(funciones.trayectoriaExtrañaEscalera(new double[]{7,5,3,2,1,7}));
    }
}
