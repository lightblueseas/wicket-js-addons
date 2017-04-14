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

import java.util.Map;
import java.util.Set;

/**
 * The Class TextTemplateExtensions.
 */
public class TextTemplateExtensions
{

	/**
	 * Converts the given {@link Set} of {@link StringTextValue} to a javascript array.
	 *
	 * @param settings
	 *            the settings
	 * @return the generated javascript array.
	 */
	public static String asJavascriptArray(final Set<StringTextValue<?>> settings)
	{
		final StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		int count = 1;
		for (final StringTextValue<?> textValue : settings)
		{
			switch (textValue.getType())
			{
				case STRING :
					if (textValue.getQuotationMarkType().equals(QuotationMarkType.NONE))
					{
						sb.append(textValue.getName());
						sb.append(":");
						sb.append(textValue.getValue());
						break;
					}
					sb.append(textValue.getName());
					sb.append(":");
					sb.append("\"" + textValue.getValue() + "\"");
					break;
				default :
					sb.append(textValue.getName());
					sb.append(":");
					sb.append(textValue.getValue());
					break;
			}
			if (count < settings.size())
			{
				sb.append(",\n");
			}
			count++;
		}
		sb.append("\n}");
		return sb.toString();
	}

	/**
	 * Sets the variable with singe quotation marks.
	 *
	 * @param variablename
	 *            the variablename
	 * @param object
	 *            the object
	 * @param variables
	 *            the variables
	 */
	public static void setVariableWithSingleQuotationMarks(final String variablename,
		final Object object, final Map<String, Object> variables)
	{
		if (object != null)
		{
			variables.put(variablename, "'" + object + "'");
		}
		else
		{
			variables.put(variablename, "null");
		}
	}
}
