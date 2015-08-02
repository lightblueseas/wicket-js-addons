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

import org.junit.Test;

/**
 * Unit test class for class SpinJsGenerator.
 */
public class SpinJsGeneratorTest
{

	@Test
	public void testGenerator()
	{
		final SpinSettings spinSettings = SpinSettings.builder().build();
		spinSettings.getClassName().setValue("fancy");
		spinSettings.getTop().setValue("3");
		final SpinJsGenerator generator = new SpinJsGenerator(spinSettings, "aComponent");
		final String result = generator.generateJs();
		System.out.println(result);
	}
}
