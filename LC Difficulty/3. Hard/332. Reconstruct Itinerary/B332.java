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
    private Map<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
                
        for (List<String> flight: tickets) {
            String dep = flight.get(0);
            String arr = flight.get(1);
            
            graph.computeIfAbsent(dep, k -> new PriorityQueue<>()).add(arr);
            // if (!graph.containsKey(dep)) {
            //     graph.put(dep, new PriorityQueue<>());
            // }
            // graph.get(dep).add(arr);
        }
        return graph;
    }
    private void dfs(LinkedList<String> res, Map<String, PriorityQueue<String>> graph, String source) {
        PriorityQueue<String> arrivals = graph.get(source);
        while (arrivals != null && !arrivals.isEmpty()) {
            String next = arrivals.poll();
            dfs(res, graph, next);
        }
        res.addFirst(source);
    }
}