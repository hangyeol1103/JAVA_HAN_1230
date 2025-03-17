package day21;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Word {
	
	private String word;
	private String type;
	private String mean;
	
	@Override
	public String toString() {
		return "단어 - " + word + " /" + " 품사 - " + type + " /"+ " 의미 - " + mean;
	}
	
	
	
}
