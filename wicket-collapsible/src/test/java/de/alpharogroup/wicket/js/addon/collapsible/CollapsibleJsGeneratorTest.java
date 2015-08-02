package de.alpharogroup.wicket.js.addon.collapsible;

import org.junit.Test;

public class CollapsibleJsGeneratorTest
{

	@Test
	public void testCollapsibleJsGenerator()
	{
		final CollapsibleSettings settings = CollapsibleSettings.builder().build();
		settings.getAccordionDownSpeed().setValue(300);

		final CollapsibleJsGenerator generator = new CollapsibleJsGenerator(settings, "foo");
		final String result = generator.generateJs();
		System.out.println(result);
	}

}
