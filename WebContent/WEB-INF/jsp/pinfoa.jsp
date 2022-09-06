<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>كيف يراني الآخرون - حسابي</title>
	
	<link href="${pageContext.request.contextPath}/css/arabic.css" rel="stylesheet">
	
	<!-- Bootstrap core CSS -->
	<!--link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"-->
   	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap337.min.css">
   	<!-- specific -->
   	
   	<link href="${pageContext.request.contextPath}/css/grid.css" rel="stylesheet">
   	<link href="${pageContext.request.contextPath}/css/profile.css" rel="stylesheet">
   	
   	<meta name="viewport" content="width=device-width, initial-scale=1">
 		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap337.min.css">
   	
   	<!-- Side navigation menu -->
   	<link href="${pageContext.request.contextPath}/css/sidnavpush.css" rel="stylesheet">
	
	<!-- for responsive tabs -->
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap337.min.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/actions.js"></script>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css">
	<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
 	<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
 	<script src="${pageContext.request.contextPath}/js/checkFileType.js"></script>
</head>
<body>
	<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");%>
	<% if(session.getAttribute("username")==null) response.sendRedirect("/HappyLife");%>
	<header>
		<!-- Fixed navbar -->
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="javascript:void(0)"
						style="cursor: pointer;" id="nav_title" onclick="openNav()">&#9776;
						Happy Life</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a>مرحبا ${username}</a></li>
						<li class="active"><a href="${pageContext.request.contextPath}/logout">تسجيل الخروج</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</nav>
	</header>
	
	<div id="mySidenav" class="sidenav">
		<a href="/HappyLife/myinbox">Inbox</a>
		<a href="#">Sent</a>
		<a href="#">Search</a>
		<a href="#">My Favorites</a>
	</div>

	<br>
	<br>

	<br>
	<br>
	<div class="container">
		<ul class="nav nav-tabs navbar-right">
			<li><a href="#menu3">كيف تبحث عن </a></li>
			<li><a href="/HappyLife/search">البحث</a></li>
			<li class="active"><a href="/HappyLife/pinfo">حسابي الشخصي</a></li>
			<li><a href="/HappyLife/myprofile">الرئيسية</a></li>
		</ul>

		<div class="tab-content">

			<!-- home tab -->

			<div id="howilook" class="tab-pane fade in active">
				<br><br><br>
				<p>تعديل</p>
				<ul class="nav nav-pills updateProfile navbar-right">
					<li><a href="#myQuestions">My Questions</a></li>
					<li><a>صورتي <form action="uploadphoto" method="post" enctype="multipart/form-data">
										<input type="file" id="uploadFile" name="photo" multiple>
										<input type="submit" name="save" onclick="CheckFileName();">
									</form></a></li>
					<li><a href="${pageContext.request.contextPath}/aboutme&lookingfor">عني/ أبحث عن</a></li>
				</ul>
				<br>
				<hr>
				<br>
				<p style="text-align: right;">كيف يراني الآخرون</p>
				
				<br>
				<div id="user-block" class="grid-container container">
					<div class="row">
						<div class="profile-image col-xs-12 col-md-2">
							<div>
								<!-- src="http://placehold.it/119/00F/FFF" -->
								<p>
									<a id="mainfullimage" href="http://placehold.it/400/00F/FFF">
										<img src="${pageContext.request.contextPath}/publicphotos/${publicPhoto}" alt="click to see larger photo"
										title="click to see larger photo">
									</a>
								</p>
								<p>
									<a href="#createphotoprofilepage"><button>تغيير صورتك</button></a>
								</p>
							</div>
							<!-- <div><p><a href="#createphotoprofilepage"><button>Change Photo</button></a></p></div> -->
						</div>

						<div class="item3 col-xs-12 col-md-5">
							<ul class="navbar-right summary">
								<li><label>العمر: ${myAge}</label></li>
								<li><label>الموقع:</label></li>
								<li><label>آخر ظهور: الآن</label></li>
								<li><label>I am currently available for communication:</label></li>
								<li><label>معدل الرد على الرسائل:</label></li>
							</ul>
						</div>
						<div class="item4 col-xs-12 col-md-5">
							<ul class="primary">
								<li id="morelikeli"><a href="#prfprofile.php">أعضاء مثل ${username}</a></li>
								<li id="messagetoli"><a href="#purematches.php">إرسال رسالة </a></li>
								<li id="addfavli"><a href="#bestmatch.php">الإضافة إلى مفضلاتي</a></li>
								<li id="inviteli"><a href="#lookingforme.php">دعوة إلى الاطلاع على حسابي</a></li>
								<li id="myfavli"><a href="#favourites.php">ملاحظاتي على هذا الحساب</a></li>
								<li id="historyli"><a href="" target="_blank">Your history with them</a></li>
								<li id="dontshowmeli"><a href="" target="_blank">لا أريد رؤية هذا الحساب مجددا</a></li>
								<li id="blockedli"><a href="" target="_blank">حظر هذا الحساب</a></li>
							</ul>
						</div>
					</div>
					<!-- END .row -->
				</div>
				<!-- user-block -->
				<br>
				
				<form action="${pageContext.request.contextPath}/aboutme&lookingfor" method="POST">
				<div id="" class="grid-container">
					<!-- <h3 class="">Profile</h3> -->
					<table class="table table-dark">
						<tbody>
							<tr>
								<th class="col-md-4 text-right">حسابي</th>
							</tr>
							<tr>
								<th><c:if test="${not empty aboutMeInfo}">
									<p>${aboutMeInfo}</p>
								</c:if></th>
							</tr>
							
						</tbody>
					</table>
					
      				<table class="table table-dark">
	      				<tbody>
		      				<tr>
	      						<th class="col-md-3 text-right">نظام حياتي</th>
	      						<th class="col-md-3 text-right">عن حسابي</th>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">الصلاة: 
			      					<c:choose>
										<c:when test="${sessionUser.pray=='5'}">أصلي دائماً </c:when>
										<c:when test="${sessionUser.pray=='4'}">أحيانا أنام عن الفجر وأصلي القضاء</c:when>
										<c:when test="${sessionUser.pray=='3'}">نادرا ما أضيع صلاة وأصلي قضاء</c:when>
										<c:when test="${sessionUser.pray=='2'}">أحياناً أصلي</c:when>
										<c:when test="${sessionUser.pray=='1'}">أنوي أن أبدأ </c:when>
    								</c:choose>
								</td>
								<td class="col-md-3">الحساب أنشئ بواسطة: ${sessionUser.profilePostedBy}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">الطائفة: ${sessionUser.sect}</td>
			      				<td class="col-md-3">نوع الإقامة: ${sessionUser.residencyStatus}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">الحالة الاجتماعية: 
			      					<c:choose>
										<c:when test="${sessionUser.maritalStatus=='NM'}">لم يسبق لي الزواج من قبل</c:when>
										<c:otherwise>${sessionUser.maritalStatus}</c:otherwise>
    								</c:choose>
			      				</td>
			      				<td class="col-md-3">Are you Willing to relocate: </td>
			      			</tr>
			      			<tr>
			      				
			      				<td class="col-md-3">الأطفال: ${sessionUser.children}</td>
			      				<td class="col-md-3">القبيلة: ${sessionUser.ethnicOrigin}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">:من أصحاب الهمم </td>
			      				<td class="col-md-3">My Religious History: 
			      					<c:choose><c:when test="${sessionUser.religiousHistory=='dontmind'}">
									        		don't mind
									          </c:when>
									          <c:when test="${sessionUser.religiousHistory=='BM'}">
									        		Muslim since Birth
									          </c:when>
											  <c:otherwise> مسلم جديد </c:otherwise>
    								</c:choose>
    							</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3"></td>
			      				<td class="col-md-3">Like to have children: ${sessionUser.likeToHaveChildren}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3"></td>
			      				<td class="col-md-3">Polygamy: </td>
			      			</tr>
			      			<tr>
			      				<th class="col-md-3 text-right">المظهر الخارجي </th>
			      				<td class="col-md-3">اللغات: ${sessionuser.languages}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">لون الشعر: ${sessionUser.hairColor}</td>
			      				<th class="col-md-3 text-right">التعليم - العمل</th>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">البنية: ${sessionUser.bodyType}</td>
			      				<td class="col-md-3">المهنة: ${sessionuser.profession}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">الطول: ${sessionUser.height}</td>
			      				<td class="col-md-3">أعلى مؤهل أكاديمي: ${sessionuser.highestQual}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">
			      					<c:if test="${sessionUser.gender=='M'}">
										اللحية: ${sessionUser.hijabBeard}
									</c:if>
									<c:if test="${sessionUser.gender=='F'}"> الحجاب: 
										<c:choose>
											<c:when test="${sessionUser.hijabBeard=='withniqab'}">Always with Niqab </c:when>
											<c:when test="${sessionUser.hijabBeard=='dontmind'}">don't mind</c:when>
											<c:otherwise>Always</c:otherwise>
	    								</c:choose>
									</c:if>
			      				</td>
			      				<td class="col-md-3"></td>
			      			</tr>
		      			</tbody>
	      			</table>
				</div>

				<br>
				<div id="" class="grid-container">
					<!-- <h3 class="">Looking For</h3> -->
					<table class="table table-dark">
						<tbody>
							<tr>
								<th class="col-md-4 text-right">أبحث عن</th>
							</tr>
							<tr>
								<th><c:if test="${not empty sessionLookingFor.lookingFor}">
									<p>${lookingForInfo}</p>
								</c:if></th>
							</tr>
							
						</tbody>
					</table>
					<table class="table table-dark">
	      				<tbody>
		      				<tr>
      							<th class="col-md-3 text-right">أبحث في: ${sessionLookingFor.lookingIn}</th>
	      						<th class="col-md-3 text-right">العمر: من ${sessionLookingFor.ageL} إلى ${sessionLookingFor.ageH}</th>
			      			</tr>
			      			<tr>
			      				<th class="col-md-3 text-right">نبذة عن من أبحث</th>
			      				<th class="col-md-3 text-right">نمط الحياة</th>
			      			</tr>
			      			<tr>
								<td class="col-md-3">هل يوجد استعداد للإقامة مع أهل زوجتي - زوجي: 
									<c:choose>
										<c:when test="${sessionLookingFor.residencyStatus=='dontmind'}">don't mind</c:when>
										<c:when test="${sessionLookingFor.residencyStatus=='dc'}">Definitely Consider </c:when>
										<c:when test="${sessionLookingFor.residencyStatus=='mc'}">May Consider</c:when>
										<c:when test="${sessionLookingFor.residencyStatus=='wc'}">Would not Consider</c:when>
    								</c:choose>
								</td>
								<td class="col-md-3"> الصلاة: 
									<c:choose>
										<c:when test="${sessionLookingFor.pray=='dontmind'}">لا أهتم</c:when>
										<c:when test="${sessionLookingFor.pray=='AP'}">دائماً </c:when>
										<c:when test="${sessionLookingFor.pray=='smissfajr'}">أحيانا يضيع الفجر</c:when>
										<c:when test="${sessionLookingFor.pray=='rmissprayer'}">نادرا تضيع الصلاة</c:when>
    								</c:choose>
								</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Are you Willing to relocate: 
			      					<c:choose>
										<c:when test="${sessionLookingFor.willingToRelocate=='dontmind'}">don't mind</c:when>
										<c:when test="${sessionLookingFor.willingToRelocate=='Yes'}">Yes</c:when>
										<c:when test="${sessionLookingFor.willingToRelocate=='No'}">No</c:when>
    								</c:choose>
			      				</td>
			      				<td class="col-md-3">أي طائفة تود -تودين الزواج: ${sessionLookingFor.sect}</td>
			      			</tr>
			      			<tr>
								<td class="col-md-3">القبيلة: ${sessionLookingFor.ethnicOrigin}</td>
								<td class="col-md-3">الحالة الاجتماعية: 
									<c:choose>
										<c:when test="${sessionLookingFor.maritalStatus=='NM'}">لم يسبق له - لها الزواج</c:when>
										<c:otherwise>${sessionLookingFor.maritalStatus}</c:otherwise>
    								</c:choose>
								</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Candidate Religious History: 
			      					<c:choose><c:when test="${sessionLookingFor.religiousHistory=='dontmind'}">
									        		don't mind
									          </c:when>
									          <c:when test="${sessionLookingFor.religiousHistory=='BM'}">
									        		Muslim since Birth
									          </c:when>
											  <c:otherwise> Revert Muslim </c:otherwise>
    								</c:choose>
    							</td>
			      				<td class="col-md-3">له - لها  أطفال: ${sessionLookingFor.hasChildren}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Living with in-laws: 
			      					<c:choose><c:when test="${sessionLookingFor.livingWithInLaws=='dontmind'}">
									        		don't mind
									          </c:when>
									          <c:when test="${sessionLookingFor.livingWithInLaws=='dc'}">
									        		Definitely Consider
									          </c:when>
									          <c:when test="${sessionLookingFor.livingWithInLaws=='mc'}">
									        		May Consider
									          </c:when>
											  <c:otherwise>Would not Consider </c:otherwise>
    								</c:choose>
			      				</td>
			      				<td class="col-md-3">Has physical disability: ${sessionLookingFor.hasPDisability}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3"></td>
			      				<td class="col-md-3">Like to have children: ${sessionLookingFor.likeToHaveChildren}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3"></td>
			      				<td class="col-md-3">Polygamy: </td>
			      			</tr>
			      			<tr>
			      				<th class="col-md-3 text-right">المظهر الخارجي </th>
			      				<th class="col-md-3 text-right">التعليم - العمل</th>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Body type: ${sessionLookingFor.bodyType}</td>
			      				<td class="col-md-3">Profession: ${sessionLookingFor.profession}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">
									<c:if test="${sessionUser.gender=='F'}">
										اللحية: ${sessionLookingFor.hijabBeard}
									</c:if>
									<c:if test="${sessionUser.gender=='M'}"> الحجاب: 
										<c:choose>
											<c:when test="${sessionLookingFor.hijabBeard=='withniqab'}">Always with Niqab </c:when>
											<c:when test="${sessionLookingFor.hijabBeard=='dontmind'}">don't mind</c:when>
											<c:otherwise>Always</c:otherwise>
	    								</c:choose>
									</c:if>
								</td>
			      				<td class="col-md-3">أقل مؤهل أكاديمي: ${sessionLookingFor.minimumQual}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">
			      					الطول: من ${sessionLookingFor.heightL} إلى ${sessionLookingFor.heightH} 
			      				</td>
			      				<td class="col-md-3"></td>
			      			</tr>
		      			</tbody>
	      			</table>
				</div>
				</form>
				<br>
			</div>


		</div>

	</div>
	<!-- container -->


	<script type="text/javascript" src="${pageContext.request.contextPath}/js/actions.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/opennav.js"></script>
	
</body>
</html>