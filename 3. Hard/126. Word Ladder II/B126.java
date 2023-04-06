import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class B126 {

    // This is the list of all possible word ladders from the starting word to the ending word
    List<List<String>> answer = new ArrayList<>();
    
    // These maps store the mapping of words to their corresponding ID numbers, and vice versa
    Map<String, Integer> wordToId = new HashMap<>();
    Map<Integer, String> idToWord = new HashMap<>();

    // This map stores the path between words as a graph
    Map<Integer, List<Integer>> paths = new HashMap<>();

    // This deque stores the current word ladder    
    Deque<String> currentPath = new LinkedList<>();

    // These arrays and variables are used for the graph traversal algorithm
    int[] neighborEdges, edges, head;
    boolean[] visited;
    int length, index, startWordId, endWordId;
    
    // This method is used to add an edge between two nodes in the graph
    void addEdge(int u, int v) {
        edges[++length] = v;
        neighborEdges[length] = head[u];
        head[u] = length;
    }
    
    // This method finds all shortest word ladders from the start word to the end word, given a list of possible intermediate words
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        neighborEdges = new int[20 * n];
        edges = new int[20 * n];
        head = new int[20 * n];
        visited = new boolean[10 * n];
        
        // Add the start word to the word list if it is not already present
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }
        // If the end word is not present in the word list, there can be no ladders between the start and end word
        if (!wordList.contains(endWord)) {
            return answer;
        }
        
        // Add all the words in the word list to the graph
        for (int i = 0; i < wordList.size(); i++) {
            addWord(wordList.get(i));
        }
        
        // Use BFS to find the shortest paths between the start word and all other words in the graph
        Queue<Integer> queue = new LinkedList<>();
        startWordId = wordToId.get(beginWord);
        endWordId = wordToId.get(endWord);
        queue.add(startWordId); 
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (u == endWordId) {
                break; 
            }
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            for (int j = head[u]; j != 0; j = neighborEdges[j]) {
                int v = edges[j];
                if (visited[v]) {
                    continue;
                }
                if (!paths.containsKey(v)) {
                    paths.put(v, new ArrayList<>());
                }
                paths.get(v).add(u);
                queue.add(v);
            }
        }
        
        // Use DFS to find all shortest word ladders from the start word to the end word
        currentPath.add(endWord);
        dfs(endWordId, 0);
        return answer;
    }
    
    void dfs(int u, int level) {
        // If we have reached the start word, add the current path to the answer list and return
        if (u == startWordId) {
            answer.add(new ArrayList<>(currentPath));
            return;
        }
    
        // Get the adjacent vertices of the current word
        List<Integer> p = paths.get(u);
        if (p == null) {
            return;
        }
    
        // Iterate through the adjacent vertices
        for (int i = 0; i < p.size(); i++) {
            int v = p.get(i);
    
            // If we are at an odd level, add the current word to the front of the path
            if (level % 2 == 1) {
                currentPath.addFirst(idToWord.get(v));
            }
    
            // Recurse on the adjacent vertex
            dfs(v, level + 1);
    
            // If we are at an odd level, remove the current word from the front of the path
            if (level % 2 == 1) {
                currentPath.pollFirst();
            }
        }
    }
    
    void addWord(String word) {
        int u = index;
        char[] arr = word.toCharArray();
    
        // Add the word and its index to the word-to-id and id-to-word maps
        wordToId.put(word, index);
        idToWord.put(index++, word);
    
        // Replace each character in the word with a '*' to get all possible intermediate words
        for (int i = 0; i < arr.length; i++) {
            char t = arr[i];
            arr[i] = '*';
            String vStr = new String(arr);
    
            // If the intermediate word has not been seen before, add it to the word-to-id and id-to-word maps
            if (!wordToId.containsKey(vStr)) {
                wordToId.put(vStr, index);
                idToWord.put(index++, vStr);
            }
    
            // Get the index of the intermediate word and add edges between it and the current word
            int v = wordToId.get(vStr);
            addEdge(u, v);
            addEdge(v, u);
    
            // Restore the character that was replaced with '*'
            arr[i] = t;
        }
    }
    
}
