//  NO MODIFICAR NOMBRE DE ESTE PAQUETE, crear un paquete nuevo en vuestro proyecto que se llame así: "evalNestor"
//  y meted en él esta clase
package evalNestor;

//SUSTITUIR el nombre del paquete donde está Graph (import de debajo) por el paquete vuestro de grafos
import grafosUO251017.Graph;

public class EvalGraph<T> extends Graph<T> {

	public EvalGraph(int i) {
		super(i);
	}
	
	public EvalGraph(int i,T initialNodes[], boolean[][] initialEdges, double [][] initialWeights, double [][] initialAfloyd, int [][] initialPfloyd){
		super(i,initialNodes,initialEdges,initialWeights,initialAfloyd,initialPfloyd);
	}
	
	public String getNombreFicheroAlumno(){
		// Poned vuestros apellidos, nombre y UO; sustituyendolos en el return de debajo...
		return "Ev-Intermedia-Grafos-DiazRancañoPablo-UO251017";
	}
}
