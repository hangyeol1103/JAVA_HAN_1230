package day20;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class PurchaseItem {
	
	Product p;
	int amount;
	int totalPrice;
	Date date;
	
	public PurchaseItem(Product p, int amount, int totalPrice) {
		this.p = p;
		this.amount = amount;
		this.totalPrice = p.getPrice() * amount;
		date = new Date();
	}
	
	
	
}
