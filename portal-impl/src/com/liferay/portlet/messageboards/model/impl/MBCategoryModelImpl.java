/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.messageboards.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBCategoryModel;
import com.liferay.portlet.messageboards.model.MBCategorySoap;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the MBCategory service. Represents a row in the &quot;MBCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.messageboards.model.MBCategoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MBCategoryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBCategoryImpl
 * @see com.liferay.portlet.messageboards.model.MBCategory
 * @see com.liferay.portlet.messageboards.model.MBCategoryModel
 * @generated
 */
@JSON(strict = true)
public class MBCategoryModelImpl extends BaseModelImpl<MBCategory>
	implements MBCategoryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a message boards category model instance should use the {@link com.liferay.portlet.messageboards.model.MBCategory} interface instead.
	 */
	public static final String TABLE_NAME = "MBCategory";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "categoryId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "parentCategoryId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "displayStyle", Types.VARCHAR },
			{ "threadCount", Types.INTEGER },
			{ "messageCount", Types.INTEGER },
			{ "lastPostDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table MBCategory (uuid_ VARCHAR(75) null,categoryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,parentCategoryId LONG,name VARCHAR(75) null,description STRING null,displayStyle VARCHAR(75) null,threadCount INTEGER,messageCount INTEGER,lastPostDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table MBCategory";
	public static final String ORDER_BY_JPQL = " ORDER BY mbCategory.parentCategoryId ASC, mbCategory.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY MBCategory.parentCategoryId ASC, MBCategory.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.messageboards.model.MBCategory"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.messageboards.model.MBCategory"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portlet.messageboards.model.MBCategory"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long PARENTCATEGORYID_COLUMN_BITMASK = 4L;
	public static long UUID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static MBCategory toModel(MBCategorySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		MBCategory model = new MBCategoryImpl();

		model.setUuid(soapModel.getUuid());
		model.setCategoryId(soapModel.getCategoryId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setParentCategoryId(soapModel.getParentCategoryId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setDisplayStyle(soapModel.getDisplayStyle());
		model.setThreadCount(soapModel.getThreadCount());
		model.setMessageCount(soapModel.getMessageCount());
		model.setLastPostDate(soapModel.getLastPostDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<MBCategory> toModels(MBCategorySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<MBCategory> models = new ArrayList<MBCategory>(soapModels.length);

		for (MBCategorySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.messageboards.model.MBCategory"));

	public MBCategoryModelImpl() {
	}

	public long getPrimaryKey() {
		return _categoryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCategoryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_categoryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return MBCategory.class;
	}

	public String getModelClassName() {
		return MBCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("categoryId", getCategoryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("parentCategoryId", getParentCategoryId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("displayStyle", getDisplayStyle());
		attributes.put("threadCount", getThreadCount());
		attributes.put("messageCount", getMessageCount());
		attributes.put("lastPostDate", getLastPostDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long parentCategoryId = (Long)attributes.get("parentCategoryId");

		if (parentCategoryId != null) {
			setParentCategoryId(parentCategoryId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String displayStyle = (String)attributes.get("displayStyle");

		if (displayStyle != null) {
			setDisplayStyle(displayStyle);
		}

		Integer threadCount = (Integer)attributes.get("threadCount");

		if (threadCount != null) {
			setThreadCount(threadCount);
		}

		Integer messageCount = (Integer)attributes.get("messageCount");

		if (messageCount != null) {
			setMessageCount(messageCount);
		}

		Date lastPostDate = (Date)attributes.get("lastPostDate");

		if (lastPostDate != null) {
			setLastPostDate(lastPostDate);
		}
	}

	@JSON
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public long getParentCategoryId() {
		return _parentCategoryId;
	}

	public void setParentCategoryId(long parentCategoryId) {
		_columnBitmask = -1L;

		if (!_setOriginalParentCategoryId) {
			_setOriginalParentCategoryId = true;

			_originalParentCategoryId = _parentCategoryId;
		}

		_parentCategoryId = parentCategoryId;
	}

	public long getOriginalParentCategoryId() {
		return _originalParentCategoryId;
	}

	@JSON
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_columnBitmask = -1L;

		_name = name;
	}

	@JSON
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	public String getDisplayStyle() {
		if (_displayStyle == null) {
			return StringPool.BLANK;
		}
		else {
			return _displayStyle;
		}
	}

	public void setDisplayStyle(String displayStyle) {
		_displayStyle = displayStyle;
	}

	@JSON
	public int getThreadCount() {
		return _threadCount;
	}

	public void setThreadCount(int threadCount) {
		_threadCount = threadCount;
	}

	@JSON
	public int getMessageCount() {
		return _messageCount;
	}

	public void setMessageCount(int messageCount) {
		_messageCount = messageCount;
	}

	@JSON
	public Date getLastPostDate() {
		return _lastPostDate;
	}

	public void setLastPostDate(Date lastPostDate) {
		_lastPostDate = lastPostDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			MBCategory.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public MBCategory toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (MBCategory)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public MBCategory toUnescapedModel() {
		if (ProxyUtil.isProxyClass(getClass())) {
			InvocationHandler invocationHandler = ProxyUtil.getInvocationHandler(this);

			AutoEscapeBeanHandler autoEscapeBeanHandler = (AutoEscapeBeanHandler)invocationHandler;

			_unescapedModel = (MBCategory)autoEscapeBeanHandler.getBean();
		}
		else {
			_unescapedModel = (MBCategory)this;
		}

		return _unescapedModel;
	}

	@Override
	public Object clone() {
		MBCategoryImpl mbCategoryImpl = new MBCategoryImpl();

		mbCategoryImpl.setUuid(getUuid());
		mbCategoryImpl.setCategoryId(getCategoryId());
		mbCategoryImpl.setGroupId(getGroupId());
		mbCategoryImpl.setCompanyId(getCompanyId());
		mbCategoryImpl.setUserId(getUserId());
		mbCategoryImpl.setUserName(getUserName());
		mbCategoryImpl.setCreateDate(getCreateDate());
		mbCategoryImpl.setModifiedDate(getModifiedDate());
		mbCategoryImpl.setParentCategoryId(getParentCategoryId());
		mbCategoryImpl.setName(getName());
		mbCategoryImpl.setDescription(getDescription());
		mbCategoryImpl.setDisplayStyle(getDisplayStyle());
		mbCategoryImpl.setThreadCount(getThreadCount());
		mbCategoryImpl.setMessageCount(getMessageCount());
		mbCategoryImpl.setLastPostDate(getLastPostDate());

		mbCategoryImpl.resetOriginalValues();

		return mbCategoryImpl;
	}

	public int compareTo(MBCategory mbCategory) {
		int value = 0;

		if (getParentCategoryId() < mbCategory.getParentCategoryId()) {
			value = -1;
		}
		else if (getParentCategoryId() > mbCategory.getParentCategoryId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getName().toLowerCase()
					.compareTo(mbCategory.getName().toLowerCase());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		MBCategory mbCategory = null;

		try {
			mbCategory = (MBCategory)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = mbCategory.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		MBCategoryModelImpl mbCategoryModelImpl = this;

		mbCategoryModelImpl._originalUuid = mbCategoryModelImpl._uuid;

		mbCategoryModelImpl._originalGroupId = mbCategoryModelImpl._groupId;

		mbCategoryModelImpl._setOriginalGroupId = false;

		mbCategoryModelImpl._originalCompanyId = mbCategoryModelImpl._companyId;

		mbCategoryModelImpl._setOriginalCompanyId = false;

		mbCategoryModelImpl._originalParentCategoryId = mbCategoryModelImpl._parentCategoryId;

		mbCategoryModelImpl._setOriginalParentCategoryId = false;

		mbCategoryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<MBCategory> toCacheModel() {
		MBCategoryCacheModel mbCategoryCacheModel = new MBCategoryCacheModel();

		mbCategoryCacheModel.uuid = getUuid();

		String uuid = mbCategoryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			mbCategoryCacheModel.uuid = null;
		}

		mbCategoryCacheModel.categoryId = getCategoryId();

		mbCategoryCacheModel.groupId = getGroupId();

		mbCategoryCacheModel.companyId = getCompanyId();

		mbCategoryCacheModel.userId = getUserId();

		mbCategoryCacheModel.userName = getUserName();

		String userName = mbCategoryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			mbCategoryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			mbCategoryCacheModel.createDate = createDate.getTime();
		}
		else {
			mbCategoryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			mbCategoryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			mbCategoryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		mbCategoryCacheModel.parentCategoryId = getParentCategoryId();

		mbCategoryCacheModel.name = getName();

		String name = mbCategoryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			mbCategoryCacheModel.name = null;
		}

		mbCategoryCacheModel.description = getDescription();

		String description = mbCategoryCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			mbCategoryCacheModel.description = null;
		}

		mbCategoryCacheModel.displayStyle = getDisplayStyle();

		String displayStyle = mbCategoryCacheModel.displayStyle;

		if ((displayStyle != null) && (displayStyle.length() == 0)) {
			mbCategoryCacheModel.displayStyle = null;
		}

		mbCategoryCacheModel.threadCount = getThreadCount();

		mbCategoryCacheModel.messageCount = getMessageCount();

		Date lastPostDate = getLastPostDate();

		if (lastPostDate != null) {
			mbCategoryCacheModel.lastPostDate = lastPostDate.getTime();
		}
		else {
			mbCategoryCacheModel.lastPostDate = Long.MIN_VALUE;
		}

		return mbCategoryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", parentCategoryId=");
		sb.append(getParentCategoryId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", displayStyle=");
		sb.append(getDisplayStyle());
		sb.append(", threadCount=");
		sb.append(getThreadCount());
		sb.append(", messageCount=");
		sb.append(getMessageCount());
		sb.append(", lastPostDate=");
		sb.append(getLastPostDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.messageboards.model.MBCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentCategoryId</column-name><column-value><![CDATA[");
		sb.append(getParentCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayStyle</column-name><column-value><![CDATA[");
		sb.append(getDisplayStyle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>threadCount</column-name><column-value><![CDATA[");
		sb.append(getThreadCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageCount</column-name><column-value><![CDATA[");
		sb.append(getMessageCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastPostDate</column-name><column-value><![CDATA[");
		sb.append(getLastPostDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = MBCategory.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			MBCategory.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _categoryId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _parentCategoryId;
	private long _originalParentCategoryId;
	private boolean _setOriginalParentCategoryId;
	private String _name;
	private String _description;
	private String _displayStyle;
	private int _threadCount;
	private int _messageCount;
	private Date _lastPostDate;
	private long _columnBitmask;
	private MBCategory _escapedModel;
	private MBCategory _unescapedModel;
}