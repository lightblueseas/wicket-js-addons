package de.alpharogroup.wicket.js.addon.iscroll;

import java.util.Map;

import org.apache.wicket.util.lang.Args;

import de.alpharogroup.wicket.js.addon.core.JavascriptGenerator;

public class IscrollJsGenerator extends JavascriptGenerator<IscrollSettings>
{

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link IscrollJsGenerator}.
	 *
	 * @param settings
	 *            the settings for the Iscroll library.
	 * @param componentId
	 *            the component id
	 */
	public IscrollJsGenerator(final IscrollSettings settings, final String componentId)
	{
		super(settings);
		setMethodName("IScroll");
		setComponentId(Args.notNull(componentId, "componentId"));
		setWithComponentId(true);
	}

	/**
	 * Generates the javascript template code from the given map and the given method name that will
	 * be used to interpolate with the values of the given map.
	 *
	 * @param variables
	 *            the map with the javascript options.
	 * @param methodName
	 *            The method name.
	 * @return The generated javascript from the given map and the given method name.
	 */
	@Override
	public String generateJavascriptTemplateContent(final Map<String, Object> variables,
		final String methodName)
	{
		final StringBuilder sb = new StringBuilder();
		sb.append("new");
		sb.append(" ");
		sb.append(methodName);
		sb.append("(");
		sb.append("'#");
		sb.append(getComponentId());
		sb.append("', ");
		if (0 < variables.size())
		{
			generateJsOptionsForTemplateContent(variables, sb);
		}
		sb.append(");");
		return sb.toString();
	}

}
