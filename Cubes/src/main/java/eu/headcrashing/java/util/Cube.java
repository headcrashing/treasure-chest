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
 * A three-dimensional, fixed-sized container.
 * 
 * @param E
 *            The type of values stored in this cube, e. g. {@link Integer}.
 * @author Markus KARG (markus@headcrashing.eu)
 * @version 1.0
 */
public interface Cube<E> {
	/**
	 * @return Cube size, x-dimension.
	 */
	public int getSizeX();

	/**
	 * @return Cube size, y-dimension.
	 */
	public int getSizeY();

	/**
	 * @return Cube size, z-dimension.
	 */
	public int getSizeZ();

	/**
	 * Stores {@code e} at location {@code (x, y, z)}. If the location was not empty before, the previously stored element is removed.
	 * 
	 * @param x
	 *            Location, x-dimension.
	 * @param y
	 *            Location, y-dimension.
	 * @param z
	 *            Location, z-dimension.
	 * @param e
	 *            Element to store.
	 */
	public void put(final int x, final int y, final int z, final E e);

	/**
	 * Retrieves element stored at location {@code (x, y, z)}.
	 * 
	 * @param x
	 *            Location, x-dimension.
	 * @param y
	 *            Location, y-dimension.
	 * @param z
	 *            Location, z-dimension.
	 * @return Element at specified location.
	 */
	public E get(final int x, final int y, final int z);
}