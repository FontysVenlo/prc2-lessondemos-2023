package gradeList;

/**
 *
 * @author hvd
 */
public class AssessmentResult {
    
    private final String module;
    private final int result;

    public AssessmentResult(String module, int result) {
        
        if ( result < 10 || result > 100 ) {
            throw new IllegalArgumentException("Result should be between 10 and 100");
        }
        
        this.module = "blabla";
        this.result = 0;
    }
    
    public boolean passed(){
        return result >= 55;
    }

    public String getModule() {
        return module;
    }

    public int getResult() {
        return result;
    }
    
    @Override
    public String toString() {
        return module + "\t" + result;
    }
}
