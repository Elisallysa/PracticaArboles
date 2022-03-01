package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Nodo {

	// ATRIBUTOS
	// Cadena de caracteres con el valor del Nodo
	private String value;
	// Lista de Nodos hijos
	private List<Nodo> children;

	// CONSTRUCTOR
	/**
	 * Constructor de Nodo que solo tiene como par�metro el valor del mismo Nodo
	 * 
	 * @param value - Cadena de caracteres con el valor del Nodo
	 */
	public Nodo(String value) {
		super();
		this.value = value;
	}

	/**
	 * Constructor de Nodo con su valor y una lista de Nodos hijos como par�metros
	 * 
	 * @param value    - Cadena de caracteres con el valor del Nodo
	 * @param children - Lista de Nodos hijos del Nodo
	 */
	public Nodo(String value, List<Nodo> children) {
		super();
		this.value = value;
		this.children = new LinkedList<Nodo>();
	}

	// GETTERS & SETTERS
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Nodo> getChildren() {
		return children;
	}

	public void setChildren(LinkedList<Nodo> children) {
		this.children = children;
	}

	// M�TODOS
	/**
	 * M�todo que comprueba si el Nodo es hoja o rama.
	 * 
	 * @return true si es hoja; false si es rama
	 */
	public boolean isLeave() {
		return this.children.isEmpty();
	}

	/**
	 * M�todo que comprueba si el Nodo tiene Nodos hijos o no.
	 * 
	 * @return true si el Nodo tiene hijos; false si el Nodo no tiene hijos
	 */
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}

	/**
	 * M�todo que imprime la estructura del �rbol desde un Nodo n en orden: ra�z -->
	 * sub�rbol izquierdo --> sub�rbol derecho (siendo la izquierda el primer
	 * sub�rbol almacenado en la listas de Nodos hijos, y el derecho el �ltimo
	 * almacenado)
	 * 
	 * @param n - Nodo que se imprime y posteriormente se recorren sus hijos para
	 *          hacer el preOrden de sus Nodos hijos de forma recursiva
	 */
	public void preOrden(Nodo n) {
		System.out.print(n.value + ","); // Imprime el valor del Nodo n introducido por par�metro
		if (n.hasChildren()) {
			for (int i = 0; i < n.children.size(); i++) {
				preOrden(n.children.get(i)); // Recorre los hijos y recorre el arbol en preOrden de forma recursiva
			}
		}
	}

	/**
	 * M�todo que imprime la estructura del �rbol desde un Nodo en orden -->
	 * sub�rbol izquierdo --> subarbol derecho --> ra�z (siendo el izquierdo el
	 * primer sub�rbol almacenado en las listas de Nodos hijos, y el derecho el
	 * �ltimo).
	 * 
	 * @param n - Nodo n del que se obtiene la lista de sus Nodos hijos para
	 *          recorrerlos en postOrden de forma recursiva. Cuando llega a un Nodo
	 *          sin m�s hijos, lo imprime.
	 */
	public void postOrden(Nodo n) {
		if (n.hasChildren()) {
			for (int i = 0; i < n.children.size(); i++) {
				postOrden(n.children.get(i));
			}
		}
		System.out.print(n.value + ",");
	}

	/**
	 * Busca a lo largo del recorrido del �rbol si existe un nodo con ese valor. Si
	 * lo encuentra, lo devuelve (el nodo en s�). Si no lo encuentra en todo el
	 * �rbol devuelve null.
	 * 
	 * @param valor - Cadena de caracteres que almacena el Nodo a buscar
	 * @return Nodo que contiene el valor que se busca; null si no se encuentra
	 */
	public Nodo buscarNodo(String valor) {
		if (this.value.equals(valor)) {
			return this;
		}
		if (this.hasChildren()) {
			for (int i = 0; i < this.children.size(); i++) {
				var n = this.children.get(i).buscarNodo(valor);
				if (n != null)
					return n;
			}
		}
		return null;
	}

	/**
	 * M�todo que inserta un nuevo nodo con el valor que se pasa por par�metro bajo
	 * el nodo padre.
	 * 
	 * @param padre - Nodo que recibir� en su lista de Nodos hijos un nuevo Nodo.
	 * @param valor - Valor del Nodo que recibir� el Nodo padre en su lista de Nodos
	 *                hijos
	 * @return el Nodo insertado; null si no se ha insertado
	 */
	public Nodo insertarNodo(Nodo padre, String valor) {
		Nodo nuevo = new Nodo(valor, null);
		if (this.equals(padre)) {
			padre.children.add(nuevo);
		}
		if (!this.equals(padre)) {
			for (int i = 0; i < this.children.size(); i++) {
				this.children.get(i).insertarNodo(padre, valor);
			}
		}
		return padre.buscarNodo(valor);
	}

	/**
	 * M�todo que devuelve el recorrido desde un Nodo con un valor buscado a la
	 * ra�z.
	 * 
	 * @param valor - El valor del Nodo que se busca en el �rbol
	 * @param path  - ArrayList en el que se ir�n almacenando los Nodos desde el
	 *                Nodo buscado hasta la ra�z
	 * @return ArrayList con los Nodos desde el Nodo buscado hasta la ra�z
	 */
	public ArrayList<String> path(String valor, ArrayList<String> path) {

		if (this.hasChildren() && !this.value.equals(valor)) { // Busca en los hijos del Nodo desde el que se busca
			for (int i = 0; i < this.children.size(); i++) {
				// Descarta los sub�rboles que no contienen el Nodo con el valor buscado:
				if (this.children.get(i).buscarNodo(valor) != null && !this.children.get(i).value.equals(valor)) {
					this.children.get(i).path(valor, path); // Busca el Nodo con el valor buscado de forma recursiva en
															// cada sub�rbol.
					path.add(this.value);
				}
				if (this.children.get(i).value.equals(valor)) {
					path.add(this.children.get(i).value);
					path.add(this.value);
				}
			}
		}

		if (this.hasChildren() && this.value.equals(valor)) { // Para el caso en el que se busque la ruta de la misma
																// ra�z del �rbol
			path.add(this.value); // A�ade al ArrayList solo el valor de la ra�z
		}

		return path;
	}

	/**
	 * Devuelve los Nodos de un �rbol recorri�ndolo en preOrden.
	 * 
	 * @param n             - Nodo desde el que se recorre el �rbol en preOrden
	 * @param listaPreOrden - ArrayList donde se almacena el valor de los Nodos del
	 *                        �rbol
	 */
	public void getNodes(Nodo n, ArrayList<String> listaPreOrden) {
		listaPreOrden.add(n.value);
		if (n.hasChildren()) {
			for (int i = 0; i < n.children.size(); i++) {
				getNodes(n.children.get(i), listaPreOrden);
			}
		}
	}

	// TO STRING
	@Override
	public String toString() {
		return "Nodo [value=" + value + ", children=" + children + "]";
	}
}
