package kr.kh.spring.paginagion;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Criteria {
	
	protected int page = 1;//현재 페이지 : 기본값 - 1
	protected int perPageNum = 10;//한 페이지에서 컨텐츠 개수 : 기본값 - 10
	
	protected String search = ""; //검색어 : 기본값 - 빈문자열=> 전체 검색
	protected String type="0"; //검색 타입 
	
	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}
	public int getPageStart() { //db 04_ 파일에 limit에 페이지 계산하는 6이 getPageStart인 게터가 6의 역할을 함.
		return (page - 1) * perPageNum;
	}
}