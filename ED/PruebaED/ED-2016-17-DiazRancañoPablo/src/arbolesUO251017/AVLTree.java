package arbolesUO251017;

/**
 * Clase derivada de BSTree a�adiendo funcionalidad de AVL
 * @author N�stor
 * @version 2016-17
 */
/**
 * @author PabloD
 *
 * @param <T>
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
	 * Redefine inserci�n para funcionalidad AVL
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
			
			return updateAndBalanceIfNecesary(avl);  //�Se debe reequilibrar el �rbol tras a�adir el nuevo nodo?
		}
	}
	
	/**
	 * @param nodo el �rbol que se quiere actualizar Height, BF y balancear si fuese necesario
	 * @return la ra�z del �rbol por si ha cambiado
	 */
	private AVLNode<T> updateAndBalanceIfNecesary (AVLNode<T> theRoot)
	{
		theRoot.updateHeight(); //Para actualizar el BF antes de comprobar si necesita reequilibrarse.
		
		if (theRoot.getBF() == -2)
		{
			if (theRoot.getLeft() != null)
			{
				if (theRoot.getLeft().getBF() == -1)
				{
					theRoot= singleLeftRotation(theRoot);
				}
				
				else if(theRoot.getLeft().getBF() == 1)
				{
					theRoot= doubleLeftRotation(theRoot);
				}
				
//				else if (theRoot.getLeft().getBF() == -2)
//				{
//					theRoot= doubleLeftRotation(theRoot);
//				}	
				
				else
				{
					theRoot= singleLeftRotation(theRoot);
				}
			}
		}
		
		else if (theRoot.getBF() == 2)
		{
			if (theRoot.getRight() != null)
			{
				if (theRoot.getRight().getBF() == 1)
				{
					theRoot= singleRightRotation(theRoot);
				}
				
				else if(theRoot.getRight().getBF() == -1)
				{
					theRoot= doubleRightRotation(theRoot);
				}
				
//				else if (theRoot.getRight().getBF() == 2)
//				{
//					theRoot= doubleRightRotation(theRoot);
//				}
				
				else
				{
					theRoot= singleRightRotation(theRoot);
				}
				
			}
		}
		
		return theRoot;
	}
	
	/**
	 * @param nodo la ra�z del �rbol a balancear con rotaci�n simple
	 * @return la ra�z del nuevo �rbol que ha cambiado
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
	 * @param nodo la ra�z del �rbol a balancear con rotaci�n doble
	 * @return la ra�z del nuevo �rbol que ha cambiado
	 */
	private AVLNode<T> doubleLeftRotation(AVLNode<T> nodo) 
	{
		//(doble rotaci�n izquierda) Auxiliar apuntando al nodo derecho del nodo izquierdo de nodo
		//Sub�rbol derecho del nodo izquierdo de nodo ser� el sub�rbol izquierdo de aux
		//Sub�rbol izquierdo de aux ser� el sub�rbol izquierdo de nodo.
		//Sub�rbol izquierdo de nodo ser� el sub�rbol derecho de aux.
		//Sub�rbol derecho de aux ser� el nodo
		//Actualizar alturas y BFs.
//		
//		AVLNode<T> aux= nodo.getLeft().getRight();
//		nodo.getLeft().setRight(aux.getLeft());
//		aux.setLeft(nodo.getLeft());
//		nodo.setLeft(aux.getRight());
//		aux.setRight(nodo);
//		
//		aux.getRight().updateHeight();
//		aux.getLeft().updateHeight();
////		nodo.updateHeight();
//		aux.updateHeight();
//		
//		return aux;
		
		AVLNode<T> aux= nodo.getLeft().getRight();
		nodo.getLeft().setRight(aux.getLeft());
		aux.setLeft(nodo.getLeft());
		nodo.setLeft(aux.getRight());
		aux.setRight(nodo);
		
//		AVLNode<T> nodoReferencia= nodeToSearchOf(nodo);
//		if (nodoReferencia != null)
//		{
//			if ((nodoReferencia.getInfo().compareTo(aux.getInfo()) > 0))
//			{
//				nodeToSearchOf(nodo).setLeft(aux);
//			}
//			
//			else
//			{
//				nodeToSearchOf(nodo).setRight(aux);
//			}
//		}
		
		aux.getLeft().updateHeight();
		aux.getRight().updateHeight();
//		nodo.updateHeight();
		aux.updateHeight();
		
		return aux;
	}
	
	/**
	 * @param nodo la ra�z del �rbol a balancear con rotaci�n simple
	 * @return la ra�z del nuevo �rbol que ha cambiado
	 */
	private AVLNode<T> singleRightRotation (AVLNode<T> nodo)
	{
		//(rotacion derecha) Reservamos un nodo auxiliar apuntando al hijo derecho del par�metro (nodo)
		//El hijo derecho del nodo ser� el hijo izquierdo de aux
		//El hijo izquierdo de aux ser� el nodo.
		//Actualizar alturas de los nodos.
		
		AVLNode<T> aux= nodo.getRight();
		nodo.setRight(aux.getLeft());
		aux.setLeft(nodo);
		
		nodo.updateHeight();
		aux.updateHeight();
		
		return aux;
	}
	
	/**
	 * @param nodo la ra�z del �rbol a balancear con rotaci�n doble
	 * @return la ra�z del nuevo �rbol que ha cambiado
	 */
	private AVLNode<T> doubleRightRotation(AVLNode<T> nodo) 
	{
		AVLNode<T> aux= nodo.getRight().getLeft();
//		nodo.getRight().setLeft(aux.getRight());
		nodo.getRight().setLeft(aux.getRight());
		aux.setRight(nodo.getRight());
//		aux.setRight(nodo.getRight());
		nodo.setRight(aux.getLeft());
		aux.setLeft(nodo);
		
//		AVLNode<T> nodoReferencia= nodeToSearchOf(nodo);
//		
//		if (nodoReferencia != null)
//		{
//			if (nodoReferencia.getInfo().compareTo(aux.getInfo()) > 0)
//			{
//				nodeToSearchOf(nodo).setLeft(aux);
//			}
//			else
//			{
//				nodeToSearchOf(nodo).setRight(aux);
//			}
//		}
		
		aux.getLeft().updateHeight();
		aux.getRight().updateHeight();
//		nodo.updateHeight();
		aux.updateHeight();
		
		return aux;
	}
	
	
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
			throw new RuntimeException();
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
	
//	/** M�todo que BUSCA y DEVUELVE aquel nodo cuya referencia apunta al par�metro, nodeToSearch.
//	 * @param nodeToSearch es el nodo el cual queremos ver qu� otro nodo apunta a �ste.
//	 * @return el nodo que apunta a nodeToSearch.
//	 */
//	private AVLNode<T> nodeToSearchOf(AVLNode<T> nodeToSearch)
//	{
//		if (nodeToSearch == null || getRaiz() == null)
//		{
//			return null;
//		}
//		
//		AVLNode<T> raiz= (AVLNode<T>) getRaiz();
//		return nodeToSearchOfRec(nodeToSearch, raiz);
//	}

//	private AVLNode<T> nodeToSearchOfRec(AVLNode<T> nodeToSearch, AVLNode<T> root) 
//	{
//		if (root.getLeft() == nodeToSearch || root.getRight() == nodeToSearch)
//		{
//			return root;
//		}
//		
//		else
//		{
//			if (root.getInfo().compareTo(nodeToSearch.getInfo()) == 0)
//			{
//				return null; //se est� buscando el mismo objeto.
//			}
//			
//			else if (root.getInfo().compareTo(nodeToSearch.getInfo()) > 0)
//			{
//				root= nodeToSearchOfRec(nodeToSearch, root.getLeft());
//			}
//			
//			else
//			{
//				root= nodeToSearchOfRec(nodeToSearch, root.getRight());
//			}
//		}
//		
//		return root;
//	}
	
}

