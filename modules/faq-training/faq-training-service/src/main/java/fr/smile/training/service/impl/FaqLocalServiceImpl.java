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

package fr.smile.training.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import fr.smile.training.exception.NoSuchFaqException;
import fr.smile.training.model.Faq;
import fr.smile.training.service.base.FaqLocalServiceBaseImpl;
import fr.smile.training.service.persistence.FaqPersistence;

/**
 * The implementation of the faq local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link fr.smile.training.service.FaqLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see FaqLocalServiceBaseImpl
 * @see fr.smile.training.service.FaqLocalServiceUtil
 */
public class FaqLocalServiceImpl extends FaqLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * fr.smile.training.service.FaqLocalServiceUtil} to access the faq local
	 * service.
	 */


	
	public List<Faq> findByUuid(String uuid) {
		return faqPersistence.findByUuid(uuid);
	}



	public List<Faq> findByUuid(String uuid, int start, int end) {
		return faqPersistence.findByUuid(uuid, start, end);
	}



	public void clearCache() {
		faqPersistence.clearCache();
	}



	public void clearCache(List<Faq> modelList) {
		faqPersistence.clearCache(modelList);
	}



	public void clearCache(Faq model) {
		faqPersistence.clearCache(model);
	}



	public void closeSession(Session session) {
		faqPersistence.closeSession(session);
	}



	public long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return faqPersistence.countWithDynamicQuery(dynamicQuery);
	}



	public List<Faq> findByUuid(String uuid, int start, int end, OrderByComparator<Faq> orderByComparator) {
		return faqPersistence.findByUuid(uuid, start, end, orderByComparator);
	}



	public long countWithDynamicQuery(DynamicQuery dynamicQuery, Projection projection) {
		return faqPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}



	public Faq fetchByPrimaryKey(Serializable primaryKey) {
		return faqPersistence.fetchByPrimaryKey(primaryKey);
	}



	public Faq findByPrimaryKey(Serializable primaryKey) throws NoSuchModelException {
		return faqPersistence.findByPrimaryKey(primaryKey);
	}



	public List<Faq> findByUuid(String uuid, int start, int end, OrderByComparator<Faq> orderByComparator,
			boolean retrieveFromCache) {
		return faqPersistence.findByUuid(uuid, start, end, orderByComparator, retrieveFromCache);
	}






	public Faq findByUuid_First(String uuid, OrderByComparator<Faq> orderByComparator) throws NoSuchFaqException {
		return faqPersistence.findByUuid_First(uuid, orderByComparator);
	}



	public Faq fetchByUuid_First(String uuid, OrderByComparator<Faq> orderByComparator) {
		return faqPersistence.fetchByUuid_First(uuid, orderByComparator);
	}



	public void flush() {
		faqPersistence.flush();
	}



	public Session getCurrentSession() throws ORMException {
		return faqPersistence.getCurrentSession();
	}



	public DataSource getDataSource() {
		return faqPersistence.getDataSource();
	}



	public ModelListener<Faq>[] getListeners() {
		return faqPersistence.getListeners();
	}



	public Faq findByUuid_Last(String uuid, OrderByComparator<Faq> orderByComparator) throws NoSuchFaqException {
		return faqPersistence.findByUuid_Last(uuid, orderByComparator);
	}

	public Session openSession() throws ORMException {
		return faqPersistence.openSession();
	}

	public SystemException processException(Exception e) {
		return faqPersistence.processException(e);
	}

	public void registerListener(ModelListener<Faq> listener) {
		faqPersistence.registerListener(listener);
	}

	public Faq fetchByUuid_Last(String uuid, OrderByComparator<Faq> orderByComparator) {
		return faqPersistence.fetchByUuid_Last(uuid, orderByComparator);
	}

	public Faq remove(Serializable primaryKey) throws NoSuchModelException {
		return faqPersistence.remove(primaryKey);
	}



	public Faq[] findByUuid_PrevAndNext(long entryId, String uuid, OrderByComparator<Faq> orderByComparator)
			throws NoSuchFaqException {
		return faqPersistence.findByUuid_PrevAndNext(entryId, uuid, orderByComparator);
	}



	public Faq remove(Faq model) {
		return faqPersistence.remove(model);
	}



	public void setDataSource(DataSource dataSource) {
		faqPersistence.setDataSource(dataSource);
	}



	public void unregisterListener(ModelListener<Faq> listener) {
		faqPersistence.unregisterListener(listener);
	}



	public void removeByUuid(String uuid) {
		faqPersistence.removeByUuid(uuid);
	}



	public Faq update(Faq model) {
		return faqPersistence.update(model);
	}



	public int countByUuid(String uuid) {
		return faqPersistence.countByUuid(uuid);
	}



	public Faq findByUUID_G(String uuid, long groupId) throws NoSuchFaqException {
		return faqPersistence.findByUUID_G(uuid, groupId);
	}



	public Faq update(Faq model, ServiceContext serviceContext) {
		return faqPersistence.update(model, serviceContext);
	}



	public Faq fetchByUUID_G(String uuid, long groupId) {
		return faqPersistence.fetchByUUID_G(uuid, groupId);
	}



	public Faq fetchByUUID_G(String uuid, long groupId, boolean retrieveFromCache) {
		return faqPersistence.fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}



	public Faq removeByUUID_G(String uuid, long groupId) throws NoSuchFaqException {
		return faqPersistence.removeByUUID_G(uuid, groupId);
	}



	public int countByUUID_G(String uuid, long groupId) {
		return faqPersistence.countByUUID_G(uuid, groupId);
	}



	public List<Faq> findByUuid_C(String uuid, long companyId) {
		return faqPersistence.findByUuid_C(uuid, companyId);
	}



	public List<Faq> findByUuid_C(String uuid, long companyId, int start, int end) {
		return faqPersistence.findByUuid_C(uuid, companyId, start, end);
	}



	public List<Faq> findByUuid_C(String uuid, long companyId, int start, int end,
			OrderByComparator<Faq> orderByComparator) {
		return faqPersistence.findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}



	public List<Faq> findByUuid_C(String uuid, long companyId, int start, int end,
			OrderByComparator<Faq> orderByComparator, boolean retrieveFromCache) {
		return faqPersistence.findByUuid_C(uuid, companyId, start, end, orderByComparator, retrieveFromCache);
	}



	public Faq findByUuid_C_First(String uuid, long companyId, OrderByComparator<Faq> orderByComparator)
			throws NoSuchFaqException {
		return faqPersistence.findByUuid_C_First(uuid, companyId, orderByComparator);
	}



	public Faq fetchByUuid_C_First(String uuid, long companyId, OrderByComparator<Faq> orderByComparator) {
		return faqPersistence.fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}



	public Faq findByUuid_C_Last(String uuid, long companyId, OrderByComparator<Faq> orderByComparator)
			throws NoSuchFaqException {
		return faqPersistence.findByUuid_C_Last(uuid, companyId, orderByComparator);
	}



	public Faq fetchByUuid_C_Last(String uuid, long companyId, OrderByComparator<Faq> orderByComparator) {
		return faqPersistence.fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}



	public Faq[] findByUuid_C_PrevAndNext(long entryId, String uuid, long companyId,
			OrderByComparator<Faq> orderByComparator) throws NoSuchFaqException {
		return faqPersistence.findByUuid_C_PrevAndNext(entryId, uuid, companyId, orderByComparator);
	}



	public void removeByUuid_C(String uuid, long companyId) {
		faqPersistence.removeByUuid_C(uuid, companyId);
	}



	public int countByUuid_C(String uuid, long companyId) {
		return faqPersistence.countByUuid_C(uuid, companyId);
	}



	public void cacheResult(Faq faq) {
		faqPersistence.cacheResult(faq);
	}



	public void cacheResult(List<Faq> faqs) {
		faqPersistence.cacheResult(faqs);
	}



	public Faq create(long entryId) {
		return faqPersistence.create(entryId);
	}



	public Faq remove(long entryId) throws NoSuchFaqException {
		return faqPersistence.remove(entryId);
	}



	public Faq updateImpl(Faq faq) {
		return faqPersistence.updateImpl(faq);
	}



	public Faq findByPrimaryKey(long entryId) throws NoSuchFaqException {
		return faqPersistence.findByPrimaryKey(entryId);
	}



	public Faq fetchByPrimaryKey(long entryId) {
		return faqPersistence.fetchByPrimaryKey(entryId);
	}



	public Map<Serializable, Faq> fetchByPrimaryKeys(Set<Serializable> primaryKeys) {
		return faqPersistence.fetchByPrimaryKeys(primaryKeys);
	}



	public List<Faq> findAll() {
		return faqPersistence.findAll();
	}



	public List<Faq> findAll(int start, int end) {
		return faqPersistence.findAll(start, end);
	}



	public List<Faq> findAll(int start, int end, OrderByComparator<Faq> orderByComparator) {
		return faqPersistence.findAll(start, end, orderByComparator);
	}



	public List<Faq> findAll(int start, int end, OrderByComparator<Faq> orderByComparator, boolean retrieveFromCache) {
		return faqPersistence.findAll(start, end, orderByComparator, retrieveFromCache);
	}



	public void removeAll() {
		faqPersistence.removeAll();
	}



	public int countAll() {
		return faqPersistence.countAll();
	}



	public Set<String> getBadColumnNames() {
		return faqPersistence.getBadColumnNames();
	}



	public void addFaq(long companyId, long groupId, String question, String answer) {

		long entryId = counterLocalService.increment();

		Faq faq = faqPersistence.create(entryId);
		faq.setGroupId(groupId);
		faq.setCompanyId(companyId);
		faq.setAnswer(answer);
		faq.setQuestion(question);
		faqPersistence.update(faq);

	}
}