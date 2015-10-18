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
package de.alpharogroup.wicket.js.addon.toastr;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
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
