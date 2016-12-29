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
	 * By default the engine uses the transform CSS property. Setting this to false scrolls like we
	 * were in 2007, ie: using the top/left (and thus the scroller needs to be absolutely
	 * positioned).
	 *
	 * This might be useful when scrolling sensitive content such as Flash, iframes and videos, but
	 * be warned: performance loss is huge. <br/>
	 * Default: true
	 */
	private final StringTextValue<Boolean> useTransform = new StringTextValue<>("useTransform",
		true, StringTextType.BOOLEAN);

	/**
	 * iScroll uses CSS transition to perform animations (momentum and bounce). By setting this to
	 * false, requestAnimationFrame is used instead.
	 *
	 * On modern browsers the difference is barely noticeable. On older devices transitions perform
	 * better.
	 *
	 * <br/>
	 * Default: true
	 */
	private final StringTextValue<Boolean> useTransition = new StringTextValue<>("useTransition",
		true, StringTextType.BOOLEAN);

	/**
	 * This option tries to put the scroller on the hardware layer by appending translateZ(0) to the
	 * transform CSS property. This greatly increases performance especially on mobile, but there
	 * are situations where you might want to disable it (notably if you have too many elements and
	 * the hardware can't catch up).
	 *
	 * If unsure leave iScroll decide what's the optimal config. For best performance all the above
	 * options should be set to true (or better leave them undefined as they are set to true
	 * automatically). You may try to play with them in case you encounter hiccups and memory leaks.
	 * <br/>
	 * Default: true
	 */
	private final StringTextValue<Boolean> HWCompositing = new StringTextValue<>("HWCompositing",
		true, StringTextType.BOOLEAN);

	/**
	 * When the scroller meets the boundary it performs a small bounce animation. Disabling bounce
	 * may help reach smoother results on old or slow devices.
	 *
	 * <br/>
	 * Default: true
	 */
	private final StringTextValue<Boolean> bounce = new StringTextValue<>("bounce", true,
		StringTextType.BOOLEAN);

	/**
	 * To override the native scrolling iScroll has to inhibit some default browser behaviors, such
	 * as mouse clicks. If you want your application to respond to the click event you have to
	 * explicitly set this option to true. Please note that it is suggested to use the custom tap
	 * event instead (see below).
	 *
	 * <br/>
	 * Default: false
	 */
	private final StringTextValue<Boolean> click = new StringTextValue<>("click",
		StringTextType.BOOLEAN);

	/**
	 * By default iScroll listens to all pointer events and reacts to the first one that occurs. It
	 * may seem a waste of resources but feature detection has proven quite unreliable and this
	 * listen-to-all approach is our safest bet for wide browser/device compatibility.
	 *
	 * If you have an internal mechanism for device detection or you know in advance where your
	 * script will run on, you may want to disable all event sets you don't need (mouse, pointer or
	 * touch events).
	 *
	 * <br/>
	 * Default: false
	 */
	private final StringTextValue<Boolean> disableMouse = new StringTextValue<>("disableMouse",
		StringTextType.BOOLEAN);

	/**
	 * By default iScroll listens to all pointer events and reacts to the first one that occurs. It
	 * may seem a waste of resources but feature detection has proven quite unreliable and this
	 * listen-to-all approach is our safest bet for wide browser/device compatibility.
	 *
	 * If you have an internal mechanism for device detection or you know in advance where your
	 * script will run on, you may want to disable all event sets you don't need (mouse, pointer or
	 * touch events).
	 *
	 * <br/>
	 * Default: false
	 */
	private final StringTextValue<Boolean> disablePointer = new StringTextValue<>("disablePointer",
		StringTextType.BOOLEAN);

	/**
	 * By default iScroll listens to all pointer events and reacts to the first one that occurs. It
	 * may seem a waste of resources but feature detection has proven quite unreliable and this
	 * listen-to-all approach is our safest bet for wide browser/device compatibility.
	 *
	 * If you have an internal mechanism for device detection or you know in advance where your
	 * script will run on, you may want to disable all event sets you don't need (mouse, pointer or
	 * touch events).
	 *
	 * <br/>
	 * Default: false
	 */
	private final StringTextValue<Boolean> disableTouch = new StringTextValue<>("disableTouch",
		StringTextType.BOOLEAN);

	/**
	 * Listen to the mouse wheel event.
	 *
	 * <br/>
	 * Default: false
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
		allSettings.add(getUseTransform());
		allSettings.add(getUseTransition());
		allSettings.add(getHWCompositing());
		allSettings.add(getBounce());
		allSettings.add(getClick());
		allSettings.add(getDisableMouse());
		allSettings.add(getDisablePointer());
		allSettings.add(getDisableTouch());
		allSettings.add(getMouseWheel());
		return allSettings;
	}

}
