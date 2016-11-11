package practica1;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;


public class Algoritmos {
	public final static int SLEEP_TIME= 100;
	public final static int CUBIC= 3;
	public final static int MIN_VALUE= 0;
	
	/** Método usado para hallar el tiempo de ejecución de una determinada carga de trabajo n
	 * para una complejidad lineal.
	 *
	 * @param n es la carga de trabajo.
	 */
	public int linear(int n)
	{
		if (n >= MIN_VALUE)
		{
			int m= 0;
			for (int i=0; i<n; i++)
			{
				doNothing();
				m++;
			}
			return m;
		}
		else
			throw new IllegalStateException("Parámetro incorrecto");
	}
	
	/** Método usado para mostrar por pantalla, con una complejidad O(n), cómo funciona
	 * la complejidad lineal.
	 * @param n es la carga de trabajo.
	 */
	public void linear2(int n)
	{
		for (int i=0; i<n; i++)
			System.out.println(i);
	}
	
	/** Método usado para hallar el tiempo de ejecución de una determinada carga de trabajo n
	 * para una complejidad lineal, entre una carga de trabajo de valor startN, hasta otra
	 * de valor endN.
	 * @param startN es la carga de trabajo 1.
	 * @param endN es la carga de trabajo 2, y se resta a startN.
	 */
	public void linear3(int startN, int endN)
	{
		if ((startN <= endN) && ((startN >= MIN_VALUE)
											&& (endN >= MIN_VALUE+1)))
		{
			for (int i=startN; i<endN; i++)
				doNothing();
		}
		else
			throw new IllegalArgumentException("Parámetros incorrectos");
	}
	
	
	/** Método que pausa el hilo de ejecución del sistema durante un determinado tiempo
	 * (en milisegundos). En este caso, simulando a un procesador, se detiene 250 ms.
	 * @return 0 si se hace con éxito; -1 si no.
	 */
	public int doNothing()
	{
		try
		{
			Thread.sleep(SLEEP_TIME);
			return 0;
		} catch (InterruptedException e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	/** Método usado para hallar el tiempo de ejecución de una determinada carga de trabajo n
	 * para una complejidad logarítmica.
	 * @param n es la carga de trabajo.
	 */
	public void logarithmic(int n)
	{
		if (n >= MIN_VALUE)
		{
			for (int i=1; i<n+1; i*=2)
			{
				doNothing();
			}
		}
		else
			throw new IllegalStateException("Parámetro incorrecto");
	}
	
	/**Método usado para hallar el tiempo de ejecución de una determinada carga de trabajo n
	 * para una complejidad logarítmica, entre una carga de trabajo de valor startN, hasta otra
	 * de valor endN.
	 * @param startN es la carga de trabajo 1.
	 * @param endN es la carga de trabajo 2, la cual se resta con startN.
	 */
	public void logarithmic2(int startN, int endN)
	{
		if ((startN>=MIN_VALUE+1 && endN >=MIN_VALUE+2) && (endN >= startN))
		{
			for (int i=startN; i<endN; i++)
			{
				doNothing();
			}
		}
		else
			throw new IllegalStateException("Parámetros incorrectos");
	}
	
	/**Método usado para hallar el tiempo de ejecución de una determinada carga de trabajo n
	 * para una complejidad cuadrática, entre una carga de trabajo de valor startN, hasta otra
	 * de valor endN.
	 * @param n es la carga de trabajo.
	 */
	public int quadratic (int n)
	{
		if (n >= MIN_VALUE)
		{
			int m= 0;
			for (int i=0;i<n;i++)
			{
				for (int j=0;j<n;j++)
				{
					doNothing();
					m++;	
				}
			 }
			return m;
		}
		else
			throw new IllegalStateException("Parámetro incorrecto");
	}
	
	/**Método usado para hallar el tiempo de ejecución de una determinada carga de trabajo n
	 * para una complejidad cuadrática (O(n^2)), entre una carga de trabajo de valor startN, hasta otra
	 * de valor endN.
	 * @param startN es la carga de trabajo 1.
	 * @param endN es la carga de trabajo 2, la cual se resta a startN.
	 */
	public void quadratic2 (int startN, int endN)
	{
		if ((startN <= endN) && ((startN >= MIN_VALUE)
				&& (endN >= MIN_VALUE+1)))
		{
			for (int i=startN; i<endN; i++)
			{
				for (int j=startN; j<endN; j++)
				{
					doNothing();
				}
			}
		}
		else
			throw new IllegalStateException("Parámetros incorrectos");
	}
	
	/**Método usado para hallar el tiempo de ejecución de una determinada carga de trabajo n
	 * para una complejidad cúbica.
	 * @param n es la carga de trabajo.
	 */
	public int cubic(int n)
	{
		if (n >= MIN_VALUE)
		{
			int m= MIN_VALUE;
			for (int i=0;i<n;i++)
			{
				for (int j=0;j<n;j++)
				{
					for (int k=0; k<n; k++)
					{
						doNothing();
						m++;
					}
				}
			 }
			return m;
		}
		else
			throw new IllegalStateException("Parámetro incorrecto");
	}
	
	/**Método usado para hallar el tiempo de ejecución de una determinada carga de trabajo n
	 * para una complejidad cúbica, entre una carga de trabajo de valor startN, hasta otra
	 * de valor endN.
	 * @param startN es la carga de trabajo 1.
	 * @param endN es la carga de trabajo 2, la cual se resta a startN.
	 */
	public void cubic2(int startN, int endN)
	{
		if ((endN >= startN) && ((startN >= MIN_VALUE)
				&& (endN >= MIN_VALUE+1)))
		{
			for (int i=startN; i<endN; i++)
			{
				for (int j=startN; j<endN; j++)
				{
					for (int k=startN; k<endN; k++)
					{
						doNothing();
					}
				}
			}
		}
		else
			throw new IllegalStateException("Parámetros incorrectos");
	}

	public long pow2iter(int n)
	{
		if (n==MIN_VALUE)
		{
			return 1;
		}
		
		else if (n<MIN_VALUE)
		{
			int num1= 2;
			for (int i=1; i < n; i++)
			{
				num1*=2;
				doNothing();
			}
			return 1/num1;
		}
		
		else
		{
			int num2= 2;
			for (int i=1; i < n; i++)
			{
				num2*=2;
				doNothing();
			}
			return num2;
		}
		
	}
	
	public long fact(int n)
	{
		if (n >= MIN_VALUE)
		{
			if (n == MIN_VALUE)
			{
				return 1;
			}
			
			else if (n==1)
			{
				return 1;
			}
			
			else
			{
				int m= n-1;
				while (m != 1)
				{
					n*=m;
					m--;
				}
			}
				return n;
		}
		else
			throw new IllegalStateException("Parámetro incorrecto");
	}
	
	public long factRec(int n)
	{
		if (n==1)
		{
			return 1;
		}
		else
		{
			return n* factRec(n-1);
		}
	}
	
	//Hay que hacer pruebas JUnit desde fact(int n) hacia adelante.
	
	public long pow2rec1 (int n)
	{
			doNothing();
			if (n== MIN_VALUE)
			{
				return 1;
			}
			else
			{
				return 2* pow2rec1(n-1);
			}
	}
	
	public long pow2rec2 (int n)
	{
		doNothing();
		if (n== MIN_VALUE)
		{
			return 1;
		}
		else
		{
			long a= pow2rec2(n-1) + pow2rec2(n-1);
			return a;
		}
	}
	
	public long pow2rec3 (int n)
	{
		doNothing();
		if (n== MIN_VALUE)
		{
			return 1;
		}
		else if (n%2 == MIN_VALUE)
		{
			return pow2rec3(n/2) * pow2rec3(n/2);
		}
		else
		{
			return pow2rec3(n/2) * pow2rec3(n/2) * 2;
		}
	}
	
	public long pow2rec4 (int n)
	{
		doNothing();
		
		if (n== MIN_VALUE) //Primero comprueba si n es 0.
		{
			return 1;
		}
		
		long aux= pow2rec4(n/2); //Si n != 0, se divide entre 2. Una vez que sea
								 //cero, retornará 1. Si no, seguirá.
		if (n%2 == MIN_VALUE)
		{
			return aux*aux;
		}
		
		else
		{
			return 2*aux*aux;
		}
	}

}
