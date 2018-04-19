package com.mercury.SpringBootRestDemo.Dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import com.mercury.SpringBootRestDemo.bean.Product;
import com.mercury.SpringBootRestDemo.dao.ProductDao;
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductDaoTest {
	@Autowired
	TestEntityManager entityManager;//Jpa == session in hibernate
	@Autowired
	ProductDao productDao;
	@Test
	public void test() {
		fail("Not yet implemented");
		Product product = new Product("Test", "Test", 88, 888,"Test");
		entityManager.persist(product);
		entityManager.flush();	
		Product p = productDao.findOne(Example.of(product)).get();
		assertThat(p.getName()).isEqualTo(product.getName());
		System.out.println(p);
	}
	
}
