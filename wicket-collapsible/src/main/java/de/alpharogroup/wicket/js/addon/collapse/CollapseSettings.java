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
package de.alpharogroup.wicket.js.addon.collapse;

import java.util.HashSet;
import java.util.Set;

import de.alpharogroup.wicket.js.addon.core.Settings;
import de.alpharogroup.wicket.js.addon.core.StringTextType;
import de.alpharogroup.wicket.js.addon.core.StringTextValue;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This class encapsulates various settings for the collapse js lib for use with wicket. See the
 * documentation for the collapse js plugin for further information.
 */
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CollapseSettings implements Settings
{

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Custom function for showing content Default: function(){ this.show() }
	 */
	private final StringTextValue<String> open = new StringTextValue<>("open",
		StringTextType.STRING);

	/**
	 * Custom function for hiding content (default: function(){ this.hide() })
	 */
	private final StringTextValue<String> close = new StringTextValue<>("close",
		StringTextType.STRING);

	/**
	 * Enable accordion behaviour by setting this option to 'true'. Default: false
	 */
	private final StringTextValue<Boolean> accordion = new StringTextValue<>("accordion",
		StringTextType.BOOLEAN);

	/**
	 * Enable persistence between page loads by setting this option to 'true'. Default: false
	 */
	private final StringTextValue<Boolean> persist = new StringTextValue<>("persist",
		StringTextType.BOOLEAN);

	/**
	 * In order for the plugin to understand the above markup, we can pass a 'query' option
	 * specifying where to find the header/summary element of a section.
	 */
	private final StringTextValue<String> query = new StringTextValue<>("query",
		StringTextType.STRING);

	/**
	 * You can customize what element inside the collapse summary should trigger the open/close
	 * action.
	 */
	private final StringTextValue<String> clickQuery = new StringTextValue<>("clickQuery",
		StringTextType.STRING);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<StringTextValue<?>> asSet()
	{
		final Set<StringTextValue<?>> allSettings = new HashSet<>();
		allSettings.add(getOpen());
		allSettings.add(getClose());
		allSettings.add(getAccordion());
		allSettings.add(getPersist());
		allSettings.add(getQuery());
		allSettings.add(getClickQuery());
		return allSettings;
	}
}
