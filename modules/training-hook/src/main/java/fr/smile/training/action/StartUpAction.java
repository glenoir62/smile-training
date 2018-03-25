package fr.smile.training.action;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@Component(
		immediate = true, property = {
			"key=global.startup.events"
		}, service = LifecycleAction.class
)
public class StartUpAction implements LifecycleAction {
	private static final Log LOGGER = LogFactoryUtil.getLog(LogUserLoginAction.class);
	
	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		LOGGER.info("start up");

	}

}
