package principal;

import java.text.ParseException;

import java.util.Scanner;

import clases.Factura;
import clases.GestorFacturas;
import clases.LineaFactura;

/*
 * El método run cuando se ejecute siga el siguiente flujo:
 * 1-Pedir los datos de la factura
*  2-Pedir si se quiere introducir una línea de la factura o imprimir factura. (L o I)
    a)Si se elige introducir una nueva línea (L):
       -Pedir los datos de la línea de factura y añadir a la factura.
    b)Si se elige imprimir (I) factura mostrará los datos de la factura con sus linea.
 */

public class MainFacturas {
	private static Scanner scanner;

	public static void main(String[] args) throws ParseException {
		GestorFacturas gf = new GestorFacturas();
		gf.run();
		// declaracion de constantes (final) para las opciones

		Factura factura = new Factura();

		System.out.println("---------------Introduce los Datos de la factura--------------");
		pedirDatos(factura);

		Scanner teclado = new Scanner(System.in);
		String opcion;
		do {
			System.out.println("Introduce L para añadir linea a la factura y I para inprimir la factura con sus lineas");
			opcion = teclado.nextLine();
			if (opcion.toUpperCase().equals("L")) {
				introducirLinea(factura);
			} else if (!opcion.toUpperCase().equals("L") && !opcion.toUpperCase().equals("I")) {
				System.out.println("Opcion incorrecta");

			}

		} while (!opcion.toUpperCase().equals("I"));
		factura.mostrarEnPantalla();

		teclado.close();
	}

	public static void pedirDatos(Factura factura) throws ParseException {
		scanner = new Scanner(System.in);
		int numero_factura;
		String nombreEmpresa_factura;

		String String_fecha_factura;
		// es necesario darle un formato para guardarlo

		String concepto_factura;

		System.out.println("Introduce el numero");
		numero_factura = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Introduce el nombre de empresa");
		nombreEmpresa_factura = scanner.nextLine();
		System.out.println("Introduce la fecha de la factura en este formato (dd-MM-yyyy)");
		String_fecha_factura = scanner.nextLine();

		System.out.println("Introduce el concepto de la factura");
		concepto_factura = scanner.nextLine();

		factura.setNumero(numero_factura);
		factura.setNombreEmpresa(nombreEmpresa_factura);
		// convertimos el String a date
		factura.setFecha(Factura.formatoFechaDate(String_fecha_factura));
		factura.setConcepto(concepto_factura);

	}

	public static void introducirLinea(Factura factura) {
		int numero_linea;
		String articulo_linea;
		double precio_linea;
		int cantidad_linea;
		LineaFactura lineaFactura = new LineaFactura();
		System.out.println("Introduce el numero artículo");
		numero_linea = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Introduce el articulo ");
		articulo_linea = scanner.nextLine();
		System.out.println("Introduce el precio del articulo");
		precio_linea = scanner.nextDouble();

		System.out.println("Introduce la cantidad del articulo");
		cantidad_linea = scanner.nextInt();

		lineaFactura.setNumero(numero_linea);
		lineaFactura.setArticulo(articulo_linea);
		lineaFactura.setPrecio(precio_linea);
		lineaFactura.setNumero(numero_linea);
		lineaFactura.setCantidad(cantidad_linea);

		factura.addLinea(lineaFactura);
	}

}
