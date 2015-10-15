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
				return CMYKtoRGB(this);
			} else {
				if (hexadecimal != null) {
					return HexadecimaltoRGB(this);
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
				return RGBtoCMYK(this);
			} else {
				if (hexadecimal != null) {
					HexadecimaltoRGB(this);
					return RGBtoCMYK(this);
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
				return RGBtoHexadecimal(this);
			} else {
				if (c != null && m != null && y != null && k != null) {
					CMYKtoRGB(this);
					return RGBtoHexadecimal(this);
				}
			}
		}

		return null;
	}

	private String RGBtoCMYK(Cor cor) {
		double red = cor.r / 255;
		double green = cor.g / 255;
		double blue = cor.b / 255;

		double k = 1 - Integer.max(Integer.max(r, g), b);
		double c = (1 - red - k) / (1 - k);
		double m = (1 - green - k) / (1 - k);
		double y = (1 - blue - k) / (1 - k);

		return c + ", " + m + ", " + y + ", " + k;
	}

	private String CMYKtoRGB(Cor cor) {
		r = (int) (255 * (1 - cor.c) * (1 - cor.k));
		g = (int) (255 * (1 - cor.m) * (1 - cor.k));
		b = (int) (255 * (1 - cor.y) * (1 - cor.k));
		return r + ", " + g + ", " + b;
	}

	private String RGBtoHexadecimal(Cor cor) {
		hexadecimal = String.format("#%02x%02x%02x", cor.r, cor.g, cor.b);
		return hexadecimal;
	}

	private String HexadecimaltoRGB(Cor cor) {
		return Integer.valueOf(cor.hexadecimal.substring(1, 3), 16) + ", "
				+ Integer.valueOf(cor.hexadecimal.substring(3, 5), 16) + ", "
				+ Integer.valueOf(cor.hexadecimal.substring(5, 7), 16);
	}

}
