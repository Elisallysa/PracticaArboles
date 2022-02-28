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
	public void preOrden(Nodo n) {
		
	}
	
	//TO STRING
	@Override
	public String toString() {
		return "Nodo [value=" + value + ", children=" + children + "]";
	}
}
