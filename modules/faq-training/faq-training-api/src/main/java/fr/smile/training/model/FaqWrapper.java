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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Faq}.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see Faq
 * @generated
 */
@ProviderType
public class FaqWrapper implements Faq, ModelWrapper<Faq> {
	public FaqWrapper(Faq faq) {
		_faq = faq;
	}

	@Override
	public Class<?> getModelClass() {
		return Faq.class;
	}

	@Override
	public String getModelClassName() {
		return Faq.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("entryId", getEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("question", getQuestion());
		attributes.put("answer", getAnswer());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String question = (String)attributes.get("question");

		if (question != null) {
			setQuestion(question);
		}

		String answer = (String)attributes.get("answer");

		if (answer != null) {
			setAnswer(answer);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _faq.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _faq.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _faq.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _faq.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<fr.smile.training.model.Faq> toCacheModel() {
		return _faq.toCacheModel();
	}

	@Override
	public fr.smile.training.model.Faq toEscapedModel() {
		return new FaqWrapper(_faq.toEscapedModel());
	}

	@Override
	public fr.smile.training.model.Faq toUnescapedModel() {
		return new FaqWrapper(_faq.toUnescapedModel());
	}

	@Override
	public int compareTo(fr.smile.training.model.Faq faq) {
		return _faq.compareTo(faq);
	}

	@Override
	public int hashCode() {
		return _faq.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _faq.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new FaqWrapper((Faq)_faq.clone());
	}

	/**
	* Returns the answer of this faq.
	*
	* @return the answer of this faq
	*/
	@Override
	public java.lang.String getAnswer() {
		return _faq.getAnswer();
	}

	/**
	* Returns the question of this faq.
	*
	* @return the question of this faq
	*/
	@Override
	public java.lang.String getQuestion() {
		return _faq.getQuestion();
	}

	/**
	* Returns the uuid of this faq.
	*
	* @return the uuid of this faq
	*/
	@Override
	public java.lang.String getUuid() {
		return _faq.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _faq.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _faq.toXmlString();
	}

	/**
	* Returns the company ID of this faq.
	*
	* @return the company ID of this faq
	*/
	@Override
	public long getCompanyId() {
		return _faq.getCompanyId();
	}

	/**
	* Returns the entry ID of this faq.
	*
	* @return the entry ID of this faq
	*/
	@Override
	public long getEntryId() {
		return _faq.getEntryId();
	}

	/**
	* Returns the group ID of this faq.
	*
	* @return the group ID of this faq
	*/
	@Override
	public long getGroupId() {
		return _faq.getGroupId();
	}

	/**
	* Returns the primary key of this faq.
	*
	* @return the primary key of this faq
	*/
	@Override
	public long getPrimaryKey() {
		return _faq.getPrimaryKey();
	}

	@Override
	public void persist() {
		_faq.persist();
	}

	/**
	* Sets the answer of this faq.
	*
	* @param answer the answer of this faq
	*/
	@Override
	public void setAnswer(java.lang.String answer) {
		_faq.setAnswer(answer);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_faq.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this faq.
	*
	* @param companyId the company ID of this faq
	*/
	@Override
	public void setCompanyId(long companyId) {
		_faq.setCompanyId(companyId);
	}

	/**
	* Sets the entry ID of this faq.
	*
	* @param entryId the entry ID of this faq
	*/
	@Override
	public void setEntryId(long entryId) {
		_faq.setEntryId(entryId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_faq.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_faq.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_faq.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this faq.
	*
	* @param groupId the group ID of this faq
	*/
	@Override
	public void setGroupId(long groupId) {
		_faq.setGroupId(groupId);
	}

	@Override
	public void setNew(boolean n) {
		_faq.setNew(n);
	}

	/**
	* Sets the primary key of this faq.
	*
	* @param primaryKey the primary key of this faq
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_faq.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_faq.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the question of this faq.
	*
	* @param question the question of this faq
	*/
	@Override
	public void setQuestion(java.lang.String question) {
		_faq.setQuestion(question);
	}

	/**
	* Sets the uuid of this faq.
	*
	* @param uuid the uuid of this faq
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_faq.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FaqWrapper)) {
			return false;
		}

		FaqWrapper faqWrapper = (FaqWrapper)obj;

		if (Objects.equals(_faq, faqWrapper._faq)) {
			return true;
		}

		return false;
	}

	@Override
	public Faq getWrappedModel() {
		return _faq;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _faq.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _faq.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_faq.resetOriginalValues();
	}

	private final Faq _faq;
}