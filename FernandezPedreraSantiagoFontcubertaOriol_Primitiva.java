import javax.swing.*;
import java.util.Scanner;

/**
 * Programa de simulació de La Primitiva
 * @author Santiago, Oriol
 * @version 1.0
 * @date 16/02/2024
 */
//TODO: Fer refractor per canviar el nom de la classe
public class FernandezPedreraSantiagoFontcubertaOriol_Primitiva {
    /**
     * Mètode main executable
     * @param args
     * @since 1.0
     */
    public static void main(String[] args) {
        menuPrincipal();
    }

    /**
     * //TODO: Completar
     * @since 1.0
     */
    private static void menuPrincipal(){
        int opcio;

        int[] aposta = new int[7];
        int[] combinacioGuanyadora;
        int premi;

        do{
            System.out.println("***** PRIMITIVA ******");
            System.out.println("Loteria \n1.Hacer apuesta \n2.Girar el bombo \n3.Juego nuevo \n4.Salir ");
            opcio = llegirInt(": ", 1, 4);

            switch( opcio ){
                case 1:
                    aposta = introduirAposta();
                    break;
                case 2:
                    combinacioGuanyadora = calcularCombinacioGuanyadora();
                    if (combinacioGuanyadora != null) {
                        System.out.println("La combinació ganadora és: ");
                        for (int i = 0; i < combinacioGuanyadora.length - 1; i++) {
                            System.out.print(combinacioGuanyadora[i] + " ");
                        }
                        System.out.println("Reintegrament " + combinacioGuanyadora[combinacioGuanyadora.length - 1]);
                    }
                    premi = comprovarEncerts(aposta, combinacioGuanyadora);
                    System.out.println(premi);
                    break;
                case 3:
                    System.out.println("TODO");
                    break;
                case 4:
                    break;
            }
        } while (opcio != 4);

    }

    /**
     * //TODO: Completasr
     * @return //TODO: Completar
     * @since 1.0
     */
    private static int[] introduirAposta(){
        System.out.println("Introdueix la teva aposta: ");
        int[] aposta = new int[7];
        boolean rep = true;

        for (int i=0; i<6; i++){
            do {
                aposta[i] = llegirInt("Introdueix el número " + (i+1) + ": ", 1, 49);
                if (i>0){
                    for (int j=0; j<i; j++){
                        if (aposta[i] == aposta[j]){
                            rep = false;
                            break;
                        }else{
                            rep = true;
                        }
                    }
                }
            }while (!rep);
        }

        aposta[6] = llegirInt("Introdueix el número del reintegrament: " , 0, 9);

        return aposta;
    }

    /**
     * //TODO: Completar
     * @return //TODO: Completar
     * @since 1.0
     */
    private static int[] calcularCombinacioGuanyadora(){

        int[] combinacio = new int[7];

        //TODO: Fer el codi del mètode
        for(int i=0; i<7; i++){
            if(i!=6){
                boolean esDiferent = true;
                do {
                    int random = (int)Math.floor(Math.random()*48+1);
                    for(int x=0; x<i ;x++){
                        if(random != combinacio[x]){
                            esDiferent = true;
                        }
                        else{
                            esDiferent = false;
                            break;
                        }
                    }
                    combinacio[i] = random;
                } while (!esDiferent);

            } else{
                int random = (int)Math.floor(Math.random()*9);
                combinacio[i] = random;
            }
        }

        return combinacio;
    }

    /**
     * //TODO: Completar
     * @param aposta //TODO: Completar
     * @param combinacioGuanyadora //TODO: Completar
     * @return //TODO: Completar
     * @since 1.0
     */
    private static int comprovarEncerts(int[] aposta, int[] combinacioGuanyadora){
        int premi = 0;
        int encerts = 0;
        boolean reintregrament = false;

        //Comprobar encerts a la combinació
        for (int i=0; i<6; i++){
            for (int j=0; j<6; j++){
                if (aposta[i] == combinacioGuanyadora[j]){
                    encerts++;
                }
            }
        }

        //Comprobar reintegrament
        if (aposta[6] == combinacioGuanyadora[6]){
            reintregrament = true;
        }

        //Calcular premi
        premi = encerts * 20;

        if (reintregrament){
            premi += 6;
        }

        return premi;
    }

    /**
     * Aquest mètode llegeix un enter per teclat dins d'un domini determinat
     * @param missatge parametritzat per a mostrar a l'usuari@
     * @param min valor min acceptat
     * @param max valor max acceptat
     * @return retorna un int
     * @since 1.0
     */
    private static int llegirInt(String missatge, int min, int max) {
        Scanner llegir = new Scanner(System.in);
        int x = 0;
        boolean valorCorrecte = false;
        do{
            System.out.println(missatge);
            valorCorrecte = llegir.hasNextInt();
            if (!valorCorrecte){
                System.out.println("ERROR: Valor no enter.");
                llegir.nextLine();
            }else{ // Tinc un enter
                x = llegir.nextInt();
                llegir.nextLine();
                if (x < min || x > max){
                    System.out.println("Opció no vàlida");
                    valorCorrecte = false;
                }
            }
        }while(!valorCorrecte);

        return x;
    }

    /**
     * Aquest mètode serveix per capturar floats des de teclat amb control d'errors
     * @param missatge
     * @return
     * @since 1.0
     */
    private static float llegirFloat(String missatge){
        Scanner llegir = new Scanner(System.in);
        float x = 0;
        boolean valorCorrecte = false;
        do{
            System.out.print(missatge);
            valorCorrecte = llegir.hasNextFloat();

            if (!valorCorrecte){
                System.out.println("ERROR: Valor no float.");
            }else{
                x = llegir.nextFloat();
            }
            llegir.nextLine();
        }while(!valorCorrecte);

        return x;
    }

}
