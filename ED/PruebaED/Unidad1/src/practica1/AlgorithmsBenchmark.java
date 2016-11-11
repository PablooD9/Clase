package practica1;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;


public class AlgorithmsBenchmark {
	public final static int SLEEP_TIME= 250;
	private static Algoritmos algoritmos= new Algoritmos();
	
	/** Método que crea un fichero, y escribe en él unos valores.
	 * @param output es el nombre del fichero a escribir.
	 * @throws IOException lanza excepción si ocurre algo erróneo.
	 */
	public static void test0(String output) throws IOException{
		FileWriter file= null;
		PrintWriter pw= null;
		try{
		file= new FileWriter(output);
		pw= new PrintWriter(file);
		
		pw.println("1;10");
		pw.println("2;20");
		pw.println("3;30");
		pw.println("4;40");
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			if (file != null)
				file.close();
		}
	}
	
	/** Método que escribe en un fichero y calcula el tiempo de ejecución al invocar
	 * a otro método (de complejidad lineal, cuadrática, cúbica o logarítmica) con una carga
	 * de trabajo n.
	 * @param output es el nombre del fichero a escribir.
	 * @param n es la carga de trabajo.
	 * @throws IOException es la excepción lanzada si algo sale mal al abrir/cerrar el fichero.
	 */
	public static void test1(String output, int n) throws IOException{
		FileWriter file= null;
		PrintWriter pw= null;
		try{
			file= new FileWriter(output);
			pw= new PrintWriter(file);
			long tiempoInicio= System.currentTimeMillis(); //Recoge el tiempo
//			del ordenador (en milisegundos) en un momento INICIAL.
			algoritmos.linear(n);
			long tiempoFinal= System.currentTimeMillis(); //Recoge el tiempo
//			del ordenador (en milisegundos) en un momento FINAL.
			long tiempo= tiempoFinal-tiempoInicio; //Se resta el tiempo final
//			menos el inicial, y se obtiene el tiempo que ha tardado el ordenador
//			en ejecutar la operación linear2(10) (en milisegundos).
			pw.println(tiempo);
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			if (file != null)
				file.close();
		}
	}
	
	/** Método que escribe en un fichero y calcula el tiempo de ejecución al invocar
	 * a otro método (de complejidad lineal, cuadrática, cúbica o logarítmica) con una carga
	 * de trabajo que va desde startN hasta endN.
	 * @param output es el nombre del fichero a escribir.
	 * @param n es la carga de trabajo.
	 * @throws IOException es la excepción lanzada si algo sale mal al abrir/cerrar el fichero.
	 */
	public static void test2(String output, int startN, int endN) throws IOException{
		FileWriter file= null;
		PrintWriter pw= null;
		try{
			file= new FileWriter(output);
			pw= new PrintWriter(file);
			long tiempoInicio= System.currentTimeMillis(); //Recoge el tiempo
//			del ordenador (en milisegundos) en un momento INICIAL.
			algoritmos.linear3(startN, endN);
			long tiempoFinal= System.currentTimeMillis(); //Recoge el tiempo
//			del ordenador (en milisegundos) en un momento FINAL.
			long tiempo= tiempoFinal-tiempoInicio; //Se resta el tiempo final
//			menos el inicial, y se obtiene el tiempo que ha tardado el ordenador
//			en ejecutar la operación linear2(10) (en milisegundos).
			pw.println(tiempo);
		} catch (IOException e){
			e.printStackTrace();
		} finally{
			if (file != null)
				file.close();
		}
	}
	
	/** Método que escribe en un fichero y calcula el tiempo de ejecución al invocar
	 * a otro método (de complejidad lineal, cuadrática, cúbica o logarítmica) con una carga
	 * de trabajo que va desde startN hasta endN, y repite la ejecución del método 
	 * el número de veces que diga el parámetro "veces". Esto sirve para conseguir una mejor
	 * media.
	 * @param output es el nombre del fichero a escribir.
	 * @param n es la carga de trabajo.
	 * @throws IOException es la excepción lanzada si algo sale mal al abrir/cerrar el fichero.
	 */
	public void test3(String salida, int veces, int startN, int endN) throws IOException{
		FileWriter file= null;
		PrintWriter pw;
		try{
			file= new FileWriter(salida);
			pw= new PrintWriter(file);
			for (int workLoad= startN; workLoad < endN; workLoad++){
				long startTime= System.currentTimeMillis();
				for (int time=0; time < veces; time++)
					algoritmos.linear(workLoad);
				long tiempoFinal= System.currentTimeMillis();
				long tiempo= (tiempoFinal-startTime) / veces;
				pw.println(workLoad + ";" + tiempo);
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			if (file != null)
				file.close();
		}
	}
	
	public long testAlgorithm(String className, String methodName, int n)
	{
		long tInicial=0, tFinal=0;
		
		Class<?> cl;
		try
		{
			cl= Class.forName(className);
			Object o= cl.newInstance();
			Method m= cl.getMethod(methodName, int.class);
			
			tInicial= System.currentTimeMillis();
			m.invoke(o, n);
			tFinal= System.currentTimeMillis();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return tFinal - tInicial;
	}
	
	public void test(String output, int times, int startN, int endN, String className, String methodName) throws IOException
	{
		FileWriter file= null;
		PrintWriter pw;
		
		try{
			file= new FileWriter(output);
			pw= new PrintWriter(file);
			
			for (int workLoad= startN; workLoad < endN; workLoad++)
			{
				long tiempo= 0;
				long media= 0;
				for (int time=0; time < times; time++)
				{
					tiempo= testAlgorithm(className, methodName, workLoad);
				}
				media= tiempo/times;
				pw.println(workLoad+ ";" +media);
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			if (file != null)
				file.close();
		}
	}
}
