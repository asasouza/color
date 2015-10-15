import static org.junit.Assert.*;

import org.junit.Test;


public class CorTeste {

	@Test
	public void insereCorRGB(){
		Cor cor = Cor.novaCorRGB(255, 255, 255);
		assertEquals("255, 255, 255", cor.getColorRGB());
	}
	
	@Test
	public void insereCorCMYK(){
		Cor cor = Cor.novaCorCMYK(1, 0, 1, 0);
		assertEquals("1.0, 0.0, 1.0, 0.0", cor.getColorCMYK());
	}
	
	@Test
	public void insereCorHexadecimal(){
		Cor cor = Cor.novaCorHexadecimal("#f5f5f5");
		assertEquals("#f5f5f5", cor.getColorHexadecimal());
	}
	
	@Test
	public void converteCorRGBparaCMYK(){
		Cor cor = Cor.novaCorRGB(255, 255, 255);
		assertEquals("0.0, 0.0, 0.0, 0.0", cor.getColorCMYK());

	}

	@Test
	public void converteCorCMYKparaRGB(){
		Cor cor = Cor.novaCorCMYK(1, 0, 1, 0);
		assertEquals("0, 255, 0", cor.getColorRGB());
	}
	
	@Test
	public void converteCorHexadecimalparaRGB(){
		Cor cor = Cor.novaCorHexadecimal("#000000");
		assertEquals("0, 0, 0", cor.getColorRGB());
	}
	
	@Test
	public void converteCorHexadecimalparaCMYK(){
		Cor cor = Cor.novaCorHexadecimal("#000000");
		assertEquals("0.0, 0.0, 0.0, 1.0", cor.getColorCMYK(), 0.00005);
	}
	
	@Test
	public void converteCorRGBparaHexadecimal(){
		Cor cor = Cor.novaCorRGB(255, 255, 255);
		assertEquals("#ffffff", cor.getColorHexadecimal());
		}

}
