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

package com.liferay.headless.workflow.client.serdes.v1_0;

import com.liferay.headless.workflow.client.dto.v1_0.WorkflowTaskAssignToMe;
import com.liferay.headless.workflow.client.json.BaseJSONParser;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public class WorkflowTaskAssignToMeSerDes {

	public static WorkflowTaskAssignToMe toDTO(String json) {
		WorkflowTaskAssignToMeJSONParser workflowTaskAssignToMeJSONParser =
			new WorkflowTaskAssignToMeJSONParser();

		return workflowTaskAssignToMeJSONParser.parseToDTO(json);
	}

	public static WorkflowTaskAssignToMe[] toDTOs(String json) {
		WorkflowTaskAssignToMeJSONParser workflowTaskAssignToMeJSONParser =
			new WorkflowTaskAssignToMeJSONParser();

		return workflowTaskAssignToMeJSONParser.parseToDTOs(json);
	}

	public static String toJSON(WorkflowTaskAssignToMe workflowTaskAssignToMe) {
		if (workflowTaskAssignToMe == null) {
			return "{}";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		sb.append("\"comment\": ");

		sb.append("\"");
		sb.append(workflowTaskAssignToMe.getComment());
		sb.append("\"");
		sb.append(", ");

		sb.append("\"dueDate\": ");

		sb.append("\"");
		sb.append(workflowTaskAssignToMe.getDueDate());
		sb.append("\"");

		sb.append("}");

		return sb.toString();
	}

	public static String toJSON(
		Collection<WorkflowTaskAssignToMe> workflowTaskAssignToMes) {

		if (workflowTaskAssignToMes == null) {
			return "[]";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("[");

		for (WorkflowTaskAssignToMe workflowTaskAssignToMe :
				workflowTaskAssignToMes) {

			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append(toJSON(workflowTaskAssignToMe));
		}

		sb.append("]");

		return sb.toString();
	}

	private static class WorkflowTaskAssignToMeJSONParser
		extends BaseJSONParser<WorkflowTaskAssignToMe> {

		protected WorkflowTaskAssignToMe createDTO() {
			return new WorkflowTaskAssignToMe();
		}

		protected WorkflowTaskAssignToMe[] createDTOArray(int size) {
			return new WorkflowTaskAssignToMe[size];
		}

		protected void setField(
			WorkflowTaskAssignToMe workflowTaskAssignToMe,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "comment")) {
				if (jsonParserFieldValue != null) {
					workflowTaskAssignToMe.setComment(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dueDate")) {
				if (jsonParserFieldValue != null) {
					workflowTaskAssignToMe.setDueDate(
						(Date)jsonParserFieldValue);
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

}