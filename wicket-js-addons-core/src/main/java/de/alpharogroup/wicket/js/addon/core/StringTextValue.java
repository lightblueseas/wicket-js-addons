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

import java.io.Serializable;

import org.apache.wicket.util.lang.Args;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Value for the map of StringTextTemplate.
 *
 * @param <T>
 *            the generic type of the value.
 */
@Getter
public class StringTextValue<T> implements Serializable
{

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** The value. */
	private T value;

	/** The default value. */
	private final T defaultValue;

	/**
	 * The initial value flag indicates if the initial value is also the default value. This flag is
	 * taken for the generation of javascript code, if false(default value is set) this
	 * {@link StringTextValue} will be ignored in the generation of javascript code to keep the
	 * generated code as small as possible.
	 */
	private boolean initialValue;

	/**
	 * The quotation mark type.
	 */
	@Setter
	@Accessors(chain = true)
	private QuotationMarkType quotationMarkType = QuotationMarkType.NONE;

	/** The type. */
	@NonNull
	private final StringTextType type;

	/** The name. */
	private final String name;

	/**
	 * Instantiates a new {@link StringTextValue} object.
	 *
	 * @param name
	 *            the name
	 * @param stringTextType
	 *            the string text type
	 */
	public StringTextValue(final String name, final StringTextType stringTextType)
	{
		this(name, null, stringTextType, true);
	}

	/**
	 * Instantiates a new {@link StringTextValue} object.
	 *
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 * @param stringTextType
	 *            the string text type
	 */
	public StringTextValue(final String name, final T value, final StringTextType stringTextType)
	{
		this(name, value, stringTextType, true);
	}

	/**
	 * Instantiates a new {@link StringTextValue} object.
	 *
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 * @param stringTextType
	 *            the string text type
	 * @param initialValue
	 *            the flag if the initial value is also the default value. This flag is taken for
	 *            the generation of javascript, if false this {@link StringTextValue} will be not
	 *            added.
	 */
	@SuppressWarnings("unchecked")
	public StringTextValue(final String name, final T value, final StringTextType stringTextType,
		final boolean initialValue)
	{
		Args.notNull(stringTextType, "type");
		this.value = value;
		this.defaultValue = value;
		this.type = stringTextType;
		this.initialValue = initialValue;
		this.name = name;
		if (stringTextType.equals(StringTextType.BOOLEAN))
		{
			this.value = (T)Boolean.FALSE;
		}
		if (stringTextType.equals(StringTextType.STRING)
			|| stringTextType.equals(StringTextType.STRING_INTEGER))
		{
			setQuotationMarkType(QuotationMarkType.SINGLE);
		}
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the value
	 * @return the string text value
	 */
	public StringTextValue<T> setValue(final T value)
	{
		return setValue(value, false);
	}

	/**
	 * Sets the given value and set the initalValue flag if the flag should keep his state.
	 *
	 * @param value
	 *            the value
	 * @param initialValue
	 *            this flag tells the generator if the value is initial. This flag is taken for the
	 *            generation of javascript, if false this {@link StringTextValue} will be not added.
	 * @return the string text value
	 */
	public StringTextValue<T> setValue(final T value, final boolean initialValue)
	{
		this.initialValue = initialValue;
		this.value = value;
		return this;
	}
}
