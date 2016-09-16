package de.alpharogroup.wicket.js.addon.iscroll;

import java.util.HashSet;
import java.util.Set;

import de.alpharogroup.wicket.js.addon.core.Settings;
import de.alpharogroup.wicket.js.addon.core.StringTextType;
import de.alpharogroup.wicket.js.addon.core.StringTextValue;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * This class encapsulates various settings for the spin js library. See the documentation for the
 * spin js library for further information.
 */
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class IscrollSettings implements Settings
{

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Listen to the mouse wheel event. Default: false
	 */
	private final StringTextValue<Boolean> mouseWheel = new StringTextValue<>("mouseWheel",
		StringTextType.BOOLEAN);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<StringTextValue<?>> asSet()
	{
		final Set<StringTextValue<?>> allSettings = new HashSet<>();
		allSettings.add(getMouseWheel());
		return allSettings;
	}

}
