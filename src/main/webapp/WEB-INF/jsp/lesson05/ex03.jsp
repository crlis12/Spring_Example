<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="number" value="12345678"></c:set>
	<h3>숫자 출력</h3>
	<%-- 숫자 단위 표시 --%>
	<fmt:formatNumber value="${number}"></fmt:formatNumber>
	
	<h3>Type</h3>
	<%-- 숫자 3자리마다 콤마 출력 단위 표시 --%>
	숫자: <fmt:formatNumber value="${number}" type="number"></fmt:formatNumber><br>
	<%-- groupingUsed: 콤마 제거 --%>
	숫자 3자리마다 쉼표 제거: <fmt:formatNumber value="${number}" type="number"  groupingUsed="false"></fmt:formatNumber><br>
	
	<%-- percent는 1이 100% --%>
	100%: <fmt:formatNumber value="1" type="percent"></fmt:formatNumber><br>
	40%: <fmt:formatNumber value="0.4" type="percent"></fmt:formatNumber><br>
	
	통화(원): <fmt:formatNumber value="${number}" type="currency"></fmt:formatNumber><br>
	통화(달러): <fmt:formatNumber value="${number }" type="currency" currencySymbol="$"></fmt:formatNumber>
	
	<h3>var로 변수에 저장</h3>
	<fmt:formatNumber value="${number}" type="currency" currencySymbol="$" var="doller"></fmt:formatNumber>
	달러 EL태그로 출력: ${doller }<br>
	
	<h3>Pattern</h3>
	3.14: <fmt:formatNumber value="3.14"></fmt:formatNumber><br>
	3.14(0.0000): <fmt:formatNumber value="3.14" pattern="0.0000"></fmt:formatNumber><br>
	3.14(#.####): <fmt:formatNumber value="3.14" pattern="#.####"></fmt:formatNumber><br>
	<%--반올림 해서 #자리까지 출력 --%>
	3.141592(#.####): <fmt:formatNumber value="3.141592" pattern="#.####"></fmt:formatNumber><br>
	
	<hr>
	
	<h3>Date 객체를 String 형태로 출력 => fmt:formatDate</h3>
	${today}<br>
	<fmt:formatDate value="${today}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" var="pattern1"/>
	pattern1: ${pattern1}<br>
	
	<fmt:formatDate value="${today}" var="pattern2" pattern="yyyy/MM/dd HH:mm:ss"/>
	pattern2: ${pattern2}<br>
	
	<h3>String을 Date객체로 변환 => fmt:parseDate</h3>
	Date 객체: <fmt:parseDate value="${pattern2}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:parseDate>
</body>
</html>