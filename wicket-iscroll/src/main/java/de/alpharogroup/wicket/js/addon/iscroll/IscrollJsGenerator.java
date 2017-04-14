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
package de.alpharogroup.wicket.js.addon.iscroll;

import java.util.Map;

import org.apache.wicket.util.lang.Args;

import de.alpharogroup.wicket.js.addon.core.JavascriptGenerator;

public class IscrollJsGenerator extends JavascriptGenerator<IscrollSettings>
{

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link IscrollJsGenerator}.
	 *
	 * @param settings
	 *            the settings for the Iscroll library.
	 * @param componentId
	 *            the component id
	 */
	public IscrollJsGenerator(final IscrollSettings settings, final String componentId)
	{
		super(settings);
		setMethodName("IScroll");
		setComponentId(Args.notNull(componentId, "componentId"));
		setWithComponentId(true);
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
		sb.append("new");
		sb.append(" ");
		sb.append(methodName);
		sb.append("(");
		sb.append("'#");
		sb.append(getComponentId());
		sb.append("', ");
		if (0 < variables.size())
		{
			generateJsOptionsForTemplateContent(variables, sb);
		}
		sb.append(");");
		return sb.toString();
	}

}
