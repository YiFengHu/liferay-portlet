package com.kooppi.guestbook.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.kooppi.guestbook.model.Entry;
import com.kooppi.guestbook.model.Guestbook;
import com.kooppi.guestbook.service.EntryLocalServiceUtil;
import com.kooppi.guestbook.service.GuestbookLocalServiceUtil;
import com.kooppi.guestbook.service.GuestbookServiceUtil;
import com.kooppi.guestbook.util.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactory;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class GuestbookPortlet extends MVCPortlet{

	public void addGuestbook(ActionRequest request, ActionResponse response)
	        throws PortalException, SystemException {

	    ServiceContext serviceContext = ServiceContextFactory.getInstance(
	        Guestbook.class.getName(), request);

	    String name = ParamUtil.getString(request, "name");

	    try {
	        GuestbookLocalServiceUtil.addGuestbook(serviceContext.getUserId(),
	                name, serviceContext);

	        SessionMessages.add(request, "guestbookAdded");

	    } catch (Exception e) {
	        SessionErrors.add(request, e.getClass().getName());

	        response.setRenderParameter("mvcPath",
	            "/html/guestbook/edit_guestbook.jsp");
	    }

	}
	
	public void addEntry(ActionRequest request, ActionResponse response)
		       throws PortalException, SystemException {

		    ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         Entry.class.getName(), request);

		    String userName = ParamUtil.getString(request, "name");
		    String conferenceRoomName = ParamUtil.getString(request, "conferenceRoomName");
		    String useDate = ParamUtil.getString(request, "useDate");
		    long guestbookId = ParamUtil.getLong(request, "guestbookId");
		    long entryId = ParamUtil.getLong(request, "entryId");

		    if (entryId > 0) {

		       try {

		         EntryLocalServiceUtil.updateEntry(serviceContext.getUserId(),
		              guestbookId, entryId, userName, conferenceRoomName, useDate,
		              serviceContext);

		         SessionMessages.add(request, "entryAdded");

		         response.setRenderParameter("guestbookId",
		              Long.toString(guestbookId));

		       } catch (Exception e) {
		    	   e.printStackTrace();
		         SessionErrors.add(request, e.getClass().getName());

		                            PortalUtil.copyRequestParameters(request, response);

		         response.setRenderParameter("mvcPath",
		              "/html/guestbook/edit_entry.jsp");
		       }

		    }
		            else {

		       try {
		         EntryLocalServiceUtil.addEntry(serviceContext.getUserId(),
		              guestbookId, userName, conferenceRoomName, useDate, serviceContext);

		         SessionMessages.add(request, "entryAdded");

		         response.setRenderParameter("guestbookId",
		              Long.toString(guestbookId));

		       } catch (Exception e) {
		    	   e.printStackTrace();
		         SessionErrors.add(request, e.getClass().getName());

		                            PortalUtil.copyRequestParameters(request, response);

		         response.setRenderParameter("mvcPath",
		              "/html/guestbook/edit_entry.jsp");
		       }
		    }

		}

	
	public void deleteEntry (ActionRequest request, ActionResponse response) {

	    long entryId = ParamUtil.getLong(request, "entryId");
	    long guestbookId = ParamUtil.getLong(request, "guestbookId");

	    try {

	       ServiceContext serviceContext = ServiceContextFactory.getInstance(
	         Entry.class.getName(), request);

	                    response.setRenderParameter("guestbookId", Long.toString(guestbookId));

	       EntryLocalServiceUtil.deleteEntry(entryId, serviceContext);

	    } catch (Exception e) {

	       SessionErrors.add(request, e.getClass().getName());
	    }
	}


	
	@Override
	public void render(RenderRequest renderRequest,
	        RenderResponse renderResponse) throws PortletException, IOException {

	    try {
	        ServiceContext serviceContext = ServiceContextFactory.getInstance(
	                Guestbook.class.getName(), renderRequest);

	        long groupId = serviceContext.getScopeGroupId();
	        
	        long guestbookId = ParamUtil.getLong(renderRequest, "guestbookId");
	        
	        System.out.println("test: groupId = "+groupId);
	        System.out.println("test: guestbookId = "+guestbookId);

	        if(guestbookId <= 0) {
		        List<Guestbook> guestbooks = GuestbookLocalServiceUtil
		                .getGuestbooks(groupId, WorkflowConstants.STATUS_APPROVED);
	
		        if (guestbooks == null || guestbooks.size() == 0) {
		            Guestbook guestbook = GuestbookLocalServiceUtil.addGuestbook(
		                    serviceContext.getUserId(), "Main", serviceContext);
	
		            guestbookId = guestbook.getGuestbookId();
		            renderRequest.setAttribute("guestbook", guestbook);
		            System.out.println("test: guestbook = "+guestbook);
		        }
	
		        if (!(guestbookId > 0)) {
		            guestbookId = guestbooks.get(0).getGuestbookId();
		            Guestbook guestbook = guestbooks.get(0);
		            renderRequest.setAttribute("guestbook", guestbook);
		            System.out.println("test: guestbook2 = "+guestbook);
		        }
	
		        renderRequest.setAttribute("guestbookId", guestbookId);
	            System.out.println("test: set guestbookId = "+guestbookId);
	            
	        }else {
	        	Guestbook guestbook = GuestbookLocalServiceUtil.fetchGuestbook(guestbookId);
	        	renderRequest.setAttribute("guestbookId", guestbookId);
	        	renderRequest.setAttribute("guestbook", guestbook);
	        }

	    } catch (Exception e) {

	        throw new PortletException(e);
	    }

	    super.render(renderRequest, renderResponse);

	}

}
