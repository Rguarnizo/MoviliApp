package DataSrc.DataStructures.Trees;

public class BinarySearchTree<T extends Comparable> implements IBinarySearchTree<T>, Comparable {

    private T value;
    private int id;
    private BinarySearchTree rTree,lTree;



    @Override
    public boolean isLeaf () {
        return rTree == null && lTree == null;
    }

    @Override
    public boolean empty () {
        return value == null;
    }

    @Override
    public void insert (T value) {
        if(value == null){
            this.value = value;
        }else if(compareTo (value) < compareTo (this.value)){

        } else if(compareTo (value)> compareTo (this.value)){

        }
    }

    @Override
    public boolean exist (int id) {
        return false;
    }

    @Override
    public T obtain (int id) {
        return null;
    }

    @Override
    public void preOrder () {

    }

    @Override
    public void inOrder () {

    }

    @Override
    public void postOrder () {

    }

    @Override
    public void delete () {

    }

    @Override
    public int compareTo (Object o) {
        if(this.id < id){
            return -1;
        } else if(this.id > id){
            return 1;
        } else {
            return 0;
        }
    }
}
