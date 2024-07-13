package com.aluracursos.conversor.principal;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("****************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =)");
            System.out.println("1. Peso Mexicano a Dólar Estadounidense");
            System.out.println("2. Peso Mexicano a Euro");
            System.out.println("3. Peso Mexicano a Yen Japonés");
            System.out.println("4. Peso Mexicano a Libra Esterlina");
            System.out.println("5. Dólar Estadounidense a Euro");
            System.out.println("6. Euro a Yen Japonés");
            System.out.println("7. Yen Japonés a Libra Esterlina");
            System.out.println("8. Salir");
            System.out.println("****************************************");
            System.out.print("Elija una opción válida: ");

            int opcion = scanner.nextInt();

            if (opcion == 8) {
                System.out.println("Gracias por usar el conversor de monedas.");
                break;
            }

            String monedaOrigenCodigo = null;
            String monedaDestinoCodigo = null;

            switch (opcion) {
                case 1:
                    monedaOrigenCodigo = "MXN";
                    monedaDestinoCodigo = "USD";
                    break;
                case 2:
                    monedaOrigenCodigo = "MXN";
                    monedaDestinoCodigo = "EUR";
                    break;
                case 3:
                    monedaOrigenCodigo = "MXN";
                    monedaDestinoCodigo = "JPY";
                    break;
                case 4:
                    monedaOrigenCodigo = "MXN";
                    monedaDestinoCodigo = "GBP";
                    break;
                case 5:
                    monedaOrigenCodigo = "USD";
                    monedaDestinoCodigo = "EUR";
                    break;
                case 6:
                    monedaOrigenCodigo = "EUR";
                    monedaDestinoCodigo = "JPY";
                    break;
                case 7:
                    monedaOrigenCodigo = "JPY";
                    monedaDestinoCodigo = "GBP";
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    continue;
            }

            double tasaConversion = Api.obtenerTasaConversion(monedaOrigenCodigo, monedaDestinoCodigo);

            if (tasaConversion == -1) {
                System.out.println("No se pudo obtener la tasa de conversión. Intente de nuevo.");
                break;
            }

            System.out.println("Ingrese la cantidad a convertir:");
            double cantidad = scanner.nextDouble();

            double resultado = cantidad * tasaConversion;
            System.out.printf("La cantidad convertida es: %.2f %s\n", resultado, monedaDestinoCodigo);
        }
    }
}
