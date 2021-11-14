import java.util.*;
import java.lang.*;
import Figure.*;
import myExceptions.negativeSideException;
import myExceptions.nullSideException;

import javax.swing.*;

public class gestioneFigure {

    private static Figura[] figure = new Figura[10];

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int scelta = 99;
        double misura1, misura2, misura3;
        Figura figura = null;

        System.out.println("\nCiao!");
        do {
            System.out.println("\nCosa vuoi fare?");
            System.out.println("1) Cerchio");
            System.out.println("2) Rettangolo");
            System.out.println("3) Quadrato");
            System.out.println("4) Triangolo");
            System.out.println("5) Triangolo rettangolo");
            System.out.println("6) Stampa figure create");
            System.out.println("0) Voglio uscire");
            System.out.print("Scelta: ");

            try {
                scelta = input.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("\nInput non valido, inserisci un numero!");
                input.nextLine();
                continue;
            }
            input.nextLine(); // prendo l'invio dopo al nextInt andato a buon fine

            if (scelta < 0 || scelta > 6)
                System.out.println("\nInserisci un numero compreso tra 0 e 6");
            else {
                switch (scelta) {
                    case 0:
                        break;
                    case 6: {
                        System.out.println();
                        for (Figura f : figure)
                            if (f != null)
                                System.out.println(f);
                        break;
                    }
                    case 1: {
                        misura1 = getPositiveDouble("Raggio");
                        figura = new Cerchio(misura1);
                        break;
                    }
                    case 2: {
                        misura1 = getPositiveDouble("Base");
                        misura2 = getPositiveDouble("Altezza");
                        figura = new Rettangolo("Rettangolo", misura1, misura2);
                        break;
                    }
                    case 3: {
                        misura1 = getPositiveDouble("Lato");
                        figura = new Quadrato(misura1);
                        break;
                    }
                    case 4: {
                        misura1 = getPositiveDouble(("Primo lato"));
                        misura2 = getPositiveDouble("Secondo lato");
                        boolean invalidMeasure;
                        do {
                            misura3 = getPositiveDouble("Terzo lato");
                            invalidMeasure = !(isTriangle(misura1, misura2, misura3));
                            if(invalidMeasure)
                                System.out.println("\nTerzo lato non compatibile con i primi due, inserire una lunghezza congrua.");
                        } while(invalidMeasure);

                        figura = new Triangolo("Triangolo", misura1, misura2, misura3);
                        break;
                    }
                    case 5: {
                        misura1 = getPositiveDouble("Cateto");
                        String element;
                        do {
                            System.out.print("\nVuoi inserire l'altro cateto o l'ipotenusa? [c/i]: ");
                            element = input.nextLine();
                            if(element.charAt(0) == 'c') {
                                misura2 = getPositiveDouble("Altro cateto");
                                figura = new TriangoloRettangolo(misura1, misura2);
                            }
                            else if(element.charAt(0) == 'i') {
                                misura2 = getPositiveDouble(("Ipotenusa"));
                                figura = new TriangoloRettangolo('i', misura1, misura2);
                            }
                            else
                                System.out.println("Input non valido. Inserisci 'i' per l'ipotenusa, 'c' per l'altro cateto.");

                        } while (element.charAt(0) != 'c' && element.charAt(0) != 'i');
                        break;
                    }

                }
                if (scelta != 0 && scelta != 6) {
                    try {
                        addFigura(figura);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                        figura = null;
                    }
                }
            }


        } while (scelta != 0);

        System.out.println("\nCiao!");

    }

    private static void addFigura (Figura newFigura) throws ArrayIndexOutOfBoundsException {
        boolean notAdded = true;
        for(byte b = 0; b < figure.length && notAdded; b++)
            if (figure[b] == null) {
                figure[b] = newFigura;
                notAdded = false;
            }
        if(notAdded)
            throw new ArrayIndexOutOfBoundsException("\nLimite massimo di figure raggiunto, figura non creata!");
    }

    private static double getPositiveDouble(String nameVarToGet) {

        Scanner input = new Scanner(System.in);

        double misura = 0;
        boolean inCatch;
        do {
            inCatch = false;
            System.out.print('\n' + nameVarToGet + ": ");
            try {
                misura = input.nextDouble();
                if (misura == 0)
                    throw new nullSideException('\n' + nameVarToGet + " nullo/a, errore!");
                else if (misura < 0)
                    throw new negativeSideException('\n' + nameVarToGet + " negativo/a, impossibile!");

            } catch (InputMismatchException e) {
                System.out.println("\nInput non valido, inserisci un numero!");
                input.nextLine();
                inCatch = true;
            } catch (nullSideException | negativeSideException e) {
                System.out.println(e.getMessage());
                inCatch = true;
            }
        } while(inCatch);

        return misura;
    }

    // Returns true if the parameters can be the sides of a triangle
    private static boolean isTriangle(double lato1, double lato2, double lato3) {
        return (lato3 < lato1 + lato2) && (lato3 > Math.abs(lato1 - lato2));
    }

}