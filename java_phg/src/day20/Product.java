package day20;

import java.text.DecimalFormat;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
	private String code;
	private String category;
	private String name;
	private String option;
	private int price;
	private int amount;
	
	
	
	public Product(String code, String category, String name, String option, int price) {
		super();
		this.code = code;
		this.category = category;
		this.name = name;
		this.option = option;
		this.price = price;
	}

	public Product(int max, String category, String name, String option, int price) {
		this("", category, name, option, price);
		//code를 추가 : ABC + 001
		String prefix = Product.getCodePrefix(category);
		DecimalFormat format = new DecimalFormat("000");
		String suffix = format.format(max + 1);
		this.code = prefix + suffix;
	}

	@Override
	public String toString() {
		return "[" + category + "]" + name + " " + option + " - " + code + " : "
				+ price + "원 수량 : " + amount;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(code, other.code);
	}

	public static String getCodePrefix(String category) {
		//문구 => ABC, 의류 : DEF, 식품 : XYZ, 가전 : ELC, 기타 : ETC
		switch(category) {
		case "문구":
			return "ABC";
		case "의류":
			return "DEF";
		case "식품":
			return "XYZ";
		case "가전":
			return "ELC";
		case "기타":
			return "ETC";
		default:
			return null;
		}
	}

	public void update(String name, String option, int price) {
		this.name = name;
		this.option = option;
		this.price = price;
	}

	public void store(int amount) {
		this.amount += amount;
	}

	public static String getCategory(int categoryNum) {
		switch(categoryNum) {
		case 1: return "문구";
		case 2: return "의류";
		case 3: return "식품";
		case 4: return "가전";
		case 5: return "기타";
		case 6: return "전체";
		default:
			return null;			
		}
	}
	
	
}
