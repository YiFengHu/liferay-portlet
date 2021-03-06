<%@include file="/html/init.jsp"%>

<%
    long guestbookId = Long.valueOf((Long) renderRequest
            .getAttribute("guestbookId"));

	Guestbook guestbook = (Guestbook) renderRequest
			.getAttribute("guestbook");
	
	System.out.println("view.jsp test: guestbook= "+guestbook);
	
	SimpleDateFormat formatter = new SimpleDateFormat("MM/DD/YYYY hh:mm a", Locale.US);
%>

<%-- <aui:nav css Class="nav-tabs">

    <%
    	List<Guestbook> guestbooks = GuestbookLocalServiceUtil
    		.getGuestbooks(scopeGroupId, WorkflowConstants.STATUS_APPROVED);

            for (int i = 0; i < guestbooks.size(); i++) {
                Guestbook curGuestbook = (Guestbook) guestbooks.get(i);

                String cssClass = StringPool.BLANK;

                if (curGuestbook.getGuestbookId() == guestbookId) {
                    cssClass = "active";
                }
                
                if (GuestbookPermission.contains(
                	    permissionChecker, curGuestbook.getGuestbookId(), "VIEW")) {
                
    %>

    <portlet:renderURL var="viewPageURL">
        <portlet:param name="mvcPath" value="/html/guestbook/view.jsp" />
        <portlet:param name="guestbookId"
            value="<%=String.valueOf(curGuestbook.getGuestbookId())%>" />
            <portlet:param name="guestbookName"
				value="<%=curGuestbook.getName()%>" />
    </portlet:renderURL>

    <aui:nav-item cssClass="<%=cssClass%>" href="<%=viewPageURL%>"
        label="<%=HtmlUtil.escape(curGuestbook.getName())%>" />

    <%
        }
    }
%> 

</aui:nav> --%>

<aui:button-row cssClass="guestbook-buttons">
	<%-- <c:if test='<%= GuestbookModelPermission.contains(permissionChecker, scopeGroupId, "ADD_GUESTBOOK") %>'>

    <portlet:renderURL var="addGuestbookURL">
        <portlet:param name="mvcPath"
            value="/html/guestbook/edit_guestbook.jsp" />
    </portlet:renderURL>
    <aui:button onClick="<%= addGuestbookURL.toString() %>" value="Add Guestbook" />
    
	</c:if> --%>

	<%-- <c:if test='<%= GuestbookPermission.contains(permissionChecker, guestbookId, "ADD_ENTRY") %>'> --%>
    <portlet:renderURL var="addEntryURL">
        <portlet:param name="mvcPath" value="/html/guestbook/edit_entry.jsp" />
        <portlet:param name="guestbookId"
            value="<%=String.valueOf(guestbookId)%>" />
    </portlet:renderURL>
    <aui:button onClick="<%= addEntryURL.toString() %>" value="Reservation"></aui:button>
    
	<%-- </c:if> --%>

    
    

</aui:button-row>

<liferay-ui:search-container>
    <liferay-ui:search-container-results
    		results="<%=EntryLocalServiceUtil.getEntriesByGroup(scopeGroupId)%>"
    		total="<%=EntryLocalServiceUtil.getEntriesCountByGroup(scopeGroupId)%>" />

    <liferay-ui:search-container-row
        className="com.kooppi.guestbook.model.Entry" modelVar="entry">

        <portlet:renderURL var="viewEntry">
        	<portlet:param name="mvcPath" value="/html/guestbook/view_entry.jsp" />
        	<portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
		</portlet:renderURL>

		<%-- <liferay-ui:search-container-column-text property="message" href="<%= viewEntry %>"/> --%>
		
		<%
			
			String status = "Pending";
		
			User assignee = null;
			try{
				assignee = UserLocalServiceUtil.getUser(entry.getStatusTaskAssigneeId());
			}catch(Exception e){
				e.printStackTrace();
			}
			String asigneeJob = assignee!=null?
					( (assignee.getJobTitle()!=null && assignee.getJobTitle().length()>0)? "("+assignee.getJobTitle()+")":  "("+assignee.getFullName()+")")
					: "";
		
			switch(entry.getStatus()){
				case 0: 
						status = "Approved  "+formatter.format(entry.getStatusDate()); 
						break;
						
						default:
							status = "Review"+asigneeJob;
			}
		%>

        <liferay-ui:search-container-column-text property="name" name="Applicant" />
        <liferay-ui:search-container-column-text property="conferenceRoomName" name="Room Number" />
        <liferay-ui:search-container-column-text property="useDate" name="Date(From - To)" />
        <liferay-ui:search-container-column-text value="<%= formatter.format(entry.getCreateDate()) %>" name="Apply Time" />
        <liferay-ui:search-container-column-text value="<%= status %>" name="Status" />
		
		<%-- <liferay-ui:search-container-column-jsp path="/html/guestbook/guestbook_actions.jsp" align="right" /> --%>
    </liferay-ui:search-container-row>
	
    <liferay-ui:search-iterator />    
</liferay-ui:search-container>