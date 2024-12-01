package kr.or.ddit.vo;

import java.time.LocalDate;
import java.util.Date;

public class EventVO {

   private String eventRow;
   private String eventNo; /*  */
   private String eventType;
   private String eventName; /*  */
   private LocalDate eventDateStr; /*  */
   private LocalDate eventDateEnd; /*  */
   private String eventPeople; /*  */
   private String eventPlace; /*  */
   private LocalDate eventRegDateStr; /*  */
   private LocalDate eventRegDateEnd; /*  */
   private String eventContent; /*  */
   private String adminId; /*  */
   private long atchFileId=-1;

   public EventVO(String eventRow, String eventNo, String eventType, String eventName, LocalDate eventDateStr,
         LocalDate eventDateEnd, String eventPeople, String eventPlace, LocalDate eventRegDateStr,
         LocalDate eventRegDateEnd, String eventContent, String adminId, String imgId) {
      super();
      this.eventRow = eventRow;
      this.eventNo = eventNo;
      this.eventType = eventType;
      this.eventName = eventName;
      this.eventDateStr = eventDateStr;
      this.eventDateEnd = eventDateEnd;
      this.eventPeople = eventPeople;
      this.eventPlace = eventPlace;
      this.eventRegDateStr = eventRegDateStr;
      this.eventRegDateEnd = eventRegDateEnd;
      this.eventContent = eventContent;
      this.adminId = adminId;
   }

   
   public String getAdminId() {
      return adminId;
   }


   public void setAdminId(String adminId) {
      this.adminId = adminId;
   }


   public EventVO() {
   }
   
   public String getEventType() {
      return eventType;
   }
   
   public void setEventType(String eventType) {
      this.eventType = eventType;
   }
   
   public EventVO(String eventRow, String eventNo, String eventType , String eventName, LocalDate eventDateStr, LocalDate eventDateEnd,
         String eventPeople, String eventPlace, LocalDate eventRegDateStr, LocalDate eventRegDateEnd,
         String eventContent, String adminId) {
      super();
      this.eventRow = eventRow;
      this.eventNo = eventNo;
      this.eventType = eventType;
      this.eventName = eventName;
      this.eventDateStr = eventDateStr;
      this.eventDateEnd = eventDateEnd;
      this.eventPeople = eventPeople;
      this.eventPlace = eventPlace;
      this.eventRegDateStr = eventRegDateStr;
      this.eventRegDateEnd = eventRegDateEnd;
      this.eventContent = eventContent;
      this.adminId = adminId;
   }

   public EventVO(String eventRow, String eventNo, String eventName, LocalDate eventDateStr, LocalDate eventDateEnd, String eventPeople,
         String eventPlace, LocalDate eventRegDateStr, LocalDate eventRegDateEnd, String eventContent,
         String adminId) {
      super();
      this.eventRow = eventRow;
      this.eventNo = eventNo;
      this.eventName = eventName;
      this.eventDateStr = eventDateStr;
      this.eventDateEnd = eventDateEnd;
      this.eventPeople = eventPeople;
      this.eventPlace = eventPlace;
      this.eventRegDateStr = eventRegDateStr;
      this.eventRegDateEnd = eventRegDateEnd;
      this.eventContent = eventContent;
      this.adminId = adminId;
   }

   public EventVO(String eventNo, String eventName, LocalDate eventDateStr, LocalDate eventDateEnd, String eventPeople,
         String eventPlace, LocalDate eventRegDateStr, LocalDate eventRegDateEnd, String eventContent,
         String adminId) {
      super();
      this.eventNo = eventNo;
      this.eventName = eventName;
      this.eventDateStr = eventDateStr;
      this.eventDateEnd = eventDateEnd;
      this.eventPeople = eventPeople;
      this.eventPlace = eventPlace;
      this.eventRegDateStr = eventRegDateStr;
      this.eventRegDateEnd = eventRegDateEnd;
      this.eventContent = eventContent;
      this.adminId = adminId;
   }
   
   public EventVO( String eventName, LocalDate eventDateStr, LocalDate eventDateEnd, String eventPeople,
         String eventPlace, LocalDate eventRegDateStr, LocalDate eventRegDateEnd, String eventContent,
         String adminId) {
      super();
      this.eventName = eventName;
      this.eventDateStr = eventDateStr;
      this.eventDateEnd = eventDateEnd;
      this.eventPeople = eventPeople;
      this.eventPlace = eventPlace;
      this.eventRegDateStr = eventRegDateStr;
      this.eventRegDateEnd = eventRegDateEnd;
      this.eventContent = eventContent;
      this.adminId = adminId;
   }


   
   public EventVO(String eventNo, String eventType, String eventName, LocalDate eventDateStr, LocalDate eventDateEnd,
         LocalDate eventRegDateStr, LocalDate eventRegDateEnd) {
      super();
      this.eventNo = eventNo;
      this.eventType = eventType;
      this.eventName = eventName;
      this.eventDateStr = eventDateStr;
      this.eventDateEnd = eventDateEnd;
      this.eventRegDateStr = eventRegDateStr;
      this.eventRegDateEnd = eventRegDateEnd;
   }

   
   
   
   public long getAtchFileId() {
      return atchFileId;
   }

   public void setAtchFileId(long atchFileId) {
      this.atchFileId = atchFileId;
   }

   public LocalDate getEventDateStr() {
      return eventDateStr;
   }



   public void setEventDateStr(LocalDate eventDateStr) {
      this.eventDateStr = eventDateStr;
   }



   public String getEventRow() {
      return eventRow;
   }

   public void setEventRow(String eventRow) {
      this.eventRow = eventRow;
   }

   public LocalDate getEventDateEnd() {
      return eventDateEnd;
   }



   public void setEventDateEnd(LocalDate eventDateEnd) {
      this.eventDateEnd = eventDateEnd;
   }



   public LocalDate getEventRegDateStr() {
      return eventRegDateStr;
   }



   public void setEventRegDateStr(LocalDate eventRegDateStr) {
      this.eventRegDateStr = eventRegDateStr;
   }



   public LocalDate getEventRegDateEnd() {
      return eventRegDateEnd;
   }



   public void setEventRegDateEnd(LocalDate eventRegDateEnd) {
      this.eventRegDateEnd = eventRegDateEnd;
   }



   public String getEventContent() {
      return eventContent;
   }



   public void setEventContent(String eventContent) {
      this.eventContent = eventContent;
   }



   public String getEventNo() {
      return eventNo;
   }
   public void setEventNo(String eventNo) {
      this.eventNo = eventNo;
   }
   public String getEventName() {
      return eventName;
   }
   public void setEventName(String eventName) {
      this.eventName = eventName;
   }
   public String getEventPeople() {
      return eventPeople;
   }
   public void setEventPeople(String eventPeople) {
      this.eventPeople = eventPeople;
   }
   public String getEventPlace() {
      return eventPlace;
   }
   public void setEventPlace(String eventPlace) {
      this.eventPlace = eventPlace;
   }
   
   

   @Override
    public String toString() {
        return "EventVO{" +
                "eventNo=" + eventNo +
                ", eventType='" + eventType + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventDateStr=" + eventDateStr +
                ", eventDateEnd=" + eventDateEnd +
                ", eventRegDateStr=" + eventRegDateStr +
                ", eventRegDateEnd=" + eventRegDateEnd +
                ", eventContent=" + eventContent +
                '}';
    }
   
    public String toJson() {
           return "{" +
               "\"eventNo\":" + eventNo + "," +
               "\"eventType\":\"" + eventType + "\"," +
               "\"eventName\":\"" + eventName + "\"," +
               "\"eventDateStr\":\"" + eventDateStr + "\"," +
               "\"eventDateEnd\":\"" + eventDateEnd + "\"," +
               "\"eventRegDateStr\":\"" + eventRegDateStr + "\"," +
               "\"eventRegDateEnd\":\"" + eventRegDateEnd + "\"" +
             
               "}";
       }
   
}