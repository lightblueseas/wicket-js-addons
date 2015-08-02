package de.alpharogroup.wicket.js.addon.sessiontimeout;

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
 * This class encapsulates various settings for the SessionTimeout plugin. See the documentation for
 * the SessionTimeout plugin library for further information.
 */
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class SessionTimeoutSettings implements Settings
{

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This is the text shown to user via Bootstrap warning dialog after warning period. (modal
	 * title) Default: 'Your session is about to expire!'
	 */
	private final StringTextValue<String> title = new StringTextValue<>("title",
		"Your session is about to expire!", StringTextType.STRING);

	/**
	 * This is the text shown to user via Bootstrap warning dialog after warning period. Default:
	 * 'Your session is about to expire!'
	 */
	private final StringTextValue<String> message = new StringTextValue<>("message",
		"Your session is about to expire!", StringTextType.STRING);

	/**
	 * This is the text shown to user via Bootstrap warning dialog after warning period in the
	 * logout button. Default: 'Logout'
	 */
	private final StringTextValue<String> logoutButton = new StringTextValue<>("logoutButton",
		"Logout", StringTextType.STRING);

	/**
	 * This is the text shown to user via Bootstrap warning dialog after warning period in the Kepp
	 * Alive button. Default: 'Stay Connected'
	 */
	private final StringTextValue<String> keepAliveButton = new StringTextValue<>(
		"keepAliveButton", "Stay Connected", StringTextType.STRING);

	/**
	 * URL to ping via AJAX POST to keep the session alive. This resource should do something
	 * innocuous that would keep the session alive, which will depend on your server-side platform.
	 * Default: '/keep-alive'
	 */
	private final StringTextValue<String> keepAliveUrl = new StringTextValue<>("keepAliveUrl",
		"/keep-alive", StringTextType.STRING);

	/**
	 * If true, the plugin keeps pinging the keepAliveUrl for as long as the user is active. The
	 * time between two pings is set by the keepAliveInterval option. If you have no server-side
	 * session timeout to worry about, feel free to set this one to false to prevent unnecessary
	 * network activity. Default: true
	 */
	private final StringTextValue<Boolean> keepAlive = new StringTextValue<>("keepAlive", true,
		StringTextType.BOOLEAN);

	/**
	 * Time in milliseconds between two keep-alive pings. Default: 5000 (5 seconds)
	 */
	private final StringTextValue<Integer> keepAliveInterval = new StringTextValue<>(
		"keepAliveInterval", 5000, StringTextType.INTEGER);

	/**
	 * If you need to specify the ajax method. Default: 'POST'
	 */
	private final StringTextValue<String> ajaxType = new StringTextValue<>("ajaxType", "POST",
		StringTextType.STRING);

	/**
	 * If you need to send some data via AJAX POST to your keepAliveUrl, you can use this option.
	 * Default: ''
	 */
	private final StringTextValue<String> ajaxData = new StringTextValue<>("ajaxData", "",
		StringTextType.STRING);

	/**
	 * URL to take browser to if no action is take after the warning. Default: '/timed-out'
	 */
	private final StringTextValue<String> redirUrl = new StringTextValue<>("redirUrl",
		"/timed-out", StringTextType.STRING);

	/**
	 * URL to take browser to if user clicks "Logout" on the Bootstrap warning dialog. Default:
	 * '/log-out'
	 */
	private final StringTextValue<String> logoutUrl = new StringTextValue<>("logoutUrl",
		"/log-out", StringTextType.STRING);

	/**
	 * Time in milliseconds after page is opened until warning dialog is opened. Default: 900000 (15
	 * minutes)
	 */
	private final StringTextValue<Integer> warnAfter = new StringTextValue<>("warnAfter", 900000,
		StringTextType.INTEGER);

	/**
	 * Time in milliseconds after page is opened until browser is redirected to redirUrl. Default:
	 * 1200000 (20 minutes)
	 */
	private final StringTextValue<Integer> redirAfter = new StringTextValue<>("redirAfter",
		1200000, StringTextType.INTEGER);

	/**
	 * If true, this will launch the Bootstrap warning dialog / redirect (or callback functions) in
	 * a set amounts of time regardless of user activity. This in turn makes the plugin act much
	 * like the <a
	 * href="https://github.com/maxfierke/jquery-sessionTimeout-bootstrap">jquery-sessionTimeout
	 * -bootstrap</a> by maxfierke plugin. Default: false
	 */
	private final StringTextValue<Boolean> ignoreUserActivity = new StringTextValue<>(
		"ignoreUserActivity", StringTextType.BOOLEAN);

	/**
	 * If true, displays minutes as well as seconds in the countdown timer (e.g. "3m 14s"). Displays
	 * only seconds when timer is under one minute (e.g. "42s"). Default: false
	 */
	private final StringTextValue<Boolean> countdownSmart = new StringTextValue<>("countdownSmart",
		StringTextType.BOOLEAN);

	/**
	 * If you want a custom sentence to appear in the warning dialog with a timer showing the
	 * seconds remaining, use this option. Example: countdownMessage: 'Redirecting in {timer}.'
	 * Place the {timer} string where you want the numeric countdown to appear. Another example:
	 * countdownMessage: '{timer} remaining.'. Can be combined with countdownBar option or used
	 * independently. Note: Type: String or Boolean Default: false
	 */
	private final StringTextValue<String> countdownMessage = new StringTextValue<>(
		"countdownMessage", "false", StringTextType.STRING);

	/**
	 * If true, ads a countdown bar (uses Bootstrap progress bar) to the warning dialog. Can be
	 * combined with countdownMessage option or used independently. Default: false
	 */
	private final StringTextValue<Boolean> countdownBar = new StringTextValue<>("countdownBar",
		StringTextType.BOOLEAN);

	/**
	 * Optional callback fired when first calling the plugin and every time user refreshes the
	 * session (on any mouse, keyboard or touch action). Takes options object as the only argument.
	 * Note: Type: Function or Boolean Default: false
	 */
	private final StringTextValue<String> onStart = new StringTextValue<>("onStart", "false",
		StringTextType.STRING);

	/**
	 * Custom callback you can use instead of showing the Bootstrap warning dialog. Takes options
	 * object as the only argument.
	 * 
	 * Redirect action will still occur unless you also add the onRedir callback. Note: Type:
	 * Function or Boolean Default: false
	 */
	private final StringTextValue<String> onWarn = new StringTextValue<>("onWarn", "false",
		StringTextType.STRING);

	/**
	 * Custom callback you can use instead of redirecting the user to redirUrl. Takes options object
	 * as the only argument. Note: Type: Function or Boolean Default: false
	 */
	private final StringTextValue<String> onRedir = new StringTextValue<>("onRedir", "false",
		StringTextType.STRING);

	@Override
	public Set<StringTextValue<?>> asSet()
	{
		final Set<StringTextValue<?>> allSettings = new HashSet<>();
		allSettings.add(getTitle());
		allSettings.add(getMessage());
		allSettings.add(getLogoutButton());
		allSettings.add(getKeepAliveButton());
		allSettings.add(getKeepAliveUrl());
		allSettings.add(getKeepAlive());
		allSettings.add(getKeepAliveInterval());
		allSettings.add(getAjaxType());
		allSettings.add(getAjaxData());
		allSettings.add(getRedirUrl());
		allSettings.add(getLogoutUrl());
		allSettings.add(getWarnAfter());
		allSettings.add(getRedirAfter());
		allSettings.add(getIgnoreUserActivity());
		allSettings.add(getCountdownSmart());
		allSettings.add(getCountdownMessage());
		allSettings.add(getCountdownBar());
		allSettings.add(getOnStart());
		allSettings.add(getOnWarn());
		allSettings.add(getOnRedir());
		return allSettings;
	}


}
