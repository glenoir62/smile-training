package fr.smile.training.action;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;

@Component(immediate = true, property = { "key=login.events.post" }, service = LifecycleAction.class)
public class LogUserLoginAction implements LifecycleAction {

	/**
	 * 
	 */
	private static final Log LOGGER = LogFactoryUtil.getLog(LogUserLoginAction.class);

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {

		User user = null;
		try {
			// Get user
			user = PortalUtil.getUser(lifecycleEvent.getRequest());
			LOGGER.info("LogUserLoginAction = " + user);
		} catch (PortalException e) {
			LOGGER.error("Error : unable to get user after login ");
		}

	}

}
