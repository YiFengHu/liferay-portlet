package com.kooppi.guestbook.service.persistence;

import com.kooppi.guestbook.model.Foo;
import com.kooppi.guestbook.service.FooLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class FooActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public FooActionableDynamicQuery() throws SystemException {
        setBaseLocalService(FooLocalServiceUtil.getService());
        setClass(Foo.class);

        setClassLoader(com.kooppi.guestbook.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("fooId");
    }
}
