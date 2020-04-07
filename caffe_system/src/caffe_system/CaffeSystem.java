package caffe_system;

import java.util.Random;

import javax.swing.JOptionPane;

public class CaffeSystem {
	public static void main(String[] args) {
		// 시나리오
		// 기본 주문 시나리오
		// 1. 이 프로그램은 카페에서 고객이 원하는 메뉴를 선택하고 메뉴에 따른 추가사항을 선택한 뒤 원하는
		// 원하는 지불방식으로 결제를 할 수 있는 시스템이다.
		// 2. 카페의 메뉴는 대 카테고리로 "커피, 쥬스, 국산차"가 있으며, 소 카테고리로 "아메리카노,
		// 에스프레소, 카푸치노, 카페라뗴", "오렌지 쥬스, 레몬쥬스, 자몽 쥬스", "쌍화차, 율무차"있다.
		// 4. 결제의 경우 현금, 카드, 포인트를 사용 할 수 있다. 포인트 사용의 경우 부분 사용과 전체 사용으로 나누어 진다.

		// 쿠폰시스템
		// 1. 카페는 전체 메뉴에 대해 20%할인 쿠폰이 있으며, 4자리로 이루어진 쿠폰을 1000장 발급한다.
		// 2. 쿠폰번호는 4자리 숫자의 조합이며, 쿠폰은 중복 사용 할 수없다.

		// 포인트 시스템
		// 1. 주문시 총 결제금액의 20%씩 적립이 되며, 500포인트 이상부터 사용 가능하다.
		// 2. 고객이 포인트 사용여부를 결정 할 수 있으며, 포인트를 사용한 경우 포인트 적립이 되지않는다.

		// title
		
		String title = "○커피주문시스템○";
		// 메인메뉴
		String[] menu_category = { "음료 선택", "장바구니 확인", "포인트 확인", "결제하기", "나가기" };
		// 결제메뉴
		String[] payment_category = { "포인트 사용", "쿠폰등록", "최종결제", "메인 메뉴로" };
		// 음료 카테고리
		String[] A_category = { "커피", "쥬스", "국산차" };
		String[][] B_category = { { "에스프레소", "아메리카노", "카푸치노", "카페라뗴" }, { "오렌지 쥬스", "레몬 쥬스", "자몽 쥬스" },
				{ "쌍화차", "율무차" } };
		// 메시지 변수
		String good_bye_msg = "감사합니다.";
		String nullMsg = "장바구니가 비었습니다.";
		String confirmMsg = "상품이 장바구니에 담겼습니다.";
		String errMsg = "다시 시도해주세요";

		// 가격 변수
		int[][] B_price = { { 2000, 3000, 3500, 3500 }, { 3500, 3500, 3500 }, { 3000, 2000 } };
		int[] Additional_price = { 500, 500, 500, 500 };

		int point = 0;
		int money = 1_000_000;

		// 쿠폰 생성을 위한 랜덤함수
		Random r = new Random();
		int coupon = r.nextInt(9000) + 1000;
		// 개발자 테스트
		System.out.println(coupon);

		int myCoupon = 0;
		String CouponMsg = "[20% 할인 쿠폰]\n";
		// 쿠폰 사용여부 체크
		boolean usePoint = false;
		boolean couponCheck = false;

		int choice = 0;

		for (int i = 0; i < menu_category.length; i++) {
			title += "\n" + (i + 1) + ". " + menu_category[i];
		}
		// 장바구니에 담긴 메뉴의 수
		int choice_num = 0;
		// 장바구니 변수
		String[] shopping_basket = new String[5];
		int[] shopping_price = new int[5];

		// 장바구니에 담긴 총 금액
		int total = 0;
		while (choice != 5) {
			// 장바구니에 담긴 메뉴가 5개 이상일때 선택할 수없다.
			// 미구현
			String msg = "";
			choice = Integer.parseInt(JOptionPane.showInputDialog(title));
			switch (choice) {
			// 메뉴 선택 : 메뉴 선택시 장바구니에 들어간다.
			// 뒤로가기 미구현
			case 1:
				// 메뉴 선택에 따른 카테코리 변수 및 가격
				String[] next_category;
				int[] next_price;

				for (int i = 0; i < A_category.length; i++) {
					msg += "\n" + (i + 1) + ". " + A_category[i];
				}
				choice = Integer.parseInt(JOptionPane.showInputDialog(msg));
				msg = "";
				// 메뉴 선택시 인덱스로 접근에 그에 맞는 소 카테고리가 변수에 할당된다.
				if (choice != A_category.length + 1) {
					next_category = B_category[choice - 1];
					next_price = B_price[choice - 1];
				} else {
					JOptionPane.showMessageDialog(null, good_bye_msg);
					break;
				}
				// 소 카테소리를 보여주기 위한 msg작성 부분
				for (int i = 0; i < next_category.length; i++) {
					msg += (i + 1) + ". " + next_category[i] + " " + next_price[i] + "원\n";
				}
				choice = Integer.parseInt(JOptionPane.showInputDialog(msg));

				// 메뉴를 선택하면 메뉴가 장바구니 변수에 할당된다.
				shopping_basket[choice_num] = next_category[choice - 1];
				shopping_price[choice_num] = next_price[choice - 1];
				total += next_price[choice - 1];
				choice_num++;
				JOptionPane.showMessageDialog(null, confirmMsg);
				break;
			// 장바구니에 저장된 메뉴와 총 금액을 출력해준다.
			// 장바구니 비우기 미구현
			case 2:
				msg += "○장바구니○\n";
				if (shopping_basket[0].equals(null)) {
					JOptionPane.showMessageDialog(null, nullMsg);
				} else {
					for (int i = 0; i < choice_num; i++) {
						msg += (i + 1) + ". " + shopping_basket[i] + "\n";
					}
					JOptionPane.showMessageDialog(null, msg + "총 가격: " + total + "원");
				}
				continue;
			// 포인트 확인
			case 3:
				JOptionPane.showMessageDialog(null, "현재 포인트 : " + point);
				continue;
			// 결제하기
			case 4:
				choice = 0;
				int result = total;
				while (choice != 4) {
					msg = "";
					msg += "총 가격 : " + result + "원\n";
					// 현재 장바구니에 담긴 상품과 총금액을 출력한다.
					for (int i = 0; i < payment_category.length; i++) {
						msg += "\n" + (i + 1) + ". " + payment_category[i];
					}
					choice = Integer.parseInt(JOptionPane.showInputDialog(msg));

					switch (choice) {
					// 포인트 사용
					case 1:
						// 포인트가 500점 이하의 경우 사용할 수 없다.
						if (point > 500) {
							int use_point = 500 * (point / 500);
							result = total - use_point;
							point -= use_point;
							usePoint = true;
							JOptionPane.showMessageDialog(null, "포인트가 " + use_point + "원 사용되었습니다.");
						} else {
							JOptionPane.showMessageDialog(null, "포인트가 500이상일 때 사용가능 합니다.");
						}
						continue;
					// 쿠폰을 입력하고 그에 맞는 가격 할인을 적용한다.
					case 2:
						if (!couponCheck) {
							myCoupon = Integer.parseInt(JOptionPane.showInputDialog("쿠폰 번호 입력"));
							if (myCoupon == coupon) {
								JOptionPane.showMessageDialog(null, CouponMsg + "등록 성공!");
								couponCheck = true;
								result = (int) (result * 0.8);
							} else
								JOptionPane.showMessageDialog(null, "잘못된 쿠폰번호 입니다.");
						} else
							JOptionPane.showMessageDialog(null, "이미 쿠폰을 등록하셨습니다.");
						continue;
					// 최종결제부분
					case 3:
						String result_msg = "결제완료. 남은 금액 : %d\n";
						money -= result;
						if (!usePoint) {
							point += 0.2 * result;
							result_msg += "포인트 충전 완료!";
						}
						result_msg = String.format(result_msg, money);
						JOptionPane.showMessageDialog(null, result_msg);
						choice = 4;

						// 장바구니 초기화
						// 결제를 완료하고 장바구니를 비운다.
						usePoint = false;
						couponCheck = false;
						shopping_basket = new String[5];
						shopping_price = new int[5];
						total = 0;
						break;
					case 4:
						break;
					default:
						JOptionPane.showMessageDialog(null, errMsg);
					}
				}
				choice = 0;
			case 5:
				JOptionPane.showMessageDialog(null, good_bye_msg);
				continue;
			default:
				JOptionPane.showMessageDialog(null, errMsg);
			}
		} // while문 종료

	}
}
