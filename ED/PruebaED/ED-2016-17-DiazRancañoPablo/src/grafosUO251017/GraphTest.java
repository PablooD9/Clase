package grafosUO251017;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {

	private Graph<Integer> graph;
	private Graph<String> graphS;
	private Integer n0, n1, n2, n3, n4, n5, n6, n7;
	private String n0S, n1S, n2S, n3S, n4S, n5S, n6S, n7S;
	private final static int SIZE= 8;
	
	/** Método que instancia todos los atributos antes de ejecutar los tests.
	 * 
	 */
	@Before
	public void setUp()
	{
		n0= 0;
		n1= 1;
		n2= 2;
		n3= 3;
		n4= 4;
		n5= 5;
		n6= 6;
		n7= 7;
		graph= new Graph<Integer>(SIZE);
		
		n0S= "A";
		n1S= "B";
		n2S= "C";
		n3S= "D";
		n4S= "E";
		n5S= "F";
		n6S= "G";
		n7S= "H";
		graphS= new Graph<String>(8);		
	}
	
//	@Test
	public void testAddNode()
	{
		//Añadimos un nodo de valor null.
		assertEquals(-1, graph.addNode(null));
		assertEquals(-1, graphS.addNode(null)); //Array de String
		
		//Añadimos un nodo.
		assertEquals(0, graph.addNode(n0));
		assertEquals(0, graphS.addNode(n0S)); //Array de String
		System.out.println(graph.toString());
		System.out.println("-----------------------"); //separación, para distinguir mejor.
		
		//Volvemos a añadir el nodo de antes.
		assertEquals(-1, graph.addNode(n0));
		assertEquals(-1, graphS.addNode(n0S)); //Array de String
		
		//Añadimos varios nodos, hasta llenar el vector de nodos (tamaño 6).
		assertEquals(0, graph.addNode(n1));
		assertEquals(0, graph.addNode(n2));
		assertEquals(0, graph.addNode(n3));
		assertEquals(0, graph.addNode(n4));
		assertEquals(0, graph.addNode(n5));
		assertEquals(0, graph.addNode(n6));
		
		assertEquals(0, graphS.addNode(n1S)); //Array de String
		assertEquals(0, graphS.addNode(n2S));
		assertEquals(0, graphS.addNode(n3S));
		assertEquals(0, graphS.addNode(n4S));
		assertEquals(0, graphS.addNode(n5S));
		
		//Se intenta añadir otro nodo. Devolverá -1 porque ya se ha llegado al num max de nodos.
		assertEquals(-1, graph.addNode(n5)); //Comprobamos una vez más que no se admiten repetidos.
		assertEquals(-1, graph.addNode(n3));
		Integer n7= 7; //este lo admite
		Integer n8= 8; //este ya se pasa de longitud del array.
		assertEquals(0, graph.addNode(n7));
		assertEquals(-1, graph.addNode(n8));
		
		System.out.println(graph.toString());
		System.out.println("-----------------------");
		
		assertEquals(-1, graphS.addNode(n6S)); //Array de String
		assertEquals(-1, graphS.addNode(n3S));
		assertEquals(-1, graphS.addNode(n5S));
		assertEquals(-1, graphS.addNode(n1S));

	}
	
//	@Test
	public void testAddEdge()
	{
		System.out.println(graph.toString()); //Comprobación de que no se copian los nodos del
												//test anterior.
		System.out.println("-----------------------");
		
		//Añadimos nodos.
		graph.addNode(n0);
		graph.addNode(n1);
		graph.addNode(n2);
		
		//Pruebas de aristas inválidas.
		assertEquals(-1, graph.addEdge(null, n2, 5));
		assertEquals(-1, graph.addEdge(n2, null, 2));
		assertEquals(-1, graph.addEdge(null, null, 9));
		assertEquals(-1, graph.addEdge(n1, n3, -1));
		assertEquals(-1, graph.addEdge(null, n2, 10));
		assertEquals(-1, graph.addEdge(n1, n3, 3)); //n3 no está añadido aún.
		assertEquals(-1, graph.addEdge(n0, n2, 0)); //no se admite una arista de 0 o menos.
		
		//Añadimos aristas.
		assertEquals(0, graph.addEdge(n0, n1, 2));
		assertEquals(0, graph.addEdge(n1, n2, 3));
		assertEquals(0, graph.addEdge(n2, n0, 4));
		System.out.println(graph.toString());
		System.out.println("-----------------------");
		
		//Añadimos nuevas aristas sobre las ya creadas anteriormente.
		assertEquals(0, graph.addEdge(n0, n1, 3));
		assertEquals(0, graph.addEdge(n1, n2, 4));
		assertEquals(0, graph.addEdge(n2, n0, 5));
		System.out.println(graph.toString());
		System.out.println("-----------------------");
		
		//Se añade un nodo, se añaden aristas, se borra, y se comprueba que la matriz de aristas pone 
		//a False lo necesario cuando se añade un nuevo nodo.
		assertEquals(0, graph.addNode(n3));
		assertEquals(0, graph.addEdge(n0, n3, 6));
		assertEquals(0, graph.addEdge(n1, n3, 7));
		assertEquals(0, graph.addEdge(n3, n1, 8));
		System.out.println(graph.toString());
		System.out.println("-----------------------");
		
		assertEquals(0, graph.removeNode(n3));
		assertEquals(0, graph.addNode(n4));
		assertEquals(false, graph.existEdge(n0, n3));
		assertEquals(false, graph.existEdge(n1, n3));
		assertEquals(false, graph.existEdge(n3, n1));
		System.out.println(graph.toString());
		System.out.println("-----------------------");
		
		//Se hace lo mismo que antes, pero con un nodo intermedio, y sin añadir ningún nodo.
		//El nodo n4 debería ocupar la posición del que se borra (n1) y, además, llevarse consigo
		//sus aristas.
		assertEquals(0, graph.addEdge(n0, n4, 9));
		System.out.println(graph.toString());
		System.out.println("-----------------------");
		assertEquals(0, graph.removeNode(n1));
		System.out.println(graph.toString());
		System.out.println("-----------------------");
	}

//	@Test
	public void testExistNode()
	{
		//Comprobamos que no admite null.
		assertEquals(false, graph.existNode(null));
		
		//Comprobamos que no existen nodos cuando no se ha añadido ninguno.
		assertEquals(false, graph.existNode(n0));
		assertEquals(false, graph.existNode(n1));
		assertEquals(false, graph.existNode(n2));
		assertEquals(false, graph.existNode(n3));
		assertEquals(false, graph.existNode(n4));
		assertEquals(false, graph.existNode(n5));
		assertEquals(false, graph.existNode(n6));
		
		//Añadimos algunos nodos.
		assertEquals(0, graph.addNode(n0));
		assertEquals(0, graph.addNode(n1));
		assertEquals(0, graph.addNode(n2));
		assertEquals(0, graph.addNode(n3));
		assertEquals(0, graph.addNode(n4));
		
		//Comprobamos que existen.
		assertEquals(true, graph.existNode(n0));
		assertEquals(true, graph.existNode(n1));
		assertEquals(true, graph.existNode(n2));
		assertEquals(true, graph.existNode(n3));
		assertEquals(true, graph.existNode(n4));
		
		//Comprobamos que, si borramos algún nodo, deja de existir.
		assertEquals(0, graph.removeNode(n1));
		assertEquals(false, graph.existNode(n1));
		assertEquals(0, graph.removeNode(n3));
		assertEquals(false, graph.existNode(n3));
	}
	
//	@Test
	public void testRemoveNode()
	{
		//Comprobación de que no admite null.
		assertEquals(-1, graph.removeNode(null));
		
		//Comprobación de que no se pueden borrar nodos inicialmente.
		assertEquals(-1, graph.removeNode(n0));
		assertEquals(-1, graph.removeNode(n1));
		assertEquals(-1, graph.removeNode(n2));
		assertEquals(-1, graph.removeNode(n3));
		assertEquals(-1, graph.removeNode(n4));
		assertEquals(-1, graph.removeNode(n5));
		assertEquals(-1, graph.removeNode(n6));
		
		//Añadimos algunos nodos.
		assertEquals(0, graph.addNode(n0));
		assertEquals(0, graph.addNode(n1));
		assertEquals(0, graph.addNode(n2));
		assertEquals(0, graph.addNode(n3));
		assertEquals(0, graph.addNode(n4));
		
		//Añadimos muchas aristas entre ellos.
		assertEquals(0, graph.addEdge(n0, n0, 1)); //Comprobamos además que también admite bucles.
		assertEquals(0, graph.addEdge(n0, n1, 2));
		assertEquals(0, graph.addEdge(n0, n2, 3));
		assertEquals(0, graph.addEdge(n1, n2, 4));
		assertEquals(0, graph.addEdge(n1, n3, 5));
		assertEquals(0, graph.addEdge(n2, n3, 6));
		assertEquals(0, graph.addEdge(n3, n4, 7));
		assertEquals(0, graph.addEdge(n4, n0, 8));
		assertEquals(0, graph.addEdge(n4, n4, 9));
		
		//Borramos nodos. En este punto, necesitamos comprobar que se borran, además, las aristas que entran
		//y salen de los nodos que borramos. Además, necesitamos comprobar que, efectivamente, se borran dichos nodos.
		assertEquals(1, graph.getEdge(n0, n0), 0.1);
		assertEquals(6, graph.getEdge(n2, n3), 0.1);
		assertEquals(9, graph.getEdge(n4, n4), 0.1);
		
		assertEquals(true, graph.existEdge(n0, n0));
		assertEquals(true, graph.existEdge(n0, n2));
		assertEquals(true, graph.existEdge(n1, n3));
		assertEquals(true, graph.existEdge(n3, n4));
		assertEquals(true, graph.existEdge(n4, n0));
		assertEquals(true, graph.existEdge(n4, n4));
		System.out.println(graph.toString());
		System.out.println("-----------------------");
			
			//añadimos un nodo n5 al final, para comprobar que lo borra correctamente, sin afectar al resto
			//de la matriz.
		assertEquals(0, graph.addNode(n5));
		assertEquals(0, graph.addEdge(n0, n5, 10));
		assertEquals(0, graph.addEdge(n3, n5, 11));
		assertEquals(0, graph.addEdge(n5, n4, 12));
		assertEquals(true, graph.existEdge(n0, n5));
		assertEquals(true, graph.existEdge(n3, n5));
		assertEquals(true, graph.existEdge(n5, n4));
		System.out.println(graph.toString());
		System.out.println("-----------------------");
		
		assertEquals(0, graph.removeNode(n5));
		assertEquals(false, graph.existNode(n5));
		assertEquals(false, graph.existEdge(n0, n5));
		assertEquals(false, graph.existEdge(n3, n5));
		assertEquals(false, graph.existEdge(n5, n4));
		System.out.println(graph.toString());
		System.out.println("-----------------------");
		
			//borramos el nodo 1. Las aristas que salen y entran de él deberían dejar de existir.
		assertEquals(0, graph.removeNode(n1));
		assertEquals(false, graph.existNode(n1));
		assertEquals(false, graph.existEdge(n0, n1));
		assertEquals(false, graph.existEdge(n1, n2));
		assertEquals(false, graph.existEdge(n1, n3));
		System.out.println(graph.toString());
		System.out.println("-----------------------");
		
			//borramos el nodo 3. Lo mismo que para el 1.
		assertEquals(0, graph.removeNode(n3));
		assertEquals(false, graph.existNode(n3));
		assertEquals(false, graph.existEdge(n1, n3));
		assertEquals(false, graph.existEdge(n2, n3));
		assertEquals(false, graph.existEdge(n3, n4));
		System.out.println(graph.toString());
		System.out.println("-----------------------");
		
			//borramos el nodo 4.
		assertEquals(0, graph.removeNode(n4));
		assertEquals(false, graph.existNode(n4));
		assertEquals(false, graph.existEdge(n3, n4));
		assertEquals(false, graph.existEdge(n4, n0));
		assertEquals(false, graph.existEdge(n4, n4));
		System.out.println(graph.toString());
		System.out.println("-----------------------");
		
	}
	
//	@Test
	public void testGetEdge()
	{
		//Comprobación de que no admite parámetros null.
		assertEquals(-1, graph.getEdge(null, null), 0.1);

		//Comprobación, además, de que no admite nodos que no estén añadidos.
		assertEquals(-1, graph.getEdge(null, n0), 0.1);
		assertEquals(-1, graph.getEdge(n1, null), 0.1);
		assertEquals(-1, graph.getEdge(null, null), 0.1);
		assertEquals(-1, graph.getEdge(n0, n1), 0.1);
		assertEquals(-1, graph.getEdge(n2, n4), 0.1);
		
		//Añadimos nodos
		assertEquals(0, graph.addNode(n0));
		assertEquals(0, graph.addNode(n1));
		assertEquals(0, graph.addNode(n2));
		assertEquals(0, graph.addNode(n3));
		
		//Añadimos aristas entre los nodos.
		assertEquals(0, graph.addEdge(n0, n0, 1));
		assertEquals(0, graph.addEdge(n0, n2, 2));
		assertEquals(0, graph.addEdge(n1, n2, 3));
		assertEquals(0, graph.addEdge(n2, n1, 4));
		assertEquals(0, graph.addEdge(n2, n3, 5));
		assertEquals(0, graph.addEdge(n3, n0, 6));
		
		//Obtenemos sus valores.
		assertEquals(1, graph.getEdge(n0, n0), 0.1);
		assertEquals(2, graph.getEdge(n0, n2), 0.1);
		assertEquals(3, graph.getEdge(n1, n2), 0.1);
		assertEquals(4, graph.getEdge(n2, n1), 0.1);
		assertEquals(5, graph.getEdge(n2, n3), 0.1);
		assertEquals(6, graph.getEdge(n3, n0), 0.1);
	}
	
//	@Test
	public void testExistEdge()
	{
		//Comprobamos que no admite nulls y que, además, si no existen los nodos, devuelve false.
		assertEquals(false, graph.existEdge(null, null));
		assertEquals(false, graph.existEdge(null, n0));
		assertEquals(false, graph.existEdge(n0, null));
		assertEquals(false, graph.existEdge(n0, n0));
		assertEquals(false, graph.existEdge(n1, n2));
		
		//Añadimos algunos nodos
		assertEquals(0, graph.addNode(n0));
		assertEquals(0, graph.addNode(n1));
		assertEquals(0, graph.addNode(n2));
		assertEquals(0, graph.addNode(n3));
		
		//Añadimos aristas
		assertEquals(0, graph.addEdge(n0, n0, 1));
		assertEquals(0, graph.addEdge(n0, n1, 2));
		assertEquals(0, graph.addEdge(n1, n2, 3));
		assertEquals(0, graph.addEdge(n2, n3, 4));
		assertEquals(0, graph.addEdge(n3, n1, 5));
		assertEquals(0, graph.addEdge(n3, n3, 6));
		
		//Comprobamos que existen
		assertEquals(true, graph.existEdge(n0, n0));
		assertEquals(true, graph.existEdge(n0, n1));
		assertEquals(true, graph.existEdge(n1, n2));
		assertEquals(true, graph.existEdge(n2, n3));
		assertEquals(true, graph.existEdge(n3, n1));
		assertEquals(true, graph.existEdge(n3, n3));
		
		//Comprobamos que, si borramos un nodo, se borran sus aristas y dejan de existir. Lo probaremos con n3.
		assertEquals(0, graph.removeNode(n3));
		assertEquals(false, graph.existEdge(n2, n3));
		assertEquals(false, graph.existEdge(n3, n1));
		assertEquals(false, graph.existEdge(n3, n3));
		
		//Comprobamos finalmente que, si se vuelve a añadir el nodo, siguen sin existir sus aristas.
		assertEquals(0, graph.addNode(n3));
		assertEquals(false, graph.existEdge(n2, n3));
		assertEquals(false, graph.existEdge(n3, n1));
		assertEquals(false, graph.existEdge(n3, n3));
	}
	
//	@Test
	public void testRemoveEdge()
	{
		//Comprobamos que no admite nulls y que, además, si no existen los nodos, devuelve -1.
		assertEquals(-1, graph.removeEdge(null, null));
		assertEquals(-1, graph.removeEdge(null, n0));
		assertEquals(-1, graph.removeEdge(n0, null));
		assertEquals(-1, graph.removeEdge(n0, n0));
		assertEquals(-1, graph.removeEdge(n1, n2));
				
		//Añadimos algunos nodos
		assertEquals(0, graph.addNode(n0));
		assertEquals(0, graph.addNode(n1));
		assertEquals(0, graph.addNode(n2));
		assertEquals(0, graph.addNode(n3));
		
		//Añadimos aristas
		assertEquals(0, graph.addEdge(n0, n0, 1));
		assertEquals(0, graph.addEdge(n0, n1, 2));
		assertEquals(0, graph.addEdge(n1, n2, 3));
		assertEquals(0, graph.addEdge(n2, n3, 4));
		assertEquals(0, graph.addEdge(n3, n1, 5));
		assertEquals(0, graph.addEdge(n3, n3, 6));
		assertEquals(0, graph.addEdge(n3, n0, 7));
		
		//Comprobamos que las aristas se borran correctamente.
		assertEquals(0, graph.removeEdge(n3, n3));
		assertEquals(false, graph.existEdge(n3, n3));
		
		assertEquals(0, graph.removeEdge(n3, n0));
		assertEquals(false, graph.existEdge(n3, n0));
		
		assertEquals(0, graph.removeEdge(n1, n2));
		assertEquals(false, graph.existEdge(n1, n2));
		
		assertEquals(0, graph.removeEdge(n0, n0));
		assertEquals(false, graph.existEdge(n0, n0));
		
		System.out.println(graph.toString());
		System.out.println("-----------------------");
	}
	
//	@Test
	public void testAllBasic()
	{
		//Añadimos nodos
		assertEquals(0, graph.addNode(n0));
		assertEquals(0, graph.addNode(n1));
		assertEquals(0, graph.addNode(n2));
		assertEquals(0, graph.addNode(n3));
		assertEquals(0, graph.addNode(n4));
		assertEquals(0, graph.addNode(n5));
		
		//Añadimos MUCHAS aristas entre los nodos
		assertEquals(0, graph.addEdge(n0, n1, 1));
		assertEquals(0, graph.addEdge(n1, n2, 2));
		assertEquals(0, graph.addEdge(n2, n3, 3));
		assertEquals(0, graph.addEdge(n3, n4, 4));
		assertEquals(0, graph.addEdge(n4, n5, 5));
		assertEquals(0, graph.addEdge(n5, n4, 6));
		assertEquals(0, graph.addEdge(n4, n3, 7));
		assertEquals(0, graph.addEdge(n3, n2, 8));
		assertEquals(0, graph.addEdge(n2, n1, 9));
		assertEquals(0, graph.addEdge(n1, n0, 10));
		assertEquals(0, graph.addEdge(n5, n0, 11));
		assertEquals(0, graph.addEdge(n0, n0, 12));
		assertEquals(0, graph.addEdge(n2, n2, 13));
		
		System.out.println(graph.toString());
		System.out.println("-----------------------"); //separación, para distinguir mejor.
		
		//Movemos el nodo n2 y, después, el n3. Se comprueba que, al borrar el nodo n2, el nodo
		//n5 (el último de la lista de nodos) pasa a su lugar. Al borrar n3, su lugar lo ocupa el n4.
		assertEquals(0, graph.removeNode(n2));
		assertEquals(0, graph.removeNode(n3));
		System.out.println(graph.toString());
		System.out.println("-----------------------");
		
		assertEquals(0, graph.addNode(n3));
		System.out.println(graph.toString());
	}
	
//	@Test
	public void testDijkstra()
	{
		//Añadimos unos cuantos nodos, incluídos algunos nodos sueltos, que no se
		//conectarán con ningún otro.
		assertEquals(0, graph.addNode(n5)); //nodo suelto
		assertEquals(0, graph.addNode(n0));
		assertEquals(0, graph.addNode(n1));
		assertEquals(0, graph.addNode(n2));
		assertEquals(0, graph.addNode(n3));
		assertEquals(0, graph.addNode(n4));
		assertEquals(0, graph.addNode(n6)); //nodo suelto
		
		double maxValor= Double.POSITIVE_INFINITY;
		
		//Añadimos aristas entre ellos.
		graph.addEdge(n0, n1, 100);
		graph.addEdge(n0, n4, 400);
		graph.addEdge(n0, n2, 20);
		graph.addEdge(n2, n1, 12);
		graph.addEdge(n0, n3, 3);
		graph.addEdge(n1, n4, 41);
		graph.addEdge(n3, n1, 31);
		
		//Comprobación de que el algoritmo de Dijkstra funciona.
		assertArrayEquals(new double[]{maxValor, 0.0, 32.0, 20.0, 3.0, 73.0, maxValor}, graph.dijkstra(n0), 0.0001);
		assertArrayEquals(new double[]{maxValor, maxValor, 0.0, maxValor, maxValor, 41.0, maxValor}, graph.dijkstra(n1), 0.0001);
		assertArrayEquals(new double[]{maxValor, maxValor, 12.0, 0.0, maxValor, 53.0, maxValor}, graph.dijkstra(n2), 0.0001);
		assertArrayEquals(new double[]{maxValor, maxValor, 31.0, maxValor, 0.0, 72.0, maxValor}, graph.dijkstra(n3), 0.0001);
		assertArrayEquals(new double[]{maxValor, maxValor, maxValor, maxValor, maxValor, 0.0, maxValor}, graph.dijkstra(n4), 0.0001);
		
		//Comprobación de que el método devuelve null cuando le pasamos por parámetro null.
		assertArrayEquals(null, graph.dijkstra(null), 0.0001);
		
		//Creamos un nodo PERO NO LO AÑADIMOS AL GRAFO (devuelve null)
		Integer n7= 7;
		assertArrayEquals(null, graph.dijkstra(n7), 0.0001);
		
		//Añadimos una arista con un valor negativo (es decir, erróneo). No debería
		//tenerla en cuenta. Además, añadimos un bucle, el cual es inútil para Dikjstra.
		graph.addEdge(n1, n2, 0);
		graph.addEdge(n1, n4, -3);
		graph.addEdge(n2, n2, 4);
		assertArrayEquals(new double[]{maxValor, 0.0, 32.0, 20.0, 3.0, 73.0, maxValor}, graph.dijkstra(n0), 0.0001);
		
		//Creamos un nuevo grafo, pero no le añadimos aristas a ningún nodo.
		Graph<Integer> grafo= new Graph<Integer>(SIZE);
		assertArrayEquals(null, grafo.dijkstra(n0), 0.0001); //grafo vacío.
		
		grafo.addNode(n0);
		grafo.addNode(n1);
		grafo.addNode(n2);
		
		assertArrayEquals(new double[]{0.0, maxValor, maxValor}, grafo.dijkstra(n0), 0.0001);
		assertArrayEquals(new double[]{maxValor, 0.0, maxValor}, grafo.dijkstra(n1), 0.0001);
		assertArrayEquals(new double[]{maxValor, maxValor, 0.0}, grafo.dijkstra(n2), 0.0001);
		
		
		
		System.out.println(graph.toString());
		System.out.println("-----------------------");
	}
	
//	@Test
	public void testDijkstra2()
	{
		graph.addNode(n0); //A
		graph.addNode(n1); //B
		graph.addNode(n2); //C
		graph.addNode(n3); //D
		graph.addNode(n4); //E
		
		graph.addEdge(n0, n1, 10); //A->B
		graph.addEdge(n0, n3, 30); //A->D
		graph.addEdge(n0, n4, 100); //A->E
		graph.addEdge(n1, n2, 50); //B->C
		graph.addEdge(n2,n4, 10); //C->E 
		graph.addEdge(n3, n2, 20); //D->C
		graph.addEdge(n3, n4, 60); //D->E
		graph.addEdge(n1, n0, -3);
		
		double[] matrizD= new double[]{0.0, 10.0, 50.0, 30.0, 60.0};
		
		assertArrayEquals(matrizD, graph.dijkstra(n0), 0.0001);
	}
	
//	@Test
	public void testDijkstra3()
	{
		graph.addNode(n6); //G (nodo suelto)
		graph.addNode(n0); //A
		graph.addNode(n1); //B
		graph.addNode(n2); //C
		graph.addNode(n5); //F (nodo suelto)
		graph.addNode(n3); //D
		graph.addNode(n4); //E (nodo suelto)
		
		graph.addEdge(n0, n1, 4);
		graph.addEdge(n0, n3, 1);
		graph.addEdge(n1, n2, 1);
		graph.addEdge(n3, n1, 2);
		graph.addEdge(n3, n2, 4);
		
		double maxValor= Double.POSITIVE_INFINITY;
	
		double[] matrizD0= new double[]{maxValor, 0.0, 3.0, 4.0, maxValor, 1.0, maxValor};
		double[] matrizD1= new double[]{maxValor, maxValor, 0.0, 1.0, maxValor, maxValor, maxValor};
		double[] matrizD2= new double[]{maxValor, maxValor, maxValor, 0.0, maxValor, maxValor, maxValor};
		double[] matrizD3= new double[]{maxValor, maxValor, 2.0, 3.0, maxValor, 0.0, maxValor};
		
		assertArrayEquals(matrizD0, graph.dijkstra(n0), 0.0001);
		assertArrayEquals(matrizD1, graph.dijkstra(n1), 0.0001);
		assertArrayEquals(matrizD2, graph.dijkstra(n2), 0.0001);
		assertArrayEquals(matrizD3, graph.dijkstra(n3), 0.0001);
	}
	
//	@Test
	public void testDijsktra4()
	{
		graph.addNode(n6); //G (nodo suelto)
		graph.addNode(n0); //A
		graph.addNode(n1); //B
		graph.addNode(n2); //C
		graph.addNode(n3); //D
		graph.addNode(n4); //E (nodo suelto)
		
		graph.addEdge(n0, n1, 3);
		graph.addEdge(n0, n2, 2);
		graph.addEdge(n2, n1, 4);
		graph.addEdge(n3, n0, 1);
		graph.addEdge(n3, n2, 5);
		
		double maxValor= Double.POSITIVE_INFINITY;
		
		double[] matrizD3= new double[]{maxValor, 1.0, 4.0, 3.0, 0.0, maxValor};
		assertArrayEquals(matrizD3, graph.dijkstra(n3), 0.0001);
	}
	
//	@Test
	public void testDijkstra5()
	{
		graph.addNode(n1); //B
		graph.addNode(n2); //C
		graph.addNode(n3); //D
		graph.addNode(n4); //E (nodos sueltos)
		double maxValor= Double.POSITIVE_INFINITY;
		
		
		double[] matrizD3= new double[]{0.0, maxValor, maxValor, maxValor};
		double[] matrizD4= new double[]{maxValor, maxValor, maxValor, 0.0};
		assertArrayEquals(null, graph.dijkstra(null), 0.0001);
		assertArrayEquals(null, graph.dijkstra(n0), 0.0001); //n0 no está añadido
		assertArrayEquals(matrizD3, graph.dijkstra(n1), 0.0001);
		assertArrayEquals(matrizD4, graph.dijkstra(n4), 0.0001);
	}
	
//	@Test
	public void testFloyd()
	{
		//(Ejercicio de apuntes)
		
		//Probamos con una matriz vacía de nodos.
		assertNull(graph.floyd()); 
		
		//Añadimos unos cuantos nodos.
		graph.addNode(n1); //V1
		graph.addNode(n2); //V2
		graph.addNode(n3); //V3
		graph.addNode(n4); //V4
		graph.addNode(n5); //V5
		graph.addNode(n6); //V6
		
		double maxValor= Double.POSITIVE_INFINITY;
		
		//Comprobamos que, sin añadir aristas, todos los valores están a +infinito.
		double matrizA[][]= new double[][]{{0, maxValor, maxValor, maxValor, maxValor, maxValor}, //fila 1
				{maxValor, 0, maxValor, maxValor, maxValor, maxValor}, //fila 2
				{maxValor, maxValor, 0, maxValor, maxValor, maxValor}, 
				{maxValor, maxValor, maxValor, 0, maxValor, maxValor}, 
				{maxValor, maxValor, maxValor, maxValor, 0, maxValor}, 
				{maxValor, maxValor, maxValor, maxValor, maxValor, 0}}; //fila 6
		
		assertArrayEquals(matrizA, graph.floyd());
		
		//Añadimos aristas
		graph.addEdge(n1, n2, 3);
		graph.addEdge(n1, n3, 4);
		graph.addEdge(n1, n5, 8);
		graph.addEdge(n2, n5, 5);
		graph.addEdge(n3, n5, 3);
		graph.addEdge(n5, n4, 7);
		graph.addEdge(n5, n6, 3);
		graph.addEdge(n6, n4, 2);
		
		//Comprobamos que hace bien los cálculos.
		double matrizA2[][]= new double[][]{{0, 3, 4, 12, 7, 10}, //fila 1
				{maxValor, 0, maxValor, 10, 5, 8}, //fila 2
				{maxValor, maxValor, 0, 8, 3, 6}, 
				{maxValor, maxValor, maxValor, 0, maxValor, maxValor}, 
				{maxValor, maxValor, maxValor, 5, 0, 3}, 
				{maxValor, maxValor, maxValor, 2, maxValor, 0}}; //fila 6
		
		assertArrayEquals(matrizA2, graph.floyd());
		System.out.println(graph.toString());
	}
	
//	@Test
	public void testFloyd2()
	{
		//(Otro ejercicio de los apuntes)
		
		//Añadimos nodos y aristas
		graph.addNode(n1); //V1
		graph.addNode(n2); //V2
		graph.addNode(n3); //V3
		graph.addNode(n4); //V4
		graph.addNode(n5); //V5
		
		graph.addEdge(n1, n2, 1);
		graph.addEdge(n1, n4, 3);
		graph.addEdge(n1, n5, 10);
		graph.addEdge(n2, n3, 5);
		graph.addEdge(n3, n5, 1);
		graph.addEdge(n4, n3, 2);
		graph.addEdge(n4, n5, 6);
		
		double maxValor= Double.POSITIVE_INFINITY;
		
		//Completamos la matrizA de Floyd y se comprueba que el resultado es el esperado.
		double matrizA[][]= new double[][]{{0, 1, 5, 3, 6},
				{maxValor, 0, 5, maxValor, 6}, 
				{maxValor, maxValor, 0, maxValor, 1}, 
				{maxValor, maxValor, 2, 0, 3}, 
				{maxValor, maxValor, maxValor, maxValor, 0}};
		
		assertArrayEquals(matrizA, graph.floyd());
	}
	
//	@Test
	public void testPath()
	{
		//Comprobamos que al invocar al método con:
		//una matriz vacía 
		//nodos incorrectos
		//devuelve -1.
		assertEquals(-1, graph.path(n0, n1), 0.00001);
		assertEquals(-1, graph.path(n1, n2), 0.00001);
		assertEquals(-1, graph.path(null, null), 0.00001);
		
		//Creamos un nuevo grafo, y añadimos aristas (ejercicio de apuntes)
		graph.addNode(n1); //V1
		graph.addNode(n2); //V2
		graph.addNode(n3); //V3
		graph.addNode(n4); //V4
		graph.addNode(n5); //V5
		graph.addNode(n6); //V6
		graph.addNode(n7); //V7
		
		graph.addEdge(n1, n2, 3);
		graph.addEdge(n1, n3, 4);
		graph.addEdge(n1, n5, 8);
		graph.addEdge(n2, n5, 5);
		graph.addEdge(n3, n5, 3);
		graph.addEdge(n5, n4, 7);
		graph.addEdge(n5, n6, 3);
		graph.addEdge(n6, n4, 2);
		
		//Comprobamos varios casos:
		
			//camino de un nodo a él mismo
		assertEquals(0, graph.path(n1, n1), 0.000001);
		assertEquals(0, graph.path(n6, n6), 0.000001);
		
			//camino inexistente de un nodo a otro (coste infinito)
		assertEquals(Double.POSITIVE_INFINITY, graph.path(n6, n1), 0.001);
		
			//camino de un nodo a otro adyacente (es decir, camino directo)
		assertEquals(3, graph.path(n1, n2), 0.00001);
		
			//caminos a nodos lejanos
		assertEquals(10, graph.path(n2, n4), 0.00001);
		assertEquals(12, graph.path(n1, n4), 0.00001);
		assertEquals(10, graph.path(n1, n6), 0.00001);
		assertEquals(7, graph.path(n1, n5), 0.00001);
		
		//LA SALIDA POR PANTALLA SERÍA LA SIGUIENTE:
		//en paréntesis el coste de ir del nodo de la izquierda al de la derecha.
		
		//1 	(0) 	1
		//6 	(0) 	6
		//6		(Infinity) 		1
		//1 	(3) 	2
		//2 	(5) 	5 		(3) 	6 		(2) 	4
		//1 	(4) 	3 	  (3)	 5    (3)   	6 	  (2)  	4
		//1		(4)		3 	  (3)	 5	  (3)		6
		//1 	(4) 	3 	  (3) 	 5
	}
	
//	@Test
	public void testPath2()
	{
		graph.addNode(n1); //V1
		graph.addNode(n2); //V2
		graph.addNode(n3); //V3
		graph.addNode(n4); //V4
		graph.addNode(n5); //V5
		graph.addNode(n6); //V6
		graph.addNode(n7); //V7
		
		graph.addEdge(n1, n2, 1);
		graph.addEdge(n2, n3, 2);
		graph.addEdge(n3, n4, 3);
		graph.addEdge(n4, n5, 4);
		graph.addEdge(n5, n6, 5);
		graph.addEdge(n6, n7, 6);
		
		assertEquals(1, graph.path(n1, n2), 0.00001);
		assertEquals(3, graph.path(n1, n3), 0.00001);
		assertEquals(6, graph.path(n1, n4), 0.00001);
		assertEquals(10, graph.path(n1, n5), 0.00001);
		assertEquals(15, graph.path(n1, n6), 0.00001);
		assertEquals(21, graph.path(n1, n7), 0.00001);
	}
//	@Test
	public void testPath3()
	{
		graph.addNode(n1); //V1
		graph.addNode(n2); //V2
		graph.addNode(n3); //V3
		graph.addNode(n4); //V4
		graph.addNode(n5); //V5
		
		graph.addEdge(n1, n2, 3);
		graph.addEdge(n1, n3, 2);
		graph.addEdge(n1, n5, 8);
		graph.addEdge(n2, n3, 1);
		graph.addEdge(n3, n4, 4);
		graph.addEdge(n4, n1, 1);
		graph.addEdge(n4, n5, 2);
		
		assertEquals(8, graph.path(n1, n5), 0.00001);
	}
	
//	@Test
	public void testSeminario()
	{
		Integer n7= 7;
		graph.addNode(n0); //D
		graph.addNode(n1); //B
		graph.addNode(n2); //F
		graph.addNode(n3); //H
		graph.addNode(n4); //G
		graph.addNode(n5); //E
		graph.addNode(n6); //C
		graph.addNode(n7); //A
		
		graph.addEdge(n0, n1, 3);
		graph.addEdge(n0, n2, 3);
		graph.addEdge(n1, n2, 6);
		graph.addEdge(n1, n4, 6);
		graph.addEdge(n2, n1, 4);
		graph.addEdge(n2, n0, 7);
		graph.addEdge(n3, n2, 6);
		graph.addEdge(n4, n6, 4);
		graph.addEdge(n5, n4, 2);
		graph.addEdge(n6, n4, 2);
		graph.addEdge(n6, n5, 6);
		graph.addEdge(n7, n6, 5);
		
		double maxValor= Double.POSITIVE_INFINITY;
		double[] matrizD= new double[]{0.0, 3, 3, maxValor, 9, 19, 13, maxValor};
		assertArrayEquals(matrizD, graph.dijkstra(n0), 0.00001);
	}
	
//	@Test
	public void testRecorridoProfundidad()
	{
		//Comprobamos que devuelve -1 si no hay nodos para evaluar, o se le pasa null.
		assertEquals(-1, graph.recorridoProfundidad(n1));
		assertEquals(-1, graph.recorridoProfundidad(null));
		
		//Añadimos algunos nodos y aristas.
		graph.addNode(n0); 
		graph.addNode(n1); 
		graph.addNode(n2); 
		graph.addNode(n3); 
		
		graph.addEdge(n0, n1, 2);
		graph.addEdge(n1, n0, 3);
		graph.addEdge(n1, n2, 3);
		graph.addEdge(n1, n3, 3);
		graph.addEdge(n2, n3, 84);
		
		//Observamos que desde 1 podemos llegar a todos los nodos de dos formas:
		//o bien directamente (hay aristas de 1 a todos los nodos) o, en el caso de que
		//no hubiese arista de 1 a 3, no importaría, pues hay otra de 2 a 3.
		//Se probarán ambos casos.
		
		assertEquals(0, graph.recorridoProfundidad(n1));
		
		graph.removeEdge(n1, n3);
		
		assertEquals(0, graph.recorridoProfundidad(n1));
	}
	
//	@Test
	public void pruebaIsStrngConnected()
	{
		graph.addNode(n0); 
		graph.addNode(n1); 
		graph.addNode(n2); 
		graph.addNode(n3); 
		
		graph.addEdge(n0, n1, 1);
		graph.addEdge(n1, n2, 2);
		graph.addEdge(n2, n3, 3);
		graph.addEdge(n3, n0, 4);
		
		//Grafo fuertemente conexo. Es decir, todos los nodos son fuertemente conexos.
		
		assertEquals(true, graph.isStronglyConnected(n0));
		assertEquals(true, graph.isStronglyConnected(n1));
		assertEquals(true, graph.isStronglyConnected(n2));
		assertEquals(true, graph.isStronglyConnected(n3));
		
		//Añadimos otro nodo, y dejará de serlo.
		
		graph.addNode(n4);
		
		assertEquals(false, graph.isStronglyConnected(n0));
	}
	
	@Test
	public void testSeminario2()
	{
		graphS.addNode(n0S); //A
		graphS.addNode(n1S); //B
		graphS.addNode(n2S); //C
		graphS.addNode(n3S); //D
		graphS.addNode(n4S); //E
		graphS.addNode(n5S); //F
		graphS.addNode(n6S); //G
		graphS.addNode(n7S); //H
		
		graphS.addEdge(n0S, n2S, 3);
		graphS.addEdge(n0S, n3S, 3);
		graphS.addEdge(n0S, n4S, 8);
		graphS.addEdge(n1S, n2S, 2);
		graphS.addEdge(n1S, n3S, 5);
		graphS.addEdge(n2S, n0S, 6);
		graphS.addEdge(n2S, n6S, 2);
		graphS.addEdge(n3S, n5S, 9);
		graphS.addEdge(n3S, n7S, 1);
		graphS.addEdge(n4S, n2S, 4);
		graphS.addEdge(n4S, n6S, 2);
		graphS.addEdge(n5S, n3S, 1);
		graphS.addEdge(n5S, n7S, 9);
		graphS.addEdge(n7S, n5S, 3);
		
		graphS.floyd();
		System.out.println(graphS.toString());
		
	}
	
}
