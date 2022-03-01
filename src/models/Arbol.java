package models;

import java.util.ArrayList;
import java.util.Collections;

public class Arbol {

	// ATRIBUTOS
	private Nodo raiz;

	// CONSTRUCTOR
	/**
	 * Constructor del �rbol que solo lleva como par�metro su Nodo ra�z.
	 * 
	 * @param raiz - Nodo que representa la ra�z del �rbol
	 */
	public Arbol(Nodo raiz) {
		super();
		this.raiz = raiz;
	}

	// GETTERS & SETTERS
	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	// M�TODOS
	/**
	 * M�todo que imprime la ra�z del arbol y sus hijos de izquierda a derecha
	 * (entendiendo izquierda como el primer elemento de la lista de hijos y derecha
	 * como el �ltimo)
	 */
	public void preOrden() {
		this.raiz.preOrden(raiz);
		System.out.println("");
	}

	/**
	 * M�todo que imprime los sub�rboles de izquierda a derecha y por �ltimo la
	 * ra�z.
	 */
	public void postOrden() {
		this.raiz.postOrden(raiz);
		System.out.println("");
	}

	/**
	 * M�todo que busca a lo largo del recorrido del �rbol si existe un nodo con ese
	 * valor.
	 * 
	 * @param valor del Nodo que se desea encontrar
	 * @return el Nodo que se busca; null si no se encuentra el Nodo
	 */
	public Nodo buscarNodo(String valor) {
		return this.raiz.buscarNodo(valor);
	}

	/**
	 * M�todo que inserta un nuevo nodo con el valor que se pasa por par�metro bajo
	 * el nodo padre si existe. Deber� buscar el nodo, y al encontrarlo, crear� un
	 * nodo hijo con ese valor.
	 * 
	 * @param padre - Nodo que tendr� como hijo el Nodo que se desea insertar
	 * @param valor - Valor del Nodo que se insertar� en los hijos del Nodo padre
	 * @return Nodo con el valor que hemos insertado; null si no existe el padre.
	 */
	public Nodo insertarNodo(Nodo padre, String valor) {
		return this.raiz.insertarNodo(padre, valor);
	}

	/**
	 * M�todo que devuelve la ruta o camino a seguir desde la ra�z hasta un Nodo del
	 * �rbol.
	 * 
	 * @param valor - Valor del Nodo del que se desea obtener la ruta
	 * @return una cadena de caracteres con la ruta desde la ra�z hasta el Nodo con
	 *         el valor buscado; si no se encuentra un Nodo con ese valor, devolver�
	 *         un mensaje que lo comunique.
	 */
	public String path(String valor) {
		ArrayList<String> path = new ArrayList<String>(); // ArrayList que almacenar� la ruta hasta el Nodo con el valor
															// introducido por par�metro
		if (this.raiz.buscarNodo(valor) != null) { // Comprueba que el valor que buscamos se encuentra en el �rbol
			path = this.raiz.path(valor, path); // Se llama al m�todo que devuelve un ArrayList con la ruta del Nodo -->
												// ra�z
			Collections.reverse(path); // Invertimos el orden de ra�z --> Nodo
			return path.toString(); // Devuelve el contenido del ArrayList en String
		} else
			return ("Este nodo no se encuentra en el �rbol.");
	}

	/**
	 * M�todo que muestra todas las rutas de cada uno de los nodos siguiendo un
	 * recorrido de preOrden.
	 * 
	 * @param raiz - Nodo ra�z del �rbol
	 */
	public void mostrarArbol(Nodo raiz) {
		ArrayList<String> listaPreOrden = new ArrayList<String>(); // ArrayList vac�o que almacenar� los valores de los
																	// nodos del �rbol en preOrden
		this.raiz.getNodes(raiz, listaPreOrden); // Se llama al m�todo que obtiene los Nodos en preorden en un ArrayList
		for (int i = 0; i < listaPreOrden.size(); i++) {
			System.out.println(this.path(listaPreOrden.get(i))); // Se llama al m�todo path para obtener la ruta de
																	// todos los Nodos del �rbol
		}
	}

	// TO STRING
	@Override
	public String toString() {
		return "Arbol [raiz=" + raiz + "]";
	}
}
