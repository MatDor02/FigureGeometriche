import java.util.*;
import Figure.*;
import myExceptions.negativeSideException;
import myExceptions.nullSideException;

import javax.swing.*;

public class gestioneFigure {

    private static Figura[] figure = new Figura[3];

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int scelta = 99;
        double misura1, misura2, misura3, misura4;
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
                        misura1 = getPositiveDouble("Altezza");
                        misura2 = getPositiveDouble(("Lato relativo al'altezza"));
                        misura3 = getPositiveDouble("Secondo lato");
                        misura4 = getPositiveDouble("Terzo lato");
                        figura = new Triangolo("Triangolo", misura1, misura2, misura3, misura4);
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

}
