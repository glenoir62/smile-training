package fr.smile.training.faq.web.portlet.action;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import fr.smile.training.faq.web.constants.FaqTrainingPortletKeys;
import fr.smile.training.model.Faq;
import fr.smile.training.service.FaqLocalServiceUtil;

@Component(service = MVCRenderCommand.class, property = { "javax.portlet.name=" + FaqTrainingPortletKeys.FaqTraining,
		"mvc.command.name=/faq/edit" })
public class FAQEditRenderCommand implements MVCRenderCommand {
	private Log LOGGER = LogFactoryUtil.getLog(FAQEditRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		String redirect = ParamUtil.getString(renderRequest, "redirect");

		long FaqId = ParamUtil.getLong(renderRequest, "faqId");

		Faq Faq = null;

		if (FaqId > 0) {
			try {
				Faq = FaqLocalServiceUtil.getFaq(FaqId);
			} catch (PortalException e) {
				LOGGER.error(Faq);
			}
		}
		String title = Faq != null ? Faq.getQuestion() : "new-Faq";
		String faqTitle = Faq != null ? "updateFaq" : "addFaq";

		renderRequest.setAttribute("redirect", redirect);
		renderRequest.setAttribute("faq", Faq);
		renderRequest.setAttribute("title", title);
		renderRequest.setAttribute("faqTitle", faqTitle);
		return "/edit.jsp";
	}
}
