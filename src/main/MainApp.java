package main;

import java.util.LinkedList;

import models.Arbol;
import models.Nodo;


public class MainApp {
	public static void main(String[] args) {
	
	// Se crean los nodos del árbol
	Nodo fantasma = new Nodo ("fantasma", null);
	Nodo n10 = new Nodo ("seis", null);
	Nodo n9 = new Nodo ("cinco", null);
	Nodo n8 = new Nodo ("cuatro", null);
	Nodo n7 = new Nodo ("tres", null);	
	Nodo n6 = new Nodo ("dos", null);	
	Nodo n5 = new Nodo ("uno", null);
	Nodo n4 = new Nodo ("ternera", null);
	Nodo n3 = new Nodo ("cerdo", null);
	Nodo n2 = new Nodo ("pollo", null);
	Nodo root = new Nodo ("~", null);
	
	/*
	 * Estructura del árbol:
	 *             	 ~
	 *        /      |      \ 
	 *   pollo     cerdo     ternera
	 *   /   \       |          | 
	 * uno   dos    tres      cuatro 
	 *        |	
	 *      cinco
	 *        |
	 *       seis
	 */
	
	// Se añaden los nodos correspondientes a la lista de hijos de los nodos con hijos
	root.getChildren().add(n2);
	root.getChildren().add(n3);
	root.getChildren().add(n4);
	n2.getChildren().add(n5);
	n2.getChildren().add(n6);
	n3.getChildren().add(n7);
	n4.getChildren().add(n8);
	n6.getChildren().add(n9);
	n9.getChildren().add(n10);
	
	// Creamos un árbol con su raíz
	Arbol tree = new Arbol(root);
	
	// Recorrido del árbol
	System.out.println("- Recorrido del árbol en preOrden:");
	tree.preOrden();
	System.out.println("");
	System.out.println("- Recorrido del árbol en postOrden:");
	tree.postOrden();
	System.out.println("");
	
	// MÉTODOS
	// Nodo buscarNodo(String valor)
	System.out.println("- Buscamos el nodo con valor 'cinco' en el arbol y lo mostramos por pantalla:");
	System.out.println(tree.buscarNodo("cinco"));
	System.out.println("- Si buscamos un valor que no tiene ningún nodo del árbol, muestra null:");
	System.out.println(tree.buscarNodo("perro")+"\n");
	// Nodo insertarNodo(Nodo padre, String valor)
	// Conel método insertarNodo insertamos un hijo más al nodo n3
	System.out.println("- Después de insertar un nuevo nodo hijo 'NUEVO' en el nodo n3 ('cerdo'): "+tree.insertarNodo(n3, "NUEVO"));
	System.out.print("Recorrido del árbol en preOrden: ");
	tree.preOrden();
	System.out.println("- Si intentamos insertar un Nodo hijo en un nodo padre que no existe: "+tree.insertarNodo(fantasma, "NUEVO")+"\n");
	// String path(String valor)
	System.out.println("- Mostrar por pantalla el recorrido hasta el nodo 10 ('seis'):");
	System.out.println(tree.path("seis"));
	System.out.println("- Recorrido de un nodo que no existe: "+tree.path("no existe")+"\n");
	// void mostrarArbol()
	System.out.println("- Mostrar todos los recorridos de todos los nodos en preOrden:");
	tree.mostrarArbol(root);
	
	}
	}
