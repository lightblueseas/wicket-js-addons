package de.alpharogroup.wicket.js.addon.iscroll;

import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * The Class {@link IscrollResourceReference} holds the references(js) for the js library iscroll.
 */
public class IscrollResourceReference extends JavaScriptResourceReference
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link IscrollResourceReference}.
	 */
	private IscrollResourceReference()
	{
		super(IscrollResourceReference.class, "iscroll.js");
	}

	/** The Constant INSTANCE. */
	private static final IscrollResourceReference INSTANCE = new IscrollResourceReference();

	/**
	 * Gets the singleton instance for this resource reference.
	 *
	 * @return the {@link IscrollResourceReference} instance
	 */
	public static IscrollResourceReference get()
	{
		return INSTANCE;
	}

}
