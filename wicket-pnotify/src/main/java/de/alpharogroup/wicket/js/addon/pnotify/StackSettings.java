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

import java.util.HashSet;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import de.alpharogroup.wicket.js.addon.core.QuotationMarkType;
import de.alpharogroup.wicket.js.addon.core.StringTextType;
import de.alpharogroup.wicket.js.addon.core.StringTextValue;
import de.alpharogroup.wicket.js.addon.core.TextTemplateExtensions;

/**
 * This class encapsulates various settings for the pnotify stack. See the documentation for the
 * pnotify for further information.
 */
@Getter
@EqualsAndHashCode
@ToString
public class StackSettings
{

	/**
	 * The dir1 value of the stack. Default: down
	 */
	private StringTextValue<String> dir1 = new StringTextValue<String>("dir1", "down",
		StringTextType.STRING);

	/**
	 * The dir2 value of the stack. Default: down
	 */
	private StringTextValue<String> dir2 = new StringTextValue<String>("dir2", "left",
		StringTextType.STRING);

	/**
	 * The push value of the stack. Default: bottom
	 */
	private StringTextValue<String> push = new StringTextValue<String>("push", "bottom",
		StringTextType.STRING);

	/**
	 * The spacing1 of the stack. Default: 25
	 */
	private StringTextValue<Integer> spacing1 = new StringTextValue<Integer>("spacing1", 25,
		StringTextType.INTEGER);

	/**
	 * The spacing2 of the stack. Default: 25
	 */
	private StringTextValue<Integer> spacing2 = new StringTextValue<Integer>("spacing2", 25,
		StringTextType.INTEGER);

	/**
	 * The push value of the stack. Default: bottom
	 */
	private StringTextValue<String> context = new StringTextValue<String>("context", "$(\"body\")",
		StringTextType.STRING).setQuotationMarkType(QuotationMarkType.NONE);

	/**
	 * This settings as a javascript array.
	 *
	 * @return This settings as a javascript array.
	 */
	public String asJavascriptArray()
	{
		return TextTemplateExtensions.asJavascriptArray(asSet());
	}

	/**
	 * Gets all settings in a {@link java.util.Set}.
	 * 
	 * @return all settings in a {@link java.util.Set}.
	 */
	public Set<StringTextValue<?>> asSet()
	{
		final Set<StringTextValue<?>> allSettings = new HashSet<>();
		allSettings.add(getContext());
		allSettings.add(getDir1());
		allSettings.add(getDir2());
		allSettings.add(getPush());
		allSettings.add(getSpacing1());
		allSettings.add(getSpacing2());
		return allSettings;
	}
}
