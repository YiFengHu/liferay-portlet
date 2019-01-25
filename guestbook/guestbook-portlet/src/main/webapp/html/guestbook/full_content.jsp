<%@include file="/html/init.jsp"%>

<%
Entry entry = (Entry)request.getAttribute("rm_entry");

entry = entry.toEscapedModel();
%>

<dl>
        <dt>Conference Room</dt>
        <dd><%= entry.getConferenceRoomName() %></dd>
        <dt>User Name</dt>
        <dd><%= entry.getUserName() %></dd>
        <dt>Use Date</dt>
        <dd><%= entry.getUseDate() %></dd>
</dl>