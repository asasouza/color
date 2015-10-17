public class Cor {

	private Integer r, g, b;
	private Double c, m, y, k;
	private String hexadecimal;

	private Cor() {

	}

	public static Cor novaCorRGB(int r, int g, int b) {
		Cor novaCor = new Cor();
		novaCor.r = r;
		novaCor.g = g;
		novaCor.b = b;
		return novaCor;
	}

	public static Cor novaCorCMYK(double c, double m, double y, double k) {
		Cor novaCor = new Cor();
		novaCor.c = c;
		novaCor.m = m;
		novaCor.y = y;
		novaCor.k = k;

		return novaCor;
	}

	public static Cor novaCorHexadecimal(String hexadecimal) {
		Cor novaCor = new Cor();
		novaCor.hexadecimal = hexadecimal;
		return novaCor;
	}

	public String getColorRGB() {
		if (r != null && g != null && b != null) {
			return r + ", " + g + ", " + b;
		} else {
			if (c != null && m != null && y != null && k != null) {
				return CMYKToRGB(this);
			} else {
				if (hexadecimal != null) {
					return HexadecimalToRGB(this);
				}
			}
		}
		return null;
	}

	public String getColorCMYK() {
		if (c != null && m != null && y != null && k != null) {
			return c + ", " + m + ", " + y + ", " + k;
		} else {
			if (r != null && g != null && b != null) {
				return RGBToCMYK(this);
			} else {
				if (hexadecimal != null) {
					return HexadecimalToCMYK(this);
				}
			}
		}
		return null;
	}

	public String getColorHexadecimal() {
		if (hexadecimal != null) {
			return hexadecimal;
		} else {
			if (r != null && g != null && b != null) {
				return RGBToHexadecimal(this);
			} else {
				if (c != null && m != null && y != null && k != null) {
					return CMYKToHexadecimal(this);
				}
			}
		}

		return null;
	}

	private String RGBToCMYK(Cor cor) {
		double red = cor.r / 255;
		double green = cor.g / 255;
		double blue = cor.b / 255;

		double k = 1 - (Integer.max(Integer.max(r, g), b) / 255);
		if (k == 1) {
			this.k = k;
			c = 0.0;
			m = 0.0;
			y = 0.0;
		} else {
			this.k = k;
			c = (1 - red - k) / (1 - k);
			m = (1 - green - k) / (1 - k);
			y = (1 - blue - k) / (1 - k);
		}
		return c + ", " + m + ", " + y + ", " + this.k;
	}

	private String RGBToHexadecimal(Cor cor) {
		hexadecimal = String.format("#%02x%02x%02x", cor.r, cor.g, cor.b);
		return hexadecimal;
	}

	private String CMYKToRGB(Cor cor) {
		r = (int) (255 * (1 - cor.c) * (1 - cor.k));
		g = (int) (255 * (1 - cor.m) * (1 - cor.k));
		b = (int) (255 * (1 - cor.y) * (1 - cor.k));
		return r + ", " + g + ", " + b;
	}

	private String CMYKToHexadecimal(Cor cor) {
		this.CMYKToRGB(cor);
		return this.RGBToHexadecimal(cor);		
	}

	private String HexadecimalToRGB(Cor cor) {
		r = Integer.valueOf(cor.hexadecimal.substring(1, 3), 16);
		g = Integer.valueOf(cor.hexadecimal.substring(3, 5), 16);
		b = Integer.valueOf(cor.hexadecimal.substring(5, 7), 16);
		return r + ", " + g + ", " + b;
	}

	private String HexadecimalToCMYK(Cor cor) {
		this.HexadecimalToRGB(cor);
		return this.RGBToCMYK(cor);
	}
}
