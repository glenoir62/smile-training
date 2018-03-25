package fr.smile.training.faq.web.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import fr.smile.training.faq.web.constants.FaqTrainingPortletKeys;
import fr.smile.training.service.FaqLocalServiceUtil;

@Component(
	    property = {
	        "javax.portlet.name=" + FaqTrainingPortletKeys.FaqTraining,
	        "mvc.command.name=/faq/delete_faq"
	    },
	    service = MVCActionCommand.class
	)
public class DeleteFaqMVCActionCommand implements MVCActionCommand {

	private static Log LOGGER = LogFactoryUtil.getLog(DeleteFaqMVCActionCommand.class);

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		LOGGER.info("Delete Faq");
		long faqId = ParamUtil.getLong(actionRequest, "faqId");
		LOGGER.info("Faq ID : "+faqId);

		try {
			FaqLocalServiceUtil.deleteFaq(faqId);
			SessionMessages.add(actionRequest, "faq-deleted");
		}
		catch (SystemException | PortalException se) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(se);
			}
	
			SessionErrors.add(actionRequest, se.getMessage());
			SessionErrors.add(actionRequest, "no-faq-deleted");
		}
		return true;
	}
	
	
}
