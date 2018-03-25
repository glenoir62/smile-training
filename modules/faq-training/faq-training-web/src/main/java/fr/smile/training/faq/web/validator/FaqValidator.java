package fr.smile.training.faq.web.validator;

import java.util.List;
import java.util.Locale;

import com.liferay.portal.kernel.util.Validator;

import fr.smile.training.model.Faq;

public class FaqValidator {

	/**
	 * Validate Faq
	 * 
	 * @param faq
	 * @param errors
	 * @return valid
	 */
	public static boolean validateFaq(Faq faq, List<String> errors, Locale locale) {

		boolean valid = true;

		if (Validator.isNull(faq)) {
			errors.add("faq-errors");
			valid = false;
		}

		if (Validator.isBlank(faq.getAnswer())) {
			errors.add("faq-answer-required");
			valid = false;
		}
		if (Validator.isBlank(faq.getQuestion())) {
			errors.add("faq-question-required");
			valid = false;
		}

		return valid;
	}
}
