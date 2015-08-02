package de.alpharogroup.wicket.js.addon.sessiontimeout;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class BootstrapSessionTimeoutResourceReference extends JavaScriptResourceReference
{

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private static final BootstrapSessionTimeoutResourceReference INSTANCE = new BootstrapSessionTimeoutResourceReference();

	public static BootstrapSessionTimeoutResourceReference get()
	{
		return INSTANCE;
	}

	private BootstrapSessionTimeoutResourceReference()
	{
		super(BootstrapSessionTimeoutResourceReference.class, "bootstrap-session-timeout.min.js");
	}

	@Override
	public List<HeaderItem> getDependencies()
	{
		final List<HeaderItem> deps = new ArrayList<HeaderItem>();
		return deps;
	}

}
