// Johannes Wolf
package beans;

import java.io.Serializable;


public class Selection implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer auswahlId;
    private Double preis;
    private Product product;
    private Integer groesse; 
    private Integer anzahl;
    
    
	public Integer getAuswahlId() {
		return auswahlId;
	}
	public void setAuswahlId(Integer auswahlId) {
		this.auswahlId = auswahlId;
	}
	public Double getPreis() {
		return preis;
	}
	public void setPreis(Double preis) {
		this.preis = preis;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getGroesse() {
		return groesse;
	}
	public void setGroesse(Integer groesse) {
		this.groesse = groesse;
	}
	public Integer getAnzahl() {
		return anzahl;
	}
	public void setAnzahl(Integer anzahl) {
		this.anzahl = anzahl;
	} 
}
