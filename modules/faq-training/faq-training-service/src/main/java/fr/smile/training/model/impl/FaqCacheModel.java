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

package fr.smile.training.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import fr.smile.training.model.Faq;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Faq in entity cache.
 *
 * @author Guillaume Lenoir
 * @see Faq
 * @generated
 */
@ProviderType
public class FaqCacheModel implements CacheModel<Faq>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FaqCacheModel)) {
			return false;
		}

		FaqCacheModel faqCacheModel = (FaqCacheModel)obj;

		if (entryId == faqCacheModel.entryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, entryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", entryId=");
		sb.append(entryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", question=");
		sb.append(question);
		sb.append(", answer=");
		sb.append(answer);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Faq toEntityModel() {
		FaqImpl faqImpl = new FaqImpl();

		if (uuid == null) {
			faqImpl.setUuid(StringPool.BLANK);
		}
		else {
			faqImpl.setUuid(uuid);
		}

		faqImpl.setEntryId(entryId);
		faqImpl.setGroupId(groupId);
		faqImpl.setCompanyId(companyId);

		if (question == null) {
			faqImpl.setQuestion(StringPool.BLANK);
		}
		else {
			faqImpl.setQuestion(question);
		}

		if (answer == null) {
			faqImpl.setAnswer(StringPool.BLANK);
		}
		else {
			faqImpl.setAnswer(answer);
		}

		faqImpl.resetOriginalValues();

		return faqImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		entryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		question = objectInput.readUTF();
		answer = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(entryId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (question == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(question);
		}

		if (answer == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answer);
		}
	}

	public String uuid;
	public long entryId;
	public long groupId;
	public long companyId;
	public String question;
	public String answer;
}