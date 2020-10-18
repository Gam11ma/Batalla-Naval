/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batallanaval;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Gama
 */
public class BatallaNaval {
Scanner teclado;
private char [][] tablero;
int fila, columna; //variables para representar las coordenadas y=fila, x=columnas

public void cargarTablero(){
    tablero=new char[10][10];
    for(int i=0;i<tablero.length;i++){
        for(int j=0;j<tablero.length;j++){
            System.out.print((tablero[i][j]='-')+" ");
        }
    }
     
}
public void mostrar(){
    for(int i=0;i<tablero.length;i++){
        for(int j=0;j<tablero.length;j++){
            System.out.print(tablero[i][j]+" ");
        }System.out.println();
    }
     
}
public void ocultarBarcos(){
    //para elegir coordenadas al azar y ocultar los barcos 
    //se usa el metodo random de la clase Math 
    System.out.println("Se muestran los barcos dispersos en una matriz 10x10\n"
            + "Los barcos de la computadora representados por X, los barcos del usario representados por O\n"
            + "Habra 10 rondas en las cuales iran disparando en turnos, comenzara disparando el Usuario Gama");
    for(int i=0;i<10;i++){
        do{
        fila=(int)(Math.random()*(10-1+1)+1);
        fila--;
        columna=(int)(Math.random()*(10-1+1)+1);
        columna--;
        }while(tablero[fila][columna]=='X');
        tablero[fila][columna]='X';     
        //Se generan los numeros aleatorios de igual manera para el usuario
    }    
     for(int i=0;i<10;i++){
         do{
            fila=(int)(Math.random()*(10-1+1)+1);
            fila--;
            columna=(int)(Math.random()*(10-1+1)+1);
            columna--;
        }while(tablero[fila][columna]=='X' || tablero[fila][columna]=='O');
            tablero[fila][columna]='O';        
    }
}
public void ataque(){
    
    int puntosGama, puntosOrdenador, disparosGama, disparosOrdenador, ronda;
    disparosGama=0;
    disparosOrdenador=0;
    puntosGama=0;
    puntosOrdenador=0;
    ronda=1;
    //codigo para realizar el ataque del usuario
    do{
        try{
            System.out.println("puntos Gama="+puntosGama+"   puntos Ordenador="+puntosOrdenador+""
                    + "    Ronda:"+ronda);
            ronda++;
            disparosGama++;
            teclado=new Scanner(System.in);
            System.out.print("Ataca Gama!. ");
            System.out.println("Introduzce coordenadas:");
            System.out.print("x:");
            columna=teclado.nextInt();
            System.out.print("y:");
            fila=teclado.nextInt(); 
            if(tablero[fila][columna]=='X'){
                tablero[fila][columna]='*';
                puntosGama++;
                System.out.println("Haz dado a un barco enemigo!");
            }else{
                System.out.println("Haz fallado!");
                }
        }catch(ArrayIndexOutOfBoundsException exc){
            System.out.println("Coordenada fuera de la matriz, introduce valores de 0 a 9 ò perderas turno:");
            System.out.print("x:");
            columna=teclado.nextInt();
            System.out.print("y:");
            fila=teclado.nextInt(); 
        }catch(InputMismatchException ex){
            System.out.println("Error de dato!, introduce un valor de tipo numerico de 0 a 9 ò perderas turno:");
            teclado=new Scanner(System.in);
            try{
            System.out.print("x:");
            columna=teclado.nextInt();
            System.out.print("y:");
            fila=teclado.nextInt(); 
            }catch(InputMismatchException e){
                System.out.println("Dato invalido, ¡Has perdido turno!");
            }
        }
            
        //Se mustra el tablero cada que el usuario ataca
        for(int i=0;i<tablero.length;i++){
            for(int j=0;j<tablero.length;j++){
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println();
        }

       //Codigo para el ataque de la computadora

        disparosOrdenador++;
        teclado=new Scanner(System.in);
        System.out.println("La computadora ataca!. ");
        columna=(int)(Math.random()*(10-1+1)+1);
        columna--;
        System.out.println("x:"+columna);        
        fila=(int)(Math.random()*(10-1+1)+1);
        fila--;        
        System.out.println("y:"+fila);
        if(tablero[fila][columna]=='O'){
            tablero[fila][columna]='o';
            puntosOrdenador++;
            System.out.println("la computadora ha hundido uno de tus barcos!");
        } else{
            System.out.println("La computadora ha fallado!");
        }
        
        //Se muestra el tablero cada que ha disparado la computadora
         
        for(int i=0;i<tablero.length;i++){
            for(int j=0;j<tablero.length;j++){
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println();
        }
        
         
    }while(disparosOrdenador!=10);
        if(puntosOrdenador>puntosGama){
            System.out.println("Fin del juego, el ganador es la computadora con " + puntosOrdenador + " puntos");
        }else{
            if(puntosGama>puntosOrdenador){
                System.out.println("Fin del juego, el ganador es Gama con " + puntosGama + " puntos");
            }else{
                System.out.println("Fin del juego, ¡Ha sido empate!: "+ puntosOrdenador + " a " + puntosGama );
            }

    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BatallaNaval batalla=new BatallaNaval();
        batalla.cargarTablero();
        System.out.println();
        batalla.ocultarBarcos();
        batalla.mostrar();
        batalla.ataque();
        // TODO code application logic here
    }
    
}
