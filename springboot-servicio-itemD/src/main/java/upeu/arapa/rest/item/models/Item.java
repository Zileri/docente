package upeu.arapa.rest.item.models;

public class Item {

	private Docente docente;
	
	public Item() {}
	
	public Item(Docente docente) {
		super();
		this.docente = docente;
	}
	
	public Docente getProducto() {
		return docente;
	}
	
	public void setProducto(Docente docente) {
		this.docente = docente;
	}
	

}
