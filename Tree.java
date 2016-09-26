package week10;

import java.util.*;

/**
 * Skeleton of the recursive implementation of a general tree.
 * 
 * @author George Bonnici-Carter
 * @param <T> The type of values stored in the tree.
 */
public class Tree<T> {

    /** The root of the tree. */
    private T rootValue;

    /** The list of child classes of the tree. */
    private List<Tree<T>> children;

    /** Declares and initialises the rootValue and the children list.
     *
     * @param rootValue for the root of the tree and child list.
     * @param children for the list of child nodes.
     */
    public Tree(T rootValue, List<Tree<T>> children) {
        this.rootValue = rootValue;
        this.children = children;
    }

    /** Declares and initialises the rootValue.
     *
     * @param rootValue to put it at top of children list.
     */
    public Tree(T rootValue) {
        this(rootValue, new ArrayList<Tree<T>>());
    }

    /** States size of tree.
     *
     * @return int for number of children in tree.
     */
    public int size() {
        int count = 1;
        if(rootValue != null){
            for(Tree<T> child: children){
                count+=child.size();
            
            }
        }else{
            return 0;
        }
        return count;
    }

    /** States max number of children at one node of tree.
     *
     * @return int for max number of children at one node in tree.
     */
    public int maxDegree() {
        if(rootValue == null){
            return 0;
        }
        int max = children.size();
        for(Tree<T> child: children){
            if(child.maxDegree() > max){
                max = child.maxDegree();
            }
        }
        return max;
    }

    /** Adds a child to a parent node in the tree.
     *
     * @param child which is a child node of the tree.
     */
    public void add(Tree<T> child) {
        if(rootValue != null){
            children.add(child);
        }
    }

    /** finds a point in the tree.
     *
     * @return Tree<T> which for a point in the tree.
     * @param  value for a value in the tree.
     */
    public Tree<T> find(T value) {
        if (rootValue.equals(value)) {
            return this;
        }
        for (Tree<T> child : children) {
            Tree<T> match = child.find(value);
            if (match != null) {
                return match;
            }
        }
        return null;
    }

    /** Orders the tree in post Order.
     *
     * @return List<T> which gives the strings in the tree in post order.
     */
    public List<T> postOrder() {
        ArrayList<T> post = new ArrayList<>();
        for(Tree<T> child : children){
            post.addAll(child.postOrder());
        }
        post.add(rootValue);
        return post;
    }

    /** Gives the string of a child node.
     *
     * @return String for the value of a child list.
     */
    public String toString() {
        if (children.isEmpty()) {
            return rootValue.toString();
        }
        return rootValue.toString() + ' ' + children.toString();
    }

    /** indents the tree so that it may be presented as required.
     *
     * @return String that indents the string.
     */
    public String toIndentedString() {
        StringBuilder space = new StringBuilder(rootValue.toString());
        for(Tree<T> child : children){
            space.append("\n");
            space.append(child.toIndentedString("  "));
        }
        space.append("\n");
        return space.toString();
    }

    /** indents the tree so that it may be presented as required.
     *
     * @return String that indents the string.
     * @param s a string that is input from the list.
     */
    public String toIndentedString(String s){
        StringBuilder space = new StringBuilder(s + rootValue.toString());
        for(Tree<T> child : children){
            space.append("\n");
            space.append(child.toIndentedString(s + "  "));
        }
        return space.toString();
    }

    /** A helper method for testing (used by main).  Searches tree for
     *  the given target and adds white space separated children to
     *  the tree matching target if there is one.
     *
     * @param target the root value to seach for.
     * @param children a white space separated list of children to add
     * to the tree whose value matches target.
     */
    private static void addChildren(String target, String children) {
        Tree<String> parent = tree.find(target);
        if (parent != null) {
            for (String child : children.split(" ")) {
                parent.add(new Tree<>(child));
            }
        }
    }

    /** A tree instance used for testing. */
    private static Tree<String> tree;

    /**
     * Entry point of the program (used for testing).
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        System.out.println("Creating tree\n-------------");
        tree = new Tree<>("food");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nAdding children\n----------------");
        addChildren("food", "meat fruit vegetable");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nAdding deeper children\n----------------------");
        addChildren("meat", "chicken beef fish");
        addChildren("fish", "salmon cod tuna shark");
        addChildren("vegetable", "cabbage");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nPostorder\n---------");
        System.out.println(tree.postOrder());
        System.out.println("\nIndented string\n---------------");
        System.out.print(tree.toIndentedString());
    }

}
