package de.alpharogroup.wicket.js.addon.collapse;

import org.junit.Test;

public class CollapseJsGeneratorTest {

	@Test
	public void testCollapsibleJsGenerator() {
		final CollapseSettings settings = CollapseSettings.builder().build();
		settings.getAccordion().setValue(Boolean.TRUE);

		final CollapseJsGenerator generator = new CollapseJsGenerator(settings, "foo");
		final String result = generator.generateJs();
		System.out.println(result);
	}

}
