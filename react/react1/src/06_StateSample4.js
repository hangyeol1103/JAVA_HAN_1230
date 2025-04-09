import { useState } from "react";


function StateSample4(){
	let [todo, setTodo] = useState("");
	let [todoList, setTodoList] = useState([]);

	function addTodo(e){
		e.preventDefault();
		if(todo.trim().length == 0){
			alert("할일을 입력하세요.");
			return;
		}
		setTodoList([...todoList, todo.trim()]);
		setTodo("");
	}

	return(
		<div>
			<form onSubmit={addTodo}>
				<input type="text" onChange={(e)=>setTodo(e.target.value)} value={todo}/>
				<button type="submit">등록</button>
			</form>
			<h1>오늘의 할일</h1>
			<ul>
				{
					todoList.map((v,i)=>{
						return <li key={i}>{v}</li>
					})
				}
			</ul>
		</div>
	)
}
export default StateSample4;