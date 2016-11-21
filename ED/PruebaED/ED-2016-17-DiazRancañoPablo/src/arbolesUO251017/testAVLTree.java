package arbolesUO251017;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testAVLTree {
	
	private AVLTree<Integer> arbolAVL;
	private Integer n0, n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, n17, n18, n19, n20, n21, n22, n23, n24, n25, n26,
																													n27, n28, n29, n30, n31;

	@Before
	public void setUp()
	{
		arbolAVL= new AVLTree<Integer>();
		
		n0= 0;
		n1= 1;
		n2= 2;
		n3= 3;
		n4= 4;
		n5= 5;
		n6= 6;
		n7= 7;
		n8= 8;
		
		n31= 31;
		n30= 30;
		n29= 29;
		n28= 28;
		n27= 27;
		n26= 26;
		n25= 25;
		n24= 24;
		n23= 23;
		n22= 22;
		n21= 21;
		n20= 20;
		n19= 19;
		n18= 18;
		n17= 17;
		n16= 16;
		n15= 15;
		n14= 14;
		n13= 13;
		n12= 12;
		n11= 11;
		n10= 10;
		n9= 9;
	}
	
//	@Test
	public void testAdd() {
		
		
		//Se a�aden muchos nodos (SE PROBAR� LA ROTACI�N SIMPLE DERECHA)
		assertTrue(arbolAVL.add(n3));
		assertTrue(arbolAVL.add(n4));
		assertTrue(arbolAVL.add(n2));
		assertTrue(arbolAVL.add(n5));
		assertTrue(arbolAVL.add(n6));
		
		System.out.println(arbolAVL.toString()); //Comprobamos por pantalla que sale bien.
		
		//Se crea un nuevo �rbol para probar la ROTACI�N SIMPLE IZQUIERDA
		AVLTree<Integer> arbolAVL2= new AVLTree<Integer>();
		
		assertTrue(arbolAVL2.add(n3));
		assertTrue(arbolAVL2.add(n2));
		assertTrue(arbolAVL2.add(n5));
		assertTrue(arbolAVL2.add(n1));
		assertTrue(arbolAVL2.add(n0));
		
		System.out.println(arbolAVL2.toString()); //Comprobamos por pantalla que sale bien.
		
		//Se crea otro nuevo �rbol para probar la ROTACI�N DOBLE DERECHA
		AVLTree<Integer> arbolAVL3= new AVLTree<Integer>();
		
		assertTrue(arbolAVL3.add(n8));
		assertTrue(arbolAVL3.add(n2));
		assertTrue(arbolAVL3.add(n9));
		assertTrue(arbolAVL3.add(n1));
		assertTrue(arbolAVL3.add(n5));
		assertTrue(arbolAVL3.add(n10));
		assertTrue(arbolAVL3.add(n4));
		assertTrue(arbolAVL3.add(n6));
		assertTrue(arbolAVL3.add(n3));
//		assertTrue(arbolAVL3.add(n6));
		
		System.out.println(arbolAVL3.toString()); //Comprobamos por pantalla que sale bien.
		
		//Se crea otro nuevo �rbol para probar la ROTACI�N DOBLE IZQUIERDA
		AVLTree<Integer> arbolAVL4= new AVLTree<Integer>();
		
		assertTrue(arbolAVL4.add(n3));
		assertTrue(arbolAVL4.add(n2));
		assertTrue(arbolAVL4.add(n8));
		assertTrue(arbolAVL4.add(n1));
		assertTrue(arbolAVL4.add(n6));
		assertTrue(arbolAVL4.add(n9));
		assertTrue(arbolAVL4.add(n4));
		assertTrue(arbolAVL4.add(n7));
		assertTrue(arbolAVL4.add(n5));
//		assertTrue(arbolAVL4.add(n6));
		
		System.out.println(arbolAVL4.toString()); //Comprobamos por pantalla que sale bien.
	}
	
//	@Test
	public void testRemove()
	{
		//Se prueba a borrar nodos de un �rbol sin raiz, y a borrar nulls.
		assertFalse(arbolAVL.remove(n1));
		assertFalse(arbolAVL.remove(null));
		
		//Se a�aden muchos nodos (SE PROBAR� LA ROTACI�N SIMPLE DERECHA). El resto de pruebas est�n
		//en el paquete evalNestor.
		assertTrue(arbolAVL.add(n3));
		assertTrue(arbolAVL.add(n4));
		assertTrue(arbolAVL.add(n2));
		assertTrue(arbolAVL.add(n5));
		assertTrue(arbolAVL.add(n6));
		
		System.out.println(arbolAVL.toString());
		
		assertTrue(arbolAVL.remove(n6));
		
		System.out.println(arbolAVL.toString());
		
		assertTrue(arbolAVL.remove(n4));
		
		System.out.println(arbolAVL.toString());
		
		assertFalse(arbolAVL.remove(n4));  //n4 ya ha sido borrado previamente.
		assertFalse(arbolAVL.remove(null));
	}
	
//	@Test
	public void testRemoveGrande()
	{
		//Creamos �rbol muy grande.
		assertTrue(arbolAVL.add(n20));
		assertTrue(arbolAVL.add(n10));
		assertTrue(arbolAVL.add(n25));
		assertTrue(arbolAVL.add(n5));
		assertTrue(arbolAVL.add(n15));
		assertTrue(arbolAVL.add(n22));
		assertTrue(arbolAVL.add(n30));
		assertTrue(arbolAVL.add(n1));
		assertTrue(arbolAVL.add(n8));
		assertTrue(arbolAVL.add(n12));
		assertTrue(arbolAVL.add(n18));
		assertTrue(arbolAVL.add(n21));
		assertTrue(arbolAVL.add(n23));
		assertTrue(arbolAVL.add(n28));
		assertTrue(arbolAVL.add(n31));
		
//		System.out.println(arbolAVL.toString());
		
		//Borro la ra�z, se coge el mayor de los menores (n18) y se coloca en su posici�n.
		assertTrue(arbolAVL.remove(n20));
		
//		System.out.println(arbolAVL.toString());
		
		//Borramos de nuevo la ra�z (n18)
		assertTrue(arbolAVL.remove(n18));
		
		System.out.println(arbolAVL.toString());
		
		//Borramos de nuevo la ra�z. En este punto, el sub�rbol izquierdo queda desequilibrado,
		//y deber�a llevar a cabo una rotaci�n simple izquierda (si el hijo del nodo desequilibrado
		//tiene dos hijos, SIEMPRE se har� una rotaci�n simple.)
		assertTrue(arbolAVL.remove(n15));
		
		System.out.println(arbolAVL.toString());
		
		//Borramos ra�z de nuevo.
		assertTrue(arbolAVL.remove(n12));
		
		System.out.println(arbolAVL.toString());
		
		//Borramos ra�z de nuevo.
		assertTrue(arbolAVL.remove(n10));
		
		System.out.println(arbolAVL.toString());
		
		//De nuevo, borramos ra�z. Se realizar� una rotaci�n simple DERECHA, ya que el sub�rbol
		//derecho tiene dos hijos.
		assertTrue(arbolAVL.remove(n8));
		
		System.out.println(arbolAVL.toString());
	}
	
	@Test
	public void testeo()
	{
		assertTrue(arbolAVL.add(n7));
		assertTrue(arbolAVL.add(n10));
		assertTrue(arbolAVL.add(n8));
		
		System.out.println(arbolAVL.toString());
	
		assertTrue(arbolAVL.add(n15));
		
		System.out.println(arbolAVL.toString());
		
		assertTrue(arbolAVL.add(n16));
		
		System.out.println(arbolAVL.toString());
	}

}
