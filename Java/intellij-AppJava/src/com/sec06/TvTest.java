package com.sec06;

public class TvTest {


	public static void main(String[] args) {

		Tv [] tvs = new Tv[3];
		tvs[0] = new Tv("INFINIA", 1500000,"LED TV");
		tvs[1] = new Tv("XCANVAS",1000000,"LCD TV");
		tvs[2] = new Tv("CINEMA",2000000,"3D TV");

		prn(tvs);

		System.out.println("XCANVAS 가 가진 가격을 4000000으로 변경 후 전체 출력");
		tvs[1].setPrice(4000000);
		prn(tvs);

		System.out.println("이름 중에 CINEMA를 찾아 가격을 500000으로 변경 후 전체 출력");
		for (Tv tv : tvs) {
//			if(tv.getName() == "CINEMA")
//			{
//				tv.setPrice(500000);
//			}

			if(tv.getName().equals("CINEMA"))
			{
				tv.setPrice(5000000);
			}

		}

		prn(tvs);

	}



	public static void prn(Tv[] tvs)
	{
		System.out.println("전체 출력");
		for (Tv tv : tvs) {
			System.out.println(tv);
		}
	}


}
