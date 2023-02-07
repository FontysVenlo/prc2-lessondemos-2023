package gradelist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author bonajo
 */
public class GradeList {
    private final String name;
    private final ArrayList<AssessmentResult> results = new ArrayList<>();

    public GradeList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public List<AssessmentResult> getResults(){
        return Collections.unmodifiableList(results);
    }

    public void addResult(AssessmentResult result){
        results.add(result);
    }
    
    public List<String> getPassedModules(){
        return results.stream()
                .filter(AssessmentResult::isSufficient)
                .map(AssessmentResult::getModule)
                .toList();
    }
}
