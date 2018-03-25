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
 * Provides a wrapper for {@link FaqLocalService}.
 *
 * @author Guillaume Lenoir
 * @see FaqLocalService
 * @generated
 */
@ProviderType
public class FaqLocalServiceWrapper implements FaqLocalService,
	ServiceWrapper<FaqLocalService> {
	public FaqLocalServiceWrapper(FaqLocalService faqLocalService) {
		_faqLocalService = faqLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _faqLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _faqLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _faqLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.Session getCurrentSession()
		throws com.liferay.portal.kernel.dao.orm.ORMException {
		return _faqLocalService.getCurrentSession();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.Session openSession()
		throws com.liferay.portal.kernel.dao.orm.ORMException {
		return _faqLocalService.openSession();
	}

	@Override
	public com.liferay.portal.kernel.exception.SystemException processException(
		java.lang.Exception e) {
		return _faqLocalService.processException(e);
	}

	@Override
	public com.liferay.portal.kernel.model.ModelListener<fr.smile.training.model.Faq>[] getListeners() {
		return _faqLocalService.getListeners();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _faqLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _faqLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the faq to the database. Also notifies the appropriate model listeners.
	*
	* @param faq the faq
	* @return the faq that was added
	*/
	@Override
	public fr.smile.training.model.Faq addFaq(fr.smile.training.model.Faq faq) {
		return _faqLocalService.addFaq(faq);
	}

	@Override
	public fr.smile.training.model.Faq create(long entryId) {
		return _faqLocalService.create(entryId);
	}

	/**
	* Creates a new faq with the primary key. Does not add the faq to the database.
	*
	* @param entryId the primary key for the new faq
	* @return the new faq
	*/
	@Override
	public fr.smile.training.model.Faq createFaq(long entryId) {
		return _faqLocalService.createFaq(entryId);
	}

	/**
	* Deletes the faq from the database. Also notifies the appropriate model listeners.
	*
	* @param faq the faq
	* @return the faq that was removed
	*/
	@Override
	public fr.smile.training.model.Faq deleteFaq(
		fr.smile.training.model.Faq faq) {
		return _faqLocalService.deleteFaq(faq);
	}

	/**
	* Deletes the faq with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the faq
	* @return the faq that was removed
	* @throws PortalException if a faq with the primary key could not be found
	*/
	@Override
	public fr.smile.training.model.Faq deleteFaq(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _faqLocalService.deleteFaq(entryId);
	}

	@Override
	public fr.smile.training.model.Faq fetchByPrimaryKey(
		java.io.Serializable primaryKey) {
		return _faqLocalService.fetchByPrimaryKey(primaryKey);
	}

	@Override
	public fr.smile.training.model.Faq fetchByPrimaryKey(long entryId) {
		return _faqLocalService.fetchByPrimaryKey(entryId);
	}

	@Override
	public fr.smile.training.model.Faq fetchByUUID_G(java.lang.String uuid,
		long groupId) {
		return _faqLocalService.fetchByUUID_G(uuid, groupId);
	}

	@Override
	public fr.smile.training.model.Faq fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return _faqLocalService.fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	@Override
	public fr.smile.training.model.Faq fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator) {
		return _faqLocalService.fetchByUuid_C_First(uuid, companyId,
			orderByComparator);
	}

	@Override
	public fr.smile.training.model.Faq fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator) {
		return _faqLocalService.fetchByUuid_C_Last(uuid, companyId,
			orderByComparator);
	}

	@Override
	public fr.smile.training.model.Faq fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator) {
		return _faqLocalService.fetchByUuid_First(uuid, orderByComparator);
	}

	@Override
	public fr.smile.training.model.Faq fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator) {
		return _faqLocalService.fetchByUuid_Last(uuid, orderByComparator);
	}

	@Override
	public fr.smile.training.model.Faq fetchFaq(long entryId) {
		return _faqLocalService.fetchFaq(entryId);
	}

	/**
	* Returns the faq matching the UUID and group.
	*
	* @param uuid the faq's UUID
	* @param groupId the primary key of the group
	* @return the matching faq, or <code>null</code> if a matching faq could not be found
	*/
	@Override
	public fr.smile.training.model.Faq fetchFaqByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _faqLocalService.fetchFaqByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public fr.smile.training.model.Faq findByPrimaryKey(
		java.io.Serializable primaryKey)
		throws com.liferay.portal.kernel.exception.NoSuchModelException {
		return _faqLocalService.findByPrimaryKey(primaryKey);
	}

	@Override
	public fr.smile.training.model.Faq findByPrimaryKey(long entryId)
		throws fr.smile.training.exception.NoSuchFaqException {
		return _faqLocalService.findByPrimaryKey(entryId);
	}

	@Override
	public fr.smile.training.model.Faq findByUUID_G(java.lang.String uuid,
		long groupId) throws fr.smile.training.exception.NoSuchFaqException {
		return _faqLocalService.findByUUID_G(uuid, groupId);
	}

	@Override
	public fr.smile.training.model.Faq findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator)
		throws fr.smile.training.exception.NoSuchFaqException {
		return _faqLocalService.findByUuid_C_First(uuid, companyId,
			orderByComparator);
	}

	@Override
	public fr.smile.training.model.Faq findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator)
		throws fr.smile.training.exception.NoSuchFaqException {
		return _faqLocalService.findByUuid_C_Last(uuid, companyId,
			orderByComparator);
	}

	@Override
	public fr.smile.training.model.Faq findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator)
		throws fr.smile.training.exception.NoSuchFaqException {
		return _faqLocalService.findByUuid_First(uuid, orderByComparator);
	}

	@Override
	public fr.smile.training.model.Faq findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator)
		throws fr.smile.training.exception.NoSuchFaqException {
		return _faqLocalService.findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the faq with the primary key.
	*
	* @param entryId the primary key of the faq
	* @return the faq
	* @throws PortalException if a faq with the primary key could not be found
	*/
	@Override
	public fr.smile.training.model.Faq getFaq(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _faqLocalService.getFaq(entryId);
	}

	/**
	* Returns the faq matching the UUID and group.
	*
	* @param uuid the faq's UUID
	* @param groupId the primary key of the group
	* @return the matching faq
	* @throws PortalException if a matching faq could not be found
	*/
	@Override
	public fr.smile.training.model.Faq getFaqByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _faqLocalService.getFaqByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public fr.smile.training.model.Faq remove(fr.smile.training.model.Faq model) {
		return _faqLocalService.remove(model);
	}

	@Override
	public fr.smile.training.model.Faq remove(java.io.Serializable primaryKey)
		throws com.liferay.portal.kernel.exception.NoSuchModelException {
		return _faqLocalService.remove(primaryKey);
	}

	@Override
	public fr.smile.training.model.Faq remove(long entryId)
		throws fr.smile.training.exception.NoSuchFaqException {
		return _faqLocalService.remove(entryId);
	}

	@Override
	public fr.smile.training.model.Faq removeByUUID_G(java.lang.String uuid,
		long groupId) throws fr.smile.training.exception.NoSuchFaqException {
		return _faqLocalService.removeByUUID_G(uuid, groupId);
	}

	@Override
	public fr.smile.training.model.Faq update(fr.smile.training.model.Faq model) {
		return _faqLocalService.update(model);
	}

	@Override
	public fr.smile.training.model.Faq update(
		fr.smile.training.model.Faq model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {
		return _faqLocalService.update(model, serviceContext);
	}

	/**
	* Updates the faq in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faq the faq
	* @return the faq that was updated
	*/
	@Override
	public fr.smile.training.model.Faq updateFaq(
		fr.smile.training.model.Faq faq) {
		return _faqLocalService.updateFaq(faq);
	}

	@Override
	public fr.smile.training.model.Faq updateImpl(
		fr.smile.training.model.Faq faq) {
		return _faqLocalService.updateImpl(faq);
	}

	@Override
	public fr.smile.training.model.Faq[] findByUuid_C_PrevAndNext(
		long entryId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator)
		throws fr.smile.training.exception.NoSuchFaqException {
		return _faqLocalService.findByUuid_C_PrevAndNext(entryId, uuid,
			companyId, orderByComparator);
	}

	@Override
	public fr.smile.training.model.Faq[] findByUuid_PrevAndNext(long entryId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator)
		throws fr.smile.training.exception.NoSuchFaqException {
		return _faqLocalService.findByUuid_PrevAndNext(entryId, uuid,
			orderByComparator);
	}

	@Override
	public int countAll() {
		return _faqLocalService.countAll();
	}

	@Override
	public int countByUUID_G(java.lang.String uuid, long groupId) {
		return _faqLocalService.countByUUID_G(uuid, groupId);
	}

	@Override
	public int countByUuid(java.lang.String uuid) {
		return _faqLocalService.countByUuid(uuid);
	}

	@Override
	public int countByUuid_C(java.lang.String uuid, long companyId) {
		return _faqLocalService.countByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of faqs.
	*
	* @return the number of faqs
	*/
	@Override
	public int getFaqsCount() {
		return _faqLocalService.getFaqsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _faqLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _faqLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.smile.training.model.impl.FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _faqLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.smile.training.model.impl.FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _faqLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<fr.smile.training.model.Faq> findAll() {
		return _faqLocalService.findAll();
	}

	@Override
	public java.util.List<fr.smile.training.model.Faq> findAll(int start,
		int end) {
		return _faqLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<fr.smile.training.model.Faq> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator) {
		return _faqLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public java.util.List<fr.smile.training.model.Faq> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator,
		boolean retrieveFromCache) {
		return _faqLocalService.findAll(start, end, orderByComparator,
			retrieveFromCache);
	}

	@Override
	public java.util.List<fr.smile.training.model.Faq> findByUuid(
		java.lang.String uuid) {
		return _faqLocalService.findByUuid(uuid);
	}

	@Override
	public java.util.List<fr.smile.training.model.Faq> findByUuid(
		java.lang.String uuid, int start, int end) {
		return _faqLocalService.findByUuid(uuid, start, end);
	}

	@Override
	public java.util.List<fr.smile.training.model.Faq> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator) {
		return _faqLocalService.findByUuid(uuid, start, end, orderByComparator);
	}

	@Override
	public java.util.List<fr.smile.training.model.Faq> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator,
		boolean retrieveFromCache) {
		return _faqLocalService.findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	@Override
	public java.util.List<fr.smile.training.model.Faq> findByUuid_C(
		java.lang.String uuid, long companyId) {
		return _faqLocalService.findByUuid_C(uuid, companyId);
	}

	@Override
	public java.util.List<fr.smile.training.model.Faq> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end) {
		return _faqLocalService.findByUuid_C(uuid, companyId, start, end);
	}

	@Override
	public java.util.List<fr.smile.training.model.Faq> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator) {
		return _faqLocalService.findByUuid_C(uuid, companyId, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<fr.smile.training.model.Faq> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator,
		boolean retrieveFromCache) {
		return _faqLocalService.findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns a range of all the faqs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fr.smile.training.model.impl.FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @return the range of faqs
	*/
	@Override
	public java.util.List<fr.smile.training.model.Faq> getFaqs(int start,
		int end) {
		return _faqLocalService.getFaqs(start, end);
	}

	/**
	* Returns all the faqs matching the UUID and company.
	*
	* @param uuid the UUID of the faqs
	* @param companyId the primary key of the company
	* @return the matching faqs, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<fr.smile.training.model.Faq> getFaqsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _faqLocalService.getFaqsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of faqs matching the UUID and company.
	*
	* @param uuid the UUID of the faqs
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching faqs, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<fr.smile.training.model.Faq> getFaqsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator) {
		return _faqLocalService.getFaqsByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
	}

	@Override
	public java.util.Map<java.io.Serializable, fr.smile.training.model.Faq> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return _faqLocalService.fetchByPrimaryKeys(primaryKeys);
	}

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames() {
		return _faqLocalService.getBadColumnNames();
	}

	@Override
	public javax.sql.DataSource getDataSource() {
		return _faqLocalService.getDataSource();
	}

	@Override
	public long countWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _faqLocalService.countWithDynamicQuery(dynamicQuery);
	}

	@Override
	public long countWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _faqLocalService.countWithDynamicQuery(dynamicQuery, projection);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _faqLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _faqLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public void addFaq(long companyId, long groupId, java.lang.String question,
		java.lang.String answer) {
		_faqLocalService.addFaq(companyId, groupId, question, answer);
	}

	@Override
	public void cacheResult(fr.smile.training.model.Faq faq) {
		_faqLocalService.cacheResult(faq);
	}

	@Override
	public void cacheResult(java.util.List<fr.smile.training.model.Faq> faqs) {
		_faqLocalService.cacheResult(faqs);
	}

	@Override
	public void clearCache() {
		_faqLocalService.clearCache();
	}

	@Override
	public void clearCache(fr.smile.training.model.Faq model) {
		_faqLocalService.clearCache(model);
	}

	@Override
	public void clearCache(
		java.util.List<fr.smile.training.model.Faq> modelList) {
		_faqLocalService.clearCache(modelList);
	}

	@Override
	public void closeSession(com.liferay.portal.kernel.dao.orm.Session session) {
		_faqLocalService.closeSession(session);
	}

	@Override
	public void flush() {
		_faqLocalService.flush();
	}

	@Override
	public void registerListener(
		com.liferay.portal.kernel.model.ModelListener<fr.smile.training.model.Faq> listener) {
		_faqLocalService.registerListener(listener);
	}

	@Override
	public void removeAll() {
		_faqLocalService.removeAll();
	}

	@Override
	public void removeByUuid(java.lang.String uuid) {
		_faqLocalService.removeByUuid(uuid);
	}

	@Override
	public void removeByUuid_C(java.lang.String uuid, long companyId) {
		_faqLocalService.removeByUuid_C(uuid, companyId);
	}

	@Override
	public void setDataSource(javax.sql.DataSource dataSource) {
		_faqLocalService.setDataSource(dataSource);
	}

	@Override
	public void unregisterListener(
		com.liferay.portal.kernel.model.ModelListener<fr.smile.training.model.Faq> listener) {
		_faqLocalService.unregisterListener(listener);
	}

	@Override
	public FaqLocalService getWrappedService() {
		return _faqLocalService;
	}

	@Override
	public void setWrappedService(FaqLocalService faqLocalService) {
		_faqLocalService = faqLocalService;
	}

	private FaqLocalService _faqLocalService;
}