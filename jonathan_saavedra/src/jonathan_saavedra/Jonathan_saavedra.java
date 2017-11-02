package jonathan_saavedra;

import java.util.Scanner;

public class Jonathan_saavedra {

    public static void main(String[] args) {
        String coordenadas;
        int MAXIMO = 20;
        int filas = 0;
        int columnas = 0;
        int contGatos = 1;
        int cantGatos = 0;
        int cantRatones = 0;
        int contRatones = 1;
        int cantMuebles = 0;
        int contMuebles = 1;
        int x1 = 0;
        int y1 = 0;
        int cantidad = 0;
        boolean error = false;
        int PORCENTAJE_GATOS = 10;
        int PORCENTAJE_RATONES = 25;

        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("-----------------------------------");
            System.out.println("Bienvenido al creador de Planos");
            System.out.println("-----------------------------------");
            System.out.println("Regla: Todo lo que sea coordenada");
            System.out.println("Se debe ingresar separado por una");
            System.out.println("coma. EJ: 1,5");
            System.out.println("-----------------------------------");
            System.out.print("Ingrese ancho y largo de la pieza: ");

            try {
                coordenadas = scan.nextLine();

                String[] cantFilaColumna = coordenadas.split(",");
                filas = Integer.parseInt(cantFilaColumna[0]);
                columnas = Integer.parseInt(cantFilaColumna[1]);
                if (filas > MAXIMO || columnas > MAXIMO || filas <= 0 || columnas <= 0) {
                    System.err.println("solo ingresar numeros entre 0 y 20");

                }

            } catch (NumberFormatException e) {
                System.err.println("solo ingresar numeros");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("datos mal ingresados");

            }

        } while (filas > MAXIMO || columnas > MAXIMO || filas <= 0 || columnas <= 0);

        String[][] matrizPiesa = new String[columnas][filas];
        String primeraFila = "f/c";
        for (columnas = 0; columnas < matrizPiesa[0].length; columnas++) {
            primeraFila = primeraFila + " 0" + Integer.toString(columnas);
        }
        System.out.println(primeraFila);

        for (int i = 0; i < matrizPiesa.length; i++) {
            for (int j = 0; j < matrizPiesa[0].length; j++) {
                matrizPiesa[i][j] = " - ";

            }

        }

        String cadenaAuxiliar = "";
        for (filas = 0; filas < matrizPiesa.length; filas++) {
            cadenaAuxiliar = Integer.toString(filas);
            for (columnas = 0; columnas < matrizPiesa[0].length; columnas++) {
                cadenaAuxiliar = cadenaAuxiliar + matrizPiesa[filas][columnas];
            }
            System.out.println("  0" + cadenaAuxiliar);
        }

        //----------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------
        int areaPieza = filas * columnas;
        int calculoPorcGatos = areaPieza * PORCENTAJE_GATOS / 100;
        int calculoPorRatones = areaPieza * PORCENTAJE_RATONES / 100;
        System.out.println("puede ingresar [" + calculoPorcGatos + "] gatos como maximo");
        do {
            try {
                do {
                    do {
                        System.out.print("cuantos gatos desea ingresar: ");
                        cantidad = Integer.parseInt(scan.nextLine());
                        if (cantidad <= 0) {
                            error = true;
                            System.err.println("no puede ser menor o igual a 0");
                        } else {
                            error = false;
                        }

                    } while (cantidad <= 0);
                    if (cantidad > calculoPorcGatos) {
                        error = true;
                        System.err.println("limite superado");

                    } else {
                        error = false;
                    }

                } while (cantidad > calculoPorcGatos);

            } catch (NumberFormatException e) {
                error = true;
                System.err.println("ingrese solo numeros");
            }

        } while (error == true);

        while (cantidad > cantGatos) {
            do {
                try {
                    System.out.print(" GATO Nº " + contGatos + " : ");
                    String coorGato = scan.nextLine();
                    String[] ubicacionGato;
                    String horizontal;
                    String vertical;
                    error = false;

                    ubicacionGato = coorGato.split(",");

                    horizontal = ubicacionGato[0];
                    vertical = ubicacionGato[1];

                    x1 = Integer.parseInt(horizontal);
                    y1 = Integer.parseInt(vertical);

                    for (int f = 0; f < matrizPiesa.length; f++) {
                        for (int c = 0; c < matrizPiesa[0].length; c++) {
                            if (matrizPiesa[f][c] == " G ") {
                                error = true;
                            } else {
                                matrizPiesa[x1][y1] = " G ";
                                error = false;
                            }

                        }
                        if (error == true) {
                            System.out.println("error");
                        } else {
                            break;
                        }
                    }

                } catch (ArrayIndexOutOfBoundsException e) {
                    error = true;
                    System.err.println("coordenadas mal ingresadas");
                }

            } while (error != false);

            contGatos++;
            cantGatos++;
        }
        primeraFila = "f/c";
        for (int c = 0; c < matrizPiesa[0].length; c++) {
            primeraFila = primeraFila + " 0" + Integer.toString(c);
        }
        System.out.println(primeraFila);

        cadenaAuxiliar = "";
        for (int f = 0; f < matrizPiesa.length; f++) {

            cadenaAuxiliar = Integer.toString(f);
            for (int c = 0; c < matrizPiesa[0].length; c++) {
                cadenaAuxiliar = cadenaAuxiliar + matrizPiesa[f][c];
            }
            System.out.println("  0" + cadenaAuxiliar);
        }

//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
        System.out.println("puede ingresar [" + calculoPorRatones + "] como maximo");
        do {
            try {
                do {
                    do {
                        error = false;
                        System.out.print("cuantos ratones desea ingresar: ");
                        cantidad = Integer.parseInt(scan.nextLine());
                        if (cantidad > calculoPorRatones) {
                            System.err.println("Limite superado");
                        }

                    } while (cantidad > calculoPorRatones);
                    if (cantidad <= 0) {
                        System.err.println("no puede ser menor o igual a 0");

                    }

                } while (cantidad <= 0);
            } catch (NumberFormatException e) {
                error = true;
                System.err.println("solo ingrese numeros");
            }

        } while (cantidad > calculoPorRatones || cantidad <= 0 || error != false);

        while (cantidad > cantRatones) {
            do {
                try {
                    error = false;
                    System.out.print(" RATÓN Nº " + contRatones + " : ");
                    String coorRaton = scan.nextLine();
                    String[] ubicacionRaton;
                    String horizontal;
                    String vertical;

                    ubicacionRaton = coorRaton.split(",");

                    horizontal = ubicacionRaton[0];
                    vertical = ubicacionRaton[1];

                    x1 = Integer.parseInt(horizontal);
                    y1 = Integer.parseInt(vertical);

                    for (int i = 0; i < matrizPiesa.length; i++) {
                        for (int j = 0; j < matrizPiesa[i].length; j++) {
                            if (matrizPiesa[i][j] == " G " || matrizPiesa[i][j] == " R ") {
                                error = true;
                            } else {
                                error = false;
                                matrizPiesa[x1][y1] = " R ";
                            }
                        }

                    }

                } catch (NumberFormatException e) {
                    error = true;
                    System.err.println("solo ingrese numeros");
                } catch (ArrayIndexOutOfBoundsException e) {
                    error = true;
                    System.err.println("Datos mal ingresados");
                }

            } while (error == true);

            contRatones++;
            cantRatones++;
        }
        primeraFila = "f/c";
        for (int c = 0; c < matrizPiesa[0].length; c++) {
            primeraFila = primeraFila + " 0" + Integer.toString(c);
        }
        System.out.println(primeraFila);

        cadenaAuxiliar = "";
        for (int f = 0; f < matrizPiesa.length; f++) {

            cadenaAuxiliar = Integer.toString(f);
            for (int c = 0; c < matrizPiesa[0].length; c++) {
                cadenaAuxiliar = cadenaAuxiliar + matrizPiesa[f][c];
            }
            System.out.println("  0" + cadenaAuxiliar);
        }

//-------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------
        
            System.out.println(" MUEBLE Nº " + contMuebles + " : ");
           do { System.out.print(" La coordenada superior izquierda del mueble:  ");
            String coorPunto1 = scan.nextLine();
            String[] punto1;
            String horizontal;
            String vertical;

            punto1 = coorPunto1.split(",");

            horizontal = punto1[0];
            vertical = punto1[1];

            x1 = Integer.parseInt(horizontal);
            y1 = Integer.parseInt(vertical);

            for (int f = 0; f < matrizPiesa.length; f++) {
                for (int c = 0; c < matrizPiesa[0].length; c++) {
                    matrizPiesa[x1][y1] = " M ";
                }
            }

            primeraFila = "f/c";
            for (int c = 0; c < matrizPiesa[0].length; c++) {
                primeraFila = primeraFila + " 0" + Integer.toString(c);
            }
            System.out.println(primeraFila);

            cadenaAuxiliar = "";
            for (int f = 0; f < matrizPiesa.length; f++) {

                cadenaAuxiliar = Integer.toString(f);
                for (int c = 0; c < matrizPiesa[0].length; c++) {
                    cadenaAuxiliar = cadenaAuxiliar + matrizPiesa[f][c];
                }
                System.out.println("  0" + cadenaAuxiliar);
            }
//----------------------------------------------------------------------------------------------

            System.out.println("mueble " + contMuebles + " : ");
            System.out.print(" La coordenada inferior derecha del mueble: ");
            String coorPunto2 = scan.nextLine();
            String[] punto2;
            String col;
            String fila;

            punto2 = coorPunto2.split(",");

            col = punto2[0];
            fila = punto2[1];

            int x2 = Integer.parseInt(col);
            int y2 = Integer.parseInt(fila);

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {

                    matrizPiesa[x2][y2] = " M ";

                }

            }

            primeraFila = "f/c";
            for (int c = 0; c < matrizPiesa[0].length; c++) {
                primeraFila = primeraFila + " 0" + Integer.toString(c);
            }
            System.out.println(primeraFila);

            cadenaAuxiliar = "";
            for (int f = 0; f < matrizPiesa.length; f++) {

                cadenaAuxiliar = Integer.toString(f);
                for (int c = 0; c < matrizPiesa[0].length; c++) {
                    cadenaAuxiliar = cadenaAuxiliar + matrizPiesa[f][c];
                }
                System.out.println("  0" + cadenaAuxiliar);

            }
            System.out.println("desea ingresar mueble: 1.- si 2.- no");
            cantidad = scan.nextInt();
            if (cantidad == 1) {
                for (int i = x1; i <= x2; i++) {
                    for (int j = y1; j <= y2; j++) {
                        matrizPiesa[i][j] = " M ";
                    }
                }
            }
            contMuebles++;

        } while (cantidad != 1);
        primeraFila = "f/c";
        for (int c = 0; c < matrizPiesa[0].length; c++) {
            primeraFila = primeraFila + " 0" + Integer.toString(c);
        }
        System.out.println(primeraFila);

        cadenaAuxiliar = "";
        for (int f = 0; f < matrizPiesa.length; f++) {

            cadenaAuxiliar = Integer.toString(f);
            for (int c = 0; c < matrizPiesa[0].length; c++) {
                cadenaAuxiliar = cadenaAuxiliar + matrizPiesa[f][c];
            }
            System.out.println("  0" + cadenaAuxiliar);
        }

    }
}
