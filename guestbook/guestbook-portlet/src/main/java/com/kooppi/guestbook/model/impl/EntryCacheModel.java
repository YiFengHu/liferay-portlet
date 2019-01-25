package com.kooppi.guestbook.model.impl;

import com.kooppi.guestbook.model.Entry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Entry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Entry
 * @generated
 */
public class EntryCacheModel implements CacheModel<Entry>, Externalizable {
    public String uuid;
    public long entryId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String message;
    public String name;
    public String conferenceRoomName;
    public String useDate;
    public long guestbookId;
    public int status;
    public long statusByUserId;
    public String statusByUserName;
    public long statusDate;
    public Long statusTaskAssigneeId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(37);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", entryId=");
        sb.append(entryId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", message=");
        sb.append(message);
        sb.append(", name=");
        sb.append(name);
        sb.append(", conferenceRoomName=");
        sb.append(conferenceRoomName);
        sb.append(", useDate=");
        sb.append(useDate);
        sb.append(", guestbookId=");
        sb.append(guestbookId);
        sb.append(", status=");
        sb.append(status);
        sb.append(", statusByUserId=");
        sb.append(statusByUserId);
        sb.append(", statusByUserName=");
        sb.append(statusByUserName);
        sb.append(", statusDate=");
        sb.append(statusDate);
        sb.append(", statusTaskAssigneeId=");
        sb.append(statusTaskAssigneeId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Entry toEntityModel() {
        EntryImpl entryImpl = new EntryImpl();

        if (uuid == null) {
            entryImpl.setUuid(StringPool.BLANK);
        } else {
            entryImpl.setUuid(uuid);
        }

        entryImpl.setEntryId(entryId);
        entryImpl.setGroupId(groupId);
        entryImpl.setCompanyId(companyId);
        entryImpl.setUserId(userId);

        if (userName == null) {
            entryImpl.setUserName(StringPool.BLANK);
        } else {
            entryImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            entryImpl.setCreateDate(null);
        } else {
            entryImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            entryImpl.setModifiedDate(null);
        } else {
            entryImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (message == null) {
            entryImpl.setMessage(StringPool.BLANK);
        } else {
            entryImpl.setMessage(message);
        }

        if (name == null) {
            entryImpl.setName(StringPool.BLANK);
        } else {
            entryImpl.setName(name);
        }

        if (conferenceRoomName == null) {
            entryImpl.setConferenceRoomName(StringPool.BLANK);
        } else {
            entryImpl.setConferenceRoomName(conferenceRoomName);
        }

        if (useDate == null) {
            entryImpl.setUseDate(StringPool.BLANK);
        } else {
            entryImpl.setUseDate(useDate);
        }

        entryImpl.setGuestbookId(guestbookId);
        entryImpl.setStatus(status);
        entryImpl.setStatusByUserId(statusByUserId);

        if (statusByUserName == null) {
            entryImpl.setStatusByUserName(StringPool.BLANK);
        } else {
            entryImpl.setStatusByUserName(statusByUserName);
        }

        if (statusDate == Long.MIN_VALUE) {
            entryImpl.setStatusDate(null);
        } else {
            entryImpl.setStatusDate(new Date(statusDate));
        }

        entryImpl.setStatusTaskAssigneeId(statusTaskAssigneeId);

        entryImpl.resetOriginalValues();

        return entryImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        entryId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        message = objectInput.readUTF();
        name = objectInput.readUTF();
        conferenceRoomName = objectInput.readUTF();
        useDate = objectInput.readUTF();
        guestbookId = objectInput.readLong();
        status = objectInput.readInt();
        statusByUserId = objectInput.readLong();
        statusByUserName = objectInput.readUTF();
        statusDate = objectInput.readLong();
        statusTaskAssigneeId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(entryId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);

        if (message == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(message);
        }

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (conferenceRoomName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(conferenceRoomName);
        }

        if (useDate == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(useDate);
        }

        objectOutput.writeLong(guestbookId);
        objectOutput.writeInt(status);
        objectOutput.writeLong(statusByUserId);

        if (statusByUserName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(statusByUserName);
        }

        objectOutput.writeLong(statusDate);
        objectOutput.writeLong(statusTaskAssigneeId);
    }
}
