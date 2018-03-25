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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Faq. This utility wraps
 * {@link fr.smile.training.service.impl.FaqLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Guillaume Lenoir
 * @see FaqLocalService
 * @see fr.smile.training.service.base.FaqLocalServiceBaseImpl
 * @see fr.smile.training.service.impl.FaqLocalServiceImpl
 * @generated
 */
@ProviderType
public class FaqLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link fr.smile.training.service.impl.FaqLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.Session getCurrentSession()
		throws com.liferay.portal.kernel.dao.orm.ORMException {
		return getService().getCurrentSession();
	}

	public static com.liferay.portal.kernel.dao.orm.Session openSession()
		throws com.liferay.portal.kernel.dao.orm.ORMException {
		return getService().openSession();
	}

	public static com.liferay.portal.kernel.exception.SystemException processException(
		java.lang.Exception e) {
		return getService().processException(e);
	}

	public static com.liferay.portal.kernel.model.ModelListener<fr.smile.training.model.Faq>[] getListeners() {
		return getService().getListeners();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the faq to the database. Also notifies the appropriate model listeners.
	*
	* @param faq the faq
	* @return the faq that was added
	*/
	public static fr.smile.training.model.Faq addFaq(
		fr.smile.training.model.Faq faq) {
		return getService().addFaq(faq);
	}

	public static fr.smile.training.model.Faq create(long entryId) {
		return getService().create(entryId);
	}

	/**
	* Creates a new faq with the primary key. Does not add the faq to the database.
	*
	* @param entryId the primary key for the new faq
	* @return the new faq
	*/
	public static fr.smile.training.model.Faq createFaq(long entryId) {
		return getService().createFaq(entryId);
	}

	/**
	* Deletes the faq from the database. Also notifies the appropriate model listeners.
	*
	* @param faq the faq
	* @return the faq that was removed
	*/
	public static fr.smile.training.model.Faq deleteFaq(
		fr.smile.training.model.Faq faq) {
		return getService().deleteFaq(faq);
	}

	/**
	* Deletes the faq with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the faq
	* @return the faq that was removed
	* @throws PortalException if a faq with the primary key could not be found
	*/
	public static fr.smile.training.model.Faq deleteFaq(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteFaq(entryId);
	}

	public static fr.smile.training.model.Faq fetchByPrimaryKey(
		java.io.Serializable primaryKey) {
		return getService().fetchByPrimaryKey(primaryKey);
	}

	public static fr.smile.training.model.Faq fetchByPrimaryKey(long entryId) {
		return getService().fetchByPrimaryKey(entryId);
	}

	public static fr.smile.training.model.Faq fetchByUUID_G(
		java.lang.String uuid, long groupId) {
		return getService().fetchByUUID_G(uuid, groupId);
	}

	public static fr.smile.training.model.Faq fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache) {
		return getService().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	public static fr.smile.training.model.Faq fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator) {
		return getService()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	public static fr.smile.training.model.Faq fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator) {
		return getService()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	public static fr.smile.training.model.Faq fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator) {
		return getService().fetchByUuid_First(uuid, orderByComparator);
	}

	public static fr.smile.training.model.Faq fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator) {
		return getService().fetchByUuid_Last(uuid, orderByComparator);
	}

	public static fr.smile.training.model.Faq fetchFaq(long entryId) {
		return getService().fetchFaq(entryId);
	}

	/**
	* Returns the faq matching the UUID and group.
	*
	* @param uuid the faq's UUID
	* @param groupId the primary key of the group
	* @return the matching faq, or <code>null</code> if a matching faq could not be found
	*/
	public static fr.smile.training.model.Faq fetchFaqByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchFaqByUuidAndGroupId(uuid, groupId);
	}

	public static fr.smile.training.model.Faq findByPrimaryKey(
		java.io.Serializable primaryKey)
		throws com.liferay.portal.kernel.exception.NoSuchModelException {
		return getService().findByPrimaryKey(primaryKey);
	}

	public static fr.smile.training.model.Faq findByPrimaryKey(long entryId)
		throws fr.smile.training.exception.NoSuchFaqException {
		return getService().findByPrimaryKey(entryId);
	}

	public static fr.smile.training.model.Faq findByUUID_G(
		java.lang.String uuid, long groupId)
		throws fr.smile.training.exception.NoSuchFaqException {
		return getService().findByUUID_G(uuid, groupId);
	}

	public static fr.smile.training.model.Faq findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator)
		throws fr.smile.training.exception.NoSuchFaqException {
		return getService()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	public static fr.smile.training.model.Faq findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator)
		throws fr.smile.training.exception.NoSuchFaqException {
		return getService().findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	public static fr.smile.training.model.Faq findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator)
		throws fr.smile.training.exception.NoSuchFaqException {
		return getService().findByUuid_First(uuid, orderByComparator);
	}

	public static fr.smile.training.model.Faq findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator)
		throws fr.smile.training.exception.NoSuchFaqException {
		return getService().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the faq with the primary key.
	*
	* @param entryId the primary key of the faq
	* @return the faq
	* @throws PortalException if a faq with the primary key could not be found
	*/
	public static fr.smile.training.model.Faq getFaq(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getFaq(entryId);
	}

	/**
	* Returns the faq matching the UUID and group.
	*
	* @param uuid the faq's UUID
	* @param groupId the primary key of the group
	* @return the matching faq
	* @throws PortalException if a matching faq could not be found
	*/
	public static fr.smile.training.model.Faq getFaqByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getFaqByUuidAndGroupId(uuid, groupId);
	}

	public static fr.smile.training.model.Faq remove(
		fr.smile.training.model.Faq model) {
		return getService().remove(model);
	}

	public static fr.smile.training.model.Faq remove(
		java.io.Serializable primaryKey)
		throws com.liferay.portal.kernel.exception.NoSuchModelException {
		return getService().remove(primaryKey);
	}

	public static fr.smile.training.model.Faq remove(long entryId)
		throws fr.smile.training.exception.NoSuchFaqException {
		return getService().remove(entryId);
	}

	public static fr.smile.training.model.Faq removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws fr.smile.training.exception.NoSuchFaqException {
		return getService().removeByUUID_G(uuid, groupId);
	}

	public static fr.smile.training.model.Faq update(
		fr.smile.training.model.Faq model) {
		return getService().update(model);
	}

	public static fr.smile.training.model.Faq update(
		fr.smile.training.model.Faq model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {
		return getService().update(model, serviceContext);
	}

	/**
	* Updates the faq in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faq the faq
	* @return the faq that was updated
	*/
	public static fr.smile.training.model.Faq updateFaq(
		fr.smile.training.model.Faq faq) {
		return getService().updateFaq(faq);
	}

	public static fr.smile.training.model.Faq updateImpl(
		fr.smile.training.model.Faq faq) {
		return getService().updateImpl(faq);
	}

	public static fr.smile.training.model.Faq[] findByUuid_C_PrevAndNext(
		long entryId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator)
		throws fr.smile.training.exception.NoSuchFaqException {
		return getService()
				   .findByUuid_C_PrevAndNext(entryId, uuid, companyId,
			orderByComparator);
	}

	public static fr.smile.training.model.Faq[] findByUuid_PrevAndNext(
		long entryId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator)
		throws fr.smile.training.exception.NoSuchFaqException {
		return getService()
				   .findByUuid_PrevAndNext(entryId, uuid, orderByComparator);
	}

	public static int countAll() {
		return getService().countAll();
	}

	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getService().countByUUID_G(uuid, groupId);
	}

	public static int countByUuid(java.lang.String uuid) {
		return getService().countByUuid(uuid);
	}

	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getService().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of faqs.
	*
	* @return the number of faqs
	*/
	public static int getFaqsCount() {
		return getService().getFaqsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<fr.smile.training.model.Faq> findAll() {
		return getService().findAll();
	}

	public static java.util.List<fr.smile.training.model.Faq> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<fr.smile.training.model.Faq> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static java.util.List<fr.smile.training.model.Faq> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator,
		boolean retrieveFromCache) {
		return getService()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	public static java.util.List<fr.smile.training.model.Faq> findByUuid(
		java.lang.String uuid) {
		return getService().findByUuid(uuid);
	}

	public static java.util.List<fr.smile.training.model.Faq> findByUuid(
		java.lang.String uuid, int start, int end) {
		return getService().findByUuid(uuid, start, end);
	}

	public static java.util.List<fr.smile.training.model.Faq> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator) {
		return getService().findByUuid(uuid, start, end, orderByComparator);
	}

	public static java.util.List<fr.smile.training.model.Faq> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator,
		boolean retrieveFromCache) {
		return getService()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	public static java.util.List<fr.smile.training.model.Faq> findByUuid_C(
		java.lang.String uuid, long companyId) {
		return getService().findByUuid_C(uuid, companyId);
	}

	public static java.util.List<fr.smile.training.model.Faq> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end) {
		return getService().findByUuid_C(uuid, companyId, start, end);
	}

	public static java.util.List<fr.smile.training.model.Faq> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator) {
		return getService()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	public static java.util.List<fr.smile.training.model.Faq> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator,
		boolean retrieveFromCache) {
		return getService()
				   .findByUuid_C(uuid, companyId, start, end,
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
	public static java.util.List<fr.smile.training.model.Faq> getFaqs(
		int start, int end) {
		return getService().getFaqs(start, end);
	}

	/**
	* Returns all the faqs matching the UUID and company.
	*
	* @param uuid the UUID of the faqs
	* @param companyId the primary key of the company
	* @return the matching faqs, or an empty list if no matches were found
	*/
	public static java.util.List<fr.smile.training.model.Faq> getFaqsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getFaqsByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<fr.smile.training.model.Faq> getFaqsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<fr.smile.training.model.Faq> orderByComparator) {
		return getService()
				   .getFaqsByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	public static java.util.Map<java.io.Serializable, fr.smile.training.model.Faq> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getService().fetchByPrimaryKeys(primaryKeys);
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getService().getBadColumnNames();
	}

	public static javax.sql.DataSource getDataSource() {
		return getService().getDataSource();
	}

	public static long countWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().countWithDynamicQuery(dynamicQuery);
	}

	public static long countWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().countWithDynamicQuery(dynamicQuery, projection);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static void addFaq(long companyId, long groupId,
		java.lang.String question, java.lang.String answer) {
		getService().addFaq(companyId, groupId, question, answer);
	}

	public static void cacheResult(fr.smile.training.model.Faq faq) {
		getService().cacheResult(faq);
	}

	public static void cacheResult(
		java.util.List<fr.smile.training.model.Faq> faqs) {
		getService().cacheResult(faqs);
	}

	public static void clearCache() {
		getService().clearCache();
	}

	public static void clearCache(fr.smile.training.model.Faq model) {
		getService().clearCache(model);
	}

	public static void clearCache(
		java.util.List<fr.smile.training.model.Faq> modelList) {
		getService().clearCache(modelList);
	}

	public static void closeSession(
		com.liferay.portal.kernel.dao.orm.Session session) {
		getService().closeSession(session);
	}

	public static void flush() {
		getService().flush();
	}

	public static void registerListener(
		com.liferay.portal.kernel.model.ModelListener<fr.smile.training.model.Faq> listener) {
		getService().registerListener(listener);
	}

	public static void removeAll() {
		getService().removeAll();
	}

	public static void removeByUuid(java.lang.String uuid) {
		getService().removeByUuid(uuid);
	}

	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getService().removeByUuid_C(uuid, companyId);
	}

	public static void setDataSource(javax.sql.DataSource dataSource) {
		getService().setDataSource(dataSource);
	}

	public static void unregisterListener(
		com.liferay.portal.kernel.model.ModelListener<fr.smile.training.model.Faq> listener) {
		getService().unregisterListener(listener);
	}

	public static FaqLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FaqLocalService, FaqLocalService> _serviceTracker =
		ServiceTrackerFactory.open(FaqLocalService.class);
}