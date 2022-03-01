package models;

import java.util.ArrayList;
import java.util.Collections;

public class Arbol {

	// ATRIBUTOS
	private Nodo raiz;

	// CONSTRUCTOR
	/**
	 * Constructor del árbol que solo lleva como parámetro su Nodo raíz.
	 * 
	 * @param raiz - Nodo que representa la raíz del árbol
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

	// MÉTODOS
	/**
	 * Método que imprime la raíz del arbol y sus hijos de izquierda a derecha
	 * (entendiendo izquierda como el primer elemento de la lista de hijos y derecha
	 * como el último)
	 */
	public void preOrden() {
		this.raiz.preOrden(raiz);
		System.out.println("");
	}

	/**
	 * Método que imprime los subárboles de izquierda a derecha y por último la
	 * raíz.
	 */
	public void postOrden() {
		this.raiz.postOrden(raiz);
		System.out.println("");
	}

	/**
	 * Método que busca a lo largo del recorrido del Árbol si existe un nodo con ese
	 * valor.
	 * 
	 * @param valor del Nodo que se desea encontrar
	 * @return el Nodo que se busca; null si no se encuentra el Nodo
	 */
	public Nodo buscarNodo(String valor) {
		return this.raiz.buscarNodo(valor);
	}

	/**
	 * Método que inserta un nuevo nodo con el valor que se pasa por parámetro bajo
	 * el nodo padre si existe. Deberá buscar el nodo, y al encontrarlo, creará un
	 * nodo hijo con ese valor.
	 * 
	 * @param padre - Nodo que tendrá como hijo el Nodo que se desea insertar
	 * @param valor - Valor del Nodo que se insertará en los hijos del Nodo padre
	 * @return Nodo con el valor que hemos insertado; null si no existe el padre.
	 */
	public Nodo insertarNodo(Nodo padre, String valor) {
		return this.raiz.insertarNodo(padre, valor);
	}

	/**
	 * Método que devuelve la ruta o camino a seguir desde la raíz hasta un Nodo del
	 * árbol.
	 * 
	 * @param valor - Valor del Nodo del que se desea obtener la ruta
	 * @return una cadena de caracteres con la ruta desde la raíz hasta el Nodo con
	 *         el valor buscado; si no se encuentra un Nodo con ese valor, devolverá
	 *         un mensaje que lo comunique.
	 */
	public String path(String valor) {
		ArrayList<String> path = new ArrayList<String>(); // ArrayList que almacenará la ruta hasta el Nodo con el valor
															// introducido por parámetro
		if (this.raiz.buscarNodo(valor) != null) { // Comprueba que el valor que buscamos se encuentra en el árbol
			path = this.raiz.path(valor, path); // Se llama al método que devuelve un ArrayList con la ruta del Nodo -->
												// raíz
			Collections.reverse(path); // Invertimos el orden de raíz --> Nodo
			return path.toString(); // Devuelve el contenido del ArrayList en String
		} else
			return ("Este nodo no se encuentra en el árbol.");
	}

	/**
	 * Método que muestra todas las rutas de cada uno de los nodos siguiendo un
	 * recorrido de preOrden.
	 * 
	 * @param raiz - Nodo raíz del árbol
	 */
	public void mostrarArbol(Nodo raiz) {
		ArrayList<String> listaPreOrden = new ArrayList<String>(); // ArrayList vacío que almacenará los valores de los
																	// nodos del árbol en preOrden
		this.raiz.getNodes(raiz, listaPreOrden); // Se llama al método que obtiene los Nodos en preorden en un ArrayList
		for (int i = 0; i < listaPreOrden.size(); i++) {
			System.out.println(this.path(listaPreOrden.get(i))); // Se llama al método path para obtener la ruta de
																	// todos los Nodos del árbol
		}
	}

	// TO STRING
	@Override
	public String toString() {
		return "Arbol [raiz=" + raiz + "]";
	}
}
