package fr.smile.training.faq.web.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import fr.smile.training.faq.web.constants.FaqTrainingPortletKeys;
import fr.smile.training.model.Faq;
import fr.smile.training.service.FaqLocalServiceUtil;

/**
 * @author guillaumelenoir
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=faq-training-web Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FaqTrainingPortletKeys.FaqTraining,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FaqTrainingPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		SearchContainer<Faq> searchContainer = new SearchContainer<Faq>(renderRequest, renderResponse.createRenderURL(), null, "empty-results-faq");
		
		List<Faq> results = null;
		int total = 0;
		
		try {
			results = FaqLocalServiceUtil.getFaqs(searchContainer.getStart(), searchContainer.getEnd());
			total = FaqLocalServiceUtil.getFaqsCount();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		searchContainer.setResults(results);
		searchContainer.setTotal(total);
		
		renderRequest.setAttribute("faqSearchContainer", searchContainer);
		
		
		super.doView(renderRequest, renderResponse);
	}
}