package practica1;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class AlgorithmsBenchmarkTest {

	private AlgorithmsBenchmark benchmark;
	private Algoritmos algoritmos;

	@Before
	public void setUp() 
	{
		benchmark= new AlgorithmsBenchmark();
		algoritmos= new Algoritmos();
	}
	
	@Test
	public void testA() throws IOException //Tests para el apartado A de la tarea (generaci�n de tiempos
						//y sus respectivas gr�ficas para los algoritmos linear, quadratic,
						//cubic y logarithmic).
	{
	//Los par�metros del m�todo test son los siguientes (separados cada uno por una coma):
	//test(fichero de salida, veces que se lleva a cabo la ejecuci�n por cada n, en qu� n empieza, 
	//en qu� n acaba, nombre de la clase donde est� el m�todo a ejecutar, nombre del m�todo).
		
		benchmark.test("testLinear.csv", 3, 0, 6, "practica1.Algoritmos", "linear");
		benchmark.test("testQuadratic.csv", 3, 0, 6, "practica1.Algoritmos", "quadratic");
		benchmark.test("testCubic.csv", 3, 0, 6, "practica1.Algoritmos", "cubic");	
		benchmark.test("testLogarithmic.csv", 3, 0, 6, "practica1.Algoritmos", "logarithmic");
	}
	
	@Test
	public void testB() throws IOException //Tests para el apartado B de la tarea (generaci�n de tiempos
						//y sus respectivas gr�ficas para los algoritmos pow2Iter, pow2Rec1, pow2Rec2,
						//pow2Rec3 y pow2Rec4).
	{
		benchmark.test("testPow2Iter.csv", 3, 0, 4, "practica1.Algoritmos", "pow2iter");
		benchmark.test("testPow2Rec1.csv", 3, 0, 4, "practica1.Algoritmos", "pow2rec1");
		benchmark.test("testPow2Rec2.csv", 3, 0, 4, "practica1.Algoritmos", "pow2rec2");
		benchmark.test("testPow2Rec3.csv", 3, 0, 4, "practica1.Algoritmos", "pow2rec3");
		benchmark.test("testPow2Rec4.csv", 3, 0, 4, "practica1.Algoritmos", "pow2rec4");
	}

	@Test
	public void testC() //Tests para el apartado C de la tarea (comprobar que los algoritmos
	//pow2Iter, pow2Rec1, pow2Rec2, pow2Rec3 y pow2Rec4 cumplen su funci�n y devuelven el valor
	//correcto).
	{
		//linear:
		assertEquals(algoritmos.linear(3), 3);
		assertEquals(algoritmos.linear(0), 0);
		try
		{
			algoritmos.linear(-1);
		} catch (IllegalStateException ise)
		{
			assertEquals(ise.getMessage(), "Par�metro incorrecto");
		}
		
		//Quadratic:
		assertEquals(algoritmos.quadratic(0), 0);
		assertEquals(algoritmos.quadratic(1), 1);
		assertEquals(algoritmos.quadratic(2), 4);
		assertEquals(algoritmos.quadratic(3), 9);
		try
		{
			algoritmos.quadratic(-1);
		} catch (IllegalStateException ise)
		{
			assertEquals(ise.getMessage(), "Par�metro incorrecto");
		}
		
		//Cubic:
		assertEquals(algoritmos.cubic(0), 0);
		assertEquals(algoritmos.cubic(1), 1);
		assertEquals(algoritmos.cubic(2), 8);
		try
		{
			algoritmos.cubic(-1);
		} catch (IllegalStateException ise)
		{
			assertEquals(ise.getMessage(), "Par�metro incorrecto");
		}
		
		//Fact:
		assertEquals(algoritmos.fact(4), 24);
		assertEquals(algoritmos.fact(3), 6);
		assertEquals(algoritmos.fact(2), 2);
		assertEquals(algoritmos.fact(1), 1);
		assertEquals(algoritmos.fact(0), 1);
		try
		{
			algoritmos.fact(-1);
		} catch (IllegalStateException ise)
		{
			assertEquals(ise.getMessage(), "Par�metro incorrecto");
		}
	
//		//Pow2Iter:
		for (int i=1; i < 5; i++)
		{
			assertEquals(algoritmos.pow2iter(i), Math.pow(2, i), 0.5);
			// Explicar en el documento c�mo funciona el m�todo pow(double n�mero, double
			// exponente)
		}
		assertEquals(algoritmos.pow2iter(0), 1);
		
//		//Pow2Rec1:
		for (int i=1; i < 5; i++)
		{
			assertEquals(algoritmos.pow2rec1(i), Math.pow(2, i), 0.5);
		}
		assertEquals(algoritmos.pow2rec1(0), 1);
		
//		//Pow2Rec2:
		for (int i=1; i < 5; i++)
		{
			assertEquals(algoritmos.pow2rec2(i), Math.pow(2, i), 0.5);
		}
		assertEquals(algoritmos.pow2rec2(0), 1);
		
//		//Pow2Rec3:
		for (int i=1; i < 5; i++)
		{
			assertEquals(algoritmos.pow2rec3(i), Math.pow(2, i), 0.5);
		}
		assertEquals(algoritmos.pow2rec3(0), 1);
	
//		//Pow2Rec4:
		for (int i=1; i < 5; i++)
		{
			assertEquals(algoritmos.pow2rec4(i), Math.pow(2, i), 0.5);
		}
		assertEquals(algoritmos.pow2rec4(0), 1);
	}

}
