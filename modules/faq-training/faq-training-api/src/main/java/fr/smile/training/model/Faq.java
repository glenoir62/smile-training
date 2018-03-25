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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Faq service. Represents a row in the &quot;FAQ_Faq&quot; database table, with each column mapped to a property of this class.
 *
 * @author Guillaume Lenoir
 * @see FaqModel
 * @see fr.smile.training.model.impl.FaqImpl
 * @see fr.smile.training.model.impl.FaqModelImpl
 * @generated
 */
@ImplementationClassName("fr.smile.training.model.impl.FaqImpl")
@ProviderType
public interface Faq extends FaqModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link fr.smile.training.model.impl.FaqImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Faq, Long> ENTRY_ID_ACCESSOR = new Accessor<Faq, Long>() {
			@Override
			public Long get(Faq faq) {
				return faq.getEntryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Faq> getTypeClass() {
				return Faq.class;
			}
		};
}