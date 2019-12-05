//erstellt von Martin Scherzer
package beans;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	private int orderId; 
	private Product product; 
	private double gesamtpreis; 
	private double einzelpreis;
	private User user; 
	
	public Integer orderId() {
		return orderId; 
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId; 
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product; 
	}
	
	public double getGesatmpreis () {
		return gesamtpreis; 
	}
	public void setGesamtpreis(Double gesamtpreis) {
		this.gesamtpreis = gesamtpreis; 
		
	}
	
	public double getEinzelpreis() {
		return einzelpreis;
	}
	public void setEinzelpreis(double einzelpreis) {
		this.einzelpreis = einzelpreis;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}