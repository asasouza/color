import static org.junit.Assert.*;

import org.junit.Test;

public class CorTeste {

	private Cor cor;

	@Test
	public void insereCorRGB() {
		cor = Cor.novaCorRGB(255, 255, 255);
		assertEquals("255, 255, 255", cor.getColorRGB());
	}

	@Test
	public void insereCorCMYK() {
		cor = Cor.novaCorCMYK(0, 0, 0, 1);
		assertEquals("0.0, 0.0, 0.0, 1.0", cor.getColorCMYK());
	}

	@Test
	public void insereCorHexadecimal() {
		cor = Cor.novaCorHexadecimal("#000000");
		assertEquals("#000000", cor.getColorHexadecimal());
	}

	@Test
	public void converteCorRGBparaCMYK() {
		cor = Cor.novaCorRGB(0, 0, 0);
		assertEquals("0.0, 0.0, 0.0, 1.0", cor.getColorCMYK());

	}

	@Test
	public void converteCorRGBparaHexadecimal() {
		cor = Cor.novaCorRGB(0, 0, 0);
		assertEquals("#000000", cor.getColorHexadecimal());
	}

	@Test
	public void converteCorCMYKparaRGB() {
		cor = Cor.novaCorCMYK(0, 0, 0, 1);
		assertEquals("0, 0, 0", cor.getColorRGB());
	}

	@Test
	public void converteCorCMYKparaHexadecimal() {
		cor = Cor.novaCorCMYK(0, 0, 0, 1);
		assertEquals("#000000", cor.getColorHexadecimal());
	}

	@Test
	public void converteCorHexadecimalparaRGB() {
		cor = Cor.novaCorHexadecimal("#000000");
		assertEquals("0, 0, 0", cor.getColorRGB());
	}

	@Test
	public void converteCorHexadecimalparaCMYK() {
		cor = Cor.novaCorHexadecimal("#000000");
		assertEquals("0.0, 0.0, 0.0, 1.0", cor.getColorCMYK());
	}

}
