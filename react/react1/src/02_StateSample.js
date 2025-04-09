import { Button } from "./Button";
import { useState } from "react";

function StateSample(){
	let [page, setPage] = useState(2);
	const maxPage = 6;
	
	function decrease(){
		page = page + (-1); //page--와 같음.
		if(page < 1){
			page = maxPage;
		}
		//따라서 setPage를 통해서 이용해야함.
		setPage(page); //page = page - 1로하면 렌더링이 안돼서 콘솔로 보면 변수값은 -1 되지만 화면으로는 모름.
	}

	const increase = function() {
		page = page + (1);
		if(page > maxPage){
			page = 1;
		}
		setPage(page);
	}
	function add(amount){
		page = page + amount;
		if(page < 1){
			page = maxPage;
		}
		if(page > maxPage){
			page = 1;
		}
		setPage(page);
	}
	return(
		<div>
			{/* <Button text={"-"} click={decrease}/> */}
			<Button text={"-"} click={()=>add(-1)}/>
			<span>{page}</span>
			<span>/{maxPage}</span>
			{/* <Button text={"+"} click={()=>increase()}/> */}
			<Button text={"+"} click={()=> add(1)}/>
		</div>
	);
}

export default StateSample;