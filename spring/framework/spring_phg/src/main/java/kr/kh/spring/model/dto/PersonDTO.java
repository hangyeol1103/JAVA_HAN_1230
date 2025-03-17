package kr.kh.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

	private String name;
	private int age;
	
	public String getTotal() { //getTotal 이라는 getter를 만들었고 total이라는 필드가 실제로 존재 하지 않음.
		return name + " : " + age;
	}
	
}
