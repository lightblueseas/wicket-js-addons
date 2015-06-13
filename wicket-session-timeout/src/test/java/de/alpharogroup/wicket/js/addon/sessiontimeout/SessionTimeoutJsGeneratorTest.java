package de.alpharogroup.wicket.js.addon.sessiontimeout;

import org.junit.Test;

public class SessionTimeoutJsGeneratorTest
{

	@Test
	public void testGenerator()
	{
		SessionTimeoutSettings settings = SessionTimeoutSettings.builder().build();
		settings.getTitle().setValue("abla session is abe to out;-)");
		settings.getMessage().setValue("!!! session timeout !!!");
		SessionTimeoutJsGenerator generator = new SessionTimeoutJsGenerator(settings);
		
		String result = generator.generateJs();
		System.out.println(result);
	}

}
