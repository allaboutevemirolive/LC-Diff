import java.util.List;
import java.util.Arrays;

public class A332 {
    public static void main(String[] args) {
        F332 solution = new F332();
        
        // List<List<String>> tickets1 = Arrays.asList(
        //     Arrays.asList("MUC", "LHR"),
        //     Arrays.asList("JFK", "MUC"),
        //     Arrays.asList("SFO", "SJC"),
        //     Arrays.asList("LHR", "SFO")
        // );
        // List<String> itinerary1 = solution.findItinerary(tickets1);
        // System.out.println(itinerary1); // expected output: [JFK, MUC, LHR, SFO, SJC]

        // System.out.println();
        
        List<List<String>> tickets2 = Arrays.asList(
            Arrays.asList("JFK", "SFO"),
            Arrays.asList("JFK", "ATL"),
            Arrays.asList("SFO", "ATL"),
            Arrays.asList("ATL", "JFK"),
            Arrays.asList("ATL", "SFO")
        );
        List<String> itinerary2 = solution.findItinerary(tickets2);
        System.out.println(itinerary2); 
    }
}
