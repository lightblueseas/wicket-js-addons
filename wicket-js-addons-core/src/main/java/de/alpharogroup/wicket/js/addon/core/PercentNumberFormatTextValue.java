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

import java.text.NumberFormat;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.wicket.util.lang.Args;

/**
 * A StringTextValue that formats the given Integer to percent. Posible values are between 0 to 100.
 */
public class PercentNumberFormatTextValue extends StringTextValue<String>
{

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** The Constant logger. */
	protected static final Logger LOGGER = Logger
		.getLogger(PercentNumberFormatTextValue.class.getName());

	/**
	 * Checks the given value if it is between 0 to 100 quietly. If not a default value from 50 will
	 * be set.
	 *
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 * @return the integer
	 */
	private static Integer checkQuietly(final String name, final Integer value)
	{
		Integer val = 50;
		try
		{
			val = Args.withinRange(0, 100, value, name);
		}
		catch (final IllegalArgumentException e)
		{
			LOGGER.error(String.format(
				"Given argument '%s' must have a value within [%s,%s], but was %s. Default value 50% will be set.",
				name, 0, 100, value));
		}
		return val;

	}

	/**
	 * Instantiates a new {@link PercentNumberFormatTextValue} object.
	 *
	 * @param name
	 *            the name
	 */
	public PercentNumberFormatTextValue(final String name)
	{
		super(name, null);
	}

	/**
	 * Instantiates a new {@link PercentNumberFormatTextValue} object.
	 *
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 */
	public PercentNumberFormatTextValue(final String name, final Integer value)
	{
		super(name,
			NumberFormat.getPercentInstance().format((double)checkQuietly(name, value) / 100),
			StringTextType.STRING_INTEGER);
	}

	/**
	 * Check string.
	 *
	 * @param value
	 *            the value
	 * @return the integer
	 */
	private Integer checkString(final String value)
	{
		Integer val = 50;
		if (value != null && !value.isEmpty())
		{
			if (value.endsWith("%"))
			{
				final String sVal = value.substring(0, value.length() - 1);
				if (StringUtils.isNumeric(sVal))
				{
					val = Integer.valueOf(sVal);
				}
			}
			else
			{
				if (StringUtils.isNumeric(value))
				{
					val = Integer.valueOf(value);
				}

			}
		}
		return val;
	}

	/**
	 * Gets the percent formatted.
	 *
	 * @param value
	 *            the value
	 * @return the percent formatted
	 */
	private String getPercentFormatted(final Integer value)
	{
		final Integer val = checkQuietly(getName(), value);
		return NumberFormat.getPercentInstance().format((double)val / 100);
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the value
	 * @return the string text value
	 */
	public StringTextValue<String> setValue(final Integer value)
	{
		final String percentFormatted = getPercentFormatted(value);
		return setValue(percentFormatted);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StringTextValue<String> setValue(final String value)
	{
		final String val = getPercentFormatted(checkString(value));
		return super.setValue(val);
	}
}
