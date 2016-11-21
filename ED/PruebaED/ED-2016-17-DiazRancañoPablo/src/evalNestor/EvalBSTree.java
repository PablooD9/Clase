//  NO MODIFICAR NOMBRE DE ESTE PAQUETE, crear un paquete nuevo (si no existe ya) en vuestro proyecto que se llame así: "evalNestor"
//  y meted en él esta clase
package evalNestor;

// SUSTITUIR el nombre del paquete donde estén BSTree y AVLTree (import de debajo) por el paquete vuestro de árboles
import arbolesUO251017.*;

public class EvalBSTree <T extends Comparable<T>> extends BSTree <T> {

	public String getNombreFicheroAlumno(){
		// Poned vuestros apellidos, nombre y UO; sustituyendolos en el return de debajo...
		return "Ev-Intermedia-Arboles-BST-Apellido1Apellido2Nombre-UOxxxx";
	}

	public EvalBSTree() {
		super();
	}
	
	public EvalBSTree(T[] serie)  {
		super();
		setRaiz(reconstruirArbolBST(0, serie));
	}

	
	private BSTNode<T> reconstruirArbolBST(int i, T[] serie) {
		if (i<serie.length && serie[i]!=null) {
			BSTNode<T> r = new BSTNode<T>(serie[i]);
			r.setLeft(reconstruirArbolBST(i*2+1, serie));
			r.setRight(reconstruirArbolBST(i*2+2, serie));
			return r;
		}
		return null;
	}	
	
}
