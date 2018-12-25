<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.kooppi.guestbook.model.Guestbook" %>
<%@ page import="com.kooppi.guestbook.service.EntryLocalServiceUtil" %>
<%@ page import="com.kooppi.guestbook.service.GuestbookLocalServiceUtil" %>

<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.kooppi.guestbook.model.Entry" %>
<%@ page import="com.kooppi.guestbook.util.WebKeys" %>

<%@ page import="com.kooppi.guestbook.service.permission.GuestbookModelPermission" %>
<%@ page import="com.kooppi.guestbook.service.permission.GuestbookPermission" %>
<%@ page import="com.kooppi.guestbook.service.permission.EntryPermission" %>

<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>

<%@ page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.asset.service.AssetTagLocalServiceUtil" %>

<%@ page import="com.liferay.portlet.asset.model.AssetEntry" %>
<%@ page import="com.liferay.portlet.asset.model.AssetTag" %>

<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>

<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>

<portlet:defineObjects />
<theme:defineObjects />
