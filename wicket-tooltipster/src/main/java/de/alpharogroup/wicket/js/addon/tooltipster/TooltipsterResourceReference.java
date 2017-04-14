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

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * The class {@link TooltipsterResourceReference} holds the references(js and css) for the jquery
 * plugin tooltipster.
 */
public class TooltipsterResourceReference extends JavaScriptResourceReference
{

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public static final TooltipsterResourceReference INSTANCE = new TooltipsterResourceReference();

	/**
	 * Instantiates a new {@link TooltipsterResourceReference}.
	 */
	private TooltipsterResourceReference()
	{
		super(TooltipsterResourceReference.class, "jquery.tooltipster.min.js");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<HeaderItem> getDependencies()
	{
		final List<HeaderItem> dependencies = new ArrayList<>();
		dependencies.add(CssHeaderItem.forReference(
			new CssResourceReference(TooltipsterResourceReference.class, "tooltipster.css")));
		return dependencies;
	}

	public static final TooltipsterResourceReference get() {
		return INSTANCE;
	}

}
