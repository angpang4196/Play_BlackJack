package com.biz.blackjack.exec;

import java.util.Scanner;

import com.biz.blackjack.service.MakeCardService;

public class PlayBlackJack_Exec {

	/*
	 * 모든 클래스의 진입점 method
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * MakeCardService를 이용한 mcs객체 선언 및 초기화
		 */
		MakeCardService mcs = new MakeCardService();

		mcs.gameStart(); // 게임 시작을 console에 표시

		mcs.makeNum(); // 카드의 숫자 생성
		mcs.makePat(); // 카드의 모양 생성
		mcs.makeAlp(); // 카드의 알파벳 생성(A, K, Q, J)

		mcs.makeNumCard(); // 모양과 숫자를 조합한 카드 생성 (36개)
		mcs.makeAlpCard(); // 모양과 알파벳을 조합한 카드 생성 (16개)

		mcs.randomCard(); // 카드 섞기
		mcs.addCard(); // 각 리스트에 카드 저장하기

		mcs.showDealer1(); // 딜러의 오픈된 한 장의 정보와 플레이어가 받은 두 장의 정보와 점수를 console에 출력하는 method

		/*
		 * 키보드로부터 입력받기 위한 Scanner 선언 및 초기화
		 */
		Scanner scan = new Scanner(System.in);

		/*
		 * MakeCardService 클래스의 getPCard()에 매개변수로 인덱스 값을 전달하기위해 선언 및 2로 저장 2로 저장한 이유는
		 * 0번째와 1번째는 이미 초기에 저장이 되어있기 때문에 2번째부터 저장하기위해
		 */
		int intIndex = 2;

		/*
		 * while문을 이용해 플레이어의 선택(멈출지, 추가로 카드를 얻을지)
		 */
		while (true) {

			/*
			 * console에 선택란을 보여주는 코드
			 */
			System.out.println("0 : STOP , 1 : GET");
			System.out.print("선택 >>>");

			/*
			 * console에 표시된 위의 내용을 보고 입력을 받는 코드 키보드로 부터 입력받은 문자열을 strWrite라는 문자열형 변수에 저장
			 */
			String strWrite = scan.nextLine();

			/*
			 * 0과 1중 입력을 받았으니 밑의 if문에서 비교하기위해 int형으로 변환 후 intWrite라는 변수에 저장
			 */
			int intWrite = Integer.valueOf(strWrite);

			/*
			 * if조건문을 이용해 0이면 스탑하고 딜러와 플레이어의 점수를 비교해 승패 결정
			 */
			if (intWrite == 0) {

				/*
				 * console에 stop을 선택했다는 메세지를 표시
				 */
				System.out.println("STOP을 선택하셨습니다.");

				/*
				 * 딜러의 오픈되지않은 카드의 정보와 점수를 알려주는 method
				 */
				mcs.showDealerAno();

				/*
				 * 딜러의 점수리스트와 플레이어의 점수리스트의 각 점수를 합쳐서 승패 정하는 method
				 */
				mcs.exam();

				/*
				 * 게임 종료
				 */
				break;
			}

			if (intWrite == 1) {

				/*
				 * 위에서 intIndex의 값을 2로 저장 후 MakeCardService 객체 mcs의 getPCard()에 매개변수로 인덱스값을 전달하고
				 * return받은 1을 intIndex에 더해주고 다시 반복하는 코드 즉 이 말은 초기값인 2부터 1씩 intIndex가 증가한다는 말이
				 * 된다.
				 */

				/*
				 * 플레이어가 얻고싶으면 실행되는 method에 인덱스 값을 매개변수로 전달해주고 리턴받은 값을 int형 변수 intScore에 저장
				 */
				int intScore = mcs.getPCard(intIndex);

				/*
				 * 위의 return받은 값이 0보다 작다는 말은 service 클래스에 가보면 알겠지만 플레이어가 얻은 카드까지 점수를 합해서 점수가 21점이
				 * 초과했을 때 -1 을 return하게 했다. 그래서 그 return받은 값이 0보다 작으면 바로 딜러가 이긴 결과이기 때문에 break를
				 * 걸어주었다.
				 */
				if (intScore < 0) {
					break;
				}

				/*
				 * return받은 값이 0이 아니라면 점수가 21점이 아직 안 넘었다는 말이다. 그리고 return받은 값은 1이되는데 원래
				 * intIndex에 + 1 을 해서 다음 순서의 카드를 받기위해 아래 코드를 적었고, while문 처음으로 가서 다시 카드를 얻을지 그만
				 * 받을지 선택하게 한다.
				 */
				intIndex += intScore;

			}
		}
	}

}