/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
	public JavascriptGenerator(final S settings)
	{
		this.settings = Args.notNull(settings, "settings");
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
		final String methodName)
	{
		final StringBuilder sb = new StringBuilder();

		if (isWithDocumentReadyFunction())
		{
			sb.append(DOCUMENT_READY_FUNCTION_PREFIX).append("\n");
		}
		if (isWithComponentId())
		{
			sb.append("$('#${").append(COMPONENT_ID).append("}')").append(".");
		}
		else
		{
			sb.append("$.");
		}
		sb.append(methodName).append("(");
		if (isWithComponentId())
		{
			if (1 < variables.size())
			{
				generateJsOptionsForTemplateContent(variables, sb);
			}
		}
		else
		{
			if (0 < variables.size())
			{
				generateJsOptionsForTemplateContent(variables, sb);
			}
		}
		sb.append(");").append("\n");
		if (isWithDocumentReadyFunction())
		{
			sb.append(DOCUMENT_READY_FUNCTION_SUFFIX);
		}
		return sb.toString();
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
		final String stringTemplateContent = generateJavascriptTemplateContent(variables,
			methodName);
		// 5. Create the StringTextTemplate with the generated template...
		final StringTextTemplate stringTextTemplate = new StringTextTemplate(stringTemplateContent);
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
			catch (final IOException e)
			{
				LOGGER.error(e.getMessage(), e);
			}
		}
	}

	/**
	 * Generate the javascript options for template content.
	 *
	 * @param variables
	 *            the map with the javascript options.
	 * @param sb
	 *            the {@link StringBuilder} to add the javascript options.
	 */
	protected void generateJsOptionsForTemplateContent(final Map<String, Object> variables,
		final StringBuilder sb)
	{
		sb.append("{\n");
		int count = 1;
		Object localComponentId = null;
		if (withComponentId)
		{
			localComponentId = variables.get(COMPONENT_ID);
			variables.remove(COMPONENT_ID);
		}
		for (final Map.Entry<String, Object> entry : variables.entrySet())
		{
			final String key = entry.getKey();
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
		for (final StringTextValue<?> textValue : allSettings)
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
						TextTemplateExtensions.setVariableWithSingleQuotationMarks(
							textValue.getName(), textValue.getValue(), variables);
						break;
					case ENUM :
						TextTemplateExtensions.setVariableWithSingleQuotationMarks(
							textValue.getName(), ((ValueEnum)textValue.getValue()).getValue(),
							variables);
						break;
					case STRING_INTEGER :
						TextTemplateExtensions.setVariableWithSingleQuotationMarks(
							textValue.getName(), textValue.getValue(), variables);
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
