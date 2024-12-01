<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서관 자료 현황 및 시설 안내</title>
    <style>
    body { font-family: Arial, sans-serif; }
        .container { width: 80%; margin: 0 auto; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .tab { overflow: hidden; border: 1px solid #ccc; background-color: #f1f1f1; }
        .tab button { background-color: inherit; float: left; border: none; outline: none; cursor: pointer; padding: 14px 16px; }
        .tab button:hover { background-color: #ddd; }
        .tab button.active { background-color: #ccc; }
        .tabcontent { display: none; padding: 6px 12px; border: 1px solid #ccc; border-top: none; }
        .floor-map { width: 100%; height: 600px; border: 1px solid #ddd; }
        .legend { margin-top: 10px; }
        .legend span { margin-right: 20px; }
        
        .floor-img {
    		width: 850px;
    		margin-right: 500px;
		}
        .floor-tabs {
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}


.floor-tab {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
}

.floor-tab:hover {
    background-color: #ddd;
}

.floor-tab.active {
    background-color: #ccc;
}

.floor-map {
    display: none;
    padding: 6px 12px;
    border: 1px solid #ccc;
    border-top: none;
    height: 450px;
}
.floor-map img {
  width: 80%;
  display: block;
    margin: auto;
}
.floor-map.active {
    display: block;
    margin: auto;
}
	b {
		color: #9986b3;
	}
    </style>
</head>
<body>
<%@include file="/include/header.jsp"%>
<div class="container">
   <%@include file="/include/libSidebar.jsp"%>
   
	<div class="content" style="position:relative; left: 200px;">
    <br><br>
        <h1><b>도서관 현황</b></h1><br>
        
        <div class="tab">
            <button class="tablinks" onclick="openTab(event, 'MaterialStatus')">자료현황</button>
            <button class="tablinks" onclick="openTab(event, 'FacilityGuide')">시설안내</button>
        </div>

        <div id="MaterialStatus" class="tabcontent">
            <h2>도서 현황</h2>
            
            <h3>유형별 구분</h3>
            <table>
                <tr>
                    <th>구분</th>
                    <th>계</th>
                    <th>일반도서</th>
                    <th>아동도서</th>
                    <th>참고도서</th>
                    <th>논문</th>
                    <th>족보</th>
                    <th>북한자료</th>
                </tr>
                <tr>
                    <td>누계</td>
                    <td>908,053</td>
                    <td>685,910</td>
                    <td>131,560</td>
                    <td>8,420</td>
                    <td>75,621</td>
                    <td>5,552</td>
                    <td>990</td>
                </tr>
            </table><br>

            <h3>주제별 구분</h3>
            <table>
                <tr>
                    <th>구분</th>
                    <th>계</th>
                    <th>총류</th>
                    <th>철학</th>
                    <th>종교</th>
                    <th>사회과학</th>
                    <th>순수과학</th>
                    <th>기술과학</th>
                    <th>예술</th>
                    <th>어학</th>
                    <th>문학</th>
                    <th>역사</th>
                </tr>
                <tr>
                    <td>계</td>
                    <td>908,053</td>
                    <td>51,998</td>
                    <td>49,232</td>
                    <td>33,249</td>
                    <td>200,788</td>
                    <td>50,177</td>
                    <td>100,819</td>
                    <td>53,371</td>
                    <td>32,402</td>
                    <td>260,842</td>
                    <td>75,175</td>
                </tr>
            </table><br><br>
        </div>

        <div id="FacilityGuide" class="tabcontent">
    <h2>라벤더 도서관 시설안내도</h2>
    
    <div class="floor-tabs">
        <button class="floor-tab active" onclick="openFloor(event, 'floor4F')">본관 4F</button>
        <button class="floor-tab" onclick="openFloor(event, 'floor3F')">본관 3F</button>
        <button class="floor-tab" onclick="openFloor(event, 'floor2F')">본관 2F</button>
        <button class="floor-tab" onclick="openFloor(event, 'floor1F')">본관 1F</button>
    </div>
    
    <div class="floor-content">
        <div id="floor4F" class="floor-map active">
            <img src="<%=request.getContextPath()%>/images/본관4층2.png" alt="본관 4층" class="floor-img">
        </div>
        <div id="floor3F" class="floor-map">
            <img src="<%=request.getContextPath()%>/images/본관3층2.png" alt="본관 3층" class="floor-img">
        </div>
        <div id="floor2F" class="floor-map">
            <img src="<%=request.getContextPath()%>/images/본관2층2.png" alt="본관 2층" class="floor-img">
        </div>
        <div id="floor1F" class="floor-map">
            <img src="<%=request.getContextPath()%>/images/본관1층2.png" alt="본관 1층" class="floor-img">
        </div>
        <!-- 다른 층에 대한 div도 같은 방식으로 추가 -->
		        </div>
    	</div>
	</div>
</div>

    <script>
    
     let active = "<%=request.getAttribute("active") %>"
    
    </script>
    
    <%request.setAttribute("active", "info"); %>

    <script>
    function openTab(evt, tabName) {
        var i, tabcontent, tablinks;
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }
        document.getElementById(tabName).style.display = "block";
        evt.currentTarget.className += " active";
    }
    function openFloor(evt, floorName) {
        var i, floorMap, floorTabs;
        floorMap = document.getElementsByClassName("floor-map");
        for (i = 0; i < floorMap.length; i++) {
            floorMap[i].style.display = "none";
        }
        floorTabs = document.getElementsByClassName("floor-tab");
        for (i = 0; i < floorTabs.length; i++) {
            floorTabs[i].className = floorTabs[i].className.replace(" active", "");
        }
        document.getElementById(floorName).style.display = "block";
        evt.currentTarget.className += " active";
    }

    // 페이지 로드 시 자료현황 탭을 기본으로 표시
    document.getElementsByClassName("tablinks")[0].click();
    </script>
    <%@include file="/include/footer.jsp"%>
</body>
</html>