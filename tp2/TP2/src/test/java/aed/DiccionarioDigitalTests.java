package aed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DiccionarioDigitalTests {

    @Test
    public void testEsta() {
        DiccionarioDigital<String> diccionario = new DiccionarioDigital<>();
        diccionario.definir("hola", "mundo");
        assertTrue(diccionario.esta("hola"));
        assertFalse(diccionario.esta("adios"));
    }

    @Test
    public void testDefinir() {
        DiccionarioDigital<String> diccionario = new DiccionarioDigital<>();
        diccionario.definir("hola", "mundo");
        assertEquals(1, diccionario.tamanio());
        diccionario.definir("hola", "mundo");
        assertEquals(1, diccionario.tamanio());
        diccionario.definir("adios", "mundo");
        assertEquals(2, diccionario.tamanio());
    }

    @Test
    public void testTamanio() {
        DiccionarioDigital<String> diccionario = new DiccionarioDigital<>();
        assertEquals(0, diccionario.tamanio());
        diccionario.definir("hola", "mundo");
        assertEquals(1, diccionario.tamanio());
    }

    @Test
    public void testObtenerNoDefinido() {
        DiccionarioDigital<String> diccionario = new DiccionarioDigital<>();
        assertNull(diccionario.obtener("hola"));
    }

    @Test
    public void testObtener() {
        DiccionarioDigital<String> diccionario = new DiccionarioDigital<>();
        diccionario.definir("hola", "mundo");
        assertEquals("mundo", diccionario.obtener("hola"));
    }

    @Test
    public void testBorrar() {
        DiccionarioDigital<String> diccionario = new DiccionarioDigital<>();

        diccionario.borrar("test");
        assertEquals(0, diccionario.tamanio());

        diccionario.definir("test", "value");
        diccionario.borrar("noExiste");
        assertEquals(1, diccionario.tamanio());

        diccionario.borrar("test");
        assertEquals(0, diccionario.tamanio());

        diccionario.definir("test1", "value1");
        diccionario.definir("test2", "value2");
        diccionario.definir("test3", "value3");
        diccionario.borrar("test2");
        assertEquals(2, diccionario.tamanio());

        diccionario.borrar("test1");
        diccionario.borrar("test3");
        assertEquals(0, diccionario.tamanio());

        diccionario.definir("test1", "value1");
        diccionario.definir("test1a", "value1");
        diccionario.borrar("test1a");
        assertTrue(diccionario.esta("test1"));
    }

    @Test
    public void testDefinirEstaBorrar() {
        DiccionarioDigital<String> diccionario = new DiccionarioDigital<>();

        // Definir las palabras
        diccionario.definir("hola", "value1");
        diccionario.definir("holan", "value2");
        diccionario.definir("holanda", "value3");

        // Comprobar que las palabras están definidas
        assertTrue(diccionario.esta("hola"));
        assertTrue(diccionario.esta("holan"));
        assertTrue(diccionario.esta("holanda"));

        // Borrar las palabras
        diccionario.borrar("hola");
        diccionario.borrar("holan");
        diccionario.borrar("holanda");

        // Comprobar que las palabras ya no están definidas
        assertFalse(diccionario.esta("hola"));
        assertFalse(diccionario.esta("holan"));
        assertFalse(diccionario.esta("holanda"));
    }
    
    @Test
    public void testBorrarNonExistingKey() {
        DiccionarioDigital<String> diccionario = new DiccionarioDigital<>();
        diccionario.definir("key1", "value1");
        diccionario.borrar("key2");
        assertEquals(1, diccionario.tamanio());
        assertNotNull(diccionario.obtener("key1"));
    }

    @Test
    public void testBorrarExistingKey() {
        DiccionarioDigital<String> diccionario = new DiccionarioDigital<>();
        diccionario.definir("key1", "value1");
        diccionario.borrar("key1");
        assertEquals(0, diccionario.tamanio());
        assertNull(diccionario.obtener("key1"));
    }

    @Test
    public void testBorrarFromEmptyDiccionario() {
        DiccionarioDigital<String> diccionario = new DiccionarioDigital<>();
        diccionario.borrar("key1");
        assertEquals(0, diccionario.tamanio());
    }

    @Test
    public void testBorrarKeyThatHasChildren() {
        DiccionarioDigital<String> diccionario = new DiccionarioDigital<>();
        diccionario.definir("key1", "value1");
        diccionario.definir("key12", "value12");
        diccionario.borrar("key1");
        assertEquals(1, diccionario.tamanio());
        assertNull(diccionario.obtener("key1"));
        assertNotNull(diccionario.obtener("key12"));
    }
    
}
