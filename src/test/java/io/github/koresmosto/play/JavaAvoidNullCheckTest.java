package io.github.koresmosto.play;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JavaAvoidNullCheckTest {

    @Test
    void testJetbrainsAnnotations() {

        var check = new JavaAvoidNullCheck();

        assertEquals(">>> abc", check.method("abc"));
        assertEquals(">>> null", check.method(null));
    }

    @Test
    void testLombokAnnotations() {

        var check = new JavaAvoidNullCheck();

        assertEquals(">>> abc", check.methodLombok("abc"));

        assertThrows(
                NullPointerException.class,
                () -> check.methodLombok(null)
        );
    }
}
