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

package com.liferay.headless.form.client.serdes.v1_0;

import com.liferay.headless.form.client.dto.v1_0.Column;
import com.liferay.headless.form.client.json.BaseJSONParser;

import java.util.Collection;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public class ColumnSerDes {

	public static Column toDTO(String json) {
		ColumnJSONParser columnJSONParser = new ColumnJSONParser();

		return columnJSONParser.parseToDTO(json);
	}

	public static Column[] toDTOs(String json) {
		ColumnJSONParser columnJSONParser = new ColumnJSONParser();

		return columnJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Column column) {
		if (column == null) {
			return "{}";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		sb.append("\"id\": ");

		sb.append(column.getId());
		sb.append(", ");

		sb.append("\"label\": ");

		sb.append("\"");
		sb.append(column.getLabel());
		sb.append("\"");
		sb.append(", ");

		sb.append("\"value\": ");

		sb.append("\"");
		sb.append(column.getValue());
		sb.append("\"");

		sb.append("}");

		return sb.toString();
	}

	public static String toJSON(Collection<Column> columns) {
		if (columns == null) {
			return "[]";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("[");

		for (Column column : columns) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append(toJSON(column));
		}

		sb.append("]");

		return sb.toString();
	}

	private static class ColumnJSONParser extends BaseJSONParser<Column> {

		protected Column createDTO() {
			return new Column();
		}

		protected Column[] createDTOArray(int size) {
			return new Column[size];
		}

		protected void setField(
			Column column, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					column.setId((Long)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "label")) {
				if (jsonParserFieldValue != null) {
					column.setLabel((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "value")) {
				if (jsonParserFieldValue != null) {
					column.setValue((String)jsonParserFieldValue);
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

}