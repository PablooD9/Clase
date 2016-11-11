package arbolesUO251017;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testAVLTree {
	
	private AVLTree<Integer> arbolAVL;
	private Integer n0, n1, n2, n3, n4, n5, n6, n7, n8;

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
	}
	
	@Test
	public void testAdd() {
		
		
		//Se añaden muchos nodos (SE PROBARÁ LA ROTACIÓN SIMPLE DERECHA)
		assertTrue(arbolAVL.add(n3));
		assertTrue(arbolAVL.add(n4));
		assertTrue(arbolAVL.add(n2));
		assertTrue(arbolAVL.add(n5));
		assertTrue(arbolAVL.add(n6));
		
		System.out.println(arbolAVL.toString()); //Comprobamos por pantalla que sale bien.
		
		//Se crea un nuevo árbol para probar la ROTACIÓN SIMPLE IZQUIERDA
		AVLTree<Integer> arbolAVL2= new AVLTree<Integer>();
		
		assertTrue(arbolAVL2.add(n3));
		assertTrue(arbolAVL2.add(n2));
		assertTrue(arbolAVL2.add(n5));
		assertTrue(arbolAVL2.add(n1));
		assertTrue(arbolAVL2.add(n0));
		
		System.out.println(arbolAVL2.toString()); //Comprobamos por pantalla que sale bien.
		
		//Se crea otro nuevo árbol para probar la ROTACIÓN DOBLE IZQUIERDA
		AVLTree<Integer> arbolAVL3= new AVLTree<Integer>();
		
		assertTrue(arbolAVL3.add(n7));
		assertTrue(arbolAVL3.add(n1));
		assertTrue(arbolAVL3.add(n8));
		assertTrue(arbolAVL3.add(n0));
		assertTrue(arbolAVL3.add(n4));
		Integer n9= 9;
		assertTrue(arbolAVL3.add(n9));
		assertTrue(arbolAVL3.add(n3));
		assertTrue(arbolAVL3.add(n5));
		assertTrue(arbolAVL3.add(n2));
//		assertTrue(arbolAVL3.add(n6));
		
		System.out.println(arbolAVL3.toString()); //Comprobamos por pantalla que sale bien.
	}
	
//	@Test
	public void testRemove()
	{
		//Se añaden muchos nodos (SE PROBARÁ LA ROTACIÓN SIMPLE DERECHA)
		assertTrue(arbolAVL.add(n3));
		assertTrue(arbolAVL.add(n4));
		assertTrue(arbolAVL.add(n2));
		assertTrue(arbolAVL.add(n5));
		assertTrue(arbolAVL.add(n6));
		
		System.out.println(arbolAVL.toString());
		
		assertTrue(arbolAVL.remove(n6));
	}
	
//	@Test
	public void testRemoveUltimoNodo() 
	{
		assertTrue(arbolAVL.add(n3));
		assertTrue(arbolAVL.add(n5));
		assertTrue(arbolAVL.add(n2));
		assertTrue(arbolAVL.add(n6));
		assertTrue(arbolAVL.add(n7));
		System.out.println(arbolAVL.toString());
		
		assertTrue(arbolAVL.remove(n7));
		
		System.out.println(arbolAVL.toString());
	}


	@Test
	public void test_10_RotacionesSimplesIzquierdaAdd () 
	{
		
	}


	@Test
	public void test_10_RotacionesSimplesDerechaAdd()
	{
		
	}


	@Test
	public void test_10_RotacionesDoblesIzquierdaAdd() 
	{
		
	}


	@Test
	public void test_10_RotacionesDoblesDerechaAdd() 
	{
		
	}


	@Test
	public void test_3_RotacionesSimplesIzquierdaRemoveHijoDesequilibrado () 
	{
		
	}


	@Test
	public void test_3_RotacionesSimplesDerechaRemoveHijoDesequilibrado () 
	{
		
	}


	@Test
	public void test_3_RotacionesDoblesIzquierdaRemove () 
	{
		
	}


	@Test
	public void test_3_RotacionesDoblesDerechaRemove () 
	{
		
	}


	@Test
	public void test_3_RotacionesSimplesIzquierdaHijoEquilibrado () 
	{
		
	}


	@Test
	public void test_3_RotacionesSimplesDerechaHijoEquilibrado () 
	{
		
	}

}
