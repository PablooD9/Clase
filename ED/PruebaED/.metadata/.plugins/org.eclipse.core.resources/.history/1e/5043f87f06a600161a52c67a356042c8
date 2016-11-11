package arbolesUO251017;

/**
 * Clase derivada de BSTree añadiendo funcionalidad de AVL
 * @author Néstor
 * @version 2016-17
 */
public class AVLTree <T extends Comparable<T> >extends BSTree <T>{
	
	/**
	 * Constructor 
	 */
	public AVLTree() 
	{
		super();
	}


	/* (non-Javadoc)
	 * @see BSTree#add(java.lang.Comparable)
	 * Redefine inserción para funcionalidad AVL
	 */
	public boolean add (T info)
	{
		if (info == null)
		{
			return false;
		}
		
		else
		{
			if (getRaiz() == null)
			{
				setRaiz(new AVLNode<T>(info));
				return true;
			}
			
			AVLNode<T> raiz= (AVLNode<T>) getRaiz();
			setRaiz(addRecursive(raiz, info));
//			raiz= addRecursive(raiz, info);
			return true;
		}
	}
	
	private AVLNode<T> addRecursive(AVLNode<T> avl, T x)
	{
		if (avl == null)
		{
			return new AVLNode<T>(x);
		}
		
		else
		{
			if (x.compareTo(avl.getInfo()) == 0)
			{
				avl.setInfo(x);
			}
			
			else if (x.compareTo(avl.getInfo()) > 0)
			{
				avl.setRight(addRecursive(avl.getRight(), x));
			}
			
			else
			{
				avl.setLeft(addRecursive(avl.getLeft(), x));
			}
			
			return updateAndBalanceIfNecesary(avl);  //¿Se debe reequilibrar el árbol tras añadir el nuevo nodo?
		}
	}
	
	/**
	 * @param nodo el árbol que se quiere actualizar Height, BF y balancear si fuese necesario
	 * @return la raíz del árbol por si ha cambiado
	 */
	private AVLNode<T> updateAndBalanceIfNecesary (AVLNode<T> theRoot)
	{
		theRoot.updateHeight(); //Para actualizar el BF antes de comprobar si necesita reequilibrarse.
		
		if (theRoot.getBF() == 2)
		{
			if (theRoot.getRight().getBF() == 1)
			{
				theRoot= singleRightRotation(theRoot);
			}
			
			else if (theRoot.getRight().getBF() == 2)
			{
				theRoot= doubleRightRotation(theRoot);
			}	
			
			else
			{
				theRoot= singleRightRotation(theRoot);
			}
		}
		
		else if (theRoot.getBF() == -2)
		{
			if (theRoot.getLeft() != null)
			{
				
			
			if (theRoot.getLeft().getBF() == -1)
			{
				theRoot= singleLeftRotation(theRoot);
			}
			
			else if (theRoot.getLeft().getBF() == -2)
			{
				theRoot= doubleLeftRotation(theRoot);
			}
			
			else
			{
				theRoot= singleLeftRotation(theRoot);
			}
			
			}
		}
		
		return theRoot;
	}
	
	/**
	 * @param nodo la raíz del árbol a balancear con rotación simple
	 * @return la raíz del nuevo árbol que ha cambiado
	 */
	private AVLNode<T> singleLeftRotation (AVLNode<T> nodo)
	{
		AVLNode<T> aux= nodo.getLeft();
		nodo.setLeft(aux.getRight());
		aux.setRight(nodo);
		
		nodo.updateHeight();
		aux.updateHeight();
		
		return aux;
	}
	
	/**
	 * @param nodo la raíz del árbol a balancear con rotación doble
	 * @return la raíz del nuevo árbol que ha cambiado
	 */
	private AVLNode<T> doubleLeftRotation(AVLNode<T> nodo) 
	{
		//(doble rotación izquierda) Auxiliar apuntando al nodo derecho del nodo izquierdo de nodo
		//Subárbol derecho del nodo izquierdo de nodo será el subárbol izquierdo de aux
		//Subárbol izquierdo de aux será el subárbol izquierdo de nodo.
		//Subárbol izquierdo de nodo será el subárbol derecho de aux.
		//Subárbol derecho de aux será el nodo
		//Actualizar alturas y BFs.
		
		AVLNode<T> aux= nodo.getLeft().getRight();
		nodo.getLeft().setRight(aux.getLeft());
		aux.setLeft(nodo.getLeft());
		nodo.setLeft(aux.getRight());
		aux.setRight(nodo);
		
		aux.getLeft().updateHeight();
		aux.getRight().updateHeight();
		nodo.updateHeight();
		aux.updateHeight();
		
		return aux;
	}
	
	/**
	 * @param nodo la raíz del árbol a balancear con rotación simple
	 * @return la raíz del nuevo árbol que ha cambiado
	 */
	private AVLNode<T> singleRightRotation (AVLNode<T> nodo)
	{
		//(rotacion derecha) Reservamos un nodo auxiliar apuntando al hijo derecho del parámetro (nodo)
		//El hijo derecho del nodo será el hijo izquierdo de aux
		//El hijo izquierdo de aux será el nodo.
		//Actualizar alturas de los nodos.
		
		AVLNode<T> aux= nodo.getRight();
		nodo.setRight(aux.getLeft());
		aux.setLeft(nodo);
		
		nodo.updateHeight();
		aux.updateHeight();
		
		return aux;
	}
	
	/**
	 * @param nodo la raíz del árbol a balancear con rotación doble
	 * @return la raíz del nuevo árbol que ha cambiado
	 */
	private AVLNode<T> doubleRightRotation(AVLNode<T> nodo) 
	{
		AVLNode<T> aux= nodo.getRight().getLeft();
		nodo.getRight().setLeft(aux.getRight());
		aux.setRight(nodo.getRight());
		nodo.setRight(aux.getLeft());
		aux.setLeft(nodo);
		
		aux.getRight().updateHeight();
		aux.getLeft().updateHeight();
		nodo.updateHeight();
		aux.updateHeight();
		
		return aux;
	}
	
	/* (non-Javadoc)
	 * @see BSTree#remove(java.lang.Comparable)
	 * Redefinición para incluir características AVL
	 */
	public boolean remove (T info)
	{
		if (info == null || getRaiz() == null)
		{
			return false;
		}
		else
		{
			AVLNode<T> raiz= (AVLNode<T>) getRaiz();
			try 
			{
				setRaiz(removeRecursivo(raiz, info));
			}
			
			catch (RuntimeException rE)
			{
				return false;
			}
			
			return true;
		}
	}
	
	private AVLNode<T> removeRecursivo(AVLNode<T> root, T x)
	{
		if (root == null)
		{
			throw new RuntimeException("Nodo no encontrado");
		}
		
		else
		{
			if (root.getInfo().compareTo(x) < 0)
			{
				root.setRight(removeRecursivo(root.getRight(), x));
			}
			
			else if (root.getInfo().compareTo(x) > 0)
			{
				root.setLeft(removeRecursivo(root.getLeft(), x));
			}
			
			else
			{
				if (root.getLeft() == null && root.getRight() == null)
				{
					return null;
				}
				
				else if (root.getLeft() != null && root.getRight() == null)
				{
					return root.getLeft();
				}
				
				else if (root.getLeft() == null && root.getRight() != null)
				{
					return root.getRight();
				}
				
				else if (root.getLeft() != null && root.getRight() != null)
				{
					T maxNodo= getMaximo(root.getLeft());
					root.setInfo(maxNodo);
					root.setLeft(removeRecursivo(root.getLeft(), root.getInfo()));
				}
			}
			return updateAndBalanceIfNecesary(root);
		}
	}

}

