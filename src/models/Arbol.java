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
}
