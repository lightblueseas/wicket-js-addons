/**
 * Copyright (C) 2010 Asterios Raptis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.alpharogroup.wicket.js.addon.core;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

import org.apache.wicket.util.lang.Args;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for javascript generation for the
 * {@link de.alpharogroup.wicket.js.addon.core.StringTextTemplate}.
 *
 * @param <S>
 *            the generic type of the Settings object
 */
@Getter
@Setter
public class JavascriptGenerator<S extends Settings> implements Serializable
{

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant COMPONENT_ID. */
	public static final String COMPONENT_ID = "componentId";

	/** The Constant DOCUMENT_READY_FUNCTION_PREFIX. */
	public static final String DOCUMENT_READY_FUNCTION_PREFIX = "$(document).ready(function() {";

	/** The Constant DOCUMENT_READY_FUNCTION_SUFFIX. */
	public static final String DOCUMENT_READY_FUNCTION_SUFFIX = "})";

	/** The LOGGER. */
	protected static final Logger LOGGER = LoggerFactory.getLogger(JavascriptGenerator.class
		.getName());

	/** The component id. */
	private String componentId;

	/** The with component id flag. */
	private boolean withComponentId;

	/** The method name. */
	private String methodName;

	/** The settings. */
	private S settings;

	/** The with document ready function flag. */
	private boolean withDocumentReadyFunction;

	/**
	 * Instantiates a new javascript generator.
	 *
	 * @param settings
	 *            the settings
	 */
	public JavascriptGenerator(S settings)
	{
		this.settings = Args.notNull(settings, "settings");
	}

	/**
	 * Generate js.
	 *
	 * @return the string
	 */
	public String generateJs()
	{
		return generateJs(getSettings(), getMethodName());
	}

	/**
	 * Generate the javascript code.
	 *
	 * @param settings
	 *            the settings
	 * @param methodName
	 *            the method name
	 * @return the string
	 */
	public String generateJs(final Settings settings, final String methodName)
	{
		// 1. Create an empty map...
		final Map<String, Object> variables = initializeVariables(settings.asSet());
		// 4. Generate the js template with the map and the method name...
		String stringTemplateContent = generateJavascriptTemplateContent(variables, methodName);
		// 5. Create the StringTextTemplate with the generated template...
		StringTextTemplate stringTextTemplate = new StringTextTemplate(stringTemplateContent);
		// 6. Interpolate the template with the values of the map...
		stringTextTemplate.interpolate(variables);
		try
		{
			// 7. return it as String...
			return stringTextTemplate.asString();
		}
		finally
		{
			try
			{
				stringTextTemplate.close();
			}
			catch (IOException e)
			{
				LOGGER.error(e.getMessage(), e);
			}
		}
	}

	/**
	 * Generates the javascript template code from the given map and the given method name that will
	 * be used to interpolate with the values of the given map.
	 *
	 * @param variables
	 *            the map with the javascript options.
	 * @param methodName
	 *            The method name.
	 * @return The generated javascript from the given map and the given method name.
	 */
	protected String generateJavascriptTemplateContent(final Map<String, Object> variables,
		String methodName)
	{
		StringBuilder sb = new StringBuilder();

		if(isWithDocumentReadyFunction()) {
			sb.append(DOCUMENT_READY_FUNCTION_PREFIX).append("\n");			
		}
		if(isWithComponentId()) {
			sb.append("$('#${")
			.append(COMPONENT_ID).append("}')").append(".");
		} else {
			sb.append("$.");
		}
		sb.append(methodName).append("(");
		if(isWithComponentId()) {
			if (1 < variables.size())
			{
				generateJsOptionsForTemplateContent(variables, sb);
			}			
		} else {
			if (0 < variables.size())
			{
				generateJsOptionsForTemplateContent(variables, sb);
			}
		}
		sb.append(");").append("\n");
		if(isWithDocumentReadyFunction()) {
			sb.append(DOCUMENT_READY_FUNCTION_SUFFIX);			
		}
		return sb.toString();
	}

	/**
	 * Generate the javascript options for template content.
	 *
	 * @param variables 
	 *            the map with the javascript options.
	 * @param sb the {@link StringBuilder} to add the javascript options. 
	 */
	protected void generateJsOptionsForTemplateContent(final Map<String, Object> variables,
		StringBuilder sb)
	{
		sb.append("{\n");
		int count = 1;
		Object localComponentId = null;
		if (withComponentId)
		{
			localComponentId = variables.get(COMPONENT_ID);
			variables.remove(COMPONENT_ID);
		}
		for (Map.Entry<String, Object> entry : variables.entrySet())
		{
			String key = entry.getKey();
			sb.append(key).append(": ${").append(key).append("}");
			if (count < variables.size())
			{
				sb.append(",\n");
			}
			else
			{
				sb.append("\n");
			}
			count++;
		}
		if (withComponentId)
		{
			variables.put(COMPONENT_ID, localComponentId);
		}
		sb.append("}");
	}

	/**
	 * Sets the values to the map. If the default value is set than it will not be added to the map
	 * for later not to generate js for it.
	 *
	 * @param allSettings
	 *            All settings as a list of StringTextValue(s).
	 * @return the map
	 */
	protected Map<String, Object> initializeVariables(final Set<StringTextValue<?>> allSettings)
	{
		final Map<String, Object> variables = new HashMap<>();

		// 2. put the component id that is the initiator for the js code...
		if (withComponentId)
		{
			variables.put(JavascriptGenerator.COMPONENT_ID, componentId);
		}
		for (StringTextValue<?> textValue : allSettings)
		{
			if (!textValue.isInitialValue())
			{
				switch (textValue.getType())
				{
					case STRING :
						if (textValue.getQuotationMarkType().equals(QuotationMarkType.NONE))
						{
							variables.put(textValue.getName(), textValue.getValue());
							break;
						}
						TextTemplateExtensions.setVariableWithSingleQuotationMarks(textValue.getName(),
							textValue.getValue(), variables);
						break;
					case ENUM :
						TextTemplateExtensions.setVariableWithSingleQuotationMarks(textValue.getName(),
							((ValueEnum)textValue.getValue()).getValue(), variables);
						break;
					case STRING_INTEGER :
						TextTemplateExtensions.setVariableWithSingleQuotationMarks(textValue.getName(),
							textValue.getValue(), variables);
						break;
					default :
						variables.put(textValue.getName(), textValue.getValue());
						break;
				}
			}
		}
		return variables;
	}

}
