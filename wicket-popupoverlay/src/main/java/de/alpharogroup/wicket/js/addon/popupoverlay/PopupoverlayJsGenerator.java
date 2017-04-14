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
package de.alpharogroup.wicket.js.addon.popupoverlay;

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


import org.apache.wicket.util.lang.Args;

import de.alpharogroup.wicket.js.addon.core.JavascriptGenerator;

/**
 * The Class PopupoverlayJsGenerator generates the javascript with a PopupoverlaySettings object.
 */
public class PopupoverlayJsGenerator extends JavascriptGenerator<PopupoverlaySettings>
{

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link PopupoverlayJsGenerator} with the given
	 * {@link PopupoverlaySettings}.
	 *
	 * @param settings
	 *            the settings for the jquery-popup-overlay plugin.
	 *
	 * @param componentId
	 *            the component id
	 */
	public PopupoverlayJsGenerator(final PopupoverlaySettings settings, final String componentId)
	{
		this(settings, componentId, true);
	}

	/**
	 * Instantiates a new {@link PopupoverlayJsGenerator} with the given
	 * {@link PopupoverlaySettings}.
	 *
	 * @param settings
	 *            the settings for the jquery-popup-overlay plugin.
	 * @param componentId
	 *            the component id
	 * @param withDocumentReadyFunction
	 *            the flag if the script will be wrapped with document ready function
	 */
	public PopupoverlayJsGenerator(final PopupoverlaySettings settings, final String componentId,
		final boolean withDocumentReadyFunction)
	{
		super(settings);
		setComponentId(Args.notEmpty(componentId, "componentId"));
		setWithComponentId(true);
		setMethodName("popup");
		setWithDocumentReadyFunction(withDocumentReadyFunction);
	}

	/**
	 * Instantiates a new {@link PopupoverlayJsGenerator}.
	 *
	 * @param componentId
	 *            the component id
	 */
	public PopupoverlayJsGenerator(final String componentId)
	{
		this(PopupoverlaySettings.builder().build(), componentId);
	}

}
