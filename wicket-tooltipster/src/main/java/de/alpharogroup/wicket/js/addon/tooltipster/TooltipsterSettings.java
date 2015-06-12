/**
 * Copyright (C) 2010 Asterios Raptis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.alpharogroup.wicket.js.addon.tooltipster;

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
 * This class encapsulates various settings for the tooltipster js library. See the documentation
 * for the tooltipster js library for further information.
 */
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class TooltipsterSettings implements Settings
{

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Determines how the tooltip will animate in and out. Feel free to modify or create custom
	 * transitions in the tooltipster.css file. In IE9 and 8, all animations default to a JavaScript
	 * generated, fade animation. Default: 'fade' Posible values: fade, grow, swing, slide, fall
	 */
	private final StringTextValue<String> animation = new StringTextValue<>("animation", "fade",
		StringTextType.STRING);

	/**
	 * Adds the "speech bubble arrow" to the tooltip. Default: true
	 */
	private final StringTextValue<Boolean> arrow = new StringTextValue<>("arrow", true,
		StringTextType.BOOLEAN);

	/**
	 * Select a specific color for the "speech bubble arrow". Default: will inherit the tooltip's
	 * background color. Posible values: hex code / rgb
	 */
	private final StringTextValue<String> arrowColor = new StringTextValue<>("arrowColor",
		StringTextType.STRING);

	/**
	 * If autoClose is set to false, the tooltip will never close unless you call the 'hide' method
	 * yourself. Default: true
	 */
	private final StringTextValue<Boolean> autoClose = new StringTextValue<>("autoClose", true,
		StringTextType.BOOLEAN);

	/**
	 * If set, this will override the content of the tooltip. Default: null
	 */
	private final StringTextValue<String> content = new StringTextValue<>("content",
		StringTextType.STRING);

	/**
	 * If the content of the tooltip is provided as a string, it is displayed as plain text by
	 * default. If this content should actually be interpreted as HTML, set this option to true.
	 * Default: false
	 */
	private final StringTextValue<Boolean> contentAsHTML = new StringTextValue<>("contentAsHTML",
		StringTextType.BOOLEAN);

	/**
	 * If you provide a jQuery object to the 'content' option, this sets if it is a clone of this
	 * object that should actually be used. Default: true
	 */
	private final StringTextValue<Boolean> contentCloning = new StringTextValue<>("contentCloning",
		true, StringTextType.BOOLEAN);

	/**
	 * Tooltipster logs notices into the console when you're doing something you ideally shouldn't
	 * be doing. Set to false to disable logging. Default: true
	 */
	private final StringTextValue<Boolean> debug = new StringTextValue<>("debug", true,
		StringTextType.BOOLEAN);

	/**
	 * Delay how long it takes (in milliseconds) for the tooltip to start animating in. Default: 200
	 */
	private final StringTextValue<Integer> delay = new StringTextValue<>("delay", 200,
		StringTextType.INTEGER);

	/**
	 * Set a minimum width for the tooltip. Default: 0 (auto width)
	 */
	private final StringTextValue<Integer> minWidth = new StringTextValue<>("minWidth", 0,
		StringTextType.INTEGER);

	/**
	 * Set a maximum width for the tooltip. Default: null (no max width)
	 */
	private final StringTextValue<String> maxWidth = new StringTextValue<>("maxWidth",
		StringTextType.STRING_INTEGER);

	/**
	 * Create a custom function to be fired only once at instantiation. If the function returns a
	 * value, this value will become the content of the tooltip. See the advanced section to learn
	 * more. Default: function(origin, content) {}
	 */
	private final StringTextValue<String> functionInit = new StringTextValue<>("functionInit",
		StringTextType.STRING);

	/**
	 * Create a custom function to be fired before the tooltip opens. This function may prevent or
	 * hold off the opening. See the advanced section to learn more. Default: function(origin,
	 * continueTooltip) { continueTooltip(); }
	 */
	private final StringTextValue<String> functionBefore = new StringTextValue<>("functionBefore",
		StringTextType.STRING);

	/**
	 * Create a custom function to be fired when the tooltip and its contents have been added to the
	 * DOM. Default: function(origin, tooltip) {}
	 */
	private final StringTextValue<String> functionReady = new StringTextValue<>("functionReady",
		StringTextType.STRING);

	/**
	 * Create a custom function to be fired once the tooltip has been closed and removed from the
	 * DOM. Default: function(origin) {}
	 */
	private final StringTextValue<String> functionAfter = new StringTextValue<>("functionAfter",
		StringTextType.STRING);

	/**
	 * If true, the tooltip will close if its origin is clicked. This option only applies when
	 * 'trigger' is 'hover' and 'autoClose' is false. Default: false
	 */
	private final StringTextValue<Boolean> hideOnClick = new StringTextValue<>("hideOnClick",
		StringTextType.BOOLEAN);

	/**
	 * If using the iconDesktop or iconTouch options, this sets the content for your icon. Default:
	 * '(?)'
	 */
	private final StringTextValue<String> icon = new StringTextValue<>("icon",
		StringTextType.STRING);

	/**
	 * If you provide a jQuery object to the 'icon' option, this sets if it is a clone of this
	 * object that should actually be used. Default: true
	 */
	private final StringTextValue<Boolean> iconCloning = new StringTextValue<>("iconCloning", true,
		StringTextType.BOOLEAN);

	/**
	 * Generate an icon next to your content that is responsible for activating the tooltip on
	 * non-touch devices. Default: false
	 */
	private final StringTextValue<Boolean> iconDesktop = new StringTextValue<>("iconDesktop",
		StringTextType.BOOLEAN);

	/**
	 * If using the iconDesktop or iconTouch options, this sets the class on the icon (used to style
	 * the icon). Default: 'tooltipster-icon'
	 */
	private final StringTextValue<String> iconTheme = new StringTextValue<>("iconTheme",
		StringTextType.STRING);

	/**
	 * Generate an icon next to your content that is responsible for activating the tooltip on touch
	 * devices (tablets, phones, etc). Default: false
	 */
	private final StringTextValue<Boolean> iconTouch = new StringTextValue<>("iconTouch",
		StringTextType.BOOLEAN);

	/**
	 * Give users the possibility to interact with the tooltip. Unless autoClose is set to false,
	 * the tooltip will still close if the user moves away from or clicks out of the tooltip.
	 * Default: false
	 */
	private final StringTextValue<Boolean> interactive = new StringTextValue<>("interactive",
		StringTextType.BOOLEAN);

	/**
	 * If the tooltip is interactive and activated by a hover event, set the amount of time
	 * (milliseconds) allowed for a user to hover off of the tooltip activator (origin) on to the
	 * tooltip itself - keeping the tooltip from closing. Default: 350
	 */
	private final StringTextValue<Integer> interactiveTolerance = new StringTextValue<>(
		"interactiveTolerance", 350, StringTextType.INTEGER);

	/**
	 * Allows you to put multiple tooltips on a single element. Read further instructions down this
	 * page. Default: false
	 */
	private final StringTextValue<Boolean> multiple = new StringTextValue<>("multiple",
		StringTextType.BOOLEAN);

	/**
	 * Offsets the tooltip (in pixels) farther left/right from the origin. Default: 0
	 */
	private final StringTextValue<Integer> offsetX = new StringTextValue<>("offsetX", 0,
		StringTextType.INTEGER);

	/**
	 * Offsets the tooltip (in pixels) farther up/down from the origin. Default: 0
	 */
	private final StringTextValue<Integer> offsetY = new StringTextValue<>("offsetY", 0,
		StringTextType.INTEGER);

	/**
	 * If true, only one tooltip will be allowed to be active at a time. Non-autoclosing tooltips
	 * will not be closed though. Default: false
	 */
	private final StringTextValue<Boolean> onlyOne = new StringTextValue<>("onlyOne",
		StringTextType.BOOLEAN);

	/**
	 * Set the position of the tooltip. Default: 'top'
	 */
	private final StringTextValue<String> position = new StringTextValue<>("position", "top",
		StringTextType.STRING);

	/**
	 * Will reposition the tooltip if the origin moves. As this option may have an impact on
	 * performance, we suggest you enable it only if you need to. Default: false
	 */
	private final StringTextValue<Boolean> positionTracker = new StringTextValue<>(
		"positionTracker", StringTextType.BOOLEAN);

	/**
	 * Called after the tooltip has been repositioned by the position tracker (if enabled). Default:
	 * A function that will close the tooltip if the trigger is 'hover' and autoClose is false.
	 */
	private final StringTextValue<String> positionTrackerCallback = new StringTextValue<>(
		"positionTrackerCallback", null, StringTextType.STRING);

	/**
	 * Specify if a TITLE attribute should be restored on the HTML element after a call to the
	 * 'destroy' method. This attribute may be omitted, or be restored with the value that existed
	 * before Tooltipster was initialized, or be restored with the stringified value of the current
	 * content. Note: in case of multiple tooltips on a single element, only the last destroyed
	 * tooltip may trigger a restoration. Default: 'current'
	 */
	private final StringTextValue<String> restoration = new StringTextValue<>("restoration",
		"current", StringTextType.STRING);

	/**
	 * Set the speed of the animation. Default: 350
	 */
	private final StringTextValue<Integer> speed = new StringTextValue<>("speed", 350,
		StringTextType.INTEGER);

	/**
	 * How long the tooltip should be allowed to live before closing. Default: 0 (disabled)
	 */
	private final StringTextValue<Integer> timer = new StringTextValue<>("timer", 0,
		StringTextType.INTEGER);

	/**
	 * Set the theme used for your tooltip. Default: 'tooltipster-default'
	 */
	private final StringTextValue<String> theme = new StringTextValue<>("theme",
		"tooltipster-default", StringTextType.STRING);

	/**
	 * If set to false, tooltips will not show on pure-touch devices, unless you open them yourself
	 * with the 'show' method. Touch gestures on devices which also have a mouse will still open the
	 * tooltips though. Default: true
	 */
	private final StringTextValue<Boolean> touchDevices = new StringTextValue<>("touchDevices",
		true, StringTextType.BOOLEAN);

	/**
	 * Set how tooltips should be activated and closed. See the advanced section to learn how to
	 * build custom triggers. Default: 'hover'
	 */
	private final StringTextValue<String> trigger = new StringTextValue<>("trigger", "hover",
		StringTextType.STRING);

	/**
	 * If a tooltip is open while its content is updated, play a subtle animation when the content
	 * changes. Default: true
	 */
	private final StringTextValue<Boolean> updateAnimation = new StringTextValue<>(
		"updateAnimation", true, StringTextType.BOOLEAN);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<StringTextValue<?>> asSet()
	{
		Set<StringTextValue<?>> allSettings = new HashSet<>();
		allSettings.add(getAnimation());
		allSettings.add(getArrow());
		allSettings.add(getArrowColor());
		allSettings.add(getAutoClose());
		allSettings.add(getContent());
		allSettings.add(getContentAsHTML());
		allSettings.add(getContentCloning());
		allSettings.add(getDebug());
		allSettings.add(getDelay());
		allSettings.add(getFunctionAfter());
		allSettings.add(getFunctionBefore());
		allSettings.add(getFunctionInit());
		allSettings.add(getFunctionReady());
		allSettings.add(getHideOnClick());
		allSettings.add(getIcon());
		allSettings.add(getIconCloning());
		allSettings.add(getIconDesktop());
		allSettings.add(getIconTheme());
		allSettings.add(getIconTouch());
		allSettings.add(getInteractive());
		allSettings.add(getInteractiveTolerance());
		allSettings.add(getMaxWidth());
		allSettings.add(getMinWidth());
		allSettings.add(getMultiple());
		allSettings.add(getOffsetX());
		allSettings.add(getOffsetY());
		allSettings.add(getOnlyOne());
		allSettings.add(getPosition());
		allSettings.add(getPositionTracker());
		allSettings.add(getRestoration());
		allSettings.add(getSpeed());
		allSettings.add(getTheme());
		allSettings.add(getTimer());
		allSettings.add(getTouchDevices());
		allSettings.add(getTrigger());
		allSettings.add(getUpdateAnimation());
		return allSettings;
	}
}
