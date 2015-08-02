package de.alpharogroup.wicket.js.addon.sessiontimeout;

import org.junit.Test;

public class SessionTimeoutJsGeneratorTest
{

	@Test
	public void testGenerator()
	{
		final SessionTimeoutSettings settings = SessionTimeoutSettings.builder().build();
		settings.getTitle().setValue("abla session is abe to out;-)");
		settings.getMessage().setValue("!!! session timeout !!!");
		final SessionTimeoutJsGenerator generator = new SessionTimeoutJsGenerator(settings);

		final String result = generator.generateJs();
		System.out.println(result);
	}

}
