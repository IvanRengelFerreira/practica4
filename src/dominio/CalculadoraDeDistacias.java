package dominio;

public class CalculadoraDeDistacias {

//En este clase calcularemos la distancia de edicion de dos palbras mediante tablas de edicion segun el algoritmo de leveinstein
/**
 * 
 * @param s1
 * @param s2
 * @return distancia minima de edicion en la matriz
 */ 
    public static int CalculadoradeDistacias(String s1, String s2) {
        //En el caso las palabras sean iguales, se retorna 0 
    if (s1 == s2) {
        return 0;
    }else{
        //Si son diferentes se crea una matriz basada en el tamaño de las palabras, sumando uno a la fila y a la columna por el caso en la tabla donde no hay palabra
       int[][] tabla = new int[s1.length()+1][s2.length()+1];

       //Los dos bucles for siguientes sirven para explorar los casos base del problema, dando la distancia de insercion de la columna y el caso de eliminacion para la fila
       //aca deberian salir que el tamaño de edicion sean iguales a las palabras correspondientes
       for(int fila = 0;fila < s1.length()+1;fila++){
           tabla[fila][0] = fila;
       }
         for(int columna = 0;columna < s2.length()+1;columna++){
              tabla[0][columna] = columna;
         }
         //Este bucle exploramos los casos restantes y nos adentramos por la matriz
         //Empezamos por la posicion [1][1] ya que anteriormente vimos los casos donde la columna y fila es 0, y se alamacenara los cambios de edicion que en ese momento se ha visualizado.
         for(int fila = 1;fila < s1.length()+1;fila++){
             for(int columna = 1;columna < s2.length()+1;columna++){
        //Creamos variables para asignar el valor que consigamos a partir de los casos que genere y dependiendo de las sumas, sacaremos el minimo.
                int insertar, eliminar,sustituir;
        //Segun el algoritmo tenemos dos casos, cuando la letra de la palabra es igual o cuando son diferentes.
                if(s1.charAt(fila-1) == s2.charAt(columna-1)){
                    //Se mantiene igual al no tener quer hacer cambio
                    sustituir = tabla[fila-1][columna-1] ;
                }else {
                    //Se le suma dos al tener que hacer dos procesos cuando se sustituye una letra
                    sustituir = tabla[fila -1][columna -1]+2;
                }
        //Se le suma uno en caso de insertar o eliminar al ser solo un proceso que se tiene que hacer en cada caso, siendo insertar cuando exploramos las filas y eliminar cuando exploramos las columnas de las tablas
                insertar = tabla[fila][columna-1]+1;
                eliminar = tabla[fila -1][columna]+1;
        //Se calcula el minimo de edicion que hemos sacado y se almacena en la posicion correspondiente de los valores que tiene el bucle en ese momento
                tabla[fila][columna] = Math.min(sustituir,Math.min(eliminar, insertar));
                
             }
         }
         //Cuando el bucle explore todas las posiciones de la matriz retornara el valor final que se alamceno despues de comparar minimos
         return tabla[s1.length()][s2.length()];
    }
}
}
