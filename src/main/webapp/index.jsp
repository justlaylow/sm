<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<html>
<body>

<c:forEach var="dep" items="${listDep}">
					<h2>${dep.depId}</h2>
								<h2>${dep.depName}</h2>
								<h2>${dep.depCostCategory}</h2>
								<h2>${dep.depRemark}</h2>
										</c:forEach>
</body>
</html>
