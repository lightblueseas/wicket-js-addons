package de.alpharogroup.wicket.js.addon.collapsible;

import java.util.HashSet;
import java.util.Set;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import de.alpharogroup.wicket.js.addon.core.Settings;
import de.alpharogroup.wicket.js.addon.core.StringTextType;
import de.alpharogroup.wicket.js.addon.core.StringTextValue;

/**
 * This class encapsulates various settings for the collapsible js lib for use with wicket. See the
 * documentation for the collapsible js plugin for further information.
 */
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CollapsibleSettings implements Settings
{

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The speed of the accordion when it goes up. Default: 400
	 */
	private final StringTextValue<Integer> accordionUpSpeed = new StringTextValue<>(
		"accordionUpSpeed", 400, StringTextType.INTEGER);

	/**
	 * The speed of the accordion when it goes down. Default: 400
	 */
	private final StringTextValue<Integer> accordionDownSpeed = new StringTextValue<>(
		"accordionDownSpeed", 400, StringTextType.INTEGER);

	/**
	 * The speed of the accordion when it collapse. Default: 400
	 */
	private final StringTextValue<Integer> collapseSpeed = new StringTextValue<>("collapseSpeed",
		400, StringTextType.INTEGER);

	/**
	 * The content open defines how many content is allowed to open. Default pane open, if any.
	 * Default: 0
	 */
	private final StringTextValue<Integer> contentOpen = new StringTextValue<>("contentOpen", 0,
		StringTextType.INTEGER);

	/**
	 * The css class for dropdown arrow. Default: arrow-r
	 */
	private final StringTextValue<String> arrowRclass = new StringTextValue<>("arrowRclass",
		"arrow-r", StringTextType.STRING);

	/**
	 * The css class for dropdown arrow. Default: arrow-d
	 */
	private final StringTextValue<String> arrowDclass = new StringTextValue<>("arrowRclass",
		"arrow-d", StringTextType.STRING);

	/**
	 * If the collapse should be animated. Default: true
	 */
	private final StringTextValue<Boolean> animate = new StringTextValue<>("animate", true,
		StringTextType.BOOLEAN);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<StringTextValue<?>> asSet()
	{
		final Set<StringTextValue<?>> allSettings = new HashSet<>();
		allSettings.add(getAccordionUpSpeed());
		allSettings.add(getAccordionDownSpeed());
		allSettings.add(getCollapseSpeed());
		allSettings.add(getContentOpen());
		allSettings.add(getArrowRclass());
		allSettings.add(getArrowDclass());
		allSettings.add(getAnimate());
		return allSettings;
	}
}
