package eu.headcrashing.java.util;

import static java.lang.String.format;

/*
 * #%L
 * Cubes
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2013 Head Crashing Informatics
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
 * Abstract implementation of {@link Cube}.
 * 
 * @param E
 *            The type of values stored in this cube, e. g. {@link Integer}.
 * @param F
 *            The type of the backing store.
 * @author Markus KARG (markus@headcrashing.eu)
 * @version 1.0
 */
public abstract class AbstractCube<E, F> implements Cube<E> {
	private final F elementData;
	private final int sizeX;
	private final int sizeY;
	private final int sizeZ;

	/**
	 * Creates a cube with the specified size.
	 * 
	 * @param sizeX
	 *            The size in x-direction. Must not be negative.
	 * @param sizeY
	 *            The size in x-direction. Must not be negative.
	 * @param sizeZ
	 *            The size in x-direction. Must not be negative.
	 * @param elementData
	 *            The backing store. Must not be {@code null}.
	 * @throws IllegalArgumentException
	 *             if any of the sizes is negative
	 */
	public AbstractCube(final int sizeX, final int sizeY, final int sizeZ, final F elementData) throws IllegalArgumentException {
		if (sizeX < 0)
			throw new IllegalArgumentException("sizeX must not be negative");
		if (sizeY < 0)
			throw new IllegalArgumentException("sizeY must not be negative");
		if (sizeZ < 0)
			throw new IllegalArgumentException("sizeZ must not be negative");
		assert elementData != null;
		this.elementData = elementData;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.sizeZ = sizeZ;
	}

	@Override
	public final int hashCode() {
		return this.elementData.hashCode();
	}

	@Override
	public final boolean equals(final Object other) {
		if (!(other instanceof AbstractCube))
			return false;

		@SuppressWarnings("unchecked")
		final AbstractCube<E, F> that = (AbstractCube<E, F>) other;

		return this.elementData.equals(that.elementData);
	}

	@Override
	public final String toString() {
		final StringBuilder content = new StringBuilder();
		for (int x = 0; x < this.sizeX; x++)
			for (int y = 0; y < this.sizeY; y++)
				for (int z = 0; z < this.sizeZ; z++)
					content.append(format("[(%d, %d, %d) = %s]", x, y, z, this.get(x, y, z)));
		return String.format("%s[%s]", this.getClass().getSimpleName(), content);
	}

	protected final F getElementData() {
		return this.elementData;
	}

	@Override
	public final int getSizeX() {
		return this.sizeX;
	}

	@Override
	public final int getSizeY() {
		return this.sizeY;
	}

	@Override
	public final int getSizeZ() {
		return this.sizeZ;
	}
}