package day23;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Ex20_test {

	public static void main(String[] args) {
		fileSave();
	}
	
	public static void fileSave() {
		
		Food food = new Food("사과", 20);
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/day23/ex20.txt"))){
			oos.writeObject(food);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
}


@Getter
@Setter
@AllArgsConstructor
class Food implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int kcal;
	
	
	@Override
	public String toString() {
		return name + "의 킬로칼로리는 : " + kcal + "kcal";
	}
	
	
}