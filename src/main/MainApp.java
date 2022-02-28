package main;

import java.util.LinkedList;

import models.Nodo;


public class MainApp {
	public static void main(String[] args) {
	
	Nodo n10 = new Nodo ("10", null);
	Nodo n9 = new Nodo ("9", null);
	Nodo n8 = new Nodo ("8", null);
	Nodo n7 = new Nodo ("7", null);	
	Nodo n6 = new Nodo ("6", null);	
	Nodo n5 = new Nodo ("5", null);
	Nodo n4 = new Nodo ("4", null);
	Nodo n3 = new Nodo ("3", null);
	Nodo n2 = new Nodo ("2", null);
	Nodo root = new Nodo ("1", null);
	
	/*
	 * Estructura del árbol:
	 *     1
	 *  2    3 4
	 * 5 6   7 8
	 *   9
	 *   10
	 */
	root.getChildren().add(n2);
	n2.getChildren().add(n5);
	n2.getChildren().add(n6);
	n3.getChildren().add(n7);
	n4.getChildren().add(n8);
	n6.getChildren().add(n9);
	n9.getChildren().add(n10);
	
		
	}
	}
