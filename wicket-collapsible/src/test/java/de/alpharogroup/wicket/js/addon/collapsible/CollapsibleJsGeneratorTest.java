package de.alpharogroup.wicket.js.addon.collapsible;

import org.junit.Test;

public class CollapsibleJsGeneratorTest
{

	@Test
	public void testCollapsibleJsGenerator()
	{
		CollapsibleSettings settings = CollapsibleSettings.builder().build();
		settings.getAccordionDownSpeed().setValue(300);
		
		CollapsibleJsGenerator generator = new CollapsibleJsGenerator(settings, "foo");
		String result = generator.generateJs();
		System.out.println(result);
	}

}
