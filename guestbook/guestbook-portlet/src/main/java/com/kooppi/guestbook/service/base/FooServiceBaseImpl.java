package com.kooppi.guestbook.service.base;

import com.kooppi.guestbook.model.Foo;
import com.kooppi.guestbook.service.FooService;
import com.kooppi.guestbook.service.persistence.EntryPersistence;
import com.kooppi.guestbook.service.persistence.FooPersistence;
import com.kooppi.guestbook.service.persistence.GuestbookPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.asset.service.persistence.AssetLinkPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the foo remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.kooppi.guestbook.service.impl.FooServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.kooppi.guestbook.service.impl.FooServiceImpl
 * @see com.kooppi.guestbook.service.FooServiceUtil
 * @generated
 */
public abstract class FooServiceBaseImpl extends BaseServiceImpl
    implements FooService, IdentifiableBean {
    @BeanReference(type = com.kooppi.guestbook.service.EntryLocalService.class)
    protected com.kooppi.guestbook.service.EntryLocalService entryLocalService;
    @BeanReference(type = com.kooppi.guestbook.service.EntryService.class)
    protected com.kooppi.guestbook.service.EntryService entryService;
    @BeanReference(type = EntryPersistence.class)
    protected EntryPersistence entryPersistence;
    @BeanReference(type = com.kooppi.guestbook.service.FooLocalService.class)
    protected com.kooppi.guestbook.service.FooLocalService fooLocalService;
    @BeanReference(type = com.kooppi.guestbook.service.FooService.class)
    protected com.kooppi.guestbook.service.FooService fooService;
    @BeanReference(type = FooPersistence.class)
    protected FooPersistence fooPersistence;
    @BeanReference(type = com.kooppi.guestbook.service.GuestbookLocalService.class)
    protected com.kooppi.guestbook.service.GuestbookLocalService guestbookLocalService;
    @BeanReference(type = com.kooppi.guestbook.service.GuestbookService.class)
    protected com.kooppi.guestbook.service.GuestbookService guestbookService;
    @BeanReference(type = GuestbookPersistence.class)
    protected GuestbookPersistence guestbookPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    @BeanReference(type = com.liferay.portlet.asset.service.AssetEntryLocalService.class)
    protected com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService;
    @BeanReference(type = com.liferay.portlet.asset.service.AssetEntryService.class)
    protected com.liferay.portlet.asset.service.AssetEntryService assetEntryService;
    @BeanReference(type = AssetEntryPersistence.class)
    protected AssetEntryPersistence assetEntryPersistence;
    @BeanReference(type = com.liferay.portlet.asset.service.AssetLinkLocalService.class)
    protected com.liferay.portlet.asset.service.AssetLinkLocalService assetLinkLocalService;
    @BeanReference(type = AssetLinkPersistence.class)
    protected AssetLinkPersistence assetLinkPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private FooServiceClpInvoker _clpInvoker = new FooServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.kooppi.guestbook.service.FooServiceUtil} to access the foo remote service.
     */

    /**
     * Returns the entry local service.
     *
     * @return the entry local service
     */
    public com.kooppi.guestbook.service.EntryLocalService getEntryLocalService() {
        return entryLocalService;
    }

    /**
     * Sets the entry local service.
     *
     * @param entryLocalService the entry local service
     */
    public void setEntryLocalService(
        com.kooppi.guestbook.service.EntryLocalService entryLocalService) {
        this.entryLocalService = entryLocalService;
    }

    /**
     * Returns the entry remote service.
     *
     * @return the entry remote service
     */
    public com.kooppi.guestbook.service.EntryService getEntryService() {
        return entryService;
    }

    /**
     * Sets the entry remote service.
     *
     * @param entryService the entry remote service
     */
    public void setEntryService(
        com.kooppi.guestbook.service.EntryService entryService) {
        this.entryService = entryService;
    }

    /**
     * Returns the entry persistence.
     *
     * @return the entry persistence
     */
    public EntryPersistence getEntryPersistence() {
        return entryPersistence;
    }

    /**
     * Sets the entry persistence.
     *
     * @param entryPersistence the entry persistence
     */
    public void setEntryPersistence(EntryPersistence entryPersistence) {
        this.entryPersistence = entryPersistence;
    }

    /**
     * Returns the foo local service.
     *
     * @return the foo local service
     */
    public com.kooppi.guestbook.service.FooLocalService getFooLocalService() {
        return fooLocalService;
    }

    /**
     * Sets the foo local service.
     *
     * @param fooLocalService the foo local service
     */
    public void setFooLocalService(
        com.kooppi.guestbook.service.FooLocalService fooLocalService) {
        this.fooLocalService = fooLocalService;
    }

    /**
     * Returns the foo remote service.
     *
     * @return the foo remote service
     */
    public com.kooppi.guestbook.service.FooService getFooService() {
        return fooService;
    }

    /**
     * Sets the foo remote service.
     *
     * @param fooService the foo remote service
     */
    public void setFooService(
        com.kooppi.guestbook.service.FooService fooService) {
        this.fooService = fooService;
    }

    /**
     * Returns the foo persistence.
     *
     * @return the foo persistence
     */
    public FooPersistence getFooPersistence() {
        return fooPersistence;
    }

    /**
     * Sets the foo persistence.
     *
     * @param fooPersistence the foo persistence
     */
    public void setFooPersistence(FooPersistence fooPersistence) {
        this.fooPersistence = fooPersistence;
    }

    /**
     * Returns the guestbook local service.
     *
     * @return the guestbook local service
     */
    public com.kooppi.guestbook.service.GuestbookLocalService getGuestbookLocalService() {
        return guestbookLocalService;
    }

    /**
     * Sets the guestbook local service.
     *
     * @param guestbookLocalService the guestbook local service
     */
    public void setGuestbookLocalService(
        com.kooppi.guestbook.service.GuestbookLocalService guestbookLocalService) {
        this.guestbookLocalService = guestbookLocalService;
    }

    /**
     * Returns the guestbook remote service.
     *
     * @return the guestbook remote service
     */
    public com.kooppi.guestbook.service.GuestbookService getGuestbookService() {
        return guestbookService;
    }

    /**
     * Sets the guestbook remote service.
     *
     * @param guestbookService the guestbook remote service
     */
    public void setGuestbookService(
        com.kooppi.guestbook.service.GuestbookService guestbookService) {
        this.guestbookService = guestbookService;
    }

    /**
     * Returns the guestbook persistence.
     *
     * @return the guestbook persistence
     */
    public GuestbookPersistence getGuestbookPersistence() {
        return guestbookPersistence;
    }

    /**
     * Sets the guestbook persistence.
     *
     * @param guestbookPersistence the guestbook persistence
     */
    public void setGuestbookPersistence(
        GuestbookPersistence guestbookPersistence) {
        this.guestbookPersistence = guestbookPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    /**
     * Returns the asset entry local service.
     *
     * @return the asset entry local service
     */
    public com.liferay.portlet.asset.service.AssetEntryLocalService getAssetEntryLocalService() {
        return assetEntryLocalService;
    }

    /**
     * Sets the asset entry local service.
     *
     * @param assetEntryLocalService the asset entry local service
     */
    public void setAssetEntryLocalService(
        com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService) {
        this.assetEntryLocalService = assetEntryLocalService;
    }

    /**
     * Returns the asset entry remote service.
     *
     * @return the asset entry remote service
     */
    public com.liferay.portlet.asset.service.AssetEntryService getAssetEntryService() {
        return assetEntryService;
    }

    /**
     * Sets the asset entry remote service.
     *
     * @param assetEntryService the asset entry remote service
     */
    public void setAssetEntryService(
        com.liferay.portlet.asset.service.AssetEntryService assetEntryService) {
        this.assetEntryService = assetEntryService;
    }

    /**
     * Returns the asset entry persistence.
     *
     * @return the asset entry persistence
     */
    public AssetEntryPersistence getAssetEntryPersistence() {
        return assetEntryPersistence;
    }

    /**
     * Sets the asset entry persistence.
     *
     * @param assetEntryPersistence the asset entry persistence
     */
    public void setAssetEntryPersistence(
        AssetEntryPersistence assetEntryPersistence) {
        this.assetEntryPersistence = assetEntryPersistence;
    }

    /**
     * Returns the asset link local service.
     *
     * @return the asset link local service
     */
    public com.liferay.portlet.asset.service.AssetLinkLocalService getAssetLinkLocalService() {
        return assetLinkLocalService;
    }

    /**
     * Sets the asset link local service.
     *
     * @param assetLinkLocalService the asset link local service
     */
    public void setAssetLinkLocalService(
        com.liferay.portlet.asset.service.AssetLinkLocalService assetLinkLocalService) {
        this.assetLinkLocalService = assetLinkLocalService;
    }

    /**
     * Returns the asset link persistence.
     *
     * @return the asset link persistence
     */
    public AssetLinkPersistence getAssetLinkPersistence() {
        return assetLinkPersistence;
    }

    /**
     * Sets the asset link persistence.
     *
     * @param assetLinkPersistence the asset link persistence
     */
    public void setAssetLinkPersistence(
        AssetLinkPersistence assetLinkPersistence) {
        this.assetLinkPersistence = assetLinkPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();
    }

    public void destroy() {
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Foo.class;
    }

    protected String getModelClassName() {
        return Foo.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = fooPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
