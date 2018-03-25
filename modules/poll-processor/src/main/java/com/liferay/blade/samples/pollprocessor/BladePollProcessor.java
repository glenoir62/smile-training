/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liferay.blade.samples.pollprocessor;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.poller.BasePollerProcessor;
import com.liferay.portal.kernel.poller.DefaultPollerResponse;
import com.liferay.portal.kernel.poller.PollerProcessor;
import com.liferay.portal.kernel.poller.PollerRequest;
import com.liferay.portal.kernel.poller.PollerResponse;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Liferay
 */
@Component(
	immediate = true,
	property = {"javax.portlet.name=blade_portlet_BladePollProcessorPortlet"},
	service = PollerProcessor.class
)
public class BladePollProcessor extends BasePollerProcessor {

	@Override
	protected PollerResponse doReceive(PollerRequest pollerRequest)
		throws Exception {

		if (_log.isDebugEnabled()) {
			_log.debug("Recevied the poller request" + pollerRequest);
		}

		JSONObject responseObject = JSONFactoryUtil.createJSONObject();
		PollerResponse pollerResponse = new DefaultPollerResponse();
		responseObject.put(
			"message", "Hello from BLADE Poller, time now is:" + new Date());
		pollerResponse.setParameter("content", responseObject);

		return pollerResponse;
	}

	@Override
	protected void doSend(PollerRequest pollerRequest) throws Exception {
		String status = getString(pollerRequest, "status");

		if (_log.isInfoEnabled()) {
			_log.info("Poller status:" + status);
		}
	}

	private final Log _log = LogFactoryUtil.getLog(BladePollProcessor.class);

}