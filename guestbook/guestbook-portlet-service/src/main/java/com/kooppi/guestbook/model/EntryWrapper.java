package com.kooppi.guestbook.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Entry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Entry
 * @generated
 */
public class EntryWrapper implements Entry, ModelWrapper<Entry> {
    private Entry _entry;

    public EntryWrapper(Entry entry) {
        _entry = entry;
    }

    @Override
    public Class<?> getModelClass() {
        return Entry.class;
    }

    @Override
    public String getModelClassName() {
        return Entry.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("entryId", getEntryId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("message", getMessage());
        attributes.put("name", getName());
        attributes.put("conferenceRoomName", getConferenceRoomName());
        attributes.put("useDate", getUseDate());
        attributes.put("guestbookId", getGuestbookId());
        attributes.put("status", getStatus());
        attributes.put("statusByUserId", getStatusByUserId());
        attributes.put("statusByUserName", getStatusByUserName());
        attributes.put("statusDate", getStatusDate());
        attributes.put("statusTaskAssigneeId", getStatusTaskAssigneeId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long entryId = (Long) attributes.get("entryId");

        if (entryId != null) {
            setEntryId(entryId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String message = (String) attributes.get("message");

        if (message != null) {
            setMessage(message);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String conferenceRoomName = (String) attributes.get(
                "conferenceRoomName");

        if (conferenceRoomName != null) {
            setConferenceRoomName(conferenceRoomName);
        }

        String useDate = (String) attributes.get("useDate");

        if (useDate != null) {
            setUseDate(useDate);
        }

        Long guestbookId = (Long) attributes.get("guestbookId");

        if (guestbookId != null) {
            setGuestbookId(guestbookId);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Long statusByUserId = (Long) attributes.get("statusByUserId");

        if (statusByUserId != null) {
            setStatusByUserId(statusByUserId);
        }

        String statusByUserName = (String) attributes.get("statusByUserName");

        if (statusByUserName != null) {
            setStatusByUserName(statusByUserName);
        }

        Date statusDate = (Date) attributes.get("statusDate");

        if (statusDate != null) {
            setStatusDate(statusDate);
        }

        Long statusTaskAssigneeId = (Long) attributes.get(
                "statusTaskAssigneeId");

        if (statusTaskAssigneeId != null) {
            setStatusTaskAssigneeId(statusTaskAssigneeId);
        }
    }

    /**
    * Returns the primary key of this entry.
    *
    * @return the primary key of this entry
    */
    @Override
    public long getPrimaryKey() {
        return _entry.getPrimaryKey();
    }

    /**
    * Sets the primary key of this entry.
    *
    * @param primaryKey the primary key of this entry
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _entry.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this entry.
    *
    * @return the uuid of this entry
    */
    @Override
    public java.lang.String getUuid() {
        return _entry.getUuid();
    }

    /**
    * Sets the uuid of this entry.
    *
    * @param uuid the uuid of this entry
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _entry.setUuid(uuid);
    }

    /**
    * Returns the entry ID of this entry.
    *
    * @return the entry ID of this entry
    */
    @Override
    public long getEntryId() {
        return _entry.getEntryId();
    }

    /**
    * Sets the entry ID of this entry.
    *
    * @param entryId the entry ID of this entry
    */
    @Override
    public void setEntryId(long entryId) {
        _entry.setEntryId(entryId);
    }

    /**
    * Returns the group ID of this entry.
    *
    * @return the group ID of this entry
    */
    @Override
    public long getGroupId() {
        return _entry.getGroupId();
    }

    /**
    * Sets the group ID of this entry.
    *
    * @param groupId the group ID of this entry
    */
    @Override
    public void setGroupId(long groupId) {
        _entry.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this entry.
    *
    * @return the company ID of this entry
    */
    @Override
    public long getCompanyId() {
        return _entry.getCompanyId();
    }

    /**
    * Sets the company ID of this entry.
    *
    * @param companyId the company ID of this entry
    */
    @Override
    public void setCompanyId(long companyId) {
        _entry.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this entry.
    *
    * @return the user ID of this entry
    */
    @Override
    public long getUserId() {
        return _entry.getUserId();
    }

    /**
    * Sets the user ID of this entry.
    *
    * @param userId the user ID of this entry
    */
    @Override
    public void setUserId(long userId) {
        _entry.setUserId(userId);
    }

    /**
    * Returns the user uuid of this entry.
    *
    * @return the user uuid of this entry
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _entry.getUserUuid();
    }

    /**
    * Sets the user uuid of this entry.
    *
    * @param userUuid the user uuid of this entry
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _entry.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this entry.
    *
    * @return the user name of this entry
    */
    @Override
    public java.lang.String getUserName() {
        return _entry.getUserName();
    }

    /**
    * Sets the user name of this entry.
    *
    * @param userName the user name of this entry
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _entry.setUserName(userName);
    }

    /**
    * Returns the create date of this entry.
    *
    * @return the create date of this entry
    */
    @Override
    public java.util.Date getCreateDate() {
        return _entry.getCreateDate();
    }

    /**
    * Sets the create date of this entry.
    *
    * @param createDate the create date of this entry
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _entry.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this entry.
    *
    * @return the modified date of this entry
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _entry.getModifiedDate();
    }

    /**
    * Sets the modified date of this entry.
    *
    * @param modifiedDate the modified date of this entry
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _entry.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the message of this entry.
    *
    * @return the message of this entry
    */
    @Override
    public java.lang.String getMessage() {
        return _entry.getMessage();
    }

    /**
    * Sets the message of this entry.
    *
    * @param message the message of this entry
    */
    @Override
    public void setMessage(java.lang.String message) {
        _entry.setMessage(message);
    }

    /**
    * Returns the name of this entry.
    *
    * @return the name of this entry
    */
    @Override
    public java.lang.String getName() {
        return _entry.getName();
    }

    /**
    * Sets the name of this entry.
    *
    * @param name the name of this entry
    */
    @Override
    public void setName(java.lang.String name) {
        _entry.setName(name);
    }

    /**
    * Returns the conference room name of this entry.
    *
    * @return the conference room name of this entry
    */
    @Override
    public java.lang.String getConferenceRoomName() {
        return _entry.getConferenceRoomName();
    }

    /**
    * Sets the conference room name of this entry.
    *
    * @param conferenceRoomName the conference room name of this entry
    */
    @Override
    public void setConferenceRoomName(java.lang.String conferenceRoomName) {
        _entry.setConferenceRoomName(conferenceRoomName);
    }

    /**
    * Returns the use date of this entry.
    *
    * @return the use date of this entry
    */
    @Override
    public java.lang.String getUseDate() {
        return _entry.getUseDate();
    }

    /**
    * Sets the use date of this entry.
    *
    * @param useDate the use date of this entry
    */
    @Override
    public void setUseDate(java.lang.String useDate) {
        _entry.setUseDate(useDate);
    }

    /**
    * Returns the guestbook ID of this entry.
    *
    * @return the guestbook ID of this entry
    */
    @Override
    public long getGuestbookId() {
        return _entry.getGuestbookId();
    }

    /**
    * Sets the guestbook ID of this entry.
    *
    * @param guestbookId the guestbook ID of this entry
    */
    @Override
    public void setGuestbookId(long guestbookId) {
        _entry.setGuestbookId(guestbookId);
    }

    /**
    * Returns the status of this entry.
    *
    * @return the status of this entry
    */
    @Override
    public int getStatus() {
        return _entry.getStatus();
    }

    /**
    * Sets the status of this entry.
    *
    * @param status the status of this entry
    */
    @Override
    public void setStatus(int status) {
        _entry.setStatus(status);
    }

    /**
    * Returns the status by user ID of this entry.
    *
    * @return the status by user ID of this entry
    */
    @Override
    public long getStatusByUserId() {
        return _entry.getStatusByUserId();
    }

    /**
    * Sets the status by user ID of this entry.
    *
    * @param statusByUserId the status by user ID of this entry
    */
    @Override
    public void setStatusByUserId(long statusByUserId) {
        _entry.setStatusByUserId(statusByUserId);
    }

    /**
    * Returns the status by user uuid of this entry.
    *
    * @return the status by user uuid of this entry
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getStatusByUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _entry.getStatusByUserUuid();
    }

    /**
    * Sets the status by user uuid of this entry.
    *
    * @param statusByUserUuid the status by user uuid of this entry
    */
    @Override
    public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
        _entry.setStatusByUserUuid(statusByUserUuid);
    }

    /**
    * Returns the status by user name of this entry.
    *
    * @return the status by user name of this entry
    */
    @Override
    public java.lang.String getStatusByUserName() {
        return _entry.getStatusByUserName();
    }

    /**
    * Sets the status by user name of this entry.
    *
    * @param statusByUserName the status by user name of this entry
    */
    @Override
    public void setStatusByUserName(java.lang.String statusByUserName) {
        _entry.setStatusByUserName(statusByUserName);
    }

    /**
    * Returns the status date of this entry.
    *
    * @return the status date of this entry
    */
    @Override
    public java.util.Date getStatusDate() {
        return _entry.getStatusDate();
    }

    /**
    * Sets the status date of this entry.
    *
    * @param statusDate the status date of this entry
    */
    @Override
    public void setStatusDate(java.util.Date statusDate) {
        _entry.setStatusDate(statusDate);
    }

    /**
    * Returns the status task assignee ID of this entry.
    *
    * @return the status task assignee ID of this entry
    */
    @Override
    public java.lang.Long getStatusTaskAssigneeId() {
        return _entry.getStatusTaskAssigneeId();
    }

    /**
    * Sets the status task assignee ID of this entry.
    *
    * @param statusTaskAssigneeId the status task assignee ID of this entry
    */
    @Override
    public void setStatusTaskAssigneeId(java.lang.Long statusTaskAssigneeId) {
        _entry.setStatusTaskAssigneeId(statusTaskAssigneeId);
    }

    /**
    * @deprecated As of 6.1.0, replaced by {@link #isApproved()}
    */
    @Override
    public boolean getApproved() {
        return _entry.getApproved();
    }

    /**
    * Returns <code>true</code> if this entry is approved.
    *
    * @return <code>true</code> if this entry is approved; <code>false</code> otherwise
    */
    @Override
    public boolean isApproved() {
        return _entry.isApproved();
    }

    /**
    * Returns <code>true</code> if this entry is denied.
    *
    * @return <code>true</code> if this entry is denied; <code>false</code> otherwise
    */
    @Override
    public boolean isDenied() {
        return _entry.isDenied();
    }

    /**
    * Returns <code>true</code> if this entry is a draft.
    *
    * @return <code>true</code> if this entry is a draft; <code>false</code> otherwise
    */
    @Override
    public boolean isDraft() {
        return _entry.isDraft();
    }

    /**
    * Returns <code>true</code> if this entry is expired.
    *
    * @return <code>true</code> if this entry is expired; <code>false</code> otherwise
    */
    @Override
    public boolean isExpired() {
        return _entry.isExpired();
    }

    /**
    * Returns <code>true</code> if this entry is inactive.
    *
    * @return <code>true</code> if this entry is inactive; <code>false</code> otherwise
    */
    @Override
    public boolean isInactive() {
        return _entry.isInactive();
    }

    /**
    * Returns <code>true</code> if this entry is incomplete.
    *
    * @return <code>true</code> if this entry is incomplete; <code>false</code> otherwise
    */
    @Override
    public boolean isIncomplete() {
        return _entry.isIncomplete();
    }

    /**
    * Returns <code>true</code> if this entry is pending.
    *
    * @return <code>true</code> if this entry is pending; <code>false</code> otherwise
    */
    @Override
    public boolean isPending() {
        return _entry.isPending();
    }

    /**
    * Returns <code>true</code> if this entry is scheduled.
    *
    * @return <code>true</code> if this entry is scheduled; <code>false</code> otherwise
    */
    @Override
    public boolean isScheduled() {
        return _entry.isScheduled();
    }

    @Override
    public boolean isNew() {
        return _entry.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _entry.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _entry.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _entry.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _entry.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _entry.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _entry.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _entry.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _entry.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _entry.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _entry.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new EntryWrapper((Entry) _entry.clone());
    }

    @Override
    public int compareTo(com.kooppi.guestbook.model.Entry entry) {
        return _entry.compareTo(entry);
    }

    @Override
    public int hashCode() {
        return _entry.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.kooppi.guestbook.model.Entry> toCacheModel() {
        return _entry.toCacheModel();
    }

    @Override
    public com.kooppi.guestbook.model.Entry toEscapedModel() {
        return new EntryWrapper(_entry.toEscapedModel());
    }

    @Override
    public com.kooppi.guestbook.model.Entry toUnescapedModel() {
        return new EntryWrapper(_entry.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _entry.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _entry.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _entry.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EntryWrapper)) {
            return false;
        }

        EntryWrapper entryWrapper = (EntryWrapper) obj;

        if (Validator.equals(_entry, entryWrapper._entry)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _entry.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Entry getWrappedEntry() {
        return _entry;
    }

    @Override
    public Entry getWrappedModel() {
        return _entry;
    }

    @Override
    public void resetOriginalValues() {
        _entry.resetOriginalValues();
    }
}
