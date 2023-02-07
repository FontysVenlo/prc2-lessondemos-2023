package gradelist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author bonajo
 */
@DisplayName("AssessmentResult tests")
public class AssessmentResultTest {
    
    @Test
    @DisplayName("Constructor should create instance")
    public void testConstructor() {
        var ar = new AssessmentResult("PRC1", 100);
        assertThat(ar).isNotNull();
    }

    @Test
    @DisplayName("getModule should return module")
    public void testModule() {
        var expected = "PRC1";
        var ar = new AssessmentResult(expected, 100);
        var result = ar.getModule();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("getResult should return result")
    public void testGrade() {
        var expected = 100;
        var ar = new AssessmentResult("PRC1", expected);
        var result = ar.getResult();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("toString should return module <tab> result")
    public void testString() {
        var ar = new AssessmentResult("PRC1", 100);
        var result = ar.toString();
        assertThat(result).contains("PRC1", "100");
    }

    @Test
    @DisplayName("toString should return module <tab> result")
    public void testSufficient() {
        var ar = new AssessmentResult("PRC1", 55);
        var result = ar.isSufficient();
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("toString should return module <tab> result")
    public void testInsufficient() {
        var ar = new AssessmentResult("PRC1", 54);
        var result = ar.isSufficient();
        assertThat(result).isFalse();
    }
}
