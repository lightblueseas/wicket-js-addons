/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.wicket.js.addon.toastr;

import java.util.HashSet;
import java.util.Set;

import de.alpharogroup.wicket.js.addon.core.Settings;
import de.alpharogroup.wicket.js.addon.core.StringTextType;
import de.alpharogroup.wicket.js.addon.core.StringTextValue;
import de.alpharogroup.wicket.js.addon.enums.Easing;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This class encapsulates various settings for the toastr jquery plugin. See the documentation for
 * the jquery toastr plugin for further information.
 */
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class ToastrSettings implements Settings
{

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Shows a close button if true. Default: false
	 */
	private final StringTextValue<Boolean> closeButton = new StringTextValue<>(
		"toastr.options.closeButton", StringTextType.BOOLEAN);


	/**
	 * Shows a debug messages if true. Default: false
	 */
	private final StringTextValue<Boolean> debug = new StringTextValue<>("toastr.options.debug",
		StringTextType.BOOLEAN);

	/**
	 * Shows the newest notification if true. Default: false
	 */
	private final StringTextValue<Boolean> newestOnTop = new StringTextValue<>(
		"toastr.options.newestOnTop", StringTextType.BOOLEAN);

	/**
	 * Shows a progress bar if true. Default: false
	 */
	private final StringTextValue<Boolean> progressBar = new StringTextValue<>(
		"toastr.options.progressBar", StringTextType.BOOLEAN);

	/**
	 * The position where to show the notifications. Default: toast-top-center
	 */
	private final StringTextValue<Position> positionClass = new StringTextValue<>(
		"toastr.options.positionClass", Position.TOP_CENTER, StringTextType.ENUM);

	/**
	 * If true duplicate notifications will be prevent. Default: false
	 */
	private final StringTextValue<Boolean> preventDuplicates = new StringTextValue<>(
		"toastr.options.preventDuplicates", StringTextType.BOOLEAN);

	/**
	 * Document please. Default: false
	 */
	private final StringTextValue<Boolean> tapToDismiss = new StringTextValue<>(
		"toastr.options.tapToDismiss", StringTextType.BOOLEAN);

	/**
	 * on click. Default: null
	 */
	private final StringTextValue<String> onclick = new StringTextValue<>("toastr.options.onclick",
		StringTextType.STRING);

	/**
	 * The duration to show. Default: 300
	 */
	private final StringTextValue<Integer> showDuration = new StringTextValue<>(
		"toastr.options.showDuration", 300, StringTextType.INTEGER);

	/**
	 * The duration to hide. Default: 1000
	 */
	private final StringTextValue<Integer> hideDuration = new StringTextValue<>(
		"toastr.options.hideDuration", 1000, StringTextType.INTEGER);

	/**
	 * The timeOut. Default: 5000
	 */
	private final StringTextValue<Integer> timeOut = new StringTextValue<>("toastr.options.timeOut",
		5000, StringTextType.INTEGER);

	/**
	 * The extended timeOut. Default: 1000
	 */
	private final StringTextValue<Integer> extendedTimeOut = new StringTextValue<>(
		"toastr.options.extendedTimeOut", 1000, StringTextType.INTEGER);

	/**
	 * The value of the easing when show. Default: swing
	 */
	private final StringTextValue<Easing> showEasing = new StringTextValue<>(
		"toastr.options.showEasing", Easing.SWING, StringTextType.ENUM);

	/**
	 * The value of the easing when hide. Default: linear
	 */
	private final StringTextValue<Easing> hideEasing = new StringTextValue<>(
		"toastr.options.hideEasing", Easing.LINEAR, StringTextType.ENUM);

	/**
	 * The method when show. Default: fadeIn
	 */
	private final StringTextValue<ShowMethod> showMethod = new StringTextValue<>(
		"toastr.options.showMethod", ShowMethod.FADE_IN, StringTextType.ENUM);

	/**
	 * The method when hide. Default: fadeOut
	 */
	private final StringTextValue<HideMethod> hideMethod = new StringTextValue<>(
		"toastr.options.hideMethod", HideMethod.FADE_OUT, StringTextType.ENUM);

	/**
	 * The type of the notification. Default: success
	 */
	private final StringTextValue<ToastrType> toastrType = new StringTextValue<>(
		"toastr.options.toastrType", ToastrType.SUCCESS, StringTextType.ENUM);

	/**
	 * The content of the notification. Default: null
	 */
	private final StringTextValue<String> notificationContent = new StringTextValue<>(
		"toastr.options.notificationContent", StringTextType.STRING);

	/**
	 * The title of the notification. Default: null
	 */
	private final StringTextValue<String> notificationTitle = new StringTextValue<>(
		"toastr.options.notificationTitle", StringTextType.STRING);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<StringTextValue<?>> asSet()
	{
		final Set<StringTextValue<?>> allSettings = new HashSet<>();
		allSettings.add(getCloseButton());
		allSettings.add(getDebug());
		allSettings.add(getExtendedTimeOut());
		allSettings.add(getHideDuration());
		allSettings.add(getHideEasing());
		allSettings.add(getHideMethod());
		allSettings.add(getNewestOnTop());
		allSettings.add(getOnclick());
		allSettings.add(getPositionClass());
		allSettings.add(getPreventDuplicates());
		allSettings.add(getProgressBar());
		allSettings.add(getShowDuration());
		allSettings.add(getShowEasing());
		allSettings.add(getShowMethod());
		allSettings.add(getTapToDismiss());
		allSettings.add(getTimeOut());
		allSettings.add(getToastrType());
		return allSettings;
	}
}
