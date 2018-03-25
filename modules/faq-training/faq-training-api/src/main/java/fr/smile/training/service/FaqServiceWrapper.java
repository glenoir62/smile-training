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

package fr.smile.training.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FaqService}.
 *
 * @author Guillaume Lenoir
 * @see FaqService
 * @generated
 */
@ProviderType
public class FaqServiceWrapper implements FaqService,
	ServiceWrapper<FaqService> {
	public FaqServiceWrapper(FaqService faqService) {
		_faqService = faqService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _faqService.getOSGiServiceIdentifier();
	}

	@Override
	public FaqService getWrappedService() {
		return _faqService;
	}

	@Override
	public void setWrappedService(FaqService faqService) {
		_faqService = faqService;
	}

	private FaqService _faqService;
}