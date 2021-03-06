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

package com.liferay.exportimport.controller;

import com.liferay.exportimport.kernel.controller.ExportController;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.xml.Element;

/**
 * @author Matthew Tambara
 */
public interface PortletExportController extends ExportController {

	public void exportAssetLinks(PortletDataContext portletDataContext)
		throws Exception;

	/**
	 * @deprecated As of Judson (7.1.x)
	 */
	@Deprecated
	public void exportExpandoTables(PortletDataContext portletDataContext)
		throws Exception;

	public void exportLocks(PortletDataContext portletDataContext)
		throws Exception;

	public void exportPortlet(
			PortletDataContext portletDataContext, long plid,
			Element parentElement, boolean exportPermissions,
			boolean exportPortletArchivedSetups, boolean exportPortletData,
			boolean exportPortletSetup, boolean exportPortletUserPreferences)
		throws Exception;

	public void exportService(
			PortletDataContext portletDataContext, Element rootElement,
			boolean exportServiceSetup)
		throws Exception;

}