<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전송 확인</h1>
	<!-- 
	서버에서 객체로 보낸 경우 객체명.필드명으로 호출하는데, 이 때 실제 필드를 가져오는 것이 아니라 getter를 호출
	밑의 실행 코드 두 줄의 결과가 같다는 것에서 알 수 있음.
	-->
	<p>${person.name}의 나이 : ${person.age}</p>
	<p>${person.getName()}의 나이 : ${person.getAge()}</p>
	<p>${person.total}</p>
</form>
</body>
</html>