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

import org.apache.wicket.util.lang.Args;

import de.alpharogroup.wicket.js.addon.core.JavascriptGenerator;

public class CollapseJsGenerator extends JavascriptGenerator<CollapseSettings> {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link CollapseJsGenerator} with the given
	 * {@link CollapseSettings} .
	 *
	 * @param settings
	 *            the settings for the jquery-collapse plugin.
	 *
	 * @param componentId
	 *            the component id
	 */
	public CollapseJsGenerator(final CollapseSettings settings, final String componentId) {
		this(settings, componentId, false);
	}

	/**
	 * Instantiates a new {@link CollapseJsGenerator} with the given
	 * {@link CollapseSettings} .
	 *
	 * @param settings
	 *            the settings for the jquery-popup-overlay plugin.
	 *
	 * @param componentId
	 *            the component id
	 * @param withDocumentReadyFunction
	 *            the flag if the script will be wrapped with document ready
	 *            function
	 */
	public CollapseJsGenerator(final CollapseSettings settings, final String componentId,
			final boolean withDocumentReadyFunction) {
		super(settings);
		setComponentId(Args.notEmpty(componentId, "componentId"));
		setWithComponentId(true);
		setMethodName("collapse");
		setWithDocumentReadyFunction(withDocumentReadyFunction);
	}

	/**
	 * Instantiates a new {@link CollapseJsGenerator}.
	 *
	 * @param componentId
	 *            the component id
	 */
	public CollapseJsGenerator(final String componentId) {
		this(CollapseSettings.builder().build(), componentId);
	}

}
