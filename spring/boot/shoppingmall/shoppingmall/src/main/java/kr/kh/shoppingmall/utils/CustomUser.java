package kr.kh.shoppingmall.utils;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import kr.kh.shoppingmall.model.vo.MemberVO;
import lombok.Data;

@Data
public class CustomUser extends User {
	
	private MemberVO user; //밑의 과정 성공시에 user에 정보를 넘겨받음.
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) { // 여기서 권한은 userRole에 있는 권한들
		super(username, password, authorities);
	}
	public CustomUser(MemberVO vo) {
		super(	vo.getMe_id(),
				vo.getMe_pw(), 
				Arrays.asList(new SimpleGrantedAuthority(vo.getMe_authority())));
		this.user = vo;
	}
}

