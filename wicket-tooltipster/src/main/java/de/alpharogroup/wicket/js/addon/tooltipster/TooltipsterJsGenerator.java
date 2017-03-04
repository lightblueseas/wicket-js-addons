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
package de.alpharogroup.wicket.js.addon.tooltipster;

import java.io.Serializable;

import org.apache.wicket.util.lang.Args;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.alpharogroup.wicket.js.addon.core.JavascriptGenerator;


/**
 * The Class TooltipsterJsGenerator generates the javascript with a TooltipsterSettings object and a
 * given component id.
 */
public class TooltipsterJsGenerator extends JavascriptGenerator<TooltipsterSettings>
	implements
		Serializable
{

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** The LOGGER. */
	protected static final Logger LOGGER = LoggerFactory.getLogger(TooltipsterJsGenerator.class
		.getName());

	/**
	 * Instantiates a new {@link TooltipsterJsGenerator}.
	 *
	 * @param componentId
	 *            the component id
	 */
	public TooltipsterJsGenerator(final String componentId)
	{
		this(TooltipsterSettings.builder().build(), componentId);
	}

	/**
	 * Instantiates a new {@link TooltipsterJsGenerator} with the given {@link TooltipsterSettings}.
	 *
	 * @param settings
	 *            the settings for the tooltipster plugin.
	 *
	 * @param componentId
	 *            the component id
	 */
	public TooltipsterJsGenerator(final TooltipsterSettings settings, final String componentId)
	{
		this(settings, componentId, true);
	}

	/**
	 * Instantiates a new {@link TooltipsterJsGenerator} with the given {@link TooltipsterSettings}.
	 *
	 * @param settings
	 *            the settings for the tooltipster plugin.
	 *
	 * @param componentId
	 *            the component id
	 * @param withDocumentReadyFunction
	 *            the flag if the script will be wrapped with document ready function
	 */
	public TooltipsterJsGenerator(final TooltipsterSettings settings, final String componentId,
		final boolean withDocumentReadyFunction)
	{
		super(settings);
		setComponentId(Args.notEmpty(componentId, "componentId"));
		setWithComponentId(true);
		setMethodName("tooltipster");
		setWithDocumentReadyFunction(withDocumentReadyFunction);
	}

}
