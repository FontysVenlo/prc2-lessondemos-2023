package gradeList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.fail;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author hvd
 */
public class AssessmentResultTest {

    @Test
    public void testCreateResultSuccesfully() {

        var result = new AssessmentResult("PRC2", 100);

        assertThat(result.getModule()).as("Should be PRC2").isEqualTo("PRC2");
        assertThat(result.getResult()).as("Should be 100").isEqualTo(100);

    }

    //@Disabled("think TDD")
    @Test
    public void testCreateResultSuccesfullyNew() {

        var result = new AssessmentResult("PRC2", 100);

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(result.getModule()).as("Should be PRC2").isEqualTo("PRC2");
            softly.assertThat(result.getResult()).as("Should be 100").isEqualTo(100);
        });

        //fail("Test in development");
    }

    @Test
    public void testCreateInvalidResult() {

        ThrowingCallable code = () -> {
            new AssessmentResult("PRC2", 1000);
        };

        assertThatThrownBy(code).as("ShouldThrowIllegalArgument").isInstanceOf(IllegalArgumentException.class);

    }
    
    // DRY principle?

    @Test
    public void testPassed_with_10() {
        var result = new AssessmentResult("PRC2", 100);
        assertThat(result.passed()).as("Should be passed").isTrue();
    }
    
    @Test
    public void testPassed_with_55() {
        var result = new AssessmentResult("PRC1", 55);
        assertThat(result.passed()).as("Should be passed").isTrue();
    }
    
    @Test
    public void testFails_with_54() {
        var result = new AssessmentResult("PRC1", 54);
        assertThat(result.passed()).as("Should not be passed").isFalse();
    }

    @Test
    public void testToString() {
        var result = new AssessmentResult("PRC2", 100);
        assertThat(result.toString()).as("Should contain PRC2 and 100").contains("PRC2", "100");
    }

}
