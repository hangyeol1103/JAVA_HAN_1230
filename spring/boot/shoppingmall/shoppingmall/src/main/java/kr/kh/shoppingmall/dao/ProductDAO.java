package kr.kh.shoppingmall.dao;

import java.util.List;

import kr.kh.shoppingmall.model.vo.CategoryVO;
import kr.kh.shoppingmall.model.vo.ProductVO;

public interface ProductDAO {

	List<CategoryVO> selectCateGoryList();

	CategoryVO selectCategoryByName(String ca_name);

	void insertCategory(CategoryVO category);

	boolean updateCategory(CategoryVO category);

	CategoryVO selectCategoryByCode(String ca_code);

	boolean deleteCategory(int ca_num);

	List<ProductVO> selectProductList(int pr_ca_num);
	
}
