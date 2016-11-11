package arbolesUO251017;

/**
 * @author Néstor
 * @version 2016-17
*/
public class BSTNode <T extends Comparable<T>>{
	private T info;
	private BSTNode<T> left;
	private BSTNode<T> right;


	/**
	 * @param info Un objeto comparable
	 */
	public BSTNode (T info) 
	{
		setInfo(info);
		left= null;
		right= null;
	}
	
	/**
	 * @param info La información que se quiere meter en el nodo
	 */
	protected void setInfo(T info) 
	{
		if (info != null)
			this.info= info;
	}


	/**
	 * @return La información que almacena el nodo
	 */
	public T getInfo() 
	{
		return info;
	}
	
	/**
	 * @param x El nodo que se quiere enlazar en el subárbol izquierdo
	 */
	public void setLeft(BSTNode<T> x)
	{
		left= x;
	}


	/**
	 * @param x El nodo que se quiere enlazar en el subárbol derecho
	 */
	public void setRight(BSTNode<T> x)
	{
		right= x;
	}
	
	/**
	 * @return El subárbol izquierdo
	 */
	public BSTNode<T> getLeft ()
	{
		return left;
	}


	/**
	 * @return El subárbol derecho
	 */
	public BSTNode<T> getRight ()
	{
		return right;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return info.toString();
	}	
}
