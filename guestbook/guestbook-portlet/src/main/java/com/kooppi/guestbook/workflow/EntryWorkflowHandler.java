package com.kooppi.guestbook.workflow;

import com.kooppi.guestbook.model.Entry;
import com.kooppi.guestbook.service.EntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ServiceContext;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

public class EntryWorkflowHandler extends BaseWorkflowHandler {

    @Override
    public String getClassName() {

        return CLASS_NAME;
    }

    @Override
	public String getType(Locale locale) {
		return ResourceActionsUtil.getModelResource(locale, getClassName());
	}

    @Override
    public Object updateStatus(int status,
            Map<String, Serializable> workflowContext) throws PortalException,
            SystemException {

            long userId = GetterUtil.getLong(
                (String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
            long entryId = GetterUtil.getLong(
                (String)workflowContext.get(
                    WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

            ServiceContext serviceContext = (ServiceContext)workflowContext.get(
                "serviceContext");

            return EntryLocalServiceUtil.updateStatus(
                userId, entryId, status, serviceContext);

    }

    public static final String CLASS_NAME = Entry.class.getName();

}
