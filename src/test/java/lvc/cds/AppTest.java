package lvc.cds;

import org.junit.jupiter.api.Test;

import jdk.internal.jline.internal.TestAccessible;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.RestAssured;
import io.restassured.RestAssured.get;

/**
 * Unit test for simple App.
 */
class AppTest {

    static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8000;
    }

    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        // assertEquals(1, 1);
        get("/?file=foo.txt")
        .then()
        .body("", equals((String)"This is an example text."));
    }
}
