package de.alpharogroup.wicket.js.addon.knockout;

import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * The class {@link KnockoutResourceReference} holds the javascript reference for the knockout.js library.
 */
public class KnockoutResourceReference extends JavaScriptResourceReference
{

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The singleton instance of this {@link KnockoutResourceReference}. */
	private static final KnockoutResourceReference INSTANCE = new KnockoutResourceReference();

	/**
	 * Instantiates a new {@link KnockoutResourceReference}.
	 */
	private KnockoutResourceReference()
	{
		super(KnockoutResourceReference.class, "knockout-3.4.1.js");
	}

	/**
	 * Gets singleton instance.
	 *
	 * @return the singleton {@link KnockoutResourceReference} object.
	 */
	public static final KnockoutResourceReference get() {
		return INSTANCE;
	}

}
