package com.djd2000.repositories;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.djd2000.domain.UnitOfMeasure;

/**
 * 
 * @author david
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureReposioryIT {

	@Autowired
	UnitOfMeasureReposiory unitOfMeasureReposiry;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void findByDescription() throws Exception {

		Optional<UnitOfMeasure> uomDescription = unitOfMeasureReposiry.findByDescription("Pint");
		assertEquals("Pint", uomDescription.get().getDescription());
	}

}
