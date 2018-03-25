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

package fr.smile.training.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link fr.smile.training.service.http.FaqServiceSoap}.
 *
 * @author Guillaume Lenoir
 * @see fr.smile.training.service.http.FaqServiceSoap
 * @generated
 */
@ProviderType
public class FaqSoap implements Serializable {
	public static FaqSoap toSoapModel(Faq model) {
		FaqSoap soapModel = new FaqSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEntryId(model.getEntryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setQuestion(model.getQuestion());
		soapModel.setAnswer(model.getAnswer());

		return soapModel;
	}

	public static FaqSoap[] toSoapModels(Faq[] models) {
		FaqSoap[] soapModels = new FaqSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FaqSoap[][] toSoapModels(Faq[][] models) {
		FaqSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FaqSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FaqSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FaqSoap[] toSoapModels(List<Faq> models) {
		List<FaqSoap> soapModels = new ArrayList<FaqSoap>(models.size());

		for (Faq model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FaqSoap[soapModels.size()]);
	}

	public FaqSoap() {
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long pk) {
		setEntryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getQuestion() {
		return _question;
	}

	public void setQuestion(String question) {
		_question = question;
	}

	public String getAnswer() {
		return _answer;
	}

	public void setAnswer(String answer) {
		_answer = answer;
	}

	private String _uuid;
	private long _entryId;
	private long _groupId;
	private long _companyId;
	private String _question;
	private String _answer;
}