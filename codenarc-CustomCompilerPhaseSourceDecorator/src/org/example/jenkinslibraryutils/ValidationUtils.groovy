package org.example.jenkinslibraryutils

import org.apache.commons.lang.StringUtils

class ValidationUtils {

	static <T> T requireNonBlank(CharSequence name, T obj) {
		def text = obj as String

		if (StringUtils.isNotBlank(text)) {
			return obj
		}

		def valueType
		if (text == null) {
			valueType = 'null'
		} else if (text == '') {
			valueType = 'empty string'
		} else {
			valueType = 'text with only whitespace characters'
		}
		error "${name} cannot be blank! Its value: ${valueType}"
	}
}
