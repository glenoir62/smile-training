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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import fr.smile.training.exception.NoSuchFaqException;
import fr.smile.training.model.Faq;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

/**
 * Provides the local service interface for Faq. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Guillaume Lenoir
 * @see FaqLocalServiceUtil
 * @see fr.smile.training.service.base.FaqLocalServiceBaseImpl
 * @see fr.smile.training.service.impl.FaqLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface FaqLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FaqLocalServiceUtil} to access the faq local service. Add custom service methods to {@link fr.smile.training.service.impl.FaqLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Session getCurrentSession() throws ORMException;

	public Session openSession() throws ORMException;

	public SystemException processException(java.lang.Exception e);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ModelListener<Faq>[] getListeners();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Adds the faq to the database. Also notifies the appropriate model listeners.
	*
	* @param faq the faq
	* @return the faq that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Faq addFaq(Faq faq);

	public Faq create(long entryId);

	/**
	* Creates a new faq with the primary key. Does not add the faq to the database.
	*
	* @param entryId the primary key for the new faq
	* @return the new faq
	*/
	public Faq createFaq(long entryId);

	/**
	* Deletes the faq from the database. Also notifies the appropriate model listeners.
	*
	* @param faq the faq
	* @return the faq that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Faq deleteFaq(Faq faq);

	/**
	* Deletes the faq with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the faq
	* @return the faq that was removed
	* @throws PortalException if a faq with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Faq deleteFaq(long entryId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Faq fetchByPrimaryKey(Serializable primaryKey);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Faq fetchByPrimaryKey(long entryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Faq fetchByUUID_G(java.lang.String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Faq fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Faq fetchByUuid_C_First(java.lang.String uuid, long companyId,
		OrderByComparator<Faq> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Faq fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		OrderByComparator<Faq> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Faq fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Faq> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Faq fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Faq> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Faq fetchFaq(long entryId);

	/**
	* Returns the faq matching the UUID and group.
	*
	* @param uuid the faq's UUID
	* @param groupId the primary key of the group
	* @return the matching faq, or <code>null</code> if a matching faq could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Faq fetchFaqByUuidAndGroupId(java.lang.String uuid, long groupId);

	public Faq findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException;

	public Faq findByPrimaryKey(long entryId) throws NoSuchFaqException;

	public Faq findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchFaqException;

	public Faq findByUuid_C_First(java.lang.String uuid, long companyId,
		OrderByComparator<Faq> orderByComparator) throws NoSuchFaqException;

	public Faq findByUuid_C_Last(java.lang.String uuid, long companyId,
		OrderByComparator<Faq> orderByComparator) throws NoSuchFaqException;

	public Faq findByUuid_First(java.lang.String uuid,
		OrderByComparator<Faq> orderByComparator) throws NoSuchFaqException;

	public Faq findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Faq> orderByComparator) throws NoSuchFaqException;

	/**
	* Returns the faq with the primary key.
	*
	* @param entryId the primary key of the faq
	* @return the faq
	* @throws PortalException if a faq with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Faq getFaq(long entryId) throws PortalException;

	/**
	* Returns the faq matching the UUID and group.
	*
	* @param uuid the faq's UUID
	* @param groupId the primary key of the group
	* @return the matching faq
	* @throws PortalException if a matching faq could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Faq getFaqByUuidAndGroupId(java.lang.String uuid, long groupId)
		throws PortalException;

	public Faq remove(Faq model);

	public Faq remove(Serializable primaryKey) throws NoSuchModelException;

	public Faq remove(long entryId) throws NoSuchFaqException;

	public Faq removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchFaqException;

	public Faq update(Faq model);

	public Faq update(Faq model, ServiceContext serviceContext);

	/**
	* Updates the faq in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faq the faq
	* @return the faq that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Faq updateFaq(Faq faq);

	public Faq updateImpl(Faq faq);

	public Faq[] findByUuid_C_PrevAndNext(long entryId, java.lang.String uuid,
		long companyId, OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	public Faq[] findByUuid_PrevAndNext(long entryId, java.lang.String uuid,
		OrderByComparator<Faq> orderByComparator) throws NoSuchFaqException;

	public int countAll();

	public int countByUUID_G(java.lang.String uuid, long groupId);

	public int countByUuid(java.lang.String uuid);

	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of faqs.
	*
	* @return the number of faqs
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getFaqsCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	public List<Faq> findAll();

	public List<Faq> findAll(int start, int end);

	public List<Faq> findAll(int start, int end,
		OrderByComparator<Faq> orderByComparator);

	public List<Faq> findAll(int start, int end,
		OrderByComparator<Faq> orderByComparator, boolean retrieveFromCache);

	public List<Faq> findByUuid(java.lang.String uuid);

	public List<Faq> findByUuid(java.lang.String uuid, int start, int end);

	public List<Faq> findByUuid(java.lang.String uuid, int start, int end,
		OrderByComparator<Faq> orderByComparator);

	public List<Faq> findByUuid(java.lang.String uuid, int start, int end,
		OrderByComparator<Faq> orderByComparator, boolean retrieveFromCache);

	public List<Faq> findByUuid_C(java.lang.String uuid, long companyId);

	public List<Faq> findByUuid_C(java.lang.String uuid, long companyId,
		int start, int end);

	public List<Faq> findByUuid_C(java.lang.String uuid, long companyId,
		int start, int end, OrderByComparator<Faq> orderByComparator);

	public List<Faq> findByUuid_C(java.lang.String uuid, long companyId,
		int start, int end, OrderByComparator<Faq> orderByComparator,
		boolean retrieveFromCache);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Faq> getFaqs(int start, int end);

	/**
	* Returns all the faqs matching the UUID and company.
	*
	* @param uuid the UUID of the faqs
	* @param companyId the primary key of the company
	* @return the matching faqs, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Faq> getFaqsByUuidAndCompanyId(java.lang.String uuid,
		long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Faq> getFaqsByUuidAndCompanyId(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Faq> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<Serializable, Faq> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Set<java.lang.String> getBadColumnNames();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataSource getDataSource();

	public long countWithDynamicQuery(DynamicQuery dynamicQuery);

	public long countWithDynamicQuery(DynamicQuery dynamicQuery,
		Projection projection);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	public void addFaq(long companyId, long groupId, java.lang.String question,
		java.lang.String answer);

	public void cacheResult(Faq faq);

	public void cacheResult(List<Faq> faqs);

	public void clearCache();

	public void clearCache(Faq model);

	public void clearCache(List<Faq> modelList);

	public void closeSession(Session session);

	public void flush();

	public void registerListener(ModelListener<Faq> listener);

	public void removeAll();

	public void removeByUuid(java.lang.String uuid);

	public void removeByUuid_C(java.lang.String uuid, long companyId);

	public void setDataSource(DataSource dataSource);

	public void unregisterListener(ModelListener<Faq> listener);
}