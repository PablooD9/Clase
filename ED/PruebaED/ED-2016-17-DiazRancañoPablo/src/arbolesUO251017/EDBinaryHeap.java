package arbolesUO251017;

/**
 * @author N�stor
 * @version 2016-17
 * 
 */
public class EDBinaryHeap<T extends Comparable<T>> implements EDPriorityQueue<T>{
	protected T [] elementos;
	protected int numElementos;


	@SuppressWarnings("unchecked")
	public EDBinaryHeap(int numMaxElementos) 
	{
		elementos= (T[]) new Comparable[numMaxElementos];
		numElementos= 0;
	}


	public boolean add(T info) 
	{
		if (info == null || numElementos == elementos.length || elementos.length == 0)
		{
			return false;
		}

		elementos[numElementos]= info;
		numElementos++;
		cribaAscendente(numElementos - 1);
			
		return true;
	}
	
	private void cribaAscendente(int x)
	{
//		T nodo= elementos[x];
		
		T nodo= elementos[x];
		int posPadre= (x - 1) / 2;
		T padre= elementos[posPadre];
		
//		if (nodo.compareTo(padre) == 0)
//		{
//			padre = nodo;
//		}
		
		if (nodo.compareTo(padre) < 0)
		{
			elementos[posPadre] = nodo;
			elementos[x] = padre;
			
			cribaAscendente(posPadre);
		}	
	}


	public T poll() 
	{
		if (numElementos == 0 || elementos.length == 0)
		{
			return null;
		}
		
		T raiz= elementos[0];
		int ultimoNodo= numElementos - 1;
		
		elementos[0] = elementos[ultimoNodo];
		numElementos--; //Elimina el �ltimo nodo del vector.
		
		int posRaiz= 0;
		
		cribaDescendente(posRaiz);
		
		return raiz;
	}
	
	private void cribaDescendente(int x)
	{
		T nodoRaiz= elementos[x];
		
		int posHijoIzq= (2 * x) + 1;
		T hijoIzq= null;
		if (posHijoIzq < elementos.length)
		{
			hijoIzq= elementos[posHijoIzq];
		}
		
		int posHijoDer= (2 * x) + 2;
		T hijoDer = null;
		
		if (posHijoDer < elementos.length)
		{
			hijoDer= elementos[posHijoDer];
		}
		
		if (hijoDer != null && hijoIzq != null)
		{
			if (hijoDer.compareTo(hijoIzq) < 0) //Se va por el hijo derecho
			{
				if (nodoRaiz.compareTo(hijoDer) > 0) //Hijo derecho < padre
				{
					elementos[x] = hijoDer;
					elementos[posHijoDer] = nodoRaiz;
					
					cribaDescendente(posHijoDer);
				}
			}
			
			else  //Se va por el hijo izquierdo
			{
				if (nodoRaiz.compareTo(hijoIzq) > 0) //Hijo izquierdo < padre
				{
					elementos[x] = hijoIzq;
					elementos[posHijoIzq] = nodoRaiz;
					
					cribaDescendente(posHijoIzq);
				}
			}
		}
		
		else
		{
			if (hijoDer == null && hijoIzq != null)
			{
				elementos[x] = hijoIzq;
				elementos[posHijoIzq] = nodoRaiz;
				
				cribaDescendente(posHijoIzq);
			}
			
			else if (hijoDer != null && hijoIzq == null)
			{
				elementos[x] = hijoDer;
				elementos[posHijoDer] = nodoRaiz;
				
				cribaDescendente(posHijoDer);
			}
		}
		
	}
	

	public boolean remove(T info) 
	{
		if (info == null || elementos.length == 0)
		{
			return false;
		}
		
		int posicionNodo= search(info);
		
		if (posicionNodo != -1) //Si encuentra el nodo en el array...
		{
			elementos[posicionNodo] = elementos[numElementos - 1]; //El nodo a borrar se cambia por el �ltimo
																	//nodo del array (distinto a la teor�a)
			
			cribaAscendente(posicionNodo);
			cribaDescendente(posicionNodo); //Reubicamos el nodo, mirando si puede subir o bajar en el �rbol.
			
			numElementos--; //Se elimina el �ltimo nodo.
			
			return true;
		}
		
		return false;
	}
	
	public int search(T info)
	{
		for (int i=0; i< numElementos; i++)
		{
			if (elementos[i].equals(info))
			{
				return i;
			}
		}
		
		return -1;
	}


	public boolean isEmpty() 
	{
		return (elementos.length == 0 || numElementos == 0);
	}


	public void clear() 
	{
		numElementos = 0; //Borra TODOS los elementos.
	}


	/**
	 * Devuelve una cadena con la informaci�n de los elementos que contiene el
	 * mont�culo en forma visible (recomendado inorden-derecha-izquierda tabulado)
	 */

	public String toString() {
		// Por ejemplo el �rbol tumbado...
			StringBuilder cadena = new StringBuilder();
			cadena.append(inOrdenDerechaTabulado(0,0));
			return cadena.toString();
		}


	// el �rbol tumbado...
	private String inOrdenDerechaTabulado(int p,int esp) {
		String cadena="";
		if (p<numElementos) {
			int izq = Math.abs(2*p+1);
			int der = Math.abs(2*p+2);
			cadena+=inOrdenDerechaTabulado(der,esp+1);
			for(int i = 0;i<esp;i++)
				cadena+="\t";
			cadena += elementos[p]+"\n";
			cadena+=inOrdenDerechaTabulado(izq,esp+1);
		}
		return cadena;	
	}

}