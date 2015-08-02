package de.alpharogroup.wicket.js.addon.sessiontimeout;

import de.alpharogroup.wicket.js.addon.core.JavascriptGenerator;

public class SessionTimeoutJsGenerator extends JavascriptGenerator<SessionTimeoutSettings>
{

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public SessionTimeoutJsGenerator(final SessionTimeoutSettings settings)
	{
		this(settings, false);

	}

	public SessionTimeoutJsGenerator(final SessionTimeoutSettings settings,
		final boolean withDocumentReadyFunction)
	{
		super(settings);
		setWithComponentId(false);
		setMethodName("sessionTimeout");
		setWithDocumentReadyFunction(withDocumentReadyFunction);
	}

}