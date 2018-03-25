package fr.smile.training.web.portlet.action;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(service = MVCRenderCommand.class, property = {
		"javax.portlet.name=fr_smile_training_web_advanced_portlet_AdvancedPortlet",
		"mvc.command.name=Next" })
public class NextPageRenderCommand implements MVCRenderCommand {
	private Log _log = LogFactoryUtil.getLog(NextPageRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_log.info("render next");
		return "/next.jsp";
	}
}
