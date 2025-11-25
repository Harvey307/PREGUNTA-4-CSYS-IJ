import org.example.TextProcessor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TextProcessorTest {


    @BeforeAll
    public static void setUpClass() {
    }

    @Test
    public void testTextoValido() {
        // "hola" -> "HOLA" -> "ALOH"
        assertEquals("ALOH", TextProcessor.reverseAndCapitalize("hola"));
    }

    @Test
    public void testTextoNulo() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            TextProcessor.reverseAndCapitalize(null);
        });
        assertEquals("El texto no puede ser nulo", ex.getMessage());
    }

    @Test
    public void testTextoMuyLargo() {
        // Simulamos un texto de 1001 caracteres
        String textoLargo = "a".repeat(1001);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            TextProcessor.reverseAndCapitalize(textoLargo);
        });
        assertEquals("El texto excede el límite de 1000 caracteres", ex.getMessage());
    }

    @Test
    public void testTextoConEspaciosAlosLados() {
        // " hola " -> trim "hola" -> "ALOH"
        assertEquals("ALOH", TextProcessor.reverseAndCapitalize(" hola "));
    }

    @Test
    public void testTextoSoloEspacios() {
        // Debe lanzar error
        assertThrows(IllegalArgumentException.class, () -> {
            TextProcessor.reverseAndCapitalize("   ");
        });
    }

    @Test
    public void testTextoConNumeros() {
        // "ab1" -> "AB1" -> "1BA"
        assertEquals("1BA", TextProcessor.reverseAndCapitalize("ab1"));
    }

}

