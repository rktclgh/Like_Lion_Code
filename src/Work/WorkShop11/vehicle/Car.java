package Work.WorkShop11.vehicle;

public class Car extends Vehicle {

    private double restOil;
    private int curWeight;


    public Car() {
    }

    public Car(int maxWeight, double oilTankSize, double efficiency) {
        super(maxWeight, oilTankSize, efficiency);
    }

    public void addOil(int oil)
    {
        //        현재 오일량에 추가한다.
//            단, 오일탱크크기를 넘어서면 안된다.

        try{
        if(restOil+oil>getOilTankSize())
        {
            throw new IllegalArgumentException("오일탱크크기를 넘어서면 안된다.");
        }
            this.restOil+=oil;
        }catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }

    }
    public void moving(int distance)
    {
//        연비와 주행거리에 따라 오일량을 감소 시킨다.
        this.restOil -= (distance / getEfficiency());
    }
    public void addWeight(int weight)
    {
//        현재 적재량에 물건을 추가한다.
//        단, 최대적재중량을 넘어서면 안된다.

        try
        {
            if(this.curWeight + weight>getMaxWeight())
                throw new IllegalArgumentException("최대 적재 중량을 초과했습니다");

            this.curWeight += weight;

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        // 부모 클래스의 toString()을 호출하여 Vehicle 정보를 추가하고
        // Car의 잔여 오일량과 현재 적재 중량을 추가
        String vehicleInfo = super.toString();
        String carInfo = String.format(
                "잔여오일량: %-10s | 현재적재중량: %-10s",
                this.restOil, this.curWeight
        );

        // 모든 정보를 한 줄로 합쳐서 반환
        return vehicleInfo + " | " + carInfo;
    }


    public double getRestOil() {
        return restOil;
    }

    public void setRestOil(double restOil) {
        this.restOil = restOil;
    }

    public int getCurWeight() {
        return curWeight;
    }

    public void setCurWeight(int curWeight) {
        this.curWeight = curWeight;
    }
}
