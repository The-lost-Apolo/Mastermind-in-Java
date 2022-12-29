import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;
import javax.swing.text.Position;

public class Mastermind {
    public static void main(String[] args) throws Exception {
        //Scanner para pedirle input al usuario
        Scanner scan = new Scanner(System.in);

        //Valor de repeticion del juego
        boolean a = true;

        //Declaration of the color of the variables
        String color1 = "rojo";
        String color2 = "azul";
        String color3 = "verde";
        String color4 = "amarillo";
        String color5 = "rosa";
        String color6 = "blanco";
        String color7 = "negro";
        String color8 = "marron";


        //Clues for the players who guess
        String clave1 = "espiga blanca";
        boolean espiganegra = false;
        String clave2 = "espiga negra";
        boolean espigablanca = false;

        //Scores
        int puntuacionj1 = 0;
        int puntuacionj2 = 0;

        //Counter for when blacks are 5, ends the rounds
        int contadorn = 0;

        
        //For array to guess
        String [] codigo = new String [5];
        int [] codigon = new int [5];
        //Tries to guess
        String [] adivinacion = new String [5];
        int [] adivinacionnum = new int [5];
        //Positions of the colors
        int [] posicionc = new int [5];
        int [] posiciona = new int [5];

        //Inicialization
        System.out.println("Bienvenido al mitico juego de mesa Mastermind, ahora virtual creador por Miguel Lameiro!");
        System.out.println("Para jugar pulse 1, para salir pulse 0: ");
        int aa = scan.nextInt();
        if(aa == 1){
            a = true;
        }
        else {
            a = false;
        }

        //When while is false games ends, look if of the previosly part that inicalizates the game
        while(a == true){
            //Instructions for users
            System.out.println("Los colores disponibles son: rojo, azul, verde, amarillo, rosa, blanco, negro, marron");
            System.out.println("Escribir los colores tal cual la linea anterior");
            System.out.println("Se pueden ver las normas del juego en el pdf que esta dentro de la carpeta del proyecto, llamada REGLAS-DEL-MASTERMIND.pdf");
            System.out.println("Empieza el jugador uno");
            //Loop for the 2 rounds, 1 for each user
            for(int b =0; b<2;b++){
                int ocultar = 0;
                System.out.println("El otro jugador no puede mirar antes que se le diga");
                int jugador = b+1;     //Name of the player
                System.out.println(" ");
                
                System.out.println("Jugador "+jugador+ " dame los 5 colores del codigo para que lo adivine el otro jugador: ");
                //Input of the first user, who puts the color that has to guess the other user
                for (int i =0; i<codigo.length;i++){
                    int cuenta1 = i+1;
                    System.out.println("Dame el hueco "+cuenta1+":");
                    codigo[i] = scan.next();
                    posicionc[i] = i;
                }
                System.out.println(" ");
                System.out.println("El codigo es: ");
                for (int i =0; i<codigo.length;i++){
                    System.out.print(codigo[i] + " ");
                }
                //Select a int for each color, because when can compare Strings easily
                for(int i =0; i<codigo.length;i++){
                    if(codigo[i].equals(color1)){
                        codigon[i] = 1;
                    }
                    if(codigo[i].equals(color2)){
                        codigon[i] = 2;
                    }
                    if(codigo[i].equals(color3)){
                        codigon[i] = 3;   
                    }
                    if(codigo[i].equals(color4)){
                        codigon[i] = 4;
                    }
                    if(codigo[i].equals(color5)){
                        codigon[i] = 5;
                    }
                    if(codigo[i].equals(color6)){
                        codigon[i] = 6;
                    }
                    if(codigo[i].equals(color7)){
                        codigon[i] = 7;
                    }
                    if(codigo[i].equals(color8)){
                        codigon[i] = 8;
                    }
                }
                System.out.println(" ");
                //If user press 1 the code that puts will gop up and dissapear for the other player dont see it
                System.out.println("Pulse 1 para que no se vea el codigo escrito");
                ocultar = scan.nextInt();
                if(ocultar == 1){
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                }
                System.out.println("Ya puede mirar el otro jugador");
                System.out.println("El otro jugador trate de adivinar el codigo: ");
                //Loop for for the 12 lines that has the second player to guess
                for (int k=0; k<12;k++){
                    contadorn = 0;
                    int cuenta2 = k+1;
                    System.out.println(" ");
                    
                    System.out.println("Estamos en la linea "+cuenta2);  //Inidcates in the line we are
                    //Input of the user who guess
                    for(int i =0; i<adivinacion.length;i++){
                        int cuenta1 = i+1;
                        System.out.println("Dame el hueco "+cuenta1);
                        adivinacion[i] = scan.next();
                        posiciona[i] = i;
                    }
                    //Select a int for each color, because when can compare Strings easily
                    for(int i =0; i<adivinacion.length;i++){
                        if(adivinacion[i].equals(color1)){
                            adivinacionnum[i] = 1;
                        }
                        if(adivinacion[i].equals(color2)){
                            adivinacionnum[i] = 2;
                        }
                        if(adivinacion[i].equals(color3)){
                            adivinacionnum[i] = 3;
                        }
                        if(adivinacion[i].equals(color4)){
                            adivinacionnum[i] = 4;
                        }
                        if(adivinacion[i].equals(color5)){
                            adivinacionnum[i] = 5;
                        }
                        if(adivinacion[i].equals(color6)){
                            adivinacionnum[i] = 6;
                        }
                        if(adivinacion[i].equals(color7)){
                            adivinacionnum[i] = 7; 
                        }
                        if(adivinacion[i].equals(color8)){
                            adivinacionnum[i] = 8;
                        }
                    }

                    System.out.println(" ");
                    //We use the try of guess of the second player
                    System.out.println("El intento de adivinacion es: ");
                    for (int i =0; i<codigo.length;i++){
                        System.out.print(adivinacion[i] + " ");
                    }
        
                    System.out.println(" ");
                    System.out.println("\nEn en la linea "+cuenta2);
                    //Array for reset the numbers of time that a numbers is read by the next loop, for white espigas work
                    int [] arrposi = {0,0,0,0,0};
                    //Loop for compare the values between the try of guess and the code of the first player
                    for (int i=0; i<adivinacion.length;i++){
                        int cuenta1 = i+1;
                        //Black espigas
                        for(int j=0; j<adivinacionnum.length;j++){
                            espigablanca = false;
                            espiganegra = false;
                        
                            if(codigon[j] == (adivinacionnum[i]) && posicionc[i] == posiciona[j]){
                                System.out.println("En el hueco "+cuenta1+" hay una "+clave2);
                                arrposi[i]++;
                                espiganegra = true;
                                contadorn ++;
                                break;
                            }
                        }
                        //White espigas
                        for(int j=0; j<adivinacionnum.length;j++){
                            espigablanca = false;
                                                                                                                           //Here its the array that we need for the white works
                            if(codigon[j] == (adivinacionnum[i]) && posicionc[i] != posiciona[j] && espiganegra == false && arrposi[i] == 0){
                                arrposi[i]++;
                                System.out.println("En el hueco "+cuenta1+" hay una "+clave1);
                                espigablanca = true;
                                break;
                            }
                        }
                        //Showns if it isnt black and white espiga
                        if (espiganegra == false && espigablanca == false){
                            System.out.println("En el hueco "+cuenta1+ ", no hay nada");
                        }
                        }
                    //if the second player guess all with this we put the socre and end the round for player 1
                    if(contadorn == 5 && b ==0){
                        puntuacionj1 =k;
                        System.out.println("");
                        System.out.println("Turno del jugador dos");
                        break;
                    }
                    //for player 2
                    if(contadorn == 5 && b ==1){
                        puntuacionj2 =k;
                        break;
                    }
                
                }
                //Show scores
                System.out.println("\nLa puntuacion del jugador uno es: "+puntuacionj1);
                System.out.println("La puntuacion del jugador dos es: "+puntuacionj2);
                
            }
            //If they want to repeat the game
            System.out.println("Si desea volver a jugar pulse 1, si desea salir pulse 0");
            aa = scan.nextInt();
            if(aa == 1){
                a = true;
            }
            else {
                a = false;
            }            

        }
        //We say ty =)
        System.out.println(" ");
        System.out.println("Gracias por jugar!");
    }
             
}
        

