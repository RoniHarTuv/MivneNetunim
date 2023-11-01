//ID_207199282_322530080
public class Ex3_4 {
    //test:
    public static void main(String[] args) {
        Treap treap = new Treap();
        treap.insert(50, 15);
        treap.insert(70, 10);
        treap.insert(30, 5);
        treap.insert(20, 2);
        treap.insert(40, 4);
        treap.preorderTraversePlus();
        System.out.println();
        treap.insert(10, 1);
        treap.insert(45, 20);
        treap.preorderTraversePlus();
        System.out.println();
        System.out.println(treap.search(50));
        System.out.println(treap.search(66));
        System.out.println(treap.search(0));
        System.out.println(treap.search(10));
    }
}
class Treap {
    // variables:
    public TreapNode root;
    //constructor:
    public Treap() {
        this.root = null;
    }
    /**
     * this function insert a new node to a Treap Tree:
     * @param data to insert
     * @param priority to insert
     * @return new root
     */
    public TreapNode insert(int data, int priority) {
        TreapNode neaNode = new TreapNode(data, priority);//create a new node
        this.root = insert(this.root, neaNode);//the new root is the root after the insert
        return neaNode;
    }
    /**
     * this function is a recursive helper function to "insert" function.
     * the function add the node to the tree as a binary search tree.
     * after tha adding-do rotation to the tree in order to get a correct TreapTree
     * @param root- a treap node
     * @param newNode to add
     * @return the new root
     * complexity of insert:
     * the insert function is the same as regular BST insert function:
     * average case- (o(log(n))
     * worst case- o(n)
     */
    public TreapNode insert(TreapNode root, TreapNode newNode) {
        if (root == null) {//base case
            return newNode;
        }
        if (newNode.key >= root.key) {//if the new node key is greater than the root key
            root.right = insert(root.right, newNode);//insert the node to the right node-recursive call
            if (root.priority < newNode.priority) {//checks the priority- it is maxHeap or not
                root = rotateLeft(root);//calling to helper function in order to rotate the tree
            }
        } else if (newNode.key < root.key) {//if the root key is greater than the new node key
            root.left = insert(root.left, newNode);//insert the node to the left node-recursive call
            if (root.priority < newNode.priority) {//checks the priority- it is maxHeap or not
                root = rotateRight(root);//calling to helper function in order to rotate the tree
            }
        }
        return root;
    }
    /**
     * this function rotating the tree to the right according to the algorithm of rotating.
     * @param root treap
     * @return the new root
     * complexity of rotation- o(1)
     * finite number of actions, no loops, no recursion.
     */
    private TreapNode rotateRight(TreapNode root) {
        TreapNode newRoot = root.left;//this is the new root
        TreapNode temp = root.left.right;//this node is going to move to the left tree
        newRoot.right = root;//swap between the new root to the previous root
        root.left = temp;
        return newRoot;
    }
    /**
     * this function rotating the tree to the left according to the algorithm of rotating.
     * @param root treap
     * @return the new root
     * complexity of rotation- o(1)
     * finite number of actions, no loops, no recursion.
     */
    public TreapNode rotateLeft(TreapNode root) {
        TreapNode newRoot = root.right;//this is the new root
        TreapNode temp = root.right.left;//this node is going to move to the right tree
        newRoot.left = root;//swap between the new root to the previous root
        root.right = temp;
        return newRoot;
    }
    /**
     * this is a helper function to "search" function
     * the function use "binary search" in order to find the given key.
     * if the key is equal to the root key-return true
     * if the key is less than the root key-search in left subtree
     * if the key is greater than the root key-search in right subtree
     * @param key to search
     * @param tree treap
     * @return boolean
     * this function is a BST search-average: o(log(n))
     * worst case- o(n)
     */
    private boolean searchHelper(int key, TreapNode tree) {
        if(tree==null){//base case
            return false;
        }
        if (tree.key == key) {//if found:
            return true;
        }// search in left subtree:
        if (key < tree.key) {
            return searchHelper(key, tree.left);
        }
        // search in right subtree:
        return searchHelper(key, tree.right);
    }
    /**
     * this function return true if a given key is found in the tree
     * return false if the key not found.
     * @param key to search
     * @return boolean
     * complexity-according to "search helper" complexity- o(log(n))
     */
    public boolean search(int key) {
        return searchHelper(key,root);
    }
    /**
     * preorder traverse plus(root-> left -> right)
     * this function will also print the path to each node while printing the nodes.
     * complexity-this function visits each node in the tree- o(n)
     */
    public void preorderTraversePlus(){
        String s= "";
        preorderHelper(s,this.root);
    }

    /**
     * this is a helper function to preorderTraversePlus function
     * recursive function
     * @param node treap
     * complexity-this function visits each node in the tree- o(n)
     */
    private void preorderHelper(String s,TreapNode node){
        if (node!=null) {
            System.out.println(node.toString()+", path: "+ s);
            preorderHelper(s+"L", node.left);
            preorderHelper(s+"R",node.right);
        }
    }
}

/**
 * this class represent a TreapNode:
 */
class TreapNode {
    // variables:
    public int key;
    public int priority;
    public TreapNode left;
    public TreapNode right;
    //constructor:
    public TreapNode(int key, int priority){
        this.key=key;
        this.priority=priority;
    }
    // to String function
    //complexity- o(1)
    public String toString(){
        return "key: "+ this.key + " , priority: "+ this.priority;
    }
}
