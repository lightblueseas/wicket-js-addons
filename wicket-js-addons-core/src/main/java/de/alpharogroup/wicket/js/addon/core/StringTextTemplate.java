/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.wicket.js.addon.core;

import java.io.IOException;
import java.util.Map;

import org.apache.wicket.util.io.Streams;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.ResourceStreamNotFoundException;
import org.apache.wicket.util.resource.StringResourceStream;
import org.apache.wicket.util.string.interpolator.MapVariableInterpolator;
import org.apache.wicket.util.template.TextTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A {@link TextTemplate} that is build from a String.
 */
public class StringTextTemplate extends TextTemplate
{

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** The LOGGER. */
	static final Logger LOGGER = LoggerFactory.getLogger(StringTextTemplate.class.getName());

	/** The content of this template. */
	private final StringBuilder buffer = new StringBuilder();

	/**
	 * Creates a new instance of a {@link StringTextTemplate}.
	 * 
	 * @param content
	 *            The content of the template.
	 */
	public StringTextTemplate(final String content)
	{
		this(content, "text", "UTF-8");
	}

	/**
	 * Creates a new instance of a {@link StringTextTemplate}.
	 * 
	 * @param content
	 *            The content of the template.
	 * @param contentType
	 *            The content type.
	 * @param encoding
	 *            the file's encoding
	 */
	public StringTextTemplate(final String content, final String contentType, final String encoding)
	{
		super(contentType);
		final IResourceStream stream = new StringResourceStream(content, getContentType());
		try
		{
			if (encoding != null)
			{
				buffer.append(Streams.readString(stream.getInputStream(), encoding));
			}
			else
			{
				buffer.append(Streams.readString(stream.getInputStream()));
			}
		}
		catch (final IOException e)
		{
			throw new RuntimeException(e);
		}
		catch (final ResourceStreamNotFoundException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			try
			{
				stream.close();
			}
			catch (final IOException e)
			{
				LOGGER.error("" + e.getMessage(), e);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getString()
	{
		return buffer.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TextTemplate interpolate(final Map<String, ?> variables)
	{
		if (variables != null)
		{
			final String result = new MapVariableInterpolator(buffer.toString(), variables)
				.toString();
			buffer.delete(0, buffer.length());
			buffer.append(result);
		}
		return this;
	}
}
