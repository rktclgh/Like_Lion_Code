package Work.WorkShop07.elite.test03;

import java.util.StringTokenizer;

public class StringTest {
    public static void main(String[] args) {
                String str = "1.22,4.12,5.93,8.71,9.34";
                double data []= new double[5];
                double sum = 0;
            // StringTokenizer를 이용하여 데이터를 꺼낸다.
        StringTokenizer tokenizer = new StringTokenizer(str, ","); // 쉼표를 기준으로 문자열을 분리


        for(int i = 0; tokenizer.hasMoreTokens(); i++){
                    // 배열에 실수 데이터를 넣는다.
            data[i] = Double.parseDouble(tokenizer.nextToken());
                }

            for(int i =0; i < data.length; i++){
                sum += data[i];
                //배열 데이터의 합을 구한다.
            }
        System.out.printf("합계: %.3f\n평균: %.3f",sum,sum/ data.length);   // 결과 값을 출력한다.
            }
        }


