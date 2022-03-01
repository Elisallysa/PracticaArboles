package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Nodo {

	// ATRIBUTOS
	private String value;
	private List<Nodo> children;

	// CONSTRUCTOR
	public Nodo(String value) {
		super();
		this.value = value;
	}

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

	// MÉTODOS
	public boolean isLeave() {
		return this.children.isEmpty();
	}

	public boolean hasChildren() {
		return !this.children.isEmpty();
	}

	public void preOrden(Nodo n) {
		System.out.print(n.value + ",");
		if (n.hasChildren()) {
			for (int i = 0; i < n.children.size(); i++) {
				preOrden(n.children.get(i));
			}
		}
	}

	public void postOrden(Nodo n) {

		if (n.hasChildren()) {
			for (int i = 0; i < n.children.size(); i++) {
				postOrden(n.children.get(i));
			}
		}
		System.out.print(n.value + ",");
	}

	/**
	 * Busca a lo largo del recorrido del árbol si existe un nodo con ese valor. Si
	 * lo encuentra, lo devuelve (el nodo en sí). Si no lo encuentra en todo el
	 * árbol devuelve null.
	 * 
	 * @param valor - Cadena de caracteres que almacena el Nodo a buscar
	 * @return Nodo que contiene el valor que se busca; null si no se encuentra el
	 *         Nodo con el valor que se busca
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
	 * 
	 * @param padre
	 * @param valor
	 * @return
	 */
	public Nodo insertarNodo(Nodo padre, String valor) {
		if (this.equals(padre)) {
			padre.children.add(new Nodo (valor, null));
		}
		if (!this.equals(padre)) {
			for (int i = 0; i < this.children.size(); i++) {
				this.children.get(i).insertarNodo(padre, valor);
			}
		}
		return null;
	}

	public ArrayList<String> path(String valor, ArrayList<String> path) {
		
		if (this.hasChildren()) {
			for (int i = 0; i < this.children.size(); i++) {
				if (this.children.get(i).buscarNodo(valor) != null && !this.children.get(i).value.equals(valor)) {
					this.children.get(i).path(valor, path);
					path.add(this.value);
				} 
				if (this.children.get(i).value.equals(valor)) {
					path.add(this.children.get(i).value);
					path.add(this.value);
				}
				
			}
			
		} return path;
	}
	
//	public int profundidad(String valor, int prof) {
//		//Buscar si yo soy ese nodo
//		if (this.valor.equals(valor)) {
//			return prof;
//		}
//		//Si tengo hijos por la izqda busco en prof por la izq
//		//incrementando la prof.
//		if (tieneHijosIzq(this)) {
//			var n = this.izq.profundidad(valor, ++prof);
//			if (n != -1) return n; //encontrado devuelvo prof actual
//			else --prof; //no lo he encontrado resto prof
//		}
//		if (tieneHijosDcha(this)) {
//			var n = this.dcha.profundidad(valor, ++prof);
//			if (n != -1) return n;
//			else --prof;
//		}
//		return -1;
//	}

	// TO STRING
	@Override
	public String toString() {
		return "Nodo [value=" + value + ", children=" + children + "]";
	}
}
