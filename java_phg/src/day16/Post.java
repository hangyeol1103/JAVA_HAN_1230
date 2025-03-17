package day16;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post implements Serializable, Cloneable{

	private static final long serialVersionUID = 6450315656987259458L;

	private static int count; //게시글 번호
	private int num;
	private String title, content, writer;
	private Date date;
	private int view;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return num == other.num;
	}
	
	public void view() {
		view++;
	}

	public Post(String title, String content, String writer) {
		num = ++count; //그냥 ++num으로만 하면 각각의 게시글들의 번호가 똑같은 따라서 count는 1부터 차례대로 증가하고 그 증가한 것을 각각의 객체 num에다가 넣어주는 것임.
		this.title = title;
		this.content = content;
		this.writer = writer;
		date = new Date();
	}
	
	public Post(int num) {
		this.num = num;
	}
	
	public void print() {
		System.out.println("-------------------------");
		System.out.println("번호 : " + num);
		System.out.println("제목 : " + title);
		System.out.println("내용 : " + content);
		System.out.println("작성자 : " + writer);
		System.out.println("작성일 : " + getDateStr() );
		System.out.println("조회수 : " + view);
		System.out.println("-------------------------");
	}

	private String getDateStr() {
		//Date -> String
		//yyyy-MM-dd HH:mm:ss
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}

	public static int getCount() {
		return count;
	}
	
	public static void setCount(int count) {
		Post.count = count; //this. 못씀 this.은 객체할 때 쓰는거?
	}

	public Post(Post p) {
		this(p.title, p.content, p.writer);
	}

	@Override
	public String toString() {
		return num + " | " + title + " | " + writer + " | " + getDateStr() + "|" + view;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
