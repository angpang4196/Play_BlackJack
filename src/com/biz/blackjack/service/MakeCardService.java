package com.biz.blackjack.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MakeCardService {

	List<String> numList; // 숫자 9개를 담을 리스트 선언
	List<String> patList; // 모양 4개를 담을 리스트 선언
	List<String> alpList; // A, K, Q, J 담을 리스트 선언
	List<String> cardList; // 카드 52장을 담을 리스트 선언

	List<String> dealerCList; // 딜러의 카드를 담을 리스트 선언
	List<String> playerCList; // 플레이어의 카드를 담을 리스트 선언
	List<Integer> dScoreList; // 딜러가 받은 카드 한 장씩의 점수를 담을 리스트 선언
	List<Integer> pScoreList; // 플레이어가 받은 카드 한 장씩의 점수를 담을 리스트 선언

	/*
	 * 생성자에서 String형 리스트 6개와 Integer형 리스트2개를 초기화
	 */
	public MakeCardService() {
		numList = new ArrayList();
		patList = new ArrayList();
		alpList = new ArrayList();
		cardList = new ArrayList();

		dealerCList = new ArrayList();
		playerCList = new ArrayList();
		dScoreList = new ArrayList();
		pScoreList = new ArrayList();
	}

	/*
	 * 카드의 숫자 (2 ~ 10)를 생성해서 String형 리스트 numList에 저장하는 method
	 */
	public void makeNum() {
		/*
		 * 반복문을 이용해서 2 ~ 10 숫자를 numList에 문자열 값으로 저장
		 */
		for (int i = 0; i < 9; i++) {
			numList.add((i + 2) + "");
		}
	}

	/*
	 * 카드의 하트, 다이아, 스페이드, 클로버 모양을 String형 리스트 patList에 저장하는 method
	 */
	public void makePat() {
		/*
		 * String형 리스트 patList에 모양 4개를 저장
		 */
		patList.add("HEART");
		patList.add("SPADE");
		patList.add("DIAMOND");
		patList.add("CLOVER");
	}

	/*
	 * 알파벳 A, K, Q, J를 String형 리스트 alpList에 저장하는 method
	 */
	public void makeAlp() {
		alpList.add("A");
		alpList.add("K");
		alpList.add("Q");
		alpList.add("J");
	}

	/*
	 * 모양과 숫자을 조합해서 카드를 만들어내는 method
	 */
	public void makeNumCard() {
		/*
		 * 이중 for문을 이용하여
		 */
		for (String t : numList) {
			for (String s : patList) {
				/*
				 * patList에 있는 모양과 numList에 있는 숫자를 조합하여 String형 변수 strNumCard에 저장
				 */
				String strNumCard = s + " " + t;
				/*
				 * 위에서 만든 String형 변수 strNumCard 들을 cardList에 저장
				 */
				cardList.add(strNumCard);

			}
		}
	}

	/*
	 * 모양과 알파벳을 조합하여 카드를 만드는 method
	 */
	public void makeAlpCard() {
		/*
		 * 이중 for문을 이용해서 모양과 숫자를 String형 변수 strAlpCard에 담고 그 값을 cardList에 저장
		 */
		for (String s : patList) {
			for (String t : alpList) {
				String strAlpCard = s + " " + t;
				cardList.add(strAlpCard);
			}
		}
	}

	/*
	 * 카드 섞는 method
	 */
	public void randomCard() {
		/*
		 * for문을 이용해 cardList에 담긴 52장의 카드들을 10번 섞기 10은 임의로 본인이 설정한 값
		 */
		for (int i = 0; i < 10; i++) {
			Collections.shuffle(cardList);
		}
	}

	/*
	 * 번갈아가면서 딜러와 플레이어의 카드리스트에 카드를 저장하는 method
	 */
	public void addCard() {
		/*
		 * 리스트의 사이즈를 int형 변수에 저장
		 */
		int intSize = cardList.size();
		/*
		 * for문을 이용해서 번갈아가면서 짝수번째는 딜러카드로, 홀수번째는 플레이어카드로 저장
		 */
		for (int i = 0; i < intSize; i++) {

			/*
			 * 섞인 전체 카드중 0,2,4...짝수번째 카드는 딜러카드리스트에 저장
			 */
			if (i % 2 == 0) {
				dealerCList.add(cardList.get(i));
			}

			/*
			 * 섞인 전체 카드중 1,3,5...홀수번째 카드는 플레이어카드리스트에 저장
			 */
			if (i % 2 != 0) {
				playerCList.add(cardList.get(i));
			}
		}
	}

	/*
	 * console에 게임시작을 알려주는 method
	 */
	public void gameStart() {
		System.out.println("==================================================================");
		System.out.println("1 대 1 블랙잭 게임 시작");
		System.out.println("------------------------------------------------------------------");
	}

	/*
	 * 딜러의 오픈된 한 장의 정보와 플레이어가 받은 두 장의 정보와 점수를 console에 출력하는 method
	 */
	public void showDealer1() {

		/*
		 * 딜러의 오픈된 한 장의 정보를 console에 표시
		 */
		System.out.println("딜러의 카드 한 장은 " + "[ " + dealerCList.get(0) + " ]" + "입니다.");

		/*
		 * 플레이어가 받은 두 장의 정보를 console에 표시
		 */
		System.out.println("플레이어가 받은 카드 두 장은 " + "[ " + playerCList.get(0) + " ]" + 
					"[ " +playerCList.get(1) + " ]" + "입니다.");

		/*
		 * 플레이어가 처음에 받은 두장의 정보를 makeScore()의 매개변수로 보내서 리턴받은 값(점수)를 int형 변수 intPFScore에
		 * 저장
		 */
		int intPFScore = makeScore(playerCList.get(0)) + makeScore(playerCList.get(1));

		/*
		 * intPFScore에 있는 점수를 플레이어 점수리스트인 pScoreList에 저장
		 */
		pScoreList.add(intPFScore);

		/*
		 * 플레이어가 받은 두 장의 점수를 console에 표시
		 */
		System.out.println("현재 플레이어의 점수는 " + intPFScore + "점입니다.");
	}

	/*
	 * 딜러의 오픈되지않은 카드의 정보와 점수를 알려주는 method
	 */
	public void showDealerAno() {

		/*
		 * 딜러의 오픈되지않은 카드의 정보를 오픈하면서 console에 표시
		 */
		System.out.println("딜러의 다른 한 장은 " + "[ " + dealerCList.get(1) + " ]" + "입니다.");

		/*
		 * 딜러의 첫 두 장의 점수를 구하는 부분 첫번째 카드와 두번째카드의 정보를 makeScore()에 매개변수로 전달해서 리턴받은 값(점수)를
		 * int형 변수 intDFScore에 저장
		 */
		int intDFScore = makeScore(dealerCList.get(0)) + makeScore(dealerCList.get(1));

		/*
		 * intDFScore에 담긴 값(점수)를 console에 표시
		 */
		System.out.println("딜러의 카드 두 장의 점수는 " + intDFScore + "점입니다.");

		/*
		 * 그 점수값을 딜러의 점수리스트 dScoreList에 저장
		 */
		dScoreList.add(intDFScore);

		/*
		 * 반복문을 이용해서 딜러의 첫번째카드와 두번째카드의 점수합이 16점이하일 때 카드 한 장씩을 더하고 16과 비교 초기값을 2로 준이유는 0과
		 * 1은 위의 method에서 알고있어서
		 */
		for (int i = 2; i < 15; i++) {

			/*
			 * 딜러의 첫 카드와 두번째 카드의 점수합이 16이하이면 >>> if조건문 사용
			 */
			if (intDFScore <= 16) {

				/*
				 * 점수합이 16점이하라면 한 장을 더 받는다는 메세지와 그 받은 카드의 정보를 console에 표시
				 */
				System.out.println("딜러의 점수가 16점 이하이므로 카드 한 장을 더 받습니다.");
				System.out.println("딜러가 추가로 받은 카드는 " + "[ " + dealerCList.get(i) + " ]" + "입니다.");

				/*
				 * 추가로 받은 카드의 점수를 makeScore()에 매개변수로 전달하여 return받은 값을 intDFScore에 추가 저장
				 */
				intDFScore += makeScore(dealerCList.get(i));

				/*
				 * 그 추가로 받은 카드점수를 초기 점수와 합산하여 console에 표시
				 */
				System.out.println("딜러의  점수는 " + intDFScore + "점입니다.");

				/*
				 * dScoreList에는 딜러의 첫 카드와 두번째 카드 점수는 이미 저장이 되어있다. 그래서 추가로 받은 카드의 점수만 추가시켜주면 된다.
				 * 추가로 받은 카드의 점수는 makeScore에 추가로 받은 카드의 정보를 매개변수로 전달하여 return받은 값이다.
				 */
				dScoreList.add(makeScore(dealerCList.get(i)));
			}
		}
	}

	/*
	 * main method에서 추가로 카드를 받고싶으면 실행되는 method 매개변수 intIndex는 main에서 전달
	 */
	public int getPCard(int intIndex) {
		
		/*
		 * console에 플레이어가 한 장의 카드를 얻는다는 메세지와 얻은 카드의 정보를 표시
		 */
		System.out.println("플레이어는 한 장의 카드를 더 얻습니다.");
		System.out.println("얻은 카드는 " + "[ " + playerCList.get(intIndex) + " ]" + "입니다.");
	
		/*
		 * intPlayerScore라는 변수는 플레이어가 카드를 얻고 그 카드의 점수까지 더한 값을 저장할 변수 
		 */
		int intPlayerScore = 0;

		System.out.print("현재까지 플레이어의 카드는 ");
		/*
		 * for문을 이용해서 플레이어의 첫번째 카드부터 받은만큼 카드의 점수를 더 해줌
		 */
		for (int i = 0; i <= intIndex; i++) {
			
			System.out.print("[ " + playerCList.get(i) + " ]");
			/*
			 * += 을 이용해서 0번째 점수부터 intIndex번째 점수까지 더해주고 for문을 빠져나오게 된다.
			 */
			intPlayerScore += makeScore(playerCList.get(i));
		}
		
		System.out.println("입니다.");
		
		/*
		 * 위의 for문을 빠져나온 플레이어의 점수를 console에 표시해줌
		 */
		System.out.println("현재까지 플레이어의 점수는 " + intPlayerScore + "점입니다.");
		/*
		 * return받은 값(점수)를 플레이어의 점수리스트에 추가
		 */
		pScoreList.add(makeScore(playerCList.get(intIndex)));

		/*
		 * for문을 빠져나온 추가로 받은 카드의 점수까지 합했을 때 21이 넘으면 자동으로 딜러가 이기는 결과가 된다.
		 */
		if (intPlayerScore > 21) {
			System.out.println("21점을 초과했으므로 딜러 승");

			/*
			 * 21점초과가 되면 getPCard() method를 호출한 -1 값으로 return
			 */
			return -1;
		}

		/*
		 * 21점이 초과가 되지 않았다면 1을 이 method를 호출한 main method로 return하게 되는데 return 값을 1로 설정한
		 * 이유는 인덱스를 1씩 증가시키기위해 return해 주는 값을 1로 설정하였다.
		 */
		return 1;

	}

	/*
	 * 카드 정보를 매개변수로 받아서 빈 칸을 기준으로 분해하고 뒷 글자를 점수계산하는 method의 매개변수로 전달하는 method
	 */
	public int makeScore(String strCard) {
		/*
		 * 빈 칸을 기준으로 분해하고 각각 strSp라는 문자열 배열에 담는다.
		 */
		String[] strSp = strCard.split(" ");
		/*
		 * 뒷 글자가 점수를 구하는 데 필요하니까 배열의 1번째 값을 문자열 변수에 담고 점수계산하는 method의 매개변수로 전달
		 */
		String strScoreCode = strSp[1];
		int intScore = scoreCode(strScoreCode);
		/*
		 * 점수계산해서 리턴받아온 값을 int형 변수에 담고 makeScore() 호출한 곳으로 리턴해줌.
		 */
		return intScore;
	}

	/*
	 * 카드 정보중 뒷 글자를 매개변수로 받아서 점수값을 리턴해주는 method
	 */
	public int scoreCode(String strCode) {

		// 뒷 글자가 A일 경우 1점을 리턴
		if (strCode.equals("A")) {
			return 1;
		}
		// 뒷 글자가 J일 경우 10점을 리턴
		if (strCode.equals("J")) {
			return 10;
		}
		// 뒷 글자가 Q일 경우 10점을 리턴
		if (strCode.equals("Q")) {
			return 10;
		}
		// 뒷 글자가 K일 경우 10점을 리턴
		if (strCode.equals("K")) {
			return 10;
		}
		/*
		 * 위 4가지경우를 제외하면 나머지 뒷 글자는 모두 int형변환이 가능하다. 그래서 형변환을 한 후에 그 변환시킨 값을 그대로 점수값으로
		 * 리턴해줌
		 */
		int intScore = Integer.valueOf(strCode);
		return intScore;
	}

	/*
	 * 딜러의 점수리스트와 플레이어의 점수리스트의 각 점수를 합쳐서 승패 정하는 method
	 */
	public void exam() {

		/*
		 * 두 사람의 점수 합을 구하기위해 intD, indP라는 int형 변수 선언 및 초기화
		 */
		int intD = 0;
		int intP = 0;

		/*
		 * dScoreList(딜러 점수리스트)에 있는 딜러가 가지고있는 각 카드의 점수를 다 더하는 코드
		 */
		for (int d : dScoreList) {
			intD += d;
		}

		/*
		 * pScoreList(플레이어 점수리스트)에 있는 딜러가 가지고있는 각 카드의 점수를 다 더하는 코드
		 */
		for (int p : pScoreList) {
			intP += p;
		}

		/*
		 * console에 두 사람의 점수를 보여주는 코드
		 */
		System.out.println("------------------------------------------------------------------");
		System.out.println("딜러 : " + intD + "점");
		System.out.println("플레이어 : " + intP + "점");
		System.out.println("==================================================================");
		/*
		 * intDS는 21점과 딜러점수의 점수 차이 , intPS는 21점과 플레이어의 점수 차이
		 */
		int intDGap = intD - 21;
		int intPGap = intP - 21;

		while (true) {

			// 딜러와 플레이어 점수 모두 21점을 초과했을 때
			if (intDGap > 0 && intPGap > 0) {
				System.out.println("결과 : 딜러 승");
				break;
			}
			// 딜러점수가 21을 초과했을 때
			if (intDGap > 0) {
				System.out.println("결과 : 플레이어 승");
				break;
			}

			// 플레이어 점수가 21을 초과했을 때
			if (intPGap > 0) {
				System.out.println("결과 : 딜러 승");
				break;
			}
			
			// 플레이어와 딜러 모두 21점일 때
			if(intPGap == 0 && intDGap == 0) {
				System.out.println("결과 : DRAW");
				break;
			}

			// 딜러점수가 21일 때
			if (intDGap == 0) {
				System.out.println("결과 : 딜러 승");
				break;
			}

			// 플레이어점수가 21점일 때
			if (intPGap == 0) {
				System.out.println("Black Jack !!!");
				System.out.println("플레이어 승");
				break;
			}

			// 딜러와 플레이어 점수가 같을 때
			if (intDGap == intPGap) {
				System.out.println("결과 : DRAW");
				break;
			}

			// 딜러와 플레이어 점수 모두 21점보다 작을 때
			if (intDGap < 0 && intPGap < 0) {

				// 딜러의 점수가 21점보다 더 가까울 때
				if (intDGap > intPGap) {
					System.out.println("결과 : 딜러 승");
					break;
				}

				// 플레이어의 점수가 21점보다 더 가까울 때
				if (intDGap < intPGap) {
					System.out.println("결과 : 플레이어 승");
					break;
				}
			}
		}
	}

}