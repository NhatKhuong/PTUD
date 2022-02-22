package format;

import java.text.DecimalFormat;


public class Format {
	public static String chuyenDoiTienTe(double money) {
		DecimalFormat decimalFormat = new DecimalFormat("###,###,###,###,###,### VND");
		return decimalFormat.format(money);
	}
	public static double chuyenDoiNguocLaiTienTe(String money) {
		try {
			money = money.substring(0, money.length() - 4);
			String[] moneyArr = money.split(",");
			money = "";
			for (String string : moneyArr) {
				money += string;
			}
			return Double.parseDouble(money);

		} catch (Exception e) {
			System.err.println("Khong dung fomat" + e.getMessage());
		}
		return -0;
	}
	
}
