//ID_207199282_322530080
/**
 * tests:
 */
public class Ex3_3{
    public static void main(String[] args) {
        final boolean RED= true, BLACK=false;
        RBTree tree= new RBTree();//RBTree from the matala
        tree.root=new Node(15,BLACK);
        tree.root.left=new Node(10,RED);
        tree.root.right= new Node(20,RED);
        System.out.println("is RB tree? "+ RBTree.isValidRedBlackTree(tree));

        RBTree tree1= new RBTree(); //not RBTree
        tree1.root=new Node(15,BLACK);
        tree1.root.left=new Node(10,RED);
        tree1.root.right= new Node(20,RED);
        tree1.root.right.right= new Node(27,RED);
        System.out.println("is RB tree? "+ RBTree.isValidRedBlackTree(tree1));

        RBTree tree2= new RBTree(); // RBTree
        tree2.root=new Node(15,BLACK);
        tree2.root.left=new Node(10,RED);
        tree2.root.left.left=new Node(8,BLACK);
        tree2.root.left.right=new Node(11,BLACK);
        tree2.root.right= new Node(20,RED);
        tree2.root.right.right= new Node(27,BLACK);
        tree2.root.right.left= new Node(19,BLACK);
        System.out.println("is RB tree? "+ RBTree.isValidRedBlackTree(tree2));

        RBTree tree3= new RBTree(); //isn't RBTree
        tree3.root=new Node(15,BLACK);
        tree3.root.left=new Node(10,RED);
        tree3.root.left.left=new Node(8,BLACK);
        tree3.root.left.right=new Node(11,BLACK);
        tree3.root.right= new Node(20,RED);
        tree3.root.right.right= new Node(27,RED);
        tree3.root.right.left= new Node(19,BLACK);
        System.out.println("is RB tree? "+ RBTree.isValidRedBlackTree(tree3));

        RBTree tree4= new RBTree(); //isn't RBTree   --- red root
        tree4.root=new Node(15,RED);
        System.out.println("is RB tree? "+ RBTree.isValidRedBlackTree(tree4));

        RBTree tree6= new RBTree(); // RBTree       --- null tree
        System.out.println("is RB tree? "+ RBTree.isValidRedBlackTree(tree6));

        RBTree tree7= new RBTree();   //RBTree
        tree7.root = new Node(15, BLACK);
        tree7.root.left = new Node(10, BLACK);
        tree7.root.left.left = new Node(10, BLACK);
        tree7.root.left.right = new Node(10, BLACK);
        tree7.root.right = new Node(20, BLACK);
        tree7.root.right.left = new Node(20,BLACK);
        tree7.root.right.right = new Node(20, RED);
        tree7.root.right.right.left = new Node(20, BLACK);
        tree7.root.right.right.right = new Node(20, BLACK);
        tree7.root.right.right.right.right = new Node(20, RED);
        tree7.root.right.right.right.left = new Node(20, RED);
        System.out.println("is RB tree? "+ RBTree.isValidRedBlackTree(tree7));
    }
}
/**
 * this class represents a Red Black Tree:
 */
class RBTree {
    public static final boolean RED= true, BLACK=false;
    Node root;
    //constructor:
    public RBTree(){ //constructor
        this.root=null;
    }

    /**
     * this function checks if a given tree is a red black tree
     * the function calls a helper function in order to check if so.
     * @param tree to check
     * @return if the tree is valid RBT
     */
    public static boolean isValidRedBlackTree(RBTree tree) {
        if (tree.root!=null&& tree.root.color==RED){//if the root is red
            return false;
        }
        return isValidRedBlackTree(tree.root);
    }

    /**
     *this function is a recursion function that checks if a given Node is a Red Black tree.
     * the function checks first if the tree is null-if so- it is red black tree.
     * else- if the root color is red: make sure that the left and the right nodes color is not red.
     * if the root color is black-calling to helper function to check if the tree is balanced.
     * a node is balanced if: the distance between the root to all his leaf is the same number of black nodes.
     * if any node isn`t balanced-than the tree is not a red black tree
     * @param tree t
     * @return true\false
     */
    public static boolean isValidRedBlackTree(Node tree) {
        if (tree==null){//if the node is null
            return true;
        }
        else {//if the node is not null
            if(tree.color){//if the leaf is red
                if(tree.right!=null && tree.right.color==RED){//if right son is red-this is not RBtree
                    return false;
                }
                if(tree.left!=null && tree.left.color==RED) {//if left son is red-this is not RBtree
                    return false;
                }
            }
            if (!isBalanced(tree)) { //call to helper function - check if balance
                return false;
            }
        }// recursive call:
        return (isValidRedBlackTree(tree.right)) && (isValidRedBlackTree(tree.left));
    }
    /**
     * this function checks the balance of a given Node.
     * a node is balanced if: the distance between the root to all his leaf is the same number of black nodes.
     * @param tree t
     * @return true\false
     */
    private static boolean isBalanced(Node tree) {
        if (tree == null) {//a null tree is balanced
            return true;
        }
        if (tree.left == null && tree.right == null) {//if the tree is only root
            return true;
        }//calling to helper function in order to check the num of black nodes
        if (numOfBlack(tree.left) == numOfBlack(tree.right)) {
            return true;
        }
        return false;
    }
    /**
     this function is a recursive function that return the number of black nodes in right subtree
     and left subtree- and return true if and only if the tree is balance.
     */
    private static int numOfBlack(Node tree){
        if (tree==null){// a null tree is balanced
            return 0;
        }
        int blackLeft=numOfBlack(tree.left);//recursive call to left tree
        int blackRight= numOfBlack(tree.right);//recursive call to right tree
        if (blackRight!=blackLeft){//check if equal
            return -1;
        }
        if (tree.color==BLACK){//if the root is black
            return 1+blackLeft;
        }
        return blackLeft;
    }
}

/**
 * this class represent a Node of Red Black tree
 */
class Node {
    private Integer key;
    public final boolean RED =true;
    private final boolean BLACK=false;
    boolean color;
    Node right;
    Node left;
    public  Node(Integer data, boolean color){ //constructor
        this.key= data;
        this.color=color;
        this.left=null;
        this.right=null;
    }
    public String toString(){
        String c= "red";
        if (this.color==BLACK){
            c="black";
        }
        return "key: " +key + ", "+c;
    }
}