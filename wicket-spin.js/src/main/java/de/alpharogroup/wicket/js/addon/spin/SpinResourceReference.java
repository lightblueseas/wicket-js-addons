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
package de.alpharogroup.wicket.js.addon.spin;

import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * The class {@link SpinResourceReference} holds the references(js) for the spin js library.
 */
public class SpinResourceReference extends JavaScriptResourceReference
{

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private static final SpinResourceReference INSTANCE = new SpinResourceReference();

	public static SpinResourceReference get()
	{
		return INSTANCE;
	}

	private SpinResourceReference()
	{
		super(SpinResourceReference.class, "spin.min.js");
	}
}
