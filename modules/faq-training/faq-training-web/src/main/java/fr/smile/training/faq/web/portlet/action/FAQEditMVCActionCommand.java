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
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import fr.smile.training.faq.web.constants.FaqTrainingPortletKeys;
import fr.smile.training.faq.web.util.FaqUtil;
import fr.smile.training.faq.web.validator.FaqValidator;
import fr.smile.training.model.Faq;
import fr.smile.training.service.FaqLocalServiceUtil;

@Component(service = MVCActionCommand.class,
		property = {
				"javax.portlet.name=" + FaqTrainingPortletKeys.FaqTraining,
				"mvc.command.name=/faq/edit_faq"
				
		})
public class FAQEditMVCActionCommand implements MVCActionCommand {

	/**
	 * 
	 */
	private static Log LOGGER = LogFactoryUtil.getLog(FAQEditMVCActionCommand.class);


	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		LOGGER.info("Edit faq");
		Faq faq = FaqUtil.faqFromRequest(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			ArrayList<String> errors = new ArrayList<String>();

			if (FaqValidator.validateFaq(faq, errors, themeDisplay.getLocale())) {
				FaqLocalServiceUtil.updateFaq(faq);
				SessionMessages.add(actionRequest, "faq-updated");
			} else {
				for (String error : errors) {
					SessionErrors.add(actionRequest, error);
				}

				PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			}

		} catch (SystemException se) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(se);
			}
			if (Validator.isNotNull(faq)) {
				LOGGER.error("SystemException : impossible to update faq for " + faq.getEntryId());
			}
		}
		return false;
	}
}
