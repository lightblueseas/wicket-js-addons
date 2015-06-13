package de.alpharogroup.wicket.js.addon.popupoverlay;

import org.junit.Test;

/**
 * Unit test class for class PopupoverlayJsGenerator.
 */
public class PopupoverlayJsGeneratorTest
{
	@Test
	public void testGenerator()
	{
		PopupoverlaySettings popupoverlaySettings = PopupoverlaySettings.builder().build();
		popupoverlaySettings.getEscape().setValue(false);
		popupoverlaySettings.getFocusdelay().setValue(400);
		popupoverlaySettings.getHorizontal().setValue(HorizontalPosition.LEFT);
		PopupoverlayJsGenerator generator = new PopupoverlayJsGenerator(popupoverlaySettings,
			"aComponent");
		generator.setComponentId("aComponent");
		String result = generator.generateJs();

		System.out.println(result);
		System.out.println("=======================");
		
		generator = new PopupoverlayJsGenerator(popupoverlaySettings,
			"aComponent", false);
		generator.setComponentId("aComponent");
		result = generator.generateJs();

		System.out.println(result);
	}
}