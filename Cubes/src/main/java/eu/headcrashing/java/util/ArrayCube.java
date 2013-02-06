package eu.headcrashing.java.util;

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
 * A {@link Cube} which uses an array as its backing store.
 * 
 * Memory consumption is linearly dependent of the capacity, but static regarding the actual filling level. Access time is static and faster than other backing stores. This makes it a good choice for scenarios with a rather small coordinate system but high filling level. This class is not thread safe.
 * 
 * @param E
 *            The type of values stored in this cube, e. g. {@link Integer}.
 * @author Markus KARG (markus@headcrashing.eu)
 * @version 1.0
 */
public final class ArrayCube<E> extends AbstractCube<E, E[][][]> {
	/**
	 * Creates an array cube with the specified size.
	 * 
	 * @param sizeX
	 *            The size in x-direction. Must not be negative.
	 * @param sizeY
	 *            The size in y-direction. Must not be negative.
	 * @param sizeZ
	 *            The size in z-direction. Must not be negative.
	 * @throws IllegalArgumentException
	 *             if any of the sizes is negative
	 */
	@SuppressWarnings("unchecked")
	public ArrayCube(final int sizeX, final int sizeY, final int sizeZ) throws IllegalArgumentException {
		super(sizeX, sizeY, sizeZ, (E[][][]) new Object[sizeX][sizeY][sizeZ]);
	}

	@Override
	public final void put(final int x, final int y, final int z, final E e) {
		this.getElementData()[x][y][z] = e;
	}

	@Override
	public final E get(final int x, final int y, final int z) {
		return this.getElementData()[x][y][z];
	}
}