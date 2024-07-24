package com.example.LibraryManagementSystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class LibraryManagementSystemApplicationTests {

	@Test
	void contextLoads() {
		assertTrue(true);
	}
    @Test
	void mainTest()
	{
		LibraryManagementSystemApplication.main(new String[] {});
		assertTrue(true);
	}
}
