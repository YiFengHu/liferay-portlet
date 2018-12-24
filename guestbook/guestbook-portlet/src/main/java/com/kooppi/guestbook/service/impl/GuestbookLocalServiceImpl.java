package com.kooppi.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import com.kooppi.guestbook.GuestbookNameException;
import com.kooppi.guestbook.model.Entry;
import com.kooppi.guestbook.model.Guestbook;
import com.kooppi.guestbook.service.EntryLocalServiceUtil;
import com.kooppi.guestbook.service.base.GuestbookLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the guestbook local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kooppi.guestbook.service.GuestbookLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.kooppi.guestbook.service.base.GuestbookLocalServiceBaseImpl
 * @see com.kooppi.guestbook.service.GuestbookLocalServiceUtil
 */
public class GuestbookLocalServiceImpl extends GuestbookLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.kooppi.guestbook.service.GuestbookLocalServiceUtil} to access the guestbook local service.
     */
	
	public Guestbook addGuestbook(long userId, String name, 
		    ServiceContext serviceContext) throws SystemException, PortalException {
		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(name);

		long guestbookId = counterLocalService.increment();

		Guestbook guestbook = guestbookPersistence.create(guestbookId);

		guestbook.setUuid(serviceContext.getUuid());
		guestbook.setUserId(userId);
		guestbook.setGroupId(groupId);
		guestbook.setCompanyId(user.getCompanyId());
		guestbook.setUserName(user.getFullName());
		guestbook.setCreateDate(serviceContext.getCreateDate(now));
		guestbook.setModifiedDate(serviceContext.getModifiedDate(now));
		guestbook.setName(name);
		guestbook.setExpandoBridgeAttributes(serviceContext);

		guestbookPersistence.update(guestbook);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			       Guestbook.class.getName(), guestbookId, false, true, true);
		return guestbook;
	}
	
	public Guestbook updateGuestbook(long userId, long guestbookId,
			String name, ServiceContext serviceContext) throws PortalException,
			                SystemException {

			        Date now = new Date();

			        validate(name);

			        Guestbook guestbook = getGuestbook(guestbookId);

			        User user = UserLocalServiceUtil.getUser(userId);

			        guestbook.setUserId(userId);
			        guestbook.setUserName(user.getFullName());
			        guestbook.setModifiedDate(serviceContext.getModifiedDate(now));
			        guestbook.setName(name);
			        guestbook.setExpandoBridgeAttributes(serviceContext);

			        guestbookPersistence.update(guestbook);

			        resourceLocalService.updateResources(serviceContext.getCompanyId(),
			                        serviceContext.getScopeGroupId(), name, guestbookId,
			                        serviceContext.getGroupPermissions(),
			                        serviceContext.getGuestPermissions());

			        return guestbook;
	}
	
	public Guestbook deleteGuestbook(long guestbookId,
            ServiceContext serviceContext) throws PortalException,
            SystemException {

	    Guestbook guestbook = getGuestbook(guestbookId);
	
	    List<Entry> entries = EntryLocalServiceUtil.getEntries(
	                    serviceContext.getScopeGroupId(), guestbookId);
	
	    for (Entry entry : entries) {
	            EntryLocalServiceUtil.deleteEntry(entry.getEntryId(),
	                            serviceContext);
	    }
	
	    resourceLocalService.deleteResource(serviceContext.getCompanyId(),
	                    Guestbook.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
	                    guestbookId);
	
	    guestbook = deleteGuestbook(guestbook);

	    return guestbook;
	}

	public int getGuestbooksCount(long groupId) throws SystemException {
        return guestbookPersistence.countByGroupId(groupId);
	}

	
	public List<Guestbook> getGuestbooks (long groupId) throws SystemException {
	    return guestbookPersistence.findByGroupId(groupId);
	}

	public List<Guestbook> getGuestbooks (long groupId, int start, int end)
	   throws SystemException {
	    return guestbookPersistence.findByGroupId(groupId, start, end);
	}
	
	protected void validate (String name) throws PortalException {
	    if (Validator.isNull(name)) {
	       throw new GuestbookNameException();
	    }
	}
}
