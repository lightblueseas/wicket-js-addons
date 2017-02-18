package de.alpharogroup.wicket.js.addon.knockout;

import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * The class {@link TooltipsterKoBindingResourceReference} holds the javascript reference for the tooltipster-binding.js knockout binding.
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
	public static final TooltipsterKoBindingResourceReference get() {
		return INSTANCE;
	}

}
