class B460 {

    /*
     * Time: O(n)
     * Space: O(n)
     */

    /**
     * Your LFUCache object will be instantiated and called as such:
     * LFUCache obj = new LFUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    private int capacity; // maximum number of items that can be stored in the cache
    private int size; // current number of items stored in the cache
    private int leastCounter; // least frequency count of any item in the cache
    private Node[] cache; // array to store the items in the cache, indexed by key
    private Node[] counterMap; // array to store the linked list of items for each frequency count
    private Node[] tails; // array to store the tail of each linked list, indexed by frequency count

    // Initializes the object with the capacity of the data structure.
    public void LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new Node[100_001]; // create an array to store the items in the cache
        this.counterMap = new Node[100_001]; // create an array to store the linked lists of items for each frequency count
        this.tails = new Node[100_001]; // create an array to store the tail of each linked list
    }

    // Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
    public int get(int key) {
        int result = -1; // initialize result to -1, meaning the key is not in the cache

        if (cache[key] != null) { // if the key is in the cache
            incCounter(cache[key]); // increase the frequency count of the item
            result = cache[key].value; // return the value of the item
        }

        return result; // return the result
    }

    // Update the value of the key if present, or inserts the key if not already present.
    public void put(int key, int value) {

        if (cache[key] != null) { // if the key is already in the cache
            incCounter(cache[key]); // increase the frequency count of the item
            cache[key].value = value; // update the value of the item
            cache[key].key = key; // update the key of the item
        } else if (capacity != 0) { // if the key is not in the cache and the cache is not full

            if (size == capacity) { // if the cache is full
                evict(); // remove the least frequently used item from the cache
            }

            Node node = new Node(); // create a new item
            node.counter = 1; // initialize the frequency count to 1
            node.value = value; // set the value of the item
            node.key = key; // set the key of the item

            if (counterMap[1] != null) { // if there are already items with frequency count 1
                tails[1].next = node; // add the new item to the end of the linked list
                node.previous = tails[1]; // set the previous node of the new item to the current tail
                tails[1] = node; // update the tail of the linked list to the new item
                node.next = null; // set the next node of the new item to null
            } else {
                // if this is the first item with frequency count 1
                counterMap[1] = tails[1] = node;
            }
            // update the least frequent counter
            leastCounter = 1;
            // add the item to the cache
            cache[key] = node;
            // increment the size of the cache
            size++;
        }
    }

    private void incCounter(Node node) {
        // Store the old count of the node
        int oldCount = node.counter;

        // Increment the counter of the node
        int newCount = ++node.counter;

        // Remove the node from the linked list of the old counter
        if (node.previous != null) {
            node.previous.next = node.next;
        }

        if (node.next != null) {
            node.next.previous = node.previous;
        }

        // Move the pointer to the next element if it was the first element
        if (node.previous == null) {
            counterMap[oldCount] = node.next;
        }
        if (node.next == null) {
            tails[oldCount] = node.previous;
        }

        // Check if there is only one element of such count
        if (node.next == null && node.previous == null) {
            if (oldCount == leastCounter) {
                leastCounter = newCount;
            } else {
                leastCounter = Math.min(leastCounter, newCount);
            }
        } else {
            leastCounter = Math.min(leastCounter, oldCount);
        }

        // Add the node to the new position in the linked list
        if (counterMap[newCount] != null) {
            tails[newCount].next = node;
            node.previous = tails[newCount];
            tails[newCount] = node;
            node.next = null;
        } else {
            counterMap[newCount] = tails[newCount] = node;
            node.next = null;
            node.previous = null;
        }
    }

    private void evict() {
        // Retrieve the node with the least counter value
        Node node = counterMap[leastCounter];
        // Remove the node from the counterMap
        counterMap[leastCounter] = node.next;

        // If the node has a next node, update its previous pointer
        if (node.next != null) {
            node.next.previous = null;
        } else {
            // If the node does not have a next node, update the tail pointer for the counter
            tails[leastCounter] = node.previous;
        }
        // Remove the node from the cache
        cache[node.key] = null;
        // Decrement the size of the cache
        size--;
    }

    private static class Node {
        // Pointers to the next and previous node in the linked list
        Node next;
        Node previous;
        // The key and value for the node
        int key;
        int value;
        // The counter for the node
        int counter;
    }

}
