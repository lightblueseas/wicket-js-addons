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
package de.alpharogroup.wicket.js.addon.toastr;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.util.lang.Args;

import de.alpharogroup.wicket.js.addon.core.JavascriptGenerator;
import de.alpharogroup.wicket.js.addon.core.StringTextValue;

/**
 * The Class ToastJsGenerator generates the javascript with a ToastrSettings object.
 */
public class ToastJsGenerator extends JavascriptGenerator<ToastrSettings> implements Serializable
{

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The constant for the key of the command.
	 */
	public static final String COMMAND = "command";

	/**
	 * Instantiates a new {@link ToastJsGenerator}.
	 */
	public ToastJsGenerator()
	{
		this(ToastrSettings.builder().build());
	}

	/**
	 * Instantiates a new {@link ToastJsGenerator} with the given {@link ToastrSettings}.
	 *
	 * @param settings
	 *            the settings for the toastr plugin.
	 */
	public ToastJsGenerator(final ToastrSettings settings)
	{
		this(settings, true);
	}

	/**
	 * Instantiates a new {@link ToastJsGenerator} with the given {@link ToastrSettings}.
	 *
	 * @param settings
	 *            the settings for the toastr plugin.
	 * @param withDocumentReadyFunction
	 *            the flag if the script will be wrapped with document ready function
	 */
	public ToastJsGenerator(final ToastrSettings settings, final boolean withDocumentReadyFunction)
	{
		super(Args.notNull(settings, "settings"));
		setWithDocumentReadyFunction(withDocumentReadyFunction);
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
	@Override
	public String generateJavascriptTemplateContent(final Map<String, Object> variables,
		final String methodName)
	{
		final StringBuilder sb = new StringBuilder();
		if (isWithDocumentReadyFunction())
		{
			sb.append(DOCUMENT_READY_FUNCTION_PREFIX).append("\n").append("\n");
		}
		for (final Map.Entry<String, Object> entry : variables.entrySet())
		{
			final String key = entry.getKey();
			if (!COMMAND.equals(key))
			{
				sb.append(key).append("=${").append(key).append("};");
				sb.append("\n");
			}
		}
		sb.append("\n");
		sb.append("${" + COMMAND + "};");
		sb.append("\n");
		if (isWithDocumentReadyFunction())
		{
			sb.append(DOCUMENT_READY_FUNCTION_SUFFIX);
		}
		return sb.toString();
	}

	/**
	 * Gets the command.
	 *
	 * @param settings
	 *            the toastrSettings
	 * @return the command
	 */
	public String getCommand(final ToastrSettings settings)
	{
		final StringBuilder sb = new StringBuilder();
		sb.append("toastr.");
		sb.append(settings.getToastrType().getValue().getValue());
		sb.append("('");
		sb.append(settings.getNotificationContent().getValue());
		sb.append("'");
		if (StringUtils.isNotEmpty(settings.getNotificationTitle().getValue()))
		{
			sb.append(", '");
			sb.append(settings.getNotificationTitle().getValue());
			sb.append("'");
		}
		sb.append(")");
		return sb.toString();
	}

	/**
	 * {@inheritDoc}.
	 */
	@Override
	protected Map<String, Object> initializeVariables(final Set<StringTextValue<?>> allSettings)
	{
		final Map<String, Object> variables = super.initializeVariables(allSettings);
		variables.put(COMMAND, getCommand(getSettings()));
		return variables;
	}

}
