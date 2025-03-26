package Work.WorkShop11.vehicle;

public class Truck extends Car{

    public Truck() {
    }

    public Truck(int maxWeight, double oilTankSize, double efficiency) {
        super(maxWeight, oilTankSize, efficiency);
    }

    public double getEfficiency() {
//        현재 적재 중량 5Kg 당 연비 0.2Km 감소시 킨 값을 리턴한다.
       return super.getEfficiency()- getCurWeight()/5*0.2;

    }
    private double calcOil(int distance)
    {
//        거리를 연비로 나누어 오일 소모량을 추출 하고 리턴한다.

        return distance/this.getEfficiency();
    }

    public void moving(int distance)
    {
//        calcOil( )을 호출하여 오일 감소량을 획득하고, 잔여오일량에서 감소량을 뺀 새로운 잔여오일량으로 재설정한다.
        double oilConsumption = calcOil(distance);
        double RestOil = this.getRestOil()-calcOil(distance);
        this.setRestOil(RestOil);
    }




    public int getCost(int distance)
    {
//        calcOil( )을 호출하여 오일 감소량을 획득하 고, 1L 당 3000원의 요금을 산정하여 리턴 한다.
//                단, 소수점 이하는 버린다.
        int cost = 0;
        return cost = (int) (calcOil(distance)*3000);
    }

    @Override
    public String toString() {

        return super.toString();
    }


}
