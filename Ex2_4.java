//207199282_322530080
public class Ex2_4 {
    /**
     * this function return a string of the max path and the way to get it.
     * using two helper function:
     * @param tree t
     * @return string
     */
    public static String maxSumPath(BinaryTree tree) {
        String sum = maxSumHelper(tree.getRoot()) + "";
        String way = maxPathStringHelper(tree.getRoot());
        return "max sum = "+ sum + "\n" + "max sum path = " + way;
    }
    /**
     * This function recursively finds the maximum sum of nodes in the tree
     * if node is not None:
     * left_sum = max_sum_of_nodes(node.left)
     * right_sum = max_sum_of_nodes(node.right)
     * calculate the maximum from both and added it to the root.
     * In each iteration, add the maximum sum to the current node.
     * @param node n
     * @return int sum
     */
    public static int maxSumHelper(Node node) {
        if (node == null) { //base case
            return 0;
        }
        int sum = node.getData() + Math.max(maxSumHelper(node.getLeft()), maxSumHelper(node.getRight()));
        node.setNode(sum);
        return sum;
    }
    /**
     *this function find the directions of the max Sum in the tree
     * @param node n
     * @return string directions
     */
    public static String maxPathStringHelper(Node node) {
        String s = ""; // create a new string
        while (node != null) { //node not null
            if (node.getLeft() != null && node.getRight() != null) {// if the node has left and right children:
                if (node.getLeft().getData() > node.getRight().getData()) {//if left node data greater than right node data
                    s += "L";
                    node = node.getLeft();//continue to this node
                } else {//if right node data greater than left node data
                    s += "R";
                    node = node.getRight(); //continue to this node
                }
                //the node doesn't have right child:
            } else if (node.getLeft() != null) {
                s += "L";
                node = node.getLeft();
                //the node doesn't have right child:
            } else if (node.getRight() != null) {
                s += "R";
                node = node.getRight();
            } else {// it is a leaf
                break;
            }
        }
        return s;
    }
    /**
     * this class represent a node class based on the code that is given at the assignment.
     */
    static class Node{
        private int data;
        protected Node left, right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
        public String toString(){return data+", ";}
        public Integer getData() {return data;}
        public Node getLeft() {return left;}
        public Node getRight() {return right;}
        //this function was added to the Node class in order to set the data of a node.
        public void setNode(Integer a) {
            this.data = a;
        }
    }
    /**
     * this class represent a Binary Tree class based on the code that is given at the assignment.
     */
    static class BinaryTree {
        private final Node root;
        BinaryTree(Node root) {
            this.root = root;
        }
        public Node getRoot() {
            return root;
        }
        /**
         * tests:
         * @param args a
         */
        public static void main(String[] args) {
            //test 1:
            BinaryTree bt = new BinaryTree(new Node(6));
            Node root = bt.getRoot();
            root.left = new Node(3);
            root.left.left = new Node(2);
            root.left.right = new Node(4);
            root.right = new Node(9);
            root.right.right = new Node(11);
            root.right.left = new Node(7);
            root.right.left.left = new Node(13);
            String path = Ex2_4.maxSumPath(bt);
            System.out.println(path);
            //test 2:
            BinaryTree bt1 = new BinaryTree(new Node(7));
            Node root1 = bt1.getRoot();
            root1.left = new Node(25);
            root1.right = new Node(1);
            root1.right.right = new Node(2);
            root1.right.right.right = new Node(3);
            root1.right.right.right.right = new Node(4);
            root1.right.right.right.right.right = new Node(1);
            String path1 = Ex2_4.maxSumPath(bt1);
            System.out.println(path1);
            //test 3:
            BinaryTree bt2 = new BinaryTree(new Node(5));
            Node root2 = bt2.getRoot();
            root2.left = new Node(1);
            root2.right = new Node(1);
            root2.right.right = new Node(2);
            root2.left.right = new Node(2);
            String path2 = Ex2_4.maxSumPath(bt2);
            System.out.println(path2);
        }
    }
}
