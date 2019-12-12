//erstellt von Martin Scherzer
package beans;

import java.io.Serializable;
import java.sql.Date;
//import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	private int rechnungsnummer;
	private int orderId;
	private int userId;
	// private List<Product> products;
	private double gesamtpreis;
	private Date rechnungsdatum;

	public Integer orderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public double getGesatmpreis() {
		return gesamtpreis;
	}

	public void setGesamtpreis(Double gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}

	// public List<Product> getProducts() {
	// return products;
	// }
	//
	// public void setProducts(List<Product> products) {
	// this.products = products;
	// }

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRechnungsnummer() {
		return rechnungsnummer;
	}

	public void setRechnungsnummer(int rechnungsnummer) {
		this.rechnungsnummer = rechnungsnummer;
	}

	public Date getRechnungsdatum() {
		return rechnungsdatum;
	}

	public void setRechnungsdatum(Date rechnungsdatum) {
		this.rechnungsdatum = rechnungsdatum;
	}

}