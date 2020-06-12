package DataSrc.DataStructures.Trees;

public interface IBinarySearchTree<T extends Comparable>  {

    void insert(T value);
    boolean exist(int id);
    T obtain(int id);
    boolean isLeaf();
    boolean empty();
    void preOrder();
    void inOrder();
    void postOrder();
    void delete();

}
