//erstellt von Martin Scherzer
package beans;

import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	private int	prodId;
	private String label;
	private String type;
	private String colour;
	private double price; 
	private byte[] image;
	private int anzahl; 
	

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double d) {
		this.price = d;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public int getAnzahl() {
		return anzahl;
	}
	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

}