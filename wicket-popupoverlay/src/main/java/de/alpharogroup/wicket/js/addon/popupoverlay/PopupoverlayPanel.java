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
package de.alpharogroup.wicket.js.addon.popupoverlay;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

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

import lombok.Getter;

/**
 * The Class PopupoverlayPanel is production ready and is also an example how to use the
 * {@link PopupoverlayBehavior}.
 *
 * @param <T>
 *            the generic type of the model.
 */
public abstract class PopupoverlayPanel<T> extends GenericPanel<T>
{

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;
	public static final String OPEN_OVERLAY_SUFFIX = "_open";
	public static final String CLOSE_OVERLAY_SUFFIX = "_close";

	/**
	 * The overlay reference.
	 */
	@Getter
	private MarkupContainer overlayReference;

	/**
	 * The open button.
	 */
	@Getter
	private Button openButton;

	/**
	 * Instantiates a new popupoverlay panel.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 */
	public PopupoverlayPanel(final String id, final IModel<T> model)
	{
		super(id, model);
	}

	/**
	 * Factory method for create the Button. This method is invoked in the method
	 * {@link Component#onBeforeRender()} from the derived classes and can be overridden so users
	 * can provide their own version of a Button.
	 *
	 * @param id
	 *            the wicket id
	 * @return the Button
	 */
	protected Button newOpenButton(final String id)
	{
		return new Button(id);
	}

	/**
	 * Abstract factory method for create the new overlay reference MarkupContainer. This method is
	 * invoked in the method {@link Component#onBeforeRender()} from the derived classes and must be
	 * overridden so users can provide their own version of the overlay component.
	 *
	 * Note: If you have in your settings the attribute 'blur' set to false than you have to provide
	 * a close component. As from the documentation of the popupoverlay plugin this component have
	 * to provide the class attribute with the value 'overlayReference.getMarkupId() + "_close"'.
	 *
	 * For instance:
	 *
	 * <pre>
	 * Button button = new Button(&quot;button&quot;);
	 * getOverlayReference().add(button);
	 * // add class attributte with the markup id from the overlay with the
	 * // suffix '_close' that indicates that the overlay shell close...
	 * button.add(new AttributeModifier(&quot;class&quot;, getOverlayReference().getMarkupId() + &quot;_close&quot;));
	 * </pre>
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return the markup container
	 */
	protected abstract MarkupContainer newOverlayReference(final String id, final IModel<T> model);

	/**
	 * Factory method for create the {@link PopupoverlayBehavior}. This method is invoked in the
	 * method {@link Component#onBeforeRender()} from the derived classes and can be overridden so
	 * users can provide their own version of the {@link PopupoverlayBehavior}.
	 *
	 * @return the popupoverlay behavior
	 */
	protected PopupoverlayBehavior newPopupoverlayBehavior()
	{
		return new PopupoverlayBehavior(newPopupoverlaySettings());
	}

	/**
	 * Factory method for create the {@link PopupoverlaySettings}. This method is invoked in the
	 * method {@link #newPopupoverlayBehavior()} from the derived classes and can be overridden so
	 * users can provide their own version of the {@link PopupoverlaySettings}.
	 *
	 * @return the {@link PopupoverlaySettings}.
	 */
	protected PopupoverlaySettings newPopupoverlaySettings()
	{
		final PopupoverlaySettings settings = PopupoverlaySettings.builder().build();
		return settings;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onBeforeRender()
	{


		addOrReplace(overlayReference = newOverlayReference("overlayReference", getModel()));
		overlayReference.add(newPopupoverlayBehavior());
		overlayReference.setOutputMarkupId(true);

		addOrReplace(openButton = newOpenButton("openButton"));
		// add class attributte with the markup id from the overlay with the
		// suffix '_open' that indicates that the overlay shell open...
		openButton.add(new AttributeAppender("class",
			" " + overlayReference.getMarkupId() + OPEN_OVERLAY_SUFFIX));
		super.onBeforeRender();
	}

}
