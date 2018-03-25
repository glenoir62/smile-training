package fr.smile.training.faq.web.portlet.action;

import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import fr.smile.training.faq.web.constants.FaqTrainingPortletKeys;
import fr.smile.training.faq.web.util.FaqUtil;
import fr.smile.training.faq.web.validator.FaqValidator;
import fr.smile.training.model.Faq;
import fr.smile.training.service.FaqLocalServiceUtil;


@Component(service = MVCActionCommand.class, property = { "javax.portlet.name=" + FaqTrainingPortletKeys.FaqTraining,
		"mvc.command.name=/faq/add_faq" })
public class FAQAddActionCommand implements MVCActionCommand {

	/**
	 * The Logger
	 */
	private static Log LOGGER = LogFactoryUtil.getLog(FAQAddActionCommand.class);



	/**
	 * @param actionRequest
	 * @param actionResponse
	 * @return
	 * @throws PortletException
	 */
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		Faq faq = FaqUtil.faqFromRequest(actionRequest);
		String successMessageKey = faq.isNew() ? "faq-added" : "faq-updated";

		LOGGER.info("successMessageKey " + successMessageKey);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			ArrayList<String> errors = new ArrayList<String>();
		
			if (FaqValidator.validateFaq(faq, errors, themeDisplay.getLocale())) {
				FaqLocalServiceUtil.addFaq(faq.getCompanyId(), faq.getGroupId(), faq.getQuestion(), faq.getAnswer());
				SessionMessages.add(actionRequest, successMessageKey);
				
			} else {
				for (String error : errors) {
					SessionErrors.add(actionRequest, error);
				}
				
			}
		} catch (SystemException se) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(se);
			}
			LOGGER.error("SystemException : impossible to add Faq");
		}
		
		return true;
	}

}
