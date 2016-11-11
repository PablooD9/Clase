package grafosUO251017;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Graph <T>
{
	private T[] nodes; // Vector de nodos
	private boolean[][] edges; // matriz de aristas
	private double[][] weights; // matriz de pesos
	private int numNodes; // número de elementos en un momento dado
	public final static int MIN_VALUE= 0;
	private double[][] matrizA;
	private int[][] matrizP;
	private boolean primerNodo= true;
	private int valorCamino= 0;
	private boolean segundaIteracion= true;
	
	/** Constructor de la clase Graph, con un parámetro.
	 * 
	 * @param tam  Número máximo de nodos del grafo
	 */
	public Graph(int tam) 
	{
		numNodes= 0;
		edges= new boolean[tam][tam];
		nodes = (T[])new Object[tam];
		weights= new double[tam][tam];
	}
	
	public Graph (int tam, T initialNodes[], boolean[][] initialEdges, double [][] initialWeights, double [][] initialAfloyd, int [][] initialPfloyd) {
		// Llama al constructor original
		this(tam); 
		
		// Pero modifica los atributos con los parámetros para hacer pruebas...
		numNodes = initialNodes.length;
		
		for (int i=0;i<numNodes;i++) {
			// Si el vector de nodos se llama de otra forma (distinto de "nodes"), cambiad el nombre en la línea de abajo
			nodes[i]=initialNodes[i];
			for (int j=0;j<numNodes;j++){
				// Si la matriz de aristas se llama de otra forma (distinto de "edges"), cambiad el nombre en la línea de abajo
				edges[i][j]=initialEdges[i][j];
				// Si la matriz de pesos se llama de otra forma (distinto de "weights"), cambiad el nombre en la línea de abajo
				weights[i][j]=initialWeights[i][j];
			}
		}
		if (initialAfloyd!=null){
			// Si la matriz A de floyd se llama de otra forma (distinto de "aFloyd"), cambiad el nombre en la línea de abajo
			matrizA=initialAfloyd;
			// Si la matriz P de floyd se llama de otra forma (distinto de "pFloyd"), cambiad el nombre en la línea de abajo
			matrizP=initialPfloyd;
		}

	}
	
	/**
	 * Inserta un nuevo nodo que se le pasa como parámetro, en el vector de
	 * nodos, si existe no lo inserta
	 * 
	 * @param node
	 *            el nodo que se quiere insertar
	 * @return 0 si lo inserta, -1 si no puede insertarlo
	 */
	public int addNode(T node) 
	{
		if (getNode(node) == -1 && numNodes < nodes.length && node != null)
		{
			nodes[numNodes] = node;
			numNodes++;
			for (int i=0; i<numNodes; i++)
			{
				edges[i][numNodes-1]= false;
				edges[numNodes-1][i]= false;
				
				weights[i][numNodes-1]= MIN_VALUE;
				weights[numNodes-1][i]= MIN_VALUE;
			}
			return 0;
		}
		return -1;
	}
	
	/**
	 * Obtiene el índice de un nodo en el vector de nodos
	 *
	 * ¡¡¡ OJO que es privado porque depende de la implementación !!!
	 * 
	 * @param node
	 *            el nodo que se busca
	 * @return la posición del nodo en el vector ó -1 si no lo encuentra
	 */
	private int getNode(T node) 
	{
		if (node != null || numNodes == MIN_VALUE)
		{
			for (int i=0; i< numNodes; i++)
			{
				if (nodes[i].equals(node))
				{
					return i;
				}
			}
		}
		return -1;
	}
	
	/**
	 * Devuelve un String con la informacion del grafo
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		String cadena = "";

		cadena += "VECTOR NODOS\n";
		for (int i = 0; i < numNodes; i++) {
			cadena += nodes[i].toString() + "\t";
		}
		cadena += "\n\nMATRIZ ARISTAS\n";
		for (int i = 0; i < numNodes; i++) {
			for (int j = 0; j < numNodes; j++) {
				cadena += (edges[i][j]?"T":"F")+"\t";
			}
			cadena += "\n";
		}
		cadena += "\nMATRIZ PESOS\n";
		for (int i = 0; i < numNodes; i++) {
			for (int j = 0; j < numNodes; j++) {
				cadena += (edges[i][j]?df.format(weights[i][j]):"-") + "\t";
			}
			cadena += "\n";
		}

		// Si tu matriz A de Floyd se llama de otra forma que aFloyd, 
		// descomenta y adapta la linea de debajo 
		double [][] aFloyd= matrizA;
		if (matrizA != null) {
			cadena += "\nMATRIZ AFloyd\n";
			for (int i = 0; i < numNodes; i++) {
				for (int j = 0; j < numNodes; j++) {
					cadena += df.format(aFloyd[i][j]) + "\t";
				}
				cadena += "\n";
			}
		// Si tu matriz P de Floyd se llama de otra forma que pFloyd, 
		// descomenta y adapta la linea de debajo 
		int[][] pFloyd= matrizP;
			cadena += "\nMATRIZ PFloyd\n";
			for (int i = 0; i < numNodes; i++) {
				for (int j = 0; j < numNodes; j++) {
					cadena += (pFloyd[i][j]>=0?df.format(pFloyd[i][j]):"-") + "\t";
				}
				cadena += "\n";
			}
		}
		return cadena;
	}
	
	/**
	 * Inserta una arista con el peso indicado (> 0) entre dos nodos, uno origen y
	 * otro destino. 
	 * Si la arista existe, le cambia el peso.
	 * Devuelve 0 si la inserta (o cambia el peso) y -1 si no lo hace
	 * 
	 * @param source
	 *            nodo origen
	 * @param target
	 *            nodo destino
	 * @param edgeWeight
	 *            peso de la arista, debe ser > 0
	 * @return 0 si lo hace y -1 si no lo hace (también si el peso es < 0)
	 */
	public int addEdge(T source, T target, double edgeWeight) 
	{
		if (source != null && target != null && edgeWeight > MIN_VALUE && (getNode(source) != -1) 
																					&& (getNode(target) != -1))
		{
			int fuente= getNode(source);
			int destino= getNode(target);
			double maxValor= Double.POSITIVE_INFINITY;
			if (edgeWeight == maxValor)
			{
				weights[fuente][destino]= maxValor;
			}
			else
			{
				weights[fuente][destino]= edgeWeight;
			}
			edges[fuente][destino]= true;
			return 0;
		}
		return -1;
	}

	/** Método que devuelve verdadero o falso, en función de si el nodo que se le pasa por parámetro existe
	 * en la matriz de nodos o no.
	 * 
	 * @param node  Nodo que se quiere consultar
	 * @return si existe o no el nodo
	 */
	public boolean existNode(T node) 
	{ 
		if(getNode(node) != -1 && node != null && numNodes != MIN_VALUE)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Borra el nodo deseado del vector de nodos así como las aristas de las que
	 * forma parte
	 * 
	 * @param node
	 *            que se quiere borrar
	 * @return 0 si lo borra o -1 si no lo hace
	 */
	public int removeNode(T node) 
	{
		if (node != null && getNode(node) != -1)
		{
			int a= getNode(node);
			nodes[a] = nodes[numNodes - 1];
			nodes[numNodes-1]= null;
			numNodes--;
			for (int i=0; i< numNodes; i++)
			{
				edges[a][i]= edges[numNodes][i];
				edges[i][a]= edges[i][numNodes];
				
				weights[a][i]= weights[numNodes][i];
				weights[i][a]= weights[i][numNodes];
			}
			edges[a][a] = edges[numNodes][numNodes];
			weights[a][a] = weights[numNodes][numNodes];
			return 0;
		}
		return -1;
	}
		
	
	/** Método que devuelve el peso de una arista que va desde un nodo fuente (source) hasta un nodo objetivo
	 * (target).
	 * 
	 * @param source Nodo FUENTE a ser evaluado.
	 * @param target Nodo DESTINO a ser evaluado.
	 * @return el peso de la arista si dicha arista existe, -1 en cualquier otro caso.
	 */
	public double getEdge(T source, T target)
	{
		if (existEdge(source, target))
		{
			int node1= getNode(source);
			int node2= getNode(target);
			return weights[node1][node2];
		}
		return -1;
	}
	
	
	/** Método auxiliar para controlar el paso de parámetros.
	 * @param node Nodo a ser evaluado.
	 * @return true si el nodo existe en el grafo y es distinto de null, false en otro caso.
	 */
	private boolean comprobarParam(T node)
	{
		if (node != null && getNode(node) != -1) //nodo != de null y además existe en el grafo
			return true;
		else
			return false;
	}
	
	/** Método que devuelve true o false en función de si existe la arista que va desde el nodo source
	 * hasta el nodo target.
	 * 
	 * @param source Nodo fuente
	 * @param target Nodo destino
	 * @return true si existe la arista, false en cualquier otro caso.
	 */
	public boolean existEdge(T source, T target)
	{
		if (comprobarParam(source) && comprobarParam(target))
		{
			int node1= getNode(source);
			int node2= getNode(target);
			if (edges[node1][node2] == true)
			{
				return true;
			}
		}
		return false;
	}
	
	/** Método que borra la arista que va desde el nodo source hasta el nodo target.
	 * @param source Nodo fuente
	 * @param target Nodo objetivo
	 * @return 0 si la arista es borrada correctamente, -1 en cualquier otro caso.
	 */
	public int removeEdge(T source, T target)
	{
		if (existEdge(source, target) && comprobarParam(source) && comprobarParam(target))
		{
			int node1= getNode(source);
			int node2= getNode(target);
			
			edges[node1][node2]= false;
			weights[node1][node2]= 0.0;
			return 0;
		}
		return -1;
	}
	
	//UNIDAD 3 : DIJKSTRA

	/**
	 *  Algoritmo de Dijkstra para encontrar el camino de coste mínimo desde nodoOrigen 
	 *  hasta el resto de nodos
	 *  
	 * @param nodoOrigen
	 * @return vector D de dijkstra para comprobar funcionamiento
	 */
	public double[] dijkstra(T nodoOrigen) 
	{
		if (nodoOrigen == null || getNode(nodoOrigen) == -1 || numNodes == MIN_VALUE)
		{
			return null;
		}
		boolean[] matrizV= new boolean[numNodes];
		double[] matrizD= new double[numNodes];
		Integer[] matrizP= new Integer[numNodes];
		
		double maxValor= Double.POSITIVE_INFINITY;
		
		//Inicialización matriz visitados (matrizV)-------------------
		for (int i=0; i< numNodes; i++)
		{
			matrizV[i]= false;
		}
		
		int a= getNode(nodoOrigen);
		matrizV[a]= true;
		
		//Inicialización matriz distancias (matrizD)-------------------
		for (int i=0; i< numNodes; i++)
		{
			if (existEdge(nodoOrigen, nodes[i]))
			{
				matrizD[i]= getEdge(nodoOrigen, nodes[i]);
			}
			else
				matrizD[i]= maxValor; // Ir de A hasta A es imposible, porque ya estás en A,
									   // o quizás no puedes llegar a otro nodo desde A.
		}
		matrizD[a]= MIN_VALUE;
		
		//Inicialización matrizP---------------------------------------
		for (int i=0; i< numNodes; i++)
		{
			if (existEdge(nodoOrigen, nodes[i]))
			{
				matrizP[i]= a;
			}
			else
				matrizP[i]= -1;
		}
		
		ArrayList<Integer> nodosSueltos= comprobarNodosSueltos(); //Comprueba que no hayan nodos 
								//NO conectados y, si los hay, los mete en un ArrayList.
		
		int contador= MIN_VALUE; //Uso el contador para que, una vez evaluados todos los nodos,
								 //no haya bucle infinito
		while (minCost(matrizD, matrizV) != -1 && (contador <= numNodes - 1))
		{
			contador++;
			int nodoPivote= minCost(matrizD, matrizV);
			matrizV[nodoPivote]= true;
			for (int i=0; i< numNodes; i++)
			{
				if (matrizV[i] == false && !nodosSueltos.contains(i) && nodoPivote != maxValor)
				{
					if ((matrizD[i] > weights[nodoPivote][i] + matrizD[nodoPivote]) && (weights[nodoPivote][i] != MIN_VALUE))
					{
						matrizD[i]= weights[nodoPivote][i] + matrizD[nodoPivote];
						matrizP[i]= nodoPivote;
					}
				}
			}
		}
		return matrizD;
	}
	
	/**
	 * Busca el nodo con distancia mínima en D al resto de nodos
	 * @param dist  vector d
	 * @param v  	vector con visitados (conjunto S)
	 * @return índice del nodo buscado o -1 si el grafo es no conexo o no quedan nodos sin visitar
	 */
	private int minCost(double[] dist, boolean[] v) 
	{ 
		int index= 0;
		double maxDistance= Double.POSITIVE_INFINITY;
		boolean noQuedanPorEvaluar= true;
		ArrayList<Integer> nodosSueltos= comprobarNodosSueltos();
		for (int i=0; i< numNodes; i++)
		{
			if (!v[i] && !nodosSueltos.contains(i)) //si no está visitado
			{
				noQuedanPorEvaluar= false;
				double distancia= dist[i];
				if (distancia < maxDistance)
				{
					maxDistance= distancia;
					index= i;
				}
			}
		}
		if (noQuedanPorEvaluar)
			return -1;
		else
			return index;
	}
	
	/** Método que comprueba los nodos que no están conectados
	 * @return un arrayList con los nodos no conectados del grafo.
	 */
	private ArrayList<Integer> comprobarNodosSueltos()
	{
		ArrayList<Integer> aL= new ArrayList<Integer>();
		int contador= MIN_VALUE;
		for (int i=0; i< numNodes; i++)
		{
			contador= MIN_VALUE;
			for (int j=0; j< numNodes; j++)
			{
				if (edges[i][j] == false && (i != j))
				{
					contador++;
				}
				if (edges[j][i] == false && (j != i))
				{
					contador++;
				}
			}
			if (contador == (numNodes)*2 - 2) //-2, porque no se evalua el propio nodo con él mismo.
				aL.add(getNode(nodes[i]));
		}
		return aL;
	}
	
	//UNIDAD 3 : FLOYD
	
	/**
	 * Aplica el algoritmo de Floyd al grafo actual
	 * 
	 * @return la matriz A de Floyd
	 */
	public double[][] floyd()
	{
		double maxValor= Double.POSITIVE_INFINITY;
		if (numNodes > MIN_VALUE)
		{
			matrizA= new double[numNodes][numNodes];
			matrizP= new int[numNodes][numNodes];
			
			//Inicialización matriz A.
			for (int i=0; i< numNodes; i++)
			{
				for (int j=0; j< numNodes; j++)
				{
					if (edges[i][j])
					{
						matrizA[i][j]= weights[i][j];
					}
					if (matrizA[i][j] == MIN_VALUE)
					{
						matrizA[i][j] = maxValor;
					}
					if (i == j)  //Diago principal
					{
						matrizA[i][j] = MIN_VALUE;
					}
				}
			}
			
			//Inicialización matriz P.
			for (int i=0; i< numNodes; i++)
			{
				for (int j=0; j< numNodes; j++)
				{
					matrizP[i][j]= -1;
				}
			}
			
			for (int i=0; i< numNodes; i++)
			{
				for (int j=0; j< numNodes; j++)
				{
					for (int k=0; k< numNodes; k++)
					{
						if (matrizA[j][i] + matrizA[i][k] < matrizA[j][k])
						{
							matrizA[j][k] = matrizA[j][i] + matrizA[i][k];
							matrizP[j][k] = i;
						}
					}
				}
			}
			
			return matrizA;
		}
		else
			return null;
	}
	
	/**
	 * Indica el camino entre los nodos que se le pasan como parámetros de esta forma:
	 * Origen<tab>(coste0)<tab>Intermedio1<tab>(coste1)….IntermedioN<tab>(costeN) Destino
	 * 
	 * @param origen
	 * @param destino
	 * @return Distancia entre los nodos origen y destino según Floyd
	 */
	public double path(T origen, T destino) 
	{
		if (origen == null || destino == null || (getNode(origen) == -1 || getNode(destino) == -1))
		{
			return -1;
		}

		floyd();
		
		// Antes de llamar a path, se debe llamar a floyd.
		
		int a= getNode(origen);
		int b= getNode(destino);
		if (existEdge(origen, destino) || (a == b) || matrizA[a][b] == Double.POSITIVE_INFINITY)
		{
			if ((getEdge(origen, destino) <= matrizA[a][b]) || (a==b))
			{
				System.out.println(nodes[a].toString() + "\t(" + matrizA[a][b] + ")\t" + nodes[b].toString());
				System.out.print("\n");
				return matrizA[a][b];
			}
		}
		
		primerNodo= true;
		segundaIteracion= true;
		
		recursiveMethod(a, b);

		if (segundaIteracion && !primerNodo) //Para casos con solo un nodo intermedio,
											 //se usa esto.
		{
			System.out.print(nodes[b].toString());
		}
		
		primerNodo= true;
		segundaIteracion= true;
		valorCamino= 0; //Se vuelven a reinicializar los atributos, por si acaso...
		System.out.println("\n");
		return matrizA[a][b];
	}
	
	/** Método recursivo que muestra por pantalla la cadena de nodos que supone
	 * recorrer un camino desde un nodo Origen hasta un nodo Destino.
	 * @param a index del nodo Origen en la matriz de nodos.
	 * @param b index del nodo Destino en la matriz de nodos.
	 */
	private void recursiveMethod(int a, int b)
	{
		int k= matrizP[a][b];
		if (k > 0)
		{
			recursiveMethod(a, k);
			if (primerNodo)
			{
				System.out.print(nodes[a].toString() + "\t" + "(" + matrizA[a][k] + ")" + "\t" + nodes[k].toString() + "\t"
						+ "(" + matrizA[k][b] + ")" + "\t");
				primerNodo= false;
			}
			else
			{
				if (segundaIteracion)
				{
					System.out.print(nodes[k].toString() + "\t(" + matrizA[k][b] + ")\t" + nodes[b].toString() + "\t");
					segundaIteracion= false;
				}
				else
				{
					System.out.print("(" + matrizA[k][b] + ")\t" + nodes[b].toString() + "\t");
				}
			}
		}
	}
	
	/**
	 * Lanza el recorrido en profundidad de un grafo desde un nodo determinado,
	 * No necesariamente recorre todos los nodos.
	 * Al recorrer cada nodo hace un tratamiento del mismo programado en
	 * otro método privado: tratarNodo(...) 
	 * Usa un método privado recursivo
	 * 
	 * @param nodo
	 *            El nodo por el que se quiere empezar el recorrido en
	 *            profundidad
	 * @return si se llega a todos devuelve 0, si no devuelve -1
	 */
	public int recorridoProfundidad(T nodoOrigen)
	{
		if (getNode(nodoOrigen) != -1 && numNodes > MIN_VALUE)
		{
			boolean[] v= new boolean[numNodes];
			int a = getNode(nodoOrigen);
			v[a]= true;
			tratarNodo(a, v);
			
			int contador= 0;
			for (int i=0; i< numNodes; i++)
			{
				if (v[i])
				{
					contador++;
				}
			}
			
			if (contador == numNodes)
			{
				return 0;
			}
			else
				return -1;
		}
		return -1;
	}
	
	/** Método que trata un nodo, de tal forma que recorre dicho nodo y sus "ramificaciones".
	 * @param a es el índice del nodo a evaluar, dentro de la matriz de nodos.
	 * @param v es la matriz de nodos visitados.
	 */
	private void tratarNodo(int a, boolean[] v)
	{
		for (int i=0; i< numNodes; i++)
		{
			if (existEdge(nodes[a], nodes[i]))
			{
				if (!v[i])
				{
					v[i]= true;
					tratarNodo(i, v);
				}
			}
		}
	}
	
	public boolean isStronglyConnected(T node)
	{
		if (node == null || getNode(node) == -1 || numNodes == MIN_VALUE)
		{
			return false;
		}
		else
		{
			floyd();
			int a= getNode(node);
			for (int i=a; i< a+1; i++)
			{
				for (int j=0; j< numNodes; j++)
				{
//					if (existEdge(node, nodes[i]))
//					{
//						contador++;
//					}
					if (matrizA[i][j] == Double.POSITIVE_INFINITY)
					{
						return false;
					}
				}
			}
			return true;
		}
	}
	
}
