package de.alpharogroup.wicket.js.addon.ko.bind.tooltipster;

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
		@SuppressWarnings("unchecked")
		final List<HeaderItem> dependencies = (List<HeaderItem>)super.getDependencies();
		dependencies.add(JavaScriptHeaderItem.forReference(KnockoutResourceReference.get()));
		dependencies.add(JavaScriptHeaderItem.forReference(TooltipsterResourceReference.get()));
		return dependencies;
	}

}
