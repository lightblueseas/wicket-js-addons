package de.alpharogroup.wicket.js.addon.sessiontimeout;

import de.alpharogroup.wicket.js.addon.core.JavascriptGenerator;

public class SessionTimeoutJsGenerator extends JavascriptGenerator<SessionTimeoutSettings>
{

	public SessionTimeoutJsGenerator(SessionTimeoutSettings settings)
	{
		this(settings, false);
		
	}
	
	public SessionTimeoutJsGenerator(SessionTimeoutSettings settings, boolean withDocumentReadyFunction)
	{
		super(settings);
		setWithComponentId(false);
		setMethodName("sessionTimeout");
		setWithDocumentReadyFunction(withDocumentReadyFunction);		
	}

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

}