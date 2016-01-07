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

package com.liferay.source.formatter;

import com.liferay.portal.kernel.util.StringUtil;

import java.io.File;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class TLDSourceProcessor extends BaseSourceProcessor {

	@Override
	public String[] getIncludes() {
		return _INCLUDES;
	}

	@Override
	protected String doFormat(
			File file, String fileName, String absolutePath, String content)
		throws Exception {

		content = trimContent(content, false);

		Matcher matcher = _ATTRIBUTE_TYPE.matcher(content);

		while (matcher.find()) {
			String beforeMatch = content.substring(0, matcher.start());

			int lineCount = StringUtil.count(beforeMatch, "\n") + 1;

			processErrorMessage(
				fileName,
				"Use fully qualified classType: " + fileName + " " + lineCount);
		}

		return StringUtil.replace(content, "\n\n\n", "\n\n");
	}

	@Override
	protected List<String> doGetFileNames() throws Exception {
		String[] excludes = new String[] {"**/WEB-INF/tld/**"};

		return getFileNames(excludes, getIncludes());
	}

	private static final Pattern _ATTRIBUTE_TYPE = Pattern.compile(
		"<type>[A-Z][a-z]*</type>");

	private static final String[] _INCLUDES = new String[] {"**/*.tld"};

}