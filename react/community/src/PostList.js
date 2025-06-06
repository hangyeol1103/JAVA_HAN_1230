import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

function PostList(){
	let [list, setList] = useState([]);
	let [pm, setPm] = useState({});
	let [boards, setBoards] = useState([]);
	let {num} = useParams(); //app.js에 :num으로 넘겨줬기 때문에 useParam을 통해 자동 매핑인 0이 들어옴
	
	useEffect(()=>{
		console.log(num);
		fetch("/api/react/post/list?po_bo_num="+num)
		.then(res=>res.json())
		
		.then(res=>{
			setList(res.list);
			setPm(res.pm);
			setBoards(res.boardlist);
		})
	}, [num]);

	return(
		<div className="container">
			<h1>게시글 목록</h1>
			{
				boards.map(board=>{
					return (
					<Link to={"/post/list/" + board.bo_num} className="btn btn-outline-success me-2">{board.bo_name}</Link>)
				})
			}
			<table className="table table-striped table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
						<th>추천/비추천</th>
					</tr>
				</thead>
				<tbody>
					{
						list.map(post=>{
							return(
								<tr>
									<td>{post.po_num}</td>
									<td>{post.po_title}</td>
									<td>{post.po_me_id}</td>
									<td>{new Date(post.po_date).toLocaleDateString()}</td>
									<td>{post.po_view}</td>
									<td>{post.po_up}/{post.po_down}</td>
								</tr>
							)
						})
					}
				</tbody>
			</table>
			<ul className="pagination justify-content-center">
				{ pm.prev ?(
						<li className="page-item">
							<a className="page-link" href="javascript:void(0);">이전</a>
						</li>
				): null}

				{
					Array.from({length : pm.endPage - pm.startPage + 1}, (_, i) => pm.startPage + i).map(v=>{
						return (<li className="page-item">
							<a className="page-link">{v}</a>
						</li>)
					})
				}
				<li className="page-item">
					<a className="page-link" href="javascript:void(0);">다음</a>
				</li>
			</ul>
		</div>
	)
}
export default PostList;