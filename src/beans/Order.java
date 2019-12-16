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
	private int userId;
	private double rechnungsbetrag;

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

	public double getRechnungsbetrag() {
		return rechnungsbetrag;
	}

	public void setRechnungsbetrag(double rechnungsbetrag) {
		this.rechnungsbetrag = rechnungsbetrag;
	}

}