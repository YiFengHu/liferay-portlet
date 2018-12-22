package com.kooppi.guestbook.service.persistence;

import com.kooppi.guestbook.model.Entry;
import com.kooppi.guestbook.service.EntryLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class EntryActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public EntryActionableDynamicQuery() throws SystemException {
        setBaseLocalService(EntryLocalServiceUtil.getService());
        setClass(Entry.class);

        setClassLoader(com.kooppi.guestbook.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("entryId");
    }
}
