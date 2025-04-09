import { useState } from 'react';

function Button({click, className, text="버튼"}){

	let [num, setNum] = useState(1);
	function btnClick(){
    setNum(++num);
		alert(num)
  }

	return(
		<button onClick={btnClick} className="btn">{text}</button>
	);
}

export default Button;