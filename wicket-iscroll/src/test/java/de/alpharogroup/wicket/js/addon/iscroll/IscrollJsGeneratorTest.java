package de.alpharogroup.wicket.js.addon.iscroll;

import org.junit.Test;

public class IscrollJsGeneratorTest
{

	@Test
	public void testIscrollJsGenerator()
	{
		final IscrollSettings iscrollSettings = IscrollSettings.builder().build();
		iscrollSettings.getMouseWheel().setValue(Boolean.TRUE);
		final IscrollJsGenerator iscrollJsGenerator = new IscrollJsGenerator(iscrollSettings,
			"foo-component-id");
		final String result = iscrollJsGenerator.generateJs();

		System.out.println(result);
		System.out.println("================================");
	}

}
