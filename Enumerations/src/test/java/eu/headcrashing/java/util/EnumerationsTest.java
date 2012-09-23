package eu.headcrashing.java.util;

/*
 * #%L
 * Range Class
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2010 - 2012 Head Crashing Informatics
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Enumeration;

import org.junit.Test;

/**
 * Unit test for {@code Enumerations} class.
 * 
 * @author Markus KARG (markus@headcrashing.eu)
 */
public final class EnumerationsTest {

	@Test(expected = IllegalAccessException.class)
	public final void cannotInstantiate() throws InstantiationException, IllegalAccessException {
		Enumerations.class.newInstance();
	}

	@Test
	public final void iterableLoopsCorrectly() {
		final int SIZE = 5;

		final Enumeration<Integer> enumeration = new Enumeration<Integer>() {
			private int i;

			@Override
			public final boolean hasMoreElements() {
				return this.i++ < SIZE;
			}

			@Override
			public final Integer nextElement() {
				return this.i;
			}
		};

		int j = 0;
		for (final int i : Enumerations.iterable(enumeration))
			assertThat(i, is(++j));
		assertThat(j, is(SIZE));
	}

	@Test(expected = UnsupportedOperationException.class)
	public final void iterableDoesNotRemove() {
		Enumerations.iterable(null).iterator().remove();
	}
}
