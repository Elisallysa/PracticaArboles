# PracticaArboles
Exercise aimed at understanding and exploring n-ary data structure

## DescripciÃ³n
Ejercicio propuesto en la clase de ProgramaciÃ³n (en Java) del 1er curso del CFGS Desarrollo de Aplicaciones Multiplataforma para explorar el funcionamiento de las estructuras de datos en Ã¡rboles n-arios.

## Instrucciones del ejercicio
Dado el cÃ³digo base de los Ã¡rboles con sus respectivos recorridos (pre, in y post). Se pide:

1. Cambiar el valor que almacenan los nodos a String.
2. Hacer que el Ã¡rbol no sea binario, sino N-ario. Es decir, un nodo puede tener tantos hijos como desee.
3. Cambiar los mÃ©todos pre y post recorrido, el recorrido inorden es imposible con Ã¡rboles n-arios, elimÃ­nalo.
4. Implementa los siguientes mÃ©todos en Ã�rbol (y los necesarios en Nodo):
   
	Nodo buscarNodo(String valor);
Busca a lo largo del recorrido del Ã¡rbol si existe un nodo con ese valor. Si lo encuentra, lo devuelve (el nodo en sÃ­). Si no lo encuentra en todo el Ã¡rbol devuelve null.

	Nodo insertarNodo(Nodo padre, String valor);
Inserta un nuevo nodo con el valor que se pasa por parÃ¡metro bajo el nodo padre si existe. DeberÃ¡ buscar el nodo, y al encontrarlo, crearÃ¡ un nodo hijo con ese valor y lo devuelve.

	String path(String valor);
Se le pasarÃ¡ un String valor, este mÃ©todo buscarÃ¡ si hay un Nodo con ese valor, y si lo encuentra devolverÃ¡ la ruta o camino a seguir desde la raÃ­z hasta dicho nodo. E.g.:

~/pollo/dos/cinco/seis/

	void mostrarArbol();
Este mÃ©todo mostrarÃ¡ el path de cada uno de los nodos siguiendo un recorrido PREORDEN. E.g.:

~/

~/pollo/

~/pollo/uno/

~/pollo/dos/

~/pollo/dos/cinco/

~/pollo/dos/cinco/seis/

~/cerdo/

~/cerdo/tres/

~/ternera/

~/ternera/cuatro/


![Ã�rbol de ejemplo](/docs/arbolnario.png "Ejemplos basados en esta imagen")
