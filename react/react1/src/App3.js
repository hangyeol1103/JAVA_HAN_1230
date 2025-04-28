import { useState } from "react";

function App3(){
	let [hobbies, setHobbies] = useState([]);

	function change(e){
		let {value, checked} = e.target;
		//checked된 상태이면 배열에 추가
		if(checked){
			setHobbies([...hobbies, value]);
		}
		//아니면 배열에서 제거
		else{
			//setHobbies(hobbies.filter(v=>v !== value)) //filter는 배열에 있는 애들 중에서 식으로 넣어준 애를 제외한 나머지 애들로 배열을 새로 만들어지는 식
			let index = hobbies.indexOf(value);
			let tmp = [...hobbies];
			tmp.splice(index, 1);
			setHobbies(tmp);
		}
	}

	return(
		<div>
			<label>
				<input type="checkbox" value={"독서"} name="hobby" onClick={change}/> 독서
			</label>
			<label>
				<input type="checkbox" value={"운동"} name="hobby" onClick={change}/> 운동
			</label>
			<label>
				<input type="checkbox" value={"음악 감상"} name="hobby" onClick={change}/> 음악 감상
			</label>
			<h1>{hobbies.join(",")}</h1>
		</div>
	)
}

export default App3;