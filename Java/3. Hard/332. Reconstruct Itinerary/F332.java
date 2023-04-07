import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class F332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> res = new LinkedList<>();

        Map<String, PriorityQueue<String>> graph = buildGraph(tickets);
        dfs(res, graph, "JFK");
        return res;
    }

    private Map<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> flight : tickets) {
            String dep = flight.get(0);
            String arr = flight.get(1);

            graph.computeIfAbsent(dep, k -> new PriorityQueue<>()).add(arr);
        }
        System.out.println();
        System.out.println(graph);
        System.out.println();
        return graph;
    }

    private void dfs(LinkedList<String> res, Map<String, PriorityQueue<String>> graph, String source) {
        PriorityQueue<String> arrivals = graph.get(source);
        
        System.out.println();
        System.out.println("source: " + source);
        System.out.println("arrivals: " + arrivals);

        while (arrivals != null && !arrivals.isEmpty()) {
            
            String next = arrivals.poll();
            System.out.println("arrivals(poll): " + arrivals);
            System.out.println();

            dfs(res, graph, next);
        }
        System.out.println();
        System.out.println("************************************");
        System.out.println("source: " + source);

        res.addFirst(source);

        LinkedList<String> copyRes = new LinkedList<>(res);
        while (!copyRes.isEmpty()) {
            System.out.print(copyRes.poll() + " ");
        }
        System.out.println();
    }
}