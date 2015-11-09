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

package com.liferay.portal.workflow.kaleo.action.executor.internal;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ClassUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.workflow.kaleo.action.executor.ActionExecutor;
import com.liferay.portal.workflow.kaleo.definition.ScriptLanguage;
import com.liferay.portal.workflow.kaleo.model.KaleoAction;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.runtime.action.ActionExecutorManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Leonardo Barros
 */
@Component(immediate = true)
public class ActionExecutorManagerImpl implements ActionExecutorManager {

	@Override
	public void executeKaleoAction(
			KaleoAction kaleoAction, ExecutionContext executionContext)
		throws PortalException {

		String actionExecutorKey = getActionExecutorKey(
			kaleoAction.getScriptLanguage(), kaleoAction.getScript());

		ActionExecutor actionExecutor = _actionExecutors.get(actionExecutorKey);

		if (actionExecutor == null) {
			throw new PortalException(
				"No ActionExecutor configured for: " + actionExecutorKey);
		}

		actionExecutor.execute(kaleoAction, executionContext);
	}

	protected String getActionExecutorKey(
		String language, String actionExecutorClassName) {

		ScriptLanguage scriptLanguage = ScriptLanguage.parse(language);

		if (scriptLanguage.equals(ScriptLanguage.JAVA)) {
			return language + StringPool.COLON + actionExecutorClassName;
		}
		else {
			return language;
		}
	}

	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		unbind = "unregisterActionExecutor"
	)
	protected synchronized void registerActionExecutor(
		ActionExecutor actionExecutor, Map<String, Object> properties) {

		Object languageProperty = properties.get(
			"com.liferay.portal.workflow.kaleo.action.executor.language");

		String[] defaultValue = new String[] {String.valueOf(languageProperty)};

		String[] languages = GetterUtil.getStringValues(
			languageProperty, defaultValue);

		for (String language : languages) {
			String actionExecutorKey = getActionExecutorKey(
				language, ClassUtil.getClassName(actionExecutor));

			_actionExecutors.put(actionExecutorKey, actionExecutor);
		}
	}

	protected synchronized void unregisterActionExecutor(
		ActionExecutor actionExecutor, Map<String, Object> properties) {

		Object languageProperty = properties.get(
			"com.liferay.portal.workflow.kaleo.action.executor.language");

		String[] defaultValue = new String[] {String.valueOf(languageProperty)};

		String[] languages = GetterUtil.getStringValues(
			languageProperty, defaultValue);

		for (String language : languages) {
			String actionExecutorKey = getActionExecutorKey(
				language, ClassUtil.getClassName(actionExecutor));

			_actionExecutors.remove(actionExecutorKey);
		}
	}

	private final Map<String, ActionExecutor> _actionExecutors =
		new ConcurrentHashMap<>();

}