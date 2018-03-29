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
package fr.smile.training.web.portlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

/**
 * @author guillaumelenoir
 *
 */
@Component(immediate = true, property = { "com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.css-class-wrapper=advanced-formation-web",
		"com.liferay.portlet.display-category=category.sample", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=advanced-formation-web Portlet", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.init-param.config-template=/configure.jsp",
		"com.liferay.portlet.use-default-template=true", "javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.name=fr_smile_training_web_advanced_portlet_AdvancedPortlet",
		"javax.portlet.init-param.always-display-default-configuration-icons=true", }, service = Portlet.class)
public class AdvancedWebPortlet extends MVCPortlet {


}