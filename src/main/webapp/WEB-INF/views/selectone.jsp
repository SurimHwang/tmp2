<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>SelectOne</title>
</head>
<body>
	<h3>게시글 보기</h3>
	<table border="1">
		<tr>
			<th>No</th>
			<td>${board.bno}</td>
		</tr>
		<tr>
			<th>Apart Name</th>
			<td>${board.apartName}</td>
		</tr>
		<tr>
			<th>Floor</th>
			<td>${board.floor}</td>
		</tr>
		<tr>
			<th>Price(만원)</th>
			<td>${board.price}</td>
		</tr>
		<tr>
			<th>Area(㎡)</th>
			<td>${board.area}</td>
		</tr>
		<tr>
			<th>Date</th>
			<td>${board.date}</td>
		</tr>
		<tr>
			<th>Address</th>
			<td>${board.address}</td>
		</tr>
	</table>
	<button onclick="location='boardlist.do'" formmethod="post">목록</button>
	
	<!-- 댓글 시작 -->
		<div class="box">	
				<ul class="replyClass" >
					<c:forEach items="${reply}" var="reply" varStatus="status">
						<form action="/replyModify" method="get">
							<li>
								<input type="hidden" name="rno" value="${reply.rno}"> 
								<input type="hidden" name="bno" value="${reply.bno}">
								${reply.writer}|${reply.date}<br>
								
								<p id="${status.count}">${reply.contents}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" onclick="rereply(${status.count})">답글</button><button type="button" onclick="hideReply(${status.count})">수정</button><button formaction="/replyDelete" type="submit" >삭제</button></p>
								<textarea rows="4" cols="50" style="display:none" id="txt${status.count}" name="contents">${reply.contents}</textarea>
								
								<!-- 댓글 수정란 -->
								<button id="upbtn${status.count}" type="submit" style="display:none">수정완료</button>
								<button type="button" id="cancelbtn${status.count}" onclick="location='selectone?bno=${board.bno}'" style="display:none">취소</button>
								
								<!-- 답글 작성란 -->
								<p id="ptagrereply${status.count}" style="display:none">작성자:<%String name = (String) session.getAttribute("userName");%><%=name%></p>
								<textarea rows="4" cols="50" style="display:none" id="txtrereply${status.count}" name="REcontents">RE:</textarea>
								 <button type="button" id="btnrereply${status.count}" style="display:none"
								 onclick="fnSubMit(${board.bno}, ${reply.rno})">작성완료</button>
							</li>
						</form>
					</c:forEach>
				</ul>
		
			<form action="/replyWrite" method="get">
				<br/>
				<p>
					<label>댓글 작성자</label> <input type="text"
						name="writer"
						value=<%String name = (String) session.getAttribute("userName");%>
						<%=name%> readonly="readonly">
				</p>
				<p>
					<textarea rows="5" cols="50" name="contents"></textarea>
				</p>
				<p>
					<input type="hidden" name="bno" value="${board.bno}">
					<input type="hidden" name="parentId" value="${rno}">
					<button type="submit">작성</button>
				</p>
			</form>
		</div>
	<!-- 댓글 끝 -->
	<!-- 함수 -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">
		function fnSubMit(bno_, rno_){
			$.ajax({
				url : "/rereplyWrite",
				type : "post",
				data : { 
					bno : bno_,
					writer :'<%String name2 = (String) session.getAttribute("userName");%><%=name2%>',
					contents : $('textarea[name=REcontents]').val(),
					parentId : rno_,
					depth : 1
				},
				
				success : function(data){
					console.log(data);
					location.reload();
				}
			});
		}
		function hideReply(id){	
			var pTag = document.getElementById(id);
			pTag.style.display="none";
			
			var txtArea = document.getElementById("txt"+id);
			txtArea.style.display="";
			
			var upbtn = document.getElementById("upbtn"+id);
			upbtn.style.display="";
			
			var ccbtn = document.getElementById("cancelbtn"+id);
			ccbtn.style.display="";
		}
		function rereply(id){
			var ptag = document.getElementById("ptagrereply"+id);
			ptag.style.display="";
			
			var txt = document.getElementById("txtrereply"+id);
			txt.style.display="";
			
			var btn = document.getElementById("btnrereply"+id);
			btn.style.display="";
		}
		
		/* function String contents(){
			var conts = document.getElementByName("REcontents");
			return conts;
		} */
	</script>
</body>
</html>

