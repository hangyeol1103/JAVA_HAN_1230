package kr.kh.shoppingmall.model.vo;

import java.util.Date;
import java.util.List;

public class BuyVO {
	int bu_num;
	Date bu_date;
	String bu_state;
	int bu_total;
	Date bu_final_Date;
	String bu_me_id;
	List<BuyListVO> list;
}
