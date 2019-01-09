<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/8
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <th>用户名</th>
            <th>密码</th>
            <th>电话</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="u">
        <tr>
            <td>${u.username}</td>
            <td>${u.password}</td>
            <td>${u.tele}</td>

        </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
<ul>
    <c:choose>
        <c:when test="${page.pages>0}">
            <c:choose>
                <c:when test="${page.isFirstPage}">
                    <li>首页</li>
                    <li>上一页</li>
                </c:when>
                <c:otherwise>
                    <li><a href="index.do?pageNum=1">首页</a></li>
                    <li><a href="index.do?pageNum=${page.prePage}">上一页</a></li>
                </c:otherwise>
            </c:choose>
            <c:forEach items="${page.navigatepageNums}" var="i">
                <c:choose>
                    <c:when test="${page.pageNum==i}">
                        <li>${i}</li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="index.do?pageNum=${i}">${i}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            
            <c:choose>
                <c:when test="${page.isLastPage}">
                    <li>下一页</li>
                    <li>尾页</li>
                </c:when>
                <c:otherwise>
                    <li><a href="index.do?pageNum=${page.nextPage}">下一页</a></li>
                    <li><a href="index.do?pageNum=${page.lastPage}">尾页</a></li>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>



    <%--<li><a href="">上一页</a></li>
    <li><a href="">1</a></li>
    <li><a href="">下一页</a></li>
    <li><a href="">尾页</a></li>--%>
</ul>

${page}
<br>
    <form action="doload.do" method="post" enctype="multipart/form-data">
        <input type="file" name="files">
        <input type="file" name="files">
        <input type="file" name="files">
        <input type="file" name="files">
        <input type="file" name="files">
        <input type="submit" value="上传">
    </form>

</body>
</html>