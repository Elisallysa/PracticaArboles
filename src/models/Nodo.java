package models;

import java.util.LinkedList;
import java.util.List;

public class Nodo {

	//ATRIBUTOS
	private String value;
	private List<Nodo> children;
	
	//CONSTRUCTOR
	public Nodo(String value) {
		super();
		this.value = value;
	}
	
	public Nodo(String value, List<Nodo> children) {
		super();
		this.value = value;
		this.children = new LinkedList<Nodo>();
	}
	
	//GETTERS & SETTERS
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
	
	//MÉTODOS
	public boolean esHoja() {
		return this.izq == null && this.dcha == null;
	}

	public boolean tieneHijosIzq(Nodo n) {
		return n.izq != null;
	}

	public boolean tieneHijosDcha(Nodo n) {
		return n.dcha != null;
	}

	public void preOrden(Nodo n) {
		System.out.print(n.valor + ",");
		if (tieneHijosIzq(n)) {
			preOrden(n.izq);
		}
		if (tieneHijosDcha(n)) {
			preOrden(n.dcha);
		}
	}

	public void postOrden(Nodo n) {

		if (tieneHijosIzq(n)) {
			postOrden(n.izq);
		}
		if (tieneHijosDcha(n)) {
			postOrden(n.dcha);
		}
		System.out.print(n.valor + ",");
	}

	public Nodo buscar(String valor) {
		if (this.valor.equals(valor)) {
			return this;
		}
		if (tieneHijosIzq(this)) {
			var n = this.izq.buscar(valor);
			if (n != null)
				return n;
		}
		if (tieneHijosDcha(this)) {
			var n = this.dcha.buscar(valor);
			if (n != null)
				return n;
		}
		return null;
	}

	public int profundidad(String valor, int prof) {
		//Buscar si yo soy ese nodo
		if (this.valor.equals(valor)) {
			return prof;
		}
		//Si tengo hijos por la izqda busco en prof por la izq
		//incrementando la prof.
		if (tieneHijosIzq(this)) {
			var n = this.izq.profundidad(valor, ++prof);
			if (n != -1) return n; //encontrado devuelvo prof actual
			else --prof; //no lo he encontrado resto prof
		}
		if (tieneHijosDcha(this)) {
			var n = this.dcha.profundidad(valor, ++prof);
			if (n != -1) return n;
			else --prof;
		}
		return -1;
	}
	
	//TO STRING
	@Override
	public String toString() {
		return "Nodo [value=" + value + ", children=" + children + "]";
	}
}
