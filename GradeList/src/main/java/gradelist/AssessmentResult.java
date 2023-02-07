package gradelist;

/**
 *
 * @author bonajo
 */
public class AssessmentResult {
    private final String module;
    private final int result;

    public AssessmentResult(String module, int result) {
        this.module = module;
        this.result = result;
    }

    public String getModule() {
        return module;
    }

    public int getResult() {
        return result;
    }
    
    
    public boolean isSufficient(){
        return result >= 55;
    }

    @Override
    public String toString() {
        return module + "\t" + result;
    }
}
