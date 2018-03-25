package fr.smile.training.faq.web.util;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import fr.smile.training.model.Faq;
import fr.smile.training.service.FaqLocalServiceUtil;

public class FaqUtil {
	
	private static Log LOGGER = LogFactoryUtil.getLog(FaqUtil.class);

	/**
	 * @param request
	 * @return
	 */
	public static Faq faqFromRequest(ActionRequest request) {

		
		Faq faq = null;
		long faqId = ParamUtil.getLong(request, "faqId");
		String answer = ParamUtil.getString(request, "answer");
		String question = ParamUtil.getString(request, "question");

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		if (Validator.isNotNull(faqId)) {
			try {
				faq = FaqLocalServiceUtil.getFaq(faqId);
			} catch (PortalException pe) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(pe);
				}
				LOGGER.error("PortalException : impossible to get Faq for id " + faqId);
			} catch (SystemException se) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(se);
				}
				LOGGER.error("PortalException : impossible to get Faq for id " + faqId);
			}
		} else {
			faq = FaqLocalServiceUtil.createFaq(faqId);
		}

		faq.setAnswer(answer);
		faq.setGroupId(themeDisplay.getScopeGroupId());
		faq.setCompanyId(themeDisplay.getCompanyId());
		faq.setQuestion(question);

		return faq;
	}
}
