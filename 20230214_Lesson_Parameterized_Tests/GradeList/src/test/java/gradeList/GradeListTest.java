package gradeList;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

/**
 *
 * @author hvd
 */
public class GradeListTest {

    @Test
    public void testGetName(){
        var gradeList = new GradeList("Richard");
        assertThat(gradeList.getName()).as("Should be Richard").isEqualTo("Richard");
        //fail("Test Ready");
    }
    
    @Test
    public void testGetPassedModules() {
        var gradeList = new GradeList("Richard");
        
        var prc1 = new AssessmentResult("PRC1", 100);
        var prc2 = new AssessmentResult("PRC2", 100);
        var bit = new AssessmentResult("BIT", 30);
        
        gradeList.addResult(prc1);
        gradeList.addResult(prc2);
        gradeList.addResult(bit);
        
        assertThat(gradeList.passedModules()).as("should contain PRC1 and PRC2").containsExactlyInAnyOrder(prc1, prc2);
    }
}
