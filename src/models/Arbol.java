package models;

public class Arbol {
	
	//ATRIBUTOS
	private Nodo raiz;
	
	//CONSTRUCTOR
	public Arbol(Nodo raiz) {
		super();
		this.setRaiz(raiz);
	}

	//GETTERS & SETTERS
	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	
	//MÉTODOS
	public void preOrden() {
		this.raiz.preOrden(raiz);
	}
	
	public void postOrden() {
		this.raiz.postOrden(raiz);
	}
	
	public Nodo buscar(String valor) {
		return this.raiz.buscar(valor);
	}
	
	public int profundidad(String valor) {
		return this.raiz.profundidad(valor, 0);
	}
	
	//TO STRING
	@Override
	public String toString() {
		return "Arbol [raiz=" + raiz + "]";
	}
}
