package com.djd2000.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	private static final long _4L = 4L;
	Category category;

	@Before
	public void setUp() {
		category = new Category();
	}

	@Test
	public void testGetId() {
		category.setId(_4L);

		assertEquals(4L, category.getId(), 0);
	}

	@Test
	public void testGetDescription() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetRecipies() {
		fail("Not yet implemented"); // TODO
	}

}
