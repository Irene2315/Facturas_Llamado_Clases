package clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Factura {
	private int numero;
	private String nombreEmpresa;
	private Date fecha;
	private String concepto;
	private ArrayList<LineaFactura> lineas=new ArrayList<LineaFactura>();
	
	public Factura() {
		
	}

	public Factura(int numero, String nombreEmpresa, Date fecha, String concepto, ArrayList<LineaFactura> lineas) {
		super();
		this.numero = numero;
		this.nombreEmpresa = nombreEmpresa;
		this.fecha = fecha;
		this.concepto = concepto;
		this.lineas = lineas;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public ArrayList<LineaFactura> getLineas() {
		return lineas;
	}

	public void setLineas(ArrayList<LineaFactura> lineas) {
		this.lineas = lineas;
	}
	
	public void addLinea (LineaFactura linea) {
		
		lineas.add(linea);
	}
	public void eliminarLinea() {
		
	}
	
	public double precioTotal() {
		double total;
		total=0;
		for (int i = 0; i < lineas.size(); i++) {
			
			total=lineas.get(i).precioTotal()+total;
		}
		return total;
	}
	
public void mostrarEnPantalla() {
		
		System.out.println("Numero factura: " + this.numero + "\t\t" + this.nombreEmpresa);
		System.out.println("Fecha: " + formatoFechaString(this.fecha));
		System.out.println(this.concepto);
		
		System.out.println("num\tart.\tprecio\tcant.\ttotal");
		System.out.println("---\t----\t------\t-----\t-----");
		
		for (LineaFactura lineaFactura : this.lineas) {
			lineaFactura.mostrarEnPantalla();
		}
		
		System.out.println("\t\t\t---Total: " + this.precioTotal());
		
		
	}
	
	
	public static Date formatoFechaDate(String fechaString) throws ParseException {
		Date fecha_factura;
		SimpleDateFormat formatoLecturaFecha= new SimpleDateFormat("dd-MM-yyyy");
		fecha_factura= formatoLecturaFecha.parse(fechaString);
		return fecha_factura;
	}
	
	public static String formatoFechaString(Date fecha) {
		String fechaString;
		SimpleDateFormat fecha_impresion= new SimpleDateFormat("dd-MM-yyyy");
		fechaString=fecha_impresion.format(fecha);
		return fechaString;
	}
	
	
	
	

}
