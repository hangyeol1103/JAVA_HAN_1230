import { useState } from "react";

function MapSample(){
	let titles = ["아침", "점심", "저녁", "간식"];
	return(
		<div>
			<ul>
				{
					titles.map((v, i, arr)=>{ // v=> 벨류? i => 번지, arr => 배열전체 
						return <li key={i}>{v}</li>
					})
				}
			</ul>
		</div>
	)
}
export default MapSample;