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
package de.alpharogroup.wicket.js.addon.pnotify;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.resource.JQueryPluginResourceReference;

/**
 * A JavaScript reference that loads the JavaScript resources needed by JQuery UI components.
 */
public class PnotifyJsReference extends JQueryPluginResourceReference
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public static final PnotifyJsReference INSTANCE = new PnotifyJsReference();

	private PnotifyJsReference()
	{
		super(PnotifyJsReference.class, "pnotify.custom.min.js");
	}

	@Override
	public List<HeaderItem> getDependencies()
	{
		List<HeaderItem> deps = new ArrayList<HeaderItem>();
		for (HeaderItem dep : super.getDependencies())
		{
			deps.add(dep);
		}
		deps.add(CssHeaderItem.forReference(PnotifyCssReference.INSTANCE));
		return deps;
	}
}
