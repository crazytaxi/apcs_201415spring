public class TreeNode<E> {
    
    private E data;
    private TreeNode<E> right;
    private TreeNode<E> left;

    public TreeNode( E d ) {
    	data = d;
    }
    public String toString() {
	return "" + data;
    }
    public void setData( E c ) {
	data = c;
    }
    public E getData() {
    	return data;
    }
    public void setRight( TreeNode<E> n ) {
	right = n;
    }
    public TreeNode<E> getRight() {
    	return right;
    }    
    public void setLeft( TreeNode<E> n ) {
	left = n;
    }
    public TreeNode<E> getLeft() {
    	return left;
    }    

}
