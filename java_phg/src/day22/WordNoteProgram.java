package day22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordNoteProgram implements ConsoleProgram{

	private Scanner scan = new Scanner(System.in);
	private String id;
	private List<Word> words;
	private Map<String, List<Word>> myWords;
	
	@Override
	public void run() {
		
		String wordsFileName = "src/day22/words.txt";
		String myWordsFileName = "src/day22/myWords.txt";
		
		//불러오기
		words = (List<Word>) load(wordsFileName);
		myWords = (Map<String, List<Word>>)load(myWordsFileName);
		
		//불러오기 실패 처리
		if(words == null) {
			words = new ArrayList<Word>();
		}
		if(myWords == null) {
			myWords = new HashMap<String, List<Word>>();
		}

		
		
		//아이디 입력
		System.out.print(" 아이디 : ");
		String id = scan.next();
		
		if("admin".equals(id)) {
			WordNoteAdminProgram adminProgram = new WordNoteAdminProgram(scan, words);
			adminProgram.run();
		}else {
			WordNoteUserProgram userProgram = new WordNoteUserProgram(scan, words, myWords, id);
			userProgram.run();
		}
		
		//저장하기
		save(wordsFileName, words);
		save(myWordsFileName, myWords);
	}

	@Override
	public void printMenu() {
		System.out.println("------------------");
		System.out.println("1. 단어 검색");
		System.out.println("2. 내 검색 단어 보기");
		System.out.println("3. 종료");
		System.out.println("------------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) {
		// TODO Auto-generated method stub
		
	}

}
