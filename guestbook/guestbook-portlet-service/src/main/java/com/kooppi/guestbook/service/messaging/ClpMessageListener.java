package com.kooppi.guestbook.service.messaging;

import com.kooppi.guestbook.service.ClpSerializer;
import com.kooppi.guestbook.service.EntryLocalServiceUtil;
import com.kooppi.guestbook.service.EntryServiceUtil;
import com.kooppi.guestbook.service.GuestbookLocalServiceUtil;
import com.kooppi.guestbook.service.GuestbookServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            EntryLocalServiceUtil.clearService();

            EntryServiceUtil.clearService();
            GuestbookLocalServiceUtil.clearService();

            GuestbookServiceUtil.clearService();
        }
    }
}
