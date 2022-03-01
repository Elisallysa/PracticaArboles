package models;

import java.util.ArrayList;
import java.util.Collections;

public class Arbol {

	// ATRIBUTOS
	private Nodo raiz;

	// CONSTRUCTOR
	public Arbol(Nodo raiz) {
		super();
		this.setRaiz(raiz);
	}

	// GETTERS & SETTERS
	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	// M�TODOS
	public void preOrden() {
		this.raiz.preOrden(raiz);
		System.out.println("");
	}

	public void postOrden() {
		this.raiz.postOrden(raiz);
		System.out.println("");
	}

	/**
	 * 
	 * @param valor
	 * @return
	 */
	public Nodo buscarNodo(String valor) {
		return this.raiz.buscarNodo(valor);
	}

	/**
	 * Inserta un nuevo nodo con el valor que se pasa por par�metro bajo el nodo
	 * padre si existe. Deber� buscar el nodo, y al encontrarlo, crear� un nodo hijo
	 * con ese valor y lo devuelve.
	 * 
	 * @param padre
	 * @param valor
	 * @return
	 */
	public Nodo insertarNodo(Nodo padre, String valor) {
		return this.raiz.insertarNodo(padre, valor);
	}
	
	public String path(String valor) {
		ArrayList<String> emptyPath = new ArrayList<String>();
		ArrayList<String> path = new ArrayList<String>();
		if (this.raiz.buscarNodo(valor) != null) {
			path = this.raiz.path(valor, emptyPath);
			Collections.reverse(path);
			return path.toString();
		}else
			return ("Este nodo no se encuentra en el �rbol.");
	}

//	public int profundidad(String valor) {
//		return this.raiz.profundidad(valor, 0);
//	}

	// TO STRING
	@Override
	public String toString() {
		return "Arbol [raiz=" + raiz + "]";
	}
}
