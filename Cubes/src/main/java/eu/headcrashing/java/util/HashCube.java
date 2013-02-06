package eu.headcrashing.java.util;

import java.util.HashMap;

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
 * A {@link Cube} which uses a hash map as its backing store.
 * 
 * Memory consumption is linearly dependent of the actual filling level, so it is more or less independent of the capacity. This makes it a good choice for scenarios where only few objects have to be stored in a rather large coordinate system. Access time is rather slow compared to e. g. a real arrays, but constant, i.
 * e. it does not scale with the actual filling level. This class is not thread-safe.
 * 
 * @param E
 *            The type of values stored in this cube, e. g. {@link Integer}.
 * @author Markus KARG (markus@headcrashing.eu)
 * @version 1.0
 */
public final class HashCube<E> extends AbstractCube<E, HashMap<HashCube<E>.XYZ, E>> {
	protected final class XYZ {
		private final int x;
		private final int y;
		private final int z;

		public XYZ(final int x, final int y, final int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public final int hashCode() {
			return this.x * HashCube.this.getSizeY() * HashCube.this.getSizeZ() + this.y * HashCube.this.getSizeZ() + this.z;
		}

		@Override
		public final boolean equals(final Object other) {
			if (this == other)
				return true;

			if (!(other instanceof HashCube.XYZ))
				return false;

			@SuppressWarnings("unchecked")
			final XYZ that = (XYZ) other;

			return this.x == that.x && this.y == that.y && this.z == that.z;
		}
	}

	/**
	 * Creates a hash cube with the specified size.
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
	public HashCube(final int sizeX, final int sizeY, final int sizeZ) throws IllegalArgumentException {
		super(sizeX, sizeY, sizeZ, new HashMap<XYZ, E>(sizeX * sizeY * sizeZ, 0.0001f));
	}

	@Override
	public final void put(final int x, final int y, final int z, final E e) {
		this.getElementData().put(new XYZ(x, y, z), e);
	}

	@Override
	public final E get(final int x, final int y, final int z) {
		return this.getElementData().get(new XYZ(x, y, z));
	}
}