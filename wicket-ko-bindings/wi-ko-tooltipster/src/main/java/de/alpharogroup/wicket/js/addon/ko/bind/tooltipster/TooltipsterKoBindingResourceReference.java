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
package de.alpharogroup.wicket.js.addon.ko.bind.tooltipster;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import de.alpharogroup.wicket.js.addon.knockout.KnockoutResourceReference;
import de.alpharogroup.wicket.js.addon.tooltipster.TooltipsterResourceReference;

/**
 * The class {@link TooltipsterKoBindingResourceReference} holds the javascript reference for the
 * tooltipster-binding.js knockout binding.
 */
public class TooltipsterKoBindingResourceReference extends JavaScriptResourceReference
{

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The singleton instance of this {@link TooltipsterKoBindingResourceReference}. */
	private static final TooltipsterKoBindingResourceReference INSTANCE = new TooltipsterKoBindingResourceReference();

	/**
	 * Instantiates a new {@link TooltipsterKoBindingResourceReference}.
	 */
	private TooltipsterKoBindingResourceReference()
	{
		super(TooltipsterKoBindingResourceReference.class, "tooltipster-binding.js");
	}

	/**
	 * Gets singleton instance.
	 *
	 * @return the singleton {@link TooltipsterKoBindingResourceReference} object.
	 */
	public static final TooltipsterKoBindingResourceReference get()
	{
		return INSTANCE;
	}

	@Override
	public Iterable<? extends HeaderItem> getDependencies()
	{
		final List<HeaderItem> dependencies = new ArrayList<>();
		dependencies.add(JavaScriptHeaderItem.forReference(KnockoutResourceReference.get()));
		dependencies.add(JavaScriptHeaderItem.forReference(TooltipsterResourceReference.get()));
		return dependencies;
	}

}
