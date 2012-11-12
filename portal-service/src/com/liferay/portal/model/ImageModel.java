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

package com.liferay.portal.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Image service. Represents a row in the &quot;Image&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.ImageModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.ImageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Image
 * @see com.liferay.portal.model.impl.ImageImpl
 * @see com.liferay.portal.model.impl.ImageModelImpl
 * @generated
 */
public interface ImageModel extends BaseModel<Image> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a image model instance should use the {@link Image} interface instead.
	 */

	/**
	 * Returns the primary key of this image.
	 *
	 * @return the primary key of this image
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this image.
	 *
	 * @param primaryKey the primary key of this image
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the image ID of this image.
	 *
	 * @return the image ID of this image
	 */
	public long getImageId();

	/**
	 * Sets the image ID of this image.
	 *
	 * @param imageId the image ID of this image
	 */
	public void setImageId(long imageId);

	/**
	 * Returns the modified date of this image.
	 *
	 * @return the modified date of this image
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this image.
	 *
	 * @param modifiedDate the modified date of this image
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the text of this image.
	 *
	 * @return the text of this image
	 */
	@AutoEscape
	public String getText();

	/**
	 * Sets the text of this image.
	 *
	 * @param text the text of this image
	 */
	public void setText(String text);

	/**
	 * Returns the type of this image.
	 *
	 * @return the type of this image
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this image.
	 *
	 * @param type the type of this image
	 */
	public void setType(String type);

	/**
	 * Returns the height of this image.
	 *
	 * @return the height of this image
	 */
	public int getHeight();

	/**
	 * Sets the height of this image.
	 *
	 * @param height the height of this image
	 */
	public void setHeight(int height);

	/**
	 * Returns the width of this image.
	 *
	 * @return the width of this image
	 */
	public int getWidth();

	/**
	 * Sets the width of this image.
	 *
	 * @param width the width of this image
	 */
	public void setWidth(int width);

	/**
	 * Returns the size of this image.
	 *
	 * @return the size of this image
	 */
	public int getSize();

	/**
	 * Sets the size of this image.
	 *
	 * @param size the size of this image
	 */
	public void setSize(int size);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Image image);

	public int hashCode();

	public CacheModel<Image> toCacheModel();

	public Image toEscapedModel();

	public Image toUnescapedModel();

	public String toString();

	public String toXmlString();
}