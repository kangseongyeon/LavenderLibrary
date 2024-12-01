<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사말</title>

<style>
   body {
	    font-family: Arial, sans-serif;
	    margin: 0;
	    padding: 0;
	    display: flex;
	    flex-direction: column;
	    min-height: 100vh;
	}
	.container {
	    display: flex;
	}
	.content {
	    flex: 1;
	    padding: 20px;
	    width:1024px;
	    max-width:1024px;
	}
	.content p {
		margin: 0 30px 10px;
	}
	.content p1 {
		margin: 0 0 10px;
	}
	.greeting {
	    display: flex;
	    align-items: start;
	    margin-bottom: 20px;
	}
	
	.director-photo {
	    width: 150px;
	    margin-right: 20px;
	}
	
	.greeting-text h2 {
	    color: #e65100;
	}
	
	h3 {
	    color: #e65100;
	}
	b {
		color: #9986b3;
	}
	.container h3 {
		color : #B57EDC;
	}
</style>
</head>
<body>
<%@include file="/include/header.jsp"%>

<div class="container">        
  <div class="content" style="position:relative; left: 200px;">
           <br>
            <h1><b>인사말</b></h1><br>
            <div class="greeting">
                <img src="<%=request.getContextPath()%>/images/도서관장.png" alt="도서관장 사진" class="director-photo">
                <div class="greeting-text">
                    <h2>안녕하십니까?</h2>
                    <br>
                    <p1>대전광역시 라벤더도서관장 박병주입니다.</p1>
                    <p1>라벤더도서관에 오신 것을 환영합니다.</p1><br>
                    <p1>라벤더도서관은 대전지역 대표도서관으로 지식정보, 문화, 교육의 센터로서의 역할을 수행하며<br>
                    도서관 협력을 주도하는 시민과 함께 성장하는 도서관입니다.</p1>
               <br>
                </div>
            </div>
            
            <div class="history">
                <p1>1989년 개관이래 도서, 비도서, 전자매체 등 다양한 자료를 확충해 왔으며, 정보자료의 효율적인 접근과 이용을 보장하고 개개인의 삶과 직결되는 다양한 독서문화 프로그램과 서비스 제공을 통해 <br>
                	대전 시민의 삶과 지역사회의 발전에 기여하고자 합니다.</p1>
            </div>
            <br>
            <div class="library-features">
                <h3><b2><img src="<%= request.getContextPath() %>/images/라벤더.png" alt="라벤더">   개인의 가능성을 발견하는 라벤더도서관</h3>
                <p>라벤더도서관은 인문, 문화, 예술, 교육 등 분야별로 시민역량 발견 프로그램을 운영합니다. 또한 생애주기별 도서관서비스를 개발하면서 온 가족이 함께 하는 다채로운 공연과 전시회도 진행합니다. 그리고 소통과 연대를 위한 토론의 장인 독서모임 및 취미와 여가 활동을 위한 생활문화 동호회를 활성화하고 있습니다. 라벤더도서관은 시민들의 변화를 모색하는 활동과 관계망의 플랫폼이 되도록 힘쓰겠습니다.</p>
            </div>
            <br>
            <div class="social-inclusion">
                <h3><b2><img src="<%= request.getContextPath() %>/images/라벤더.png" alt="라벤더">   사회적 포용을 실천하는 라벤더도서관</h3>
                <p>라벤더도서관은 적극적 정보복지 실현을 위해 정보 및 매체 이용교육을 강화하고, 특수 환경 도서관 이용자를 위한 정보서비스와 아웃리치서비스를 지속적으로 확대해 나가고자 합니다. 특히 분야별, 계층별로 공평과 배려가 담겨있는 내실 있는 문화, 교육 프로그램을 개발하여 문화격차해소를 통한 사회통합에 기여하겠습니다.</p>
            </div>
            <br>
            <div class="social-inclusion2">
                <h3><b2><img src="<%= request.getContextPath() %>/images/라벤더.png" alt="라벤더">   공동체의 역량을 키우는 라벤더도서관</h3>
                <p>대전지역 대표도서관으로 국가도서관, 지역 공공도서관, 학교도서관, 작은도서관 등 관종별 도서관과의 협력체계 구축을 통한 도서관 균형발전을 도모하고, 지역사회 독서문화 단체 등과의 연대의 장도 마련하여 동반 성장을 이룰 수 있도록 노력 하겠습니다.</p>
            </div>
        </div>
    </div>
    
    <script>
    
     let active = "<%=request.getAttribute("active") %>"
    
    </script>
    
    <%request.setAttribute("active", "intro"); %>
   <%@include file="/include/libSidebar.jsp"%>
   
      <div class="col-sm-8 text-left">
<!--       <h1>1</h1> -->
   </div>
   
   

    
    
    
<%@include file="/include/footer.jsp"%>
</body>
</html>