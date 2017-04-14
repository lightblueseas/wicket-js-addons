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
package de.alpharogroup.wicket.js.addon.spin;

import java.util.Map;

import org.apache.wicket.util.lang.Args;

import de.alpharogroup.wicket.js.addon.core.JavascriptGenerator;

/**
 * The Class {@link SpinJsGenerator} generates the javascript with a SpinSettings object and a given
 * component id.
 */
public class SpinJsGenerator extends JavascriptGenerator<SpinSettings>
{

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The name of the js var for the spinner.
	 */
	public static final String SPINNER_JS_VARIABLE = "spinner";

	/**
	 * Instantiates a new {@link SpinJsGenerator}.
	 */
	public SpinJsGenerator()
	{
		this(SpinSettings.builder().build());
	}

	/**
	 * Instantiates a new {@link SpinJsGenerator}.
	 *
	 * @param settings
	 *            the settings for the spin library.
	 */
	public SpinJsGenerator(final SpinSettings settings)
	{
		this(settings, "");
	}

	/**
	 * Instantiates a new {@link SpinJsGenerator}.
	 *
	 * @param settings
	 *            the settings for the spin library.
	 * @param componentId
	 *            the component id
	 */
	public SpinJsGenerator(final SpinSettings settings, final String componentId)
	{
		super(settings);
		setComponentId(Args.notNull(componentId, "componentId"));
		setWithComponentId(true);
	}

	/**
	 * Instantiates a new {@link SpinJsGenerator}.
	 *
	 * @param componentId
	 *            the component id
	 */
	public SpinJsGenerator(final String componentId)
	{
		this(SpinSettings.builder().build(), componentId);
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
		if (1 < variables.size())
		{
			sb.append("var opts = ");
			generateJsOptionsForTemplateContent(variables, sb);
			sb.append(";");
			sb.append("\n");
		}
		if (!getComponentId().isEmpty())
		{
			sb.append("var target = document.getElementById('${").append(COMPONENT_ID)
				.append("}');");
		}
		else
		{
			sb.append("var target = document.getElementsByTagName('BODY')[0];");
		}
		sb.append("var " + SPINNER_JS_VARIABLE + " = new Spinner(");
		if (1 < variables.size())
		{
			sb.append("opts");
		}
		sb.append(").spin(target);");
		return sb.toString();
	}
}
