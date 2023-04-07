import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class B332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> res = new LinkedList<>();

        Map<String, PriorityQueue<String>> graph = buildGraph(tickets);
        dfs(res, graph, "JFK");
        return res;
    }

    // mapping tickets: source -> destinations
    // tickets = 
    // [
    //     ["JFK","SFO"],
    //     ["JFK","ATL"],
    //     ["SFO","ATL"],
    //     ["ATL","JFK"],
    //     ["ATL","SFO"]
    // ]
    // Mappping:
    // ATL=[JFK, SFO], 
    // SFO=[ATL], 
    // JFK=[ATL, SFO]
    private Map<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> flight : tickets) {
            String dep = flight.get(0);
            String arr = flight.get(1);

            graph.computeIfAbsent(dep, k -> new PriorityQueue<>()).add(arr);
            // if (!graph.containsKey(dep)) {
            // graph.put(dep, new PriorityQueue<>());
            // }
            // graph.get(dep).add(arr);
        }
        return graph;
    }

    private void dfs(LinkedList<String> res, Map<String, PriorityQueue<String>> graph, String source) {
        // Get value for the key source
        PriorityQueue<String> arrivals = graph.get(source);
        while (arrivals != null && !arrivals.isEmpty()) {
            // update new source
            // remove the first value/element from the key source
            String next = arrivals.poll();
            // dfs with new source
            dfs(res, graph, next);
        }
        // add source to the head of the list. Starting from the end dfs to the first dfs
        res.addFirst(source);
    }
}