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
	@Override
	public String generateJavascriptTemplateContent(final Map<String, Object> variables,
		final String methodName)
	{
		final StringBuilder sb = new StringBuilder();
		if (!getSettings().getStack().isInitialValue())
		{
			final String customStack = "customStack";
			final String stack = (String)variables.get("stack");
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
