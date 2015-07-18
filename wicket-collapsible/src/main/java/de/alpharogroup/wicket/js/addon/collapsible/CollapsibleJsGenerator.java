package de.alpharogroup.wicket.js.addon.collapsible;

import org.apache.wicket.util.lang.Args;

import de.alpharogroup.wicket.js.addon.core.JavascriptGenerator;

public class CollapsibleJsGenerator extends JavascriptGenerator<CollapsibleSettings>
{

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * Instantiates a new {@link CollapsibleJsGenerator}.
	 *
	 * @param componentId
	 *            the component id
	 */
	public CollapsibleJsGenerator(final String componentId)
	{
		this(CollapsibleSettings.builder().build(), componentId);
	}

	/**
	 * Instantiates a new {@link CollapsibleJsGenerator} with the given
	 * {@link PopupoverlaySettings}.
	 *
	 * @param settings
	 *            the settings for the jquery-popup-overlay plugin.
	 *
	 * @param componentId
	 *            the component id
	 */
	public CollapsibleJsGenerator(CollapsibleSettings settings, final String componentId)
	{
		this(settings, componentId, false);
	}

	/**
	 * Instantiates a new {@link CollapsibleJsGenerator} with the given
	 * {@link PopupoverlaySettings}.
	 *
	 * @param settings
	 *            the settings for the jquery-popup-overlay plugin.
	 *
	 * @param componentId
	 *            the component id
	 */
	public CollapsibleJsGenerator(CollapsibleSettings settings, final String componentId, boolean withDocumentReadyFunction)
	{
		super(settings);
		setComponentId(Args.notEmpty(componentId, "componentId"));
		setWithComponentId(true);
		setMethodName("collapsible");
		setWithDocumentReadyFunction(withDocumentReadyFunction);
	}


}
