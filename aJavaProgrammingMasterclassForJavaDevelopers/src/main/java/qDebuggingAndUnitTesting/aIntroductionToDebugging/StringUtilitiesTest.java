package qDebuggingAndUnitTesting.aIntroductionToDebugging;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilitiesTest {

    private StringUtilities stringUtilities;

    @BeforeEach
    void setup(){
        stringUtilities = new StringUtilities();
    }

    @Test
    void addChar() {
        fail();
    }

    @Test
    void upperAndPrefix() {
        String str = stringUtilities.upperAndPrefix("mama");
        assertEquals("Prefix_MAMA", str, "Not equal");
    }

    @Test
    void addSuffix() {
        fail();
    }
}