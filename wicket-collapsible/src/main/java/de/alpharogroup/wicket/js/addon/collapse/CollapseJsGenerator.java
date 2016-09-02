package de.alpharogroup.wicket.js.addon.collapse;

import org.apache.wicket.util.lang.Args;

import de.alpharogroup.wicket.js.addon.core.JavascriptGenerator;

public class CollapseJsGenerator extends JavascriptGenerator<CollapseSettings> {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link CollapseJsGenerator} with the given
	 * {@link CollapseSettings} .
	 *
	 * @param settings
	 *            the settings for the jquery-collapse plugin.
	 *
	 * @param componentId
	 *            the component id
	 */
	public CollapseJsGenerator(final CollapseSettings settings, final String componentId) {
		this(settings, componentId, false);
	}

	/**
	 * Instantiates a new {@link CollapseJsGenerator} with the given
	 * {@link CollapseSettings} .
	 *
	 * @param settings
	 *            the settings for the jquery-popup-overlay plugin.
	 *
	 * @param componentId
	 *            the component id
	 * @param withDocumentReadyFunction
	 *            the flag if the script will be wrapped with document ready
	 *            function
	 */
	public CollapseJsGenerator(final CollapseSettings settings, final String componentId,
			final boolean withDocumentReadyFunction) {
		super(settings);
		setComponentId(Args.notEmpty(componentId, "componentId"));
		setWithComponentId(true);
		setMethodName("collapse");
		setWithDocumentReadyFunction(withDocumentReadyFunction);
	}

	/**
	 * Instantiates a new {@link CollapseJsGenerator}.
	 *
	 * @param componentId
	 *            the component id
	 */
	public CollapseJsGenerator(final String componentId) {
		this(CollapseSettings.builder().build(), componentId);
	}

}
