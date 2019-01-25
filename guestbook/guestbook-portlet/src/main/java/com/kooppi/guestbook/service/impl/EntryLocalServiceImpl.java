package com.kooppi.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import com.kooppi.guestbook.EntryEmailException;
import com.kooppi.guestbook.EntryMessageException;
import com.kooppi.guestbook.EntryNameException;
import com.kooppi.guestbook.model.Entry;
import com.kooppi.guestbook.service.base.EntryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowTaskManager;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

/**
 * The implementation of the entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kooppi.guestbook.service.EntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.kooppi.guestbook.service.base.EntryLocalServiceBaseImpl
 * @see com.kooppi.guestbook.service.EntryLocalServiceUtil
 */
public class EntryLocalServiceImpl extends EntryLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.kooppi.guestbook.service.EntryLocalServiceUtil} to access the entry local service.
     */
	
	public Entry addEntry(long userId, long guestbookId, String name,
            String roomNumber, String useDate, ServiceContext serviceContext) throws PortalException, SystemException {
	    long groupId = serviceContext.getScopeGroupId();
	    
	    WorkflowTaskManager a;
	
	    User user = userPersistence.findByPrimaryKey(userId);
	
	    Date now = new Date();
	
	    validate(name, roomNumber, useDate);
	
	    long entryId = counterLocalService.increment();
	
	    Entry entry = entryPersistence.create(entryId);
	
	    entry.setUuid(serviceContext.getUuid());
	    entry.setUserId(userId);
	    entry.setGroupId(groupId);
	    entry.setCompanyId(user.getCompanyId());
	    entry.setUserName(user.getFullName());
	    entry.setCreateDate(serviceContext.getCreateDate(now));
	    entry.setModifiedDate(serviceContext.getModifiedDate(now));
	    entry.setExpandoBridgeAttributes(serviceContext);
	    entry.setGuestbookId(guestbookId);
	    entry.setName(name);
	    entry.setMessage("");
	    entry.setConferenceRoomName(roomNumber);
	    entry.setUseDate(useDate);
        entry.setStatus(WorkflowConstants.STATUS_DRAFT);

	    entryPersistence.update(entry);
	
//	    resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
//	                    Entry.class.getName(), entryId, false, true, true);
	
	    AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
	                    groupId, entry.getCreateDate(), entry.getModifiedDate(),
	                    Entry.class.getName(), entryId, entry.getUuid(), 0,
	                    serviceContext.getAssetCategoryIds(),
	                    serviceContext.getAssetTagNames(), true, null, null, null,
	                    ContentTypes.TEXT_HTML, "Book Conference Room ("+roomNumber+") at "+useDate+" by "+name, null, null, null,
	                    null, 0, 0, null, false);
	
	    assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
	                    serviceContext.getAssetLinkEntryIds(),
	                    AssetLinkConstants.TYPE_RELATED);
	
	    Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
	                    Entry.class);
	
	    indexer.reindex(entry);
	
	    WorkflowHandlerRegistryUtil.startWorkflowInstance(entry.getCompanyId(), 
	            entry.getGroupId(), entry.getUserId(), Entry.class.getName(), 
	            entry.getPrimaryKey(), entry, serviceContext);

	    return entry;
	}

	
	public Entry deleteEntry(long entryId, ServiceContext serviceContext)
            throws PortalException, SystemException {
	
	    Entry entry = getEntry(entryId);
	
//	    resourceLocalService.deleteResource(serviceContext.getCompanyId(),
//	                    Entry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
//	                    entryId);
	
	    AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
	                    Entry.class.getName(), entryId);
	
	    assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
	
	    assetEntryLocalService.deleteEntry(assetEntry);
	
	    Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
	                    Entry.class);
	
	    indexer.delete(entry);
	
	    entry = deleteEntry(entryId);
	
	    return entry;
	}

	
	public Entry updateEntry(long userId, long guestbookId, long entryId,
            String name, String roomNumber, String useDate,
            ServiceContext serviceContext) throws PortalException,
            SystemException {
	    long groupId = serviceContext.getScopeGroupId();
	
	    User user = userPersistence.findByPrimaryKey(userId);
	
	    Date now = new Date();
	
	    validate(name, roomNumber, useDate);
	
	    Entry entry = getEntry(entryId);
	
	    entry.setUserId(userId);
	    entry.setUserName(user.getFullName());
	    entry.setName(name);
	    entry.setMessage("");
	    entry.setConferenceRoomName(roomNumber);
	    entry.setUseDate(useDate);
	    entry.setModifiedDate(serviceContext.getModifiedDate(now));
	    entry.setExpandoBridgeAttributes(serviceContext);
	
	    entryPersistence.update(entry);
	
//	    resourceLocalService.updateResources(user.getCompanyId(), groupId,
//	                    Entry.class.getName(), entryId,
//	                    serviceContext.getGroupPermissions(),
//	                    serviceContext.getGuestPermissions());
	
	    AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
	                    groupId, entry.getCreateDate(), entry.getModifiedDate(),
	                    Entry.class.getName(), entryId, entry.getUuid(), 0,
	                    serviceContext.getAssetCategoryIds(),
	                    serviceContext.getAssetTagNames(), true, null, null, null,
	                    ContentTypes.TEXT_HTML, "Book Conference Room ("+roomNumber+") at "+useDate+" by "+name, null, null, null,
	                    null, 0, 0, null, false);
	
	    assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
	                    serviceContext.getAssetLinkEntryIds(),
	                    AssetLinkConstants.TYPE_RELATED);
	
	    Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
	                    Entry.class);
	
	    indexer.reindex(entry);
	
	    return entry;
	}
	
	public List<Entry> getEntries(long groupId, long guestbookId) throws SystemException {

	    return entryPersistence.findByG_G(groupId, guestbookId);
	}
	
	public List<Entry> getEntriesByGroup(long groupId) throws SystemException {
	    return entryPersistence.findByGroupId(groupId);
	}
	
	public int getEntriesCountByGroup(long groupId) throws SystemException {
	    return entryPersistence.countByGroupId(groupId);
	}
	
	public List<Entry> getEntries(long groupId, long guestbookId, int status, int start,
		       int end) throws SystemException {
		    return entryPersistence.findByG_G_S(groupId, guestbookId, WorkflowConstants.STATUS_APPROVED, 
		        start, end);
		}

	public int getEntriesCount(long groupId, long guestbookId, int status) throws SystemException {
		return entryPersistence.countByG_G_S(groupId, guestbookId, WorkflowConstants.STATUS_APPROVED);
	}
	
	protected void validate (String name, String roomNumber, String useDate) 
	        throws PortalException {
	    if (Validator.isNull(name)) {
	        throw new EntryNameException();
	    }

	    if (Validator.isNull(roomNumber)) {
	        throw new EntryEmailException();
	    }

	    if (Validator.isNull(useDate)) {
	        throw new EntryMessageException();
	    }
	}
	
	public Entry updateStatus(long userId, long entryId, int status, long assigneeId,
		       ServiceContext serviceContext) throws PortalException,
		       SystemException {
			
		    User user = userLocalService.getUser(userId);
		    Entry entry = getEntry(entryId);

		    entry.setStatus(status);
		    entry.setStatusByUserId(userId);
		    entry.setStatusByUserName(user.getFullName());
		    entry.setStatusDate(new Date());
		    entry.setStatusTaskAssigneeId(assigneeId);
 
		    entryPersistence.update(entry);

		    if (status == WorkflowConstants.STATUS_APPROVED) {

		       assetEntryLocalService.updateVisible(Entry.class.getName(),
		          entryId, true);

		    } else {

		       assetEntryLocalService.updateVisible(Entry.class.getName(),
		          entryId, false);
		    }

		    return entry;
		}

	public int getUpperLevelApprover() {
//		System.out.println("FooLocalServiceImpl");
//		System.out.println("companyId = "+companyId);
//		System.out.println("entryClassName = "+entryClassName);
//		System.out.println("entryClassPK = "+entryClassPK);
//		System.out.println("groupId = "+groupId);
//		System.out.println("serviceContext = "+serviceContext);
//		System.out.println("userId = "+userId);
		return 22516;
	}
}
