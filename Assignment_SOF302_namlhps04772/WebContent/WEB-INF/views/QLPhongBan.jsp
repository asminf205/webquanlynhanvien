<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Skylined</title>
<meta charset="utf-8">
<noscript>
<link rel="stylesheet"  href="css/core.css">
<link rel="stylesheet"  href="css/core-desktop.css">
<link rel="stylesheet"  href="css/core-1200px.css">
<link rel="stylesheet"  href="css/core-noscript.css">
<link rel="stylesheet"  href="css/style.css">
<link rel="stylesheet"  href="css/style-desktop.css">
</noscript>
<script src="css/5grid/jquery.js"></script>
<script src="css/5grid/init.js?use=mobile,desktop,1000px&amp;mobileUI=1&amp;mobileUI.theme=none"></script>
<!--[if IE 9]><link rel="stylesheet" href="css/style-ie9.css"><![endif]-->
</head>
<body class="homepage">
<div id="wrapper">
  <div id="header-wrapper">
    <header id="header">
      <div class="5grid-layout">
        <div class="row">
          <div class="12u" id="logo">
            <!-- Logo -->
            <h1><a href="#" class="mobileUI-site-name">Skylined</a></h1>
            <p>Free Responsive Template</p>
          </div>
        </div>
      </div>
      <div class="5grid-layout">
        <div class="row">
          <div class="12u" id="menu">
            <nav class="mobileUI-site-nav">
              <ul>
                <li class="current_page_item"><a href="TrangChu.htm">Homepage</a></li>
               <li><a href="QLNhanVien.htm">NhanVien</a></li>
         	   <li><a href="Thanhtichkyluat.htm">Thanh tich & ki luat</a></li>             
          	   <li><a href="QLPhongBan.htm">PhongBan</a></li>
               <li><a href="Tonghop.htm">TongHop</a></li>     
              </ul>
            </nav>
          </div>
        </div>
      </div>
    </header>
    <div class="5grid-layout">
      <div class="row">
        <div id="banner" class="12u">
          <div class="container"><a href="#"><img src="images/pics01.jpg" alt=""></a></div>
        </div>
      </div>
    </div>
  </div>
  <div id="marketing">
     
</div>
<div class="content">
${message2}
<form action="${pageContext.request.contextPath}/Phongban.htm" >

		<div>Mã Phòng Ban</div>
        <input name="txtMapb"/>

 		<div>Tên Phòng Ban</div>
 		 
        <input name="txtTenpb"/>
        <div>
        <input type="submit" name="action" value="Them"/>
		<input type="submit" name="action" value="CapNhat"/>
		<input type="submit" name="action" value="Xoa"/>
		<button name="btnReset">Nhập lại</button>        
        </div>
		
 </form>
 <table class="table table-hover" border="1">
        <tr>
            <th>Ma PB</th>
            <th>Tên PB</th>
            
        </tr>
        <c:forEach var="d" items="${Departs}">
        <tr>
            <td>${d.maPB}</td>
            <td>${d.tenPB}</td>           
        </tr>
        </c:forEach>
        </table>
	
</div>
<div id="copyright">
  <div class="5grid-layout">
    <div class="row">
      <div class="12u">
        <p>&copy; Your Site Name | Images: <a target="_blank" href="http://fotogrph.com/">Fotogrph</a> | Design: <a target="_blank" href="http://html5templates.com/">HTML5Templates.com</a></p>
      </div>
    </div>
  </div>
</div>
<div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div></body>
</html>



