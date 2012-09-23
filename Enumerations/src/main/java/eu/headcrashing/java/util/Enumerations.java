package eu.headcrashing.java.util;

/*
 * #%L
 * Enumerations Class
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

import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * This class that provides utilities for {@link Enumeration}s, like wrapping {@link Enumeration}s as {@link Iterable}s.
 * 
 * @author Markus KARG (markus@headcrashing.eu)
 */
public final class Enumerations {
	private Enumerations() {
		// As this is a utility class, no instances shall be made.
	}

	/**
	 * Allows using of {@link Enumeration} with the for-each statement. The implementation is not using any heap space and such is able to serve virtually endless Enumerations, while {@link Collections#list} is limited by available RAM. As a result, this implementation is much faster than Collections.list.
	 * 
	 * @param enumeration
	 *            The original enumeration.
	 * @return An {@link Iterable} directly calling the original Enumeration.
	 */
	public static final <T> Iterable<T> iterable(final Enumeration<T> enumeration) {
		return new Iterable<T>() {
			@Override
			public final Iterator<T> iterator() {
				return new Iterator<T>() {
					@Override
					public final boolean hasNext() {
						return enumeration.hasMoreElements();
					}

					@Override
					public final T next() {
						return enumeration.nextElement();
					}

					/**
					 * This method is not implemented as it is impossible to remove something from an Enumeration.
					 * 
					 * @throws UnsupportedOperationException
					 *             always.
					 */
					@Override
					public final void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}

}
