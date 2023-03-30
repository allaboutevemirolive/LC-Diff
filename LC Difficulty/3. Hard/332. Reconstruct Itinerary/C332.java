import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class C332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> res = new LinkedList<>();

        Map<String, PriorityQueue<String>> graph = buildGraph(tickets);
        System.out.println("====================================");

        dfs(res, graph, "JFK");
        return res;
    }

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
            // PriorityQueue<String> arrivals = graph.get(dep);
            // if (!arrivals.contains(arr)) {
            // arrivals.add(arr);
            // }
        }

        // Print the contents of the graph
        System.out.println("Graph:");
        for (Map.Entry<String, PriorityQueue<String>> entry : graph.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            PriorityQueue<String> pq = entry.getValue();
            PriorityQueue<String> copy = new PriorityQueue<>(pq); // create a temporary copy
            while (!copy.isEmpty()) {
                String next = copy.peek(); // get the next element
                System.out.print(next + " "); // print the next element
                pq.offer(copy.poll()); // add the next element back to the original PriorityQueue
            }
            System.out.println();
        }

        return graph;
    }

    private void dfs(LinkedList<String> res, Map<String, PriorityQueue<String>> graph, String source) {
        
        System.out.println("------------------------------------");

        PriorityQueue<String> arrivals = graph.get(source);

        System.out.println("source: " + source);
        // System.out.println("arrivals: " + arrivals);
        PriorityQueue<String> copy = new PriorityQueue<>(arrivals);
        System.out.println("arrivals: ");
        while (!copy.isEmpty()) {
            System.out.println(copy.poll());
        }

        while (arrivals != null && !arrivals.isEmpty()) {
            // PriorityQueue<String> copy = new PriorityQueue<>(arrivals);
            // while (!copy.isEmpty()) {
            // System.out.println(copy.poll());
            // }

            // System.out.print(source + ": ");
            // System.out.println("arrivals(before): ");
            // for (String arr : arrivals) {
            //     System.out.print(arr + " ");
            // }
            // System.out.println();
            String next = arrivals.poll();

            // System.out.println();
            // System.out.println("arrivals(after): ");
            // for (String arr : arrivals) {
            //     System.out.println(arr + " ");
            // }
            System.out.println("next: " + next);
            dfs(res, graph, next);
        }
        System.out.println("************************************");
        System.out.println("source: " + source);
        res.addFirst(source);

        // LinkedList<String> copy = new LinkedList<>(res);
        // while (!copy.isEmpty()) {
        // System.out.println(copy.poll());
        // }

    }

}