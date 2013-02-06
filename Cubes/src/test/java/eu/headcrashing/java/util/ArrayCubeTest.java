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
 * Unit test for {@code HashCube} class.
 * 
 * @author Markus KARG (markus@headcrashing.eu)
 */
public final class ArrayCubeTest extends AbstractCubeTest {
	@Override
	protected Cube<Integer> buildCube(final int sizeX, final int sizeY, final int sizeZ) {
		return new ArrayCube<>(sizeX, sizeY, sizeZ);
	}
}
