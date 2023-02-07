package gradelist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author bonajo
 */
@DisplayName("GradeList tests")
public class GradeListTest {
    
    @Test
    @DisplayName("Constructor should create instance")
    public void testConstructor() {
        var gradeList = new GradeList("Martijn");
        assertThat(gradeList).isNotNull();
    }

    @Test
    @DisplayName("getName should return the name")
    public void testName() {
        var expected = "Martijn";
        var gradeList = new GradeList(expected);
        var result = gradeList.getName();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Newly created GradeList should not have any results")
    public void testNewListIsEmpty() {
        var gradeList = new GradeList("Martijn");
        var result = gradeList.getResults();
        assertThat(result.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("Adding result should show up in results")
    public void testAddResult() {
        var gradeList = new GradeList("Martijn");
        var passed = new AssessmentResult("PRC1", 100);
        var failed = new AssessmentResult("BIIT", 40);
        gradeList.addResult(passed);
        gradeList.addResult(failed);
        var result = gradeList.getResults();
        assertThat(result).containsExactlyInAnyOrder(passed, failed);
    }

    @Test
    @DisplayName("getPassedModules should only return passed modules")
    public void testPassing() {
        var gradeList = new GradeList("Martijn");
        var passed = new AssessmentResult("PRC1", 100);
        var passed2 = new AssessmentResult("PRJ1", 80);
        var failed = new AssessmentResult("BIIT", 40);
        gradeList.addResult(passed);
        gradeList.addResult(passed2);
        gradeList.addResult(failed);
        var result = gradeList.getPassedModules();
        assertThat(result).containsExactlyInAnyOrder("PRJ1", "PRC1");
    }
}
