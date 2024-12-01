<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
<!--     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" /> -->
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.14/index.global.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<!--     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> -->
   	<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/jquery-ui.min.js"></script>



   	
    
    <script>
	      document.addEventListener("DOMContentLoaded", function () {
	        var calendarEl = document.getElementById("calendar");
	        var today = new Date();
	        var calendar = new FullCalendar.Calendar(calendarEl, {
	        	<c:set var="loginCode" value="${sessionScope.loginCode}" />
	        	<c:choose>
	        		<c:when test="${loginCode == 'b1a4'}">
	        customButtons: {
	            eventInsert: {
	              text: 'EventInsert',
	              click: function() {
	            	  window.location.href = "<%= request.getContextPath() %>/adminEvent/insert.do" ;
	              }
	            }
	          },
	          headerToolbar: {
	            left: "prev,next today",
	            center: "title",
	            right: "eventInsert dayGridMonth",
	          },
	          </c:when>
	          <c:otherwise>
	          
	          headerToolbar: {
		            left: "prev,next today",
		            center: "title",
		            right: "dayGridMonth",
		          },
		          
	          </c:otherwise>
	          </c:choose>
	          
	          initialDate: today,
	          locale: "ko",
	          navLinks: true, // can click day/week names to navigate views
	          selectable: true,
	          selectMirror: true,
	          editable: true,
	          dayMaxEvents: false, // allow "more" link when too many events
	          events: [
	            {
	              title: "Click for Google",
	              url: "http://google.com/",
	              start: "2023-01-28",
	            },
	            
		        	
	        	
	          ],
	         
	        	  
	          
	          weekends: true,
	          datesSet: function(info) {
	        	  
	        
	        	  calendar.removeAllEvents();
	        	  var calendarDate = calendar.currentData.viewTitle;
	        	  var arrayCalendarDate = calendarDate.split(" ");
	        	  
	        	  var startDate = arrayCalendarDate[0].substring(0,4);
	        	 
	        	  var endDate = arrayCalendarDate[1];
	        	  if (arrayCalendarDate.indexOf('1월') !== -1 || arrayCalendarDate.indexOf('2월') !== -1 ||  arrayCalendarDate.indexOf('3월') !== -1 ||
	        			  arrayCalendarDate.indexOf('4월') !== -1 ||  arrayCalendarDate.indexOf('5월') !== -1 ||  arrayCalendarDate.indexOf('6월') !== -1 ||
	        			  arrayCalendarDate.indexOf('7월') !== -1 ||  arrayCalendarDate.indexOf('8월') !== -1 || arrayCalendarDate.indexOf('9월') !== -1) {
	        	      endDate = arrayCalendarDate[1].substring(0, 1);
	        	  } else {
	        	      endDate = arrayCalendarDate[1].substring(0, 2);
	        	  }
	        	  
	        	  console.log("월 값:", endDate);

	        	  $.ajax({
	        	      url: "<%=request.getContextPath()%>/adminEvent/eventCalender.do",
	        	      method: "POST",
	        	      data: {
	        	          startDate: startDate,
	        	          endDate: endDate,
	        	      },
	        	      success: function(response) {
	        	          var events2 = JSON.parse(response);
	        	          for(let i=0; i<events2.length; i++) {
	        	              var eventNo = events2[i].eventNo;
	        	              var eventType = events2[i].eventType; 
	        	              var eventName = events2[i].eventName;
	        	              var eventDateStr = events2[i].eventDateStr;
	        	              var eventDateEnd = new Date(events2[i].eventDateEnd);
	        	              eventDateEnd.setDate(eventDateEnd.getDate() + 1); // end+1day

	        	              // eventadd
	        	              calendar.addEvent({
	        	                  title: eventName,
	        	                  url: `<%= request.getContextPath() %>/adminEvent/eventDetail.do?eventNo=\${eventNo}`,
	        	                  start: eventDateStr,
	        	                  end: eventDateEnd.toISOString().split('T')[0], // date change            
	        	                  textColor: "#000000",
	        	                  color: getEventColor(eventType)
	        	              });
	        	          }
	        	      },
	        	      error: function(response) {
	        	          console.log(response);
	        	      }
	        	  });
	            
          }
        });

        calendar.render();

        
        // íìë³ ìì ì§ì 
        function getEventColor(eventType) {
        	  switch (eventType) {
        	    case 'library':
        	      return '#E6E6FA'; // ë¼ë²¤ë
        	    case 'hoilday':
        	      return '#FF4500'; // ë¼ë²¤ë
        	    case 'fieldstudy':
        	      return '#DDA0DD'; // íë¼
        	    case 'movie':
        	      return '#FFB6C1'; // ë¼ì´í¸íí¬
        	    // Add more cases for different event types
        	    default:
        	      return '#9E9E9E'; // Grayìì´ì¼
        	  }
        	 }
        	  
        	document.getElementById('insertEvent').addEventListener('click', function() {
            	window.location.href = "<%= request.getContextPath() %>/adminEvent/insert.do" ;
            	
          	});
      });
    </script>
     <style>
    html, body {
	height: 100%;
	margin: 0;
	padding: 0;
	}

	body {
	display: flex;
	flex-direction: column;
	background: linear-gradient(rgba(255, 255, 255, 0.5), rgba(255, 255, 255, 0.3)), url("<%=request.getContextPath()%>/images/lab.png");
	background-size: cover;
 	background-repeat: no-repeat;
	height: 50vh;
	z-index: 0;
	}

	.content-wrapper {
	flex: 1 0 auto;
	display: flex;
	}

	.main-content {
	flex: 1;
	padding: 20px; 
	}

	table {
	border:2px double black;
	margin:auto;
	}
    #calenderDiv {
    	hight : 60%;
    	width : 75%;	
   	}
   	#calendarDiv{
   		hight : 70%;
   		width : 70%;
   		
   	}
   	/*Ã¬ÂÂ¼Ã¬ÂÂÃ¬ÂÂ¼ Ã«Â¹Â¨ÃªÂ°ÂÃ¬ÂÂ*/
	.fc-day a{
	color : black;
	text-decoration: none;
	}
   	.fc-day-sun a {
 	 color: red;
  	text-decoration: none;
	}
	/* Ã­ÂÂ Ã¬ÂÂÃ¬ÂÂ¼ Ã«ÂÂ Ã¬Â§Â Ã­ÂÂÃ«ÂÂÃ¬ÂÂ */
	.fc-day-sat a {
 	 color: blue;
 	 text-decoration: none;
	}
   	.fc-event {
   	font-size : 13px;
   	}
  </style>
  </head>
  <body>
  <%@include file="/include/header.jsp"%>
	<div class="container"> 
	<%@include file="/include/eventSidebar.jsp"%>
	<div class="content" style="position:relative; left: 200px;"> 
	
	
	<div class="content-wrapper">
		<main class="main-content">
		<h1>라벤더 도서관 달력</h1>
		<br>
  <div id=calendarDiv>
    <div id="calendar"></div>
 <!--    <button class="btn btn-primary" data-toggle="modal" data-target="#eventModal">Add Event</button> -->
 
 
    <div
      class="modal fade"
      id="eventModal"
      tabindex="-1"
      role="dialog"
      aria-labelledby="eventModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="eventModalLabel">Add Event</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form>
              <div class="form-group">
                <label for="event-title" class="col-form-label">Event Title:</label>
                <input type="text" class="form-control" id="event-title" />
              </div>
              <div class="form-group">
                <label for="event-date" class="col-form-label">Event Date:</label>
                <input type="date" class="form-control" id="event-date" />
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" id="save-event">Save</button>
          </div>
        </div>
      </div>
    </div>
    </div>
    </main>
    </div>
    	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<!-- 		<script>
			function adjustFooter() {
				var docHeight = document.documentElement.offsetHeight;
				var windowHeight = window.innerHeight;
				var footer = document.querySelector('footer');

				if (docHeight <= windowHeight) {
					footer.style.position = 'fixed';
					footer.style.bottom = '0';
					footer.style.width = '100%';
				} else {
					footer.style.position = 'static';
				}
			}

			window.addEventListener('load', adjustFooter);
			window.addEventListener('resize', adjustFooter);
		</script> -->
	
	 </div>
	 </div>
	 
    <%
    request.setAttribute("active", "calender");
    session.setAttribute("active", "calender");
    %>
    
	<%@include file="/include/footer.jsp"%>
  </body>
</html>
