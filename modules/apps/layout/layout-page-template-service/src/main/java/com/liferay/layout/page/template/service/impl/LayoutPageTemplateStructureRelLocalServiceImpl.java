/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.layout.page.template.service.impl;

import com.liferay.layout.page.template.model.LayoutPageTemplateStructureRel;
import com.liferay.layout.page.template.service.base.LayoutPageTemplateStructureRelLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.Date;
import java.util.List;

/**
 * @author Eduardo García
 */
public class LayoutPageTemplateStructureRelLocalServiceImpl
	extends LayoutPageTemplateStructureRelLocalServiceBaseImpl {

	@Override
	public LayoutPageTemplateStructureRel addLayoutPageTemplateStructureRel(
			long userId, long groupId, long layoutPageTemplateStructureId,
			long segmentsExperienceId, String data,
			ServiceContext serviceContext)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		long layoutPageTemplateStructureRelId = counterLocalService.increment();

		LayoutPageTemplateStructureRel layoutPageTemplateStructureRel =
			layoutPageTemplateStructureRelPersistence.create(
				layoutPageTemplateStructureRelId);

		layoutPageTemplateStructureRel.setUuid(serviceContext.getUuid());
		layoutPageTemplateStructureRel.setGroupId(groupId);
		layoutPageTemplateStructureRel.setCompanyId(user.getCompanyId());
		layoutPageTemplateStructureRel.setUserId(user.getUserId());
		layoutPageTemplateStructureRel.setUserName(user.getFullName());
		layoutPageTemplateStructureRel.setCreateDate(
			serviceContext.getCreateDate(new Date()));
		layoutPageTemplateStructureRel.setModifiedDate(
			serviceContext.getModifiedDate(new Date()));
		layoutPageTemplateStructureRel.setLayoutPageTemplateStructureId(
			layoutPageTemplateStructureId);
		layoutPageTemplateStructureRel.setSegmentsExperienceId(
			segmentsExperienceId);
		layoutPageTemplateStructureRel.setData(data);

		layoutPageTemplateStructureRelPersistence.update(
			layoutPageTemplateStructureRel);

		return layoutPageTemplateStructureRel;
	}

	@Override
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	public LayoutPageTemplateStructureRel deleteLayoutPageTemplateStructureRel(
			long layoutPageTemplateStructureId, long segmentsExperienceId)
		throws PortalException {

		LayoutPageTemplateStructureRel layoutPageTemplateStructureRel =
			layoutPageTemplateStructureRelPersistence.findByL_S(
				layoutPageTemplateStructureId, segmentsExperienceId);

		layoutPageTemplateStructureRelPersistence.remove(
			layoutPageTemplateStructureRel);

		return layoutPageTemplateStructureRel;
	}

	@Override
	public LayoutPageTemplateStructureRel fetchLayoutPageTemplateStructureRel(
		long layoutPageTemplateStructureId, long segmentsExperienceId) {

		return layoutPageTemplateStructureRelPersistence.fetchByL_S(
			layoutPageTemplateStructureId, segmentsExperienceId);
	}

	@Override
	public List<LayoutPageTemplateStructureRel>
		getLayoutPageTemplateStructureRels(long layoutPageTemplateStructureId) {

		return layoutPageTemplateStructureRelPersistence.
			findByLayoutPageTemplateStructureId(layoutPageTemplateStructureId);
	}

	@Override
	public LayoutPageTemplateStructureRel updateLayoutPageTemplateStructureRel(
			long layoutPageTemplateStructureId, long segmentsExperienceId,
			String data)
		throws PortalException {

		LayoutPageTemplateStructureRel layoutPageTemplateStructureRel =
			layoutPageTemplateStructureRelPersistence.findByL_S(
				layoutPageTemplateStructureId, segmentsExperienceId);

		layoutPageTemplateStructureRel.setModifiedDate(new Date());
		layoutPageTemplateStructureRel.setData(data);

		layoutPageTemplateStructureRelPersistence.update(
			layoutPageTemplateStructureRel);

		return layoutPageTemplateStructureRel;
	}

	@ServiceReference(type = LayoutLocalService.class)
	private LayoutLocalService _layoutLocalService;

	@ServiceReference(type = Portal.class)
	private Portal _portal;

}