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
package fr.smile.training.web.advanced.ws;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author guillaumelenoir
 *
 */
@Component(
	immediate = true,
	property = {
        "jaxrs.application=true"
    },
    service = Application.class
)
@Path("/myws")
/*
 * http://localhost:8080/o/rest-test/myws/list
 * 
 * https://dev.liferay.com/fr/develop/tutorials/-/knowledge_base/7-0/jax-ws-and-jax-rs
 * 
 * To configure a REST extender with the Control Panel, first go to Control Panel → Configuration → System Settings → Foundation.
 * Then select CXF Endpoint from the table. If there are any existing REST extenders, they’re shown here. To add a new one, select the Add button (icon-add.png)
 *  in the lower right-hand corner. The form that appears lets you configure a new REST extender by filling out these fields:
 * */
public class AdvanceWs extends Application {

	@Override
	public Set<Object> getSingletons() {
		return Collections.<Object> singleton(this);
	}

	@GET
	@Path("/list")
	@Produces("text/plain")
	public String getUsers() {
		StringBuilder result = new StringBuilder();

		System.out.println("test");
		
		for (User user : _userLocalService.getUsers(-1, -1)) {
			result.append(user.getFullName()).append(",\n");
		}

		return result.toString();
	}

	@Reference
	public void setUserLocalService(UserLocalService userLocalService) {
		this._userLocalService = userLocalService;
	}

	private UserLocalService _userLocalService;
}