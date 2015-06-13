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
package de.alpharogroup.wicket.js.addon.pnotify;

import java.util.Map;

import de.alpharogroup.wicket.js.addon.core.JavascriptGenerator;


/**
 * The Class PnotifyJsGenerator generates the javascript with a PnotifySettings object.
 */
public class PnotifyJsGenerator extends JavascriptGenerator<PnotifySettings>
{

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link PnotifyJsGenerator}.
	 */
	public PnotifyJsGenerator()
	{
		this(PnotifySettings.builder().build());
	}

	/**
	 * Instantiates a new {@link PnotifyJsGenerator} with the given {@link PnotifySettings}.
	 *
	 * @param settings
	 *            the settings for the toastr plugin.
	 */
	public PnotifyJsGenerator(final PnotifySettings settings)
	{
		super(settings);
		setMethodName("PNotify");
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
	public String generateJavascriptTemplateContent(final Map<String, Object> variables,
		String methodName)
	{
		StringBuilder sb = new StringBuilder();
		if (!getSettings().getStack().isInitialValue())
		{
			String customStack = "customStack";
			String stack = (String)variables.get("stack");
			sb.append("var " + customStack + " = ");
			sb.append(stack);
			sb.append(";\n");
			variables.put("stack", customStack);
		}
		sb.append("new");
		sb.append(" ");
		sb.append(methodName);
		sb.append("(");
		if (0 < variables.size())
		{
			generateJsOptionsForTemplateContent(variables, sb);
		}
		sb.append(");");
		return sb.toString();
	}

}
