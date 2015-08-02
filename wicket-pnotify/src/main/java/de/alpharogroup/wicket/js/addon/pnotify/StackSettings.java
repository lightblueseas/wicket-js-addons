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
	 * Gets all settings in a {@link java.util.Set}.
	 * 
	 * @return all settings in a {@link java.util.Set}.
	 */
	public Set<StringTextValue<?>> asSet()
	{
		Set<StringTextValue<?>> allSettings = new HashSet<>();
		allSettings.add(getContext());
		allSettings.add(getDir1());
		allSettings.add(getDir2());
		allSettings.add(getPush());
		allSettings.add(getSpacing1());
		allSettings.add(getSpacing2());
		return allSettings;
	}

	/**
	 * This settings as a javascript array.
	 *
	 * @return This settings as a javascript array.
	 */
	public String asJavascriptArray()
	{
		return TextTemplateExtensions.asJavascriptArray(asSet());
	}
}
