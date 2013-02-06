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

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Abstract unit test for {@link Cube} instances.
 * 
 * @author Markus KARG (markus@headcrashing.eu)
 */
public abstract class AbstractCubeTest {
	@Test(expected = Exception.class)
	public final void shallRejectNegativeSizeX() {
		this.buildCube(-1, 0, 0);
	}

	@Test(expected = Exception.class)
	public final void shallRejectNegativeSizeY() {
		this.buildCube(0, -1, 0);
	}

	@Test(expected = Exception.class)
	public final void shallRejectNegativeSizeZ() {
		this.buildCube(0, 0, -1);
	}

	@Test
	public final void canCreateNullInstance() {
		this.buildCube(0, 0, 0);
	}

	@Test
	public final void shallReturnGetFromPut() {
		final Cube<Integer> cube = filled(this.buildCube(2, 2, 2));
		for (int x = 0; x < cube.getSizeX(); x++)
			for (int y = 0; y < cube.getSizeY(); y++)
				for (int z = 0; z < cube.getSizeZ(); z++)
					assertEquals(x * cube.getSizeY() * cube.getSizeZ() + y * cube.getSizeZ() + z, cube.get(x, y, z).intValue());
	}

	protected abstract Cube<Integer> buildCube(final int sizeX, final int sizeY, final int sizeZ);

	private static final Cube<Integer> filled(final Cube<Integer> cube) {
		for (int x = 0; x < cube.getSizeX(); x++)
			for (int y = 0; y < cube.getSizeY(); y++)
				for (int z = 0; z < cube.getSizeZ(); z++)
					cube.put(x, y, z, x * cube.getSizeY() * cube.getSizeZ() + y * cube.getSizeZ() + z);
		return cube;
	}

	@Test
	public final void shallImplementToString() {
		final Cube<Integer> cube = filled(this.buildCube(2, 2, 2));
		assertEquals(
				format("%s[[(0, 0, 0) = 0][(0, 0, 1) = 1][(0, 1, 0) = 2][(0, 1, 1) = 3][(1, 0, 0) = 4][(1, 0, 1) = 5][(1, 1, 0) = 6][(1, 1, 1) = 7]]", cube
						.getClass().getSimpleName()), cube.toString());
	}
}
