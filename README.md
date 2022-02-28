# PracticaArboles
Exercise aimed at understanding and exploring n-ary data structure

## Descripción
Ejercicio propuesto en la clase de Programación (en Java) del 1er curso del CFGS Desarrollo de Aplicaciones Multiplataforma para explorar el funcionamiento de las estructuras de datos en árboles n-arios.

## Instrucciones del ejercicio
Dado el código base de los árboles con sus respectivos recorridos (pre, in y post). Se pide:

1. Cambiar el valor que almacenan los nodos a String.
2. Hacer que el árbol no sea binario, sino N-ario. Es decir, un nodo puede tener tantos hijos como desee.
3. Cambiar los métodos pre y post recorrido, el recorrido inorden es imposible con árboles n-arios, elimínalo.
4. Implementa los siguientes métodos en Árbol (y los necesarios en Nodo):

4.1. Nodo buscarNodo(String valor);
Busca a lo largo del recorrido del árbol si existe un nodo con ese valor. Si lo encuentra, lo devuelve (el nodo en sí). Si no lo encuentra en todo el árbol devuelve null.

4.2. Nodo insertarNodo(Nodo padre, String valor);
Inserta un nuevo nodo con el valor que se pasa por parámetro bajo el nodo padre si existe. Deberá buscar el nodo, y al encontrarlo, creará un nodo hijo con ese valor y lo devuelve.

4.3. String path(String valor);
Se le pasará un String valor, este método buscará si hay un Nodo con ese valor, y si lo encuentra devolverá la ruta o camino a seguir desde la raíz hasta dicho nodo. E.g.:

~/pollo/dos/cinco/seis/

4.4. void mostrarArbol();
Este método mostrará el path de cada uno de los nodos siguiendo un recorrido PREORDEN. E.g.:

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

![Árbol de ejemplo](/docs/arbolnario.png "Ejemplos basados en esta imagen.")
