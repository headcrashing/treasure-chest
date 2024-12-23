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

/**
 * A range is defined by a begin and an end. It allows checking whether a value is within the range or outside. A range can be open at one or both ends, i. e. the range is assumed to be endless in that direction.
 * 
 * @param T
 *            The type of values covered by this range, e. g. {@link Integer}.
 * @param lowerBound
 *            The lowest possible value of the range, or {@code null} if there is no lower bound.
 * @param upperBound
 *            The greatest possible value of the range, or {@code null} if there is no upper bound.
 * @author Markus KARG (markus@headcrashing.eu)
 * @version 2.0.0
 */
public final record Range<T extends Comparable<T>>(T lowerBound, T upperBound) {

	/**
	 * Creates a range with the specified bounds. The bounds will be included, i. e. are part of the range. Bounds can be declared as being open, i. e. the range is assumed to be endless in that direction.
	 * 
	 * @throws IllegalArgumentException
	 *             if lower bound is greater than upper bound
	 */
	public Range {
		if (lowerBound != null && upperBound != null && lowerBound.compareTo(upperBound) > 0)
			throw new IllegalArgumentException("lowerBound is greater than upperBound");
	}

	/**
	 * Checks whether the specified object is within the range, including bounds.
	 * 
	 * @param object
	 *            The object to be checked. Must not be {@code null}.
	 * @return {@code false} if {@code object} is lower than the lower bound or greater than the upper bound; otherwise {@code true}.
	 * @throws IllegalArgumentException
	 *             if {@code object} is {@code null}.
	 */
	public final boolean contains(final T object) throws IllegalArgumentException {
		if (object == null)
			throw new IllegalArgumentException("object is null");

		if (this.lowerBound != null && object.compareTo(this.lowerBound) < 0)
			return false;

		if (this.upperBound != null && object.compareTo(this.upperBound) > 0)
			return false;

		return true;
	}

	/**
	 * Checks whether the specified range is entirely contained in the range, including bounds.
	 * 
	 * @param range
	 *            The range to be checked. Must not be {@code null}.
	 * @return {@code false} if {@code range} has a lower bound lower than the lower bound of this or an upper bound greater than the upper bound of this (i. e. {@code other} overlaps or is completely outside); otherwise {@code true}.
	 * @throws IllegalArgumentException
	 *             if {@code other} is {@code null}.
	 * @since 1.1.0
	 */
	public final boolean contains(final Range<T> range) throws IllegalArgumentException {
		if (range == null)
			throw new IllegalArgumentException("range is null");

		if (this.lowerBound != null && (range.lowerBound == null || range.lowerBound.compareTo(this.lowerBound) < 0))
			return false;

		if (this.upperBound != null && (range.upperBound == null || range.upperBound.compareTo(this.upperBound) > 0))
			return false;

		return true;
	}

	/**
	 * Checks whether the specified range overlaps this range (i. e. whether the ranges intersect).
	 * 
	 * @param range
	 *            The {@code range} to be checked. Must not be {@code null}.
	 * @return {@code false} if {@code range} has an upper bound lower than the lower bound of this or a lower bound greater than the upper bound of this; otherwise {@code true}.
	 * @throws IllegalArgumentException
	 *             if {@code range} is {@code null}.
	 * @since 1.2.0
	 */
	public final boolean overlaps(final Range<T> range) throws IllegalArgumentException {
		if (range == null)
			throw new IllegalArgumentException("range is null");

		if (this.upperBound != null && range.lowerBound != null && this.upperBound.compareTo(range.lowerBound) < 0)
			return false;

		if (this.lowerBound != null && range.upperBound != null && this.lowerBound.compareTo(range.upperBound) > 0)
			return false;

		return true;
	}

}
