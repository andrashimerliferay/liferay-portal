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

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.RadioDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.RadioDSField;
import com.liferay.digital.signature.model.field.builder.RadioDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class RadioDSFieldBuilderImpl
	extends DSFieldBuilderImpl<RadioDSField> implements RadioDSFieldBuilder {

	public RadioDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<RadioDSField> getDSField() {
		RadioDSFieldImpl radioDSFieldImpl = new RadioDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber()) {

			{
				setValue(_value);
			}
		};

		populateFields(radioDSFieldImpl);

		return radioDSFieldImpl;
	}

	@Override
	public RadioDSFieldBuilder setValue(String value) {
		_value = value;

		return this;
	}

	private String _value;

}