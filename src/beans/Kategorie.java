//erstellt von Johannes Wolf
package beans;

import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class Kategorie implements Serializable {
	private static final long serialVersionUID = 1L;

	private int	kategorieId;
	private String kategorie;
	
	public int getKategorieId() {
		return kategorieId;
	}
	public void setKategorieId(int kategorieId) {
		this.kategorieId = kategorieId;
	}
	public String getKategorie() {
		return kategorie;
	}
	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}
}