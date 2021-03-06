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

import java.util.HashSet;
import java.util.Set;

import de.alpharogroup.wicket.js.addon.core.PercentNumberFormatTextValue;
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
 * This class encapsulates various settings for the spin js library. See the documentation for the
 * spin js library for further information.
 */
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class SpinSettings implements Settings
{

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The number of lines to draw. Default: 12
	 */
	private final StringTextValue<Integer> lines = new StringTextValue<>("lines", 12,
		StringTextType.INTEGER);

	/**
	 * The length of each line. Default: 7
	 */
	private final StringTextValue<Integer> length = new StringTextValue<>("length", 7,
		StringTextType.INTEGER);

	/**
	 * The line thickness. Default: 5
	 */
	private final StringTextValue<Integer> width = new StringTextValue<>("width", 5,
		StringTextType.INTEGER);

	/**
	 * The radius of the inner circle. Default: 10
	 */
	private final StringTextValue<Integer> radius = new StringTextValue<>("radius", 10,
		StringTextType.INTEGER);

	/**
	 * Scales overall size of the spinner. Default: 1.0
	 */
	private final StringTextValue<Float> scale = new StringTextValue<>("scale", 1.0f,
		StringTextType.FLOAT);

	/**
	 * Roundness (0..1). Default: 1.0
	 */
	private final StringTextValue<Float> corners = new StringTextValue<>("corners", 1.0f,
		StringTextType.FLOAT);
	/**
	 * Sets the line color. Default: #000
	 */
	private final StringTextValue<String> color = new StringTextValue<>("color", "#000",
		StringTextType.STRING);
	/**
	 * The opacity of the spinner. Default: 0.25
	 */
	private final StringTextValue<Float> opacity = new StringTextValue<>("opacity", 0.25f,
		StringTextType.FLOAT);

	/**
	 * Rotation offset. Default: 0
	 */
	private final StringTextValue<Integer> rotate = new StringTextValue<>("rotate", 0,
		StringTextType.INTEGER);

	/**
	 * Possible values are 1: clockwise, -1: counterclockwise. Default: 1
	 */
	private final StringTextValue<Integer> direction = new StringTextValue<>("direction", 1,
		StringTextType.INTEGER);

	/**
	 * Rounds per second. Possible values are between 0.0 till 2.2 Default: 1.0
	 */
	private final StringTextValue<Float> speed = new StringTextValue<>("speed", 1.0f,
		StringTextType.FLOAT);

	/**
	 * Afterglow percentage. Possible values are between 0 till 100 Default: 100
	 */
	private final StringTextValue<Integer> trail = new StringTextValue<>("trail", 100,
		StringTextType.INTEGER);

	/**
	 * Frames per second when using setTimeout() as a fallback for CSS Default: 20
	 */
	private final StringTextValue<Integer> fps = new StringTextValue<>("fps", 20,
		StringTextType.INTEGER);

	/**
	 * The z-index Default: 2000000000
	 */
	private final StringTextValue<Integer> zindex = new StringTextValue<>("zIndex", 2000000000,
		StringTextType.INTEGER);

	/**
	 * CSS class to assign to the element. Default: spinner
	 */
	private final StringTextValue<String> className = new StringTextValue<>("className", "spinner",
		StringTextType.STRING);

	/**
	 * center vertically. Default: 50%
	 */
	private final StringTextValue<String> top = new PercentNumberFormatTextValue("top", 50);

	/**
	 * center horizontally. Default: 50%
	 */
	private final StringTextValue<String> left = new PercentNumberFormatTextValue("top", 50);

	/**
	 * Whether to render a shadow Default: false
	 */
	private final StringTextValue<Boolean> shadow = new StringTextValue<>("shadow",
		StringTextType.BOOLEAN);

	/**
	 * Whether to render a shadow Default: false
	 */
	private final StringTextValue<Boolean> hwaccel = new StringTextValue<>("hwaccel",
		StringTextType.BOOLEAN);

	/**
	 * Whether to use hardware acceleration (might be buggy). Default: absolute
	 */
	private final StringTextValue<String> position = new StringTextValue<>("position", "absolute",
		StringTextType.STRING);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<StringTextValue<?>> asSet()
	{
		final Set<StringTextValue<?>> allSettings = new HashSet<>();
		allSettings.add(getLines());
		allSettings.add(getLength());
		allSettings.add(getWidth());
		allSettings.add(getRadius());
		allSettings.add(getScale());
		allSettings.add(getCorners());
		allSettings.add(getColor());
		allSettings.add(getOpacity());
		allSettings.add(getRotate());
		allSettings.add(getDirection());
		allSettings.add(getSpeed());
		allSettings.add(getTrail());
		allSettings.add(getFps());
		allSettings.add(getZindex());
		allSettings.add(getClassName());
		allSettings.add(getTop());
		allSettings.add(getLeft());
		allSettings.add(getShadow());
		allSettings.add(getHwaccel());
		allSettings.add(getPosition());
		return allSettings;
	}
}
