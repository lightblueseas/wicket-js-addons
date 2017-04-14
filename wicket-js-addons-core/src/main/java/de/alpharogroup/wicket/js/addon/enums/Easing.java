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
package de.alpharogroup.wicket.js.addon.enums;

import de.alpharogroup.wicket.js.addon.core.ValueEnum;
import lombok.Getter;


/**
 * The Enum Easing.
 */
public enum Easing implements ValueEnum
{

	/** The constant for the easing type 'linear'. */
	LINEAR("linear"),
	/** The constant for the easing type 'swing'. */
	SWING("swing"),
	/** The constant for the easing type 'jswing'. */
	JSWING("jswing"),
	/** The constant for the easing type 'easeInQuad'. */
	EASE_IN_QUAD("easeInQuad"),
	/** The constant for the easing type 'easeInCubic'. */
	EASE_IN_CUBIC("easeInCubic"),
	/** The constant for the easing type 'easeInQuart'. */
	EASE_IN_QUART("easeInQuart"),
	/** The constant for the easing type 'easeInQuint'. */
	EASE_IN_QUINT("easeInQuint"),
	/** The constant for the easing type 'easeInSine'. */
	EASE_IN_SINE("easeInSine"),
	/** The constant for the easing type 'easeInExpo'. */
	EASE_IN_EXPO("easeInExpo"),
	/** The constant for the easing type 'easeInCirc'. */
	EASE_IN_CIRC("easeInCirc"),
	/** The constant for the easing type 'easeInElastic'. */
	EASE_IN_ELASTIC("easeInElastic"),
	/** The constant for the easing type 'easeInBack'. */
	EASE_IN_BACK("easeInBack"),
	/** The constant for the easing type 'easeInBounce'. */
	EASE_IN_BOUNCE("easeInBounce"),
	/** The constant for the easing type 'easeOutQuad'. */
	EASE_OUT_QUAD("easeOutQuad"),
	/** The constant for the easing type 'easeOutCubic'. */
	EASE_OUT_CUBIC("easeOutCubic"),
	/** The constant for the easing type 'easeOutQuart'. */
	EASE_OUT_QUART("easeOutQuart"),
	/** The constant for the easing type 'easeOutQuint'. */
	EASE_OUT_QUINT("easeOutQuint"),
	/** The constant for the easing type 'easeOutSine'. */
	EASE_OUT_SINE("easeOutSine"),
	/** The constant for the easing type 'easeOutExpo'. */
	EASE_OUT_EXPO("easeOutExpo"),
	/** The constant for the easing type 'easeOutCirc'. */
	EASE_OUT_CIRC("easeOutCirc"),
	/** The constant for the easing type 'easeOutElastic'. */
	EASE_OUT_ELASTIC("easeOutElastic"),
	/** The constant for the easing type 'easeOutBack'. */
	EASE_OUT_BACK("easeOutBack"),
	/** The constant for the easing type 'easeOutBounce'. */
	EASE_OUT_BOUNCE("easeOutBounce"),
	/** The constant for the easing type 'easeInOutQuad'. */
	EASE_IN_OUT_QUAD("easeInOutQuad"),
	/** The constant for the easing type 'easeInOutCubic'. */
	EASE_IN_OUT_CUBIC("easeInOutCubic"),
	/** The constant for the easing type 'easeInOutQuart'. */
	EASE_IN_OUT_QUART("easeInOutQuart"),
	/** The constant for the easing type 'easeInOutQuint'. */
	EASE_IN_OUT_QUINT("easeInOutQuint"),
	/** The constant for the easing type 'easeInOutSine'. */
	EASE_IN_OUT_SINE("easeInOutSine"),
	/** The constant for the easing type 'easeInOutExpo'. */
	EASE_IN_OUT_EXPO("easeInOutExpo"),
	/** The constant for the easing type 'easeInOutCirc'. */
	EASE_IN_OUT_CIRC("easeInOutCirc"),
	/** The constant for the easing type 'easeInOutElastic'. */
	EASE_IN_OUT_ELASTIC("easeInOutElastic"),
	/** The constant for the easing type 'easeInOutBack'. */
	EASE_IN_OUT_BACK("easeInOutBack"),
	/** The constant for the easing type 'easeInOutBounce'. */
	EASE_IN_OUT_BOUNCE("easeInOutBounce");

	/**
	 * The value of the easing.
	 */
	@Getter
	private final String value;

	/**
	 * Constructor with a given value.
	 *
	 * @param value
	 *            the value
	 */
	private Easing(final String value)
	{
		this.value = value;
	}
}
