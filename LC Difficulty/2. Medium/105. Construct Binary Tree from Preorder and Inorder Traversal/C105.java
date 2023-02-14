class C105 {
    private int pre;
    private int in;
    public T105 buildTree(int[] preorder, int[] inorder) {
        return bulidTree(preorder, inorder, Integer.MAX_VALUE);
    }
    
    private T105 bulidTree(int[] preorder, int[] inorder, int stop) {
        if(pre >= preorder.length || inorder[in] == stop) {
            in++;
            return null;
        }
        var val = preorder[pre++];
        return new T105(val, bulidTree(preorder, inorder, val), bulidTree(preorder, inorder, stop));
    }
}