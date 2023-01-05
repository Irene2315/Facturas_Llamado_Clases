package clases;

public class LineaFactura {
    private int numero;
    private String articulo;
    private double precio;
    private int cantidad;
    
    public LineaFactura() {
    	
    }
    public LineaFactura(int numero,String articulo,double precio,int cantidad) {
    	this.numero=numero;
    	this.articulo=articulo;
    	this.precio=precio;
    	this.cantidad=cantidad;
    }
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	public double precioTotal() {
		double total;
		total=0;
		total=precio*cantidad;
	    return total;
	}
	
	public void mostrarEnPantalla() {
		System.out.println(
				this.numero+ "\t" + 	
				this.articulo + "\t" + 
				this.precio + "\t" +
				this.cantidad + "\t" +
				this.precioTotal());
	}
	
	
	
	
    
}
