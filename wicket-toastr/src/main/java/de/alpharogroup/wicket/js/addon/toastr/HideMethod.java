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
package de.alpharogroup.wicket.js.addon.toastr;

import lombok.Getter;
import de.alpharogroup.wicket.js.addon.core.ValueEnum;
import de.alpharogroup.wicket.js.addon.enums.EffectMethods;

/**
 * The Enum HideMethod.
 */
public enum HideMethod implements ValueEnum
{
	HIDE("hide"), FADE_OUT(EffectMethods.FADE_OUT.getValue()), SLIDE_UP(EffectMethods.SLIDE_UP
		.getValue());

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
	private HideMethod(final String value)
	{
		this.value = value;
	}
}
