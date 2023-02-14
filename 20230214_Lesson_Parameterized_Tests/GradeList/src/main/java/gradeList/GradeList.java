/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author hvd
 */
public class GradeList {
    
    private final String name;
    private final List<AssessmentResult> results = new ArrayList<>();

    public GradeList(String name) {
        this.name = name;
    }
        
    public void addResult(AssessmentResult result){
        results.add( result );
    } 
    
    public List<AssessmentResult> passedModules(){
        return results.stream().filter( r -> r.passed() ).collect( toList() );
    }

    public String getName() {
        return name;
    }
}
