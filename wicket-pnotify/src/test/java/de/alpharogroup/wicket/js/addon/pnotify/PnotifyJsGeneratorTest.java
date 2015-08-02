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

import org.junit.Test;

/**
 * Unit test class for class PopupoverlayJsGenerator.
 */
public class PnotifyJsGeneratorTest
{
	@Test
	public void testGenerator()
	{
		final PnotifySettings pnotifySettings = PnotifySettings.builder().build();
		pnotifySettings.getTitle().setValue("Test title");
		pnotifySettings.getText().setValue("a text");

		final PnotifyJsGenerator pnotifyJsGenerator = new PnotifyJsGenerator(pnotifySettings);
		String result = pnotifyJsGenerator.generateJs();

		System.out.println(result);
		System.out.println("================================");

		final StackSettings stackSettings = new StackSettings();
		stackSettings.getDir2().setValue("right");
		pnotifySettings.getStack().setValue(stackSettings.asJavascriptArray());

		result = pnotifyJsGenerator.generateJs();

		System.out.println(result);
	}
}
