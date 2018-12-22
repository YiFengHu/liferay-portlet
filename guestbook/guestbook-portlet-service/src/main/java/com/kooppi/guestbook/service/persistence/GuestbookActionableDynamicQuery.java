package com.kooppi.guestbook.service.persistence;

import com.kooppi.guestbook.model.Guestbook;
import com.kooppi.guestbook.service.GuestbookLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class GuestbookActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public GuestbookActionableDynamicQuery() throws SystemException {
        setBaseLocalService(GuestbookLocalServiceUtil.getService());
        setClass(Guestbook.class);

        setClassLoader(com.kooppi.guestbook.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("guestbookId");
    }
}
