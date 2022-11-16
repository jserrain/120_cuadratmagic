package net.cendrassos.locubmag.loCubMagic;

/**

	La generaci�n de cuadrados m�gicos cuando tienen tama�o impar existen varios m�todos sencillos de generarlos. 
	Uno muy conocido es el llamado m�todo siam�s (Simon de La Loub�re, 1693). 
	
	Seg�n este m�todo se empieza con un entero cualquiera (el 1 por ejemplo) que se coloca en el cuadrado central de la fila 
	superior. 
	
	Despu�s se van rellenando los cuadrados en diagonal (hacia arriba y la derecha) con n�meros consecutivos al inicial, 
	teniendo en cuenta que:
	
	c1) Si al avanzar "salimos fuera" del cuadrado por la parte superior en la columna i, se entra por la parte inferior en 
	la columna i+1.
	c2) Si al avanzar "salimos fuera" del cuadrado por la derecha en la fila j, se entra por la izquierda en la fila j-1.
	c3) Si la siguiente posici�n est� ocupada, colocamos el n�mero justo debajo de la posici�n donde colocamos el �ltimo n�mero. 
	Si estamos en la �ltima fila, volvemos a la primera.
	
	La manera de conseguir el cuadrado m�gico de orden 5 con este procedimiento es el que se detalla en la siguiente figura:
	https://www.aceptaelreto.com/problem/statement.php?id=120
 *
 */

import java.util.Scanner;

public class App 
{	
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
    	
    	int n = 5;							// mida cuadrat de N
    	int m[][] = new int[n][n];			// array n*n
    	
    	int i = 0, j = 0; 					// files; columnes: posici� primer n�mero
    	int nm = m.length * m[0].length;	// cel�les total array = cel�les d'n mida row * mida col
    	int vc = 0; 						// valor cel�la
    	
    	omplirMatriu(m); 					// omplir matriu
    	mostrarMatriu(m);					// mostrar contingut matriu
    	
    	// Se empieza con un entero cualquiera (el 1 por ejemplo) que se coloca en 
    	//  el cuadrado central de la fila superior. 
    	i = n/2; 							// fila inicial
    	j = n-1;							// columna inicial
    	vc = 1;								// valor inicial
    	
    	m[i][j] = vc;						// posici� primer n�mero = (1,2)
    	
    	//mostrarMatriu(m);
    									
    	while (vc != nm) {					// iterem fins hagim omplert totes les cel�les
    		vc++;							// seg�ent valor +1
    				
    		j += 1;							// seg�ent moviment: diagonal (hacia arriba y la derecha) 
    		i += 1;
    		
    		if (i == n & j == n){			// dos �ndex: out of range
    			i -=1;
    			j -=2;
    		}
    										// un dels dos index: fora de rang
    		if (j == n)						// fora de rang part superior columna i 
    			j -= n;
    		
    		if (i == n )					// fora de rang part dreta fila j
    			i -= n;
    		
    		if (m[i][j] != -1 ) {
    			i -= 1;
    			j -= 2;
    		}
    		
    		m[i][j] = vc;
    		
    		//mostrarMatriu(m);
    		
    	}
    	        
    	mostrarMatriu(m);
    	System.out.println( "-- fi Cuadrat M�gic --! ");
    }
    
    /*
     * m�tode: omplir matriu
     * Omple una matriu de dos dimensions posant el valor -1
     *  a totes les cel�les
     * Precondici�: la matriu d'entrada est� creada
     * Postcondici�: la matriu est� omplerta amb valors -1
     */
    public static int[][] omplirMatriu(int e[][]){
    	
    	for (int j = 0; j < e.length; j++) {
    		for(int i = 0; i < e[0].length; i++) {
    			e[i][j] = -1;
    		}
    	}
    	
    	return e;
    }
    
    public static void mostrarMatriu(int e[][]) {
    	
    	for (int j = 0; j < e.length; j++) {
    		for( int i = 0; i < e[0].length; i++) {
    			System.out.print(String.format("%02d", e[i][j]) + " ");
    		}
    	System.out.println();
    	}
    	
    	System.out.println("---");
    }
}
