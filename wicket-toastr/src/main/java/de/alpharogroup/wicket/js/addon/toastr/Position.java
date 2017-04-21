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

import de.alpharogroup.wicket.js.addon.core.ValueEnum;
import lombok.Getter;

/**
 * The Enum Position.
 */
public enum Position implements ValueEnum
{

	/** The top. */
	TOP_RIGHT("toast-top-right"),
	/** The bottom. */
	BOTTOM_RIGHT("toast-bottom-right"),
	/** The bottom. */
	BOTTOM_LEFT("toast-bottom-left"),
	/** The top. */
	TOP_LEFT("toast-top-left"),
	/** The top. */
	TOP_FULL_WIDTH("toast-top-full-width"),
	/** The top. */
	BOTTOM_FULL_WIDTH("toast-bottom-full-width"),
	/** The center. */
	TOP_CENTER("toast-top-center"),
	/** The center. */
	BOTTOM_CENTER("toast-bottom-center");

	/**
	 * The value of the vertical position.
	 */
	@Getter
	private final String value;

	/**
	 * Constructor with a given vertical value.
	 *
	 * @param value
	 *            the value
	 */
	private Position(final String value)
	{
		this.value = value;
	}
}
