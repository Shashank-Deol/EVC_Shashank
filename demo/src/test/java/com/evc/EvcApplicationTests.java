package com.evc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EvcApplicationTests {

	@Test
	public void main() {
		Application.main(new String[] {});
	}
}
