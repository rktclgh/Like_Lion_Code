package Work.WorkShop11.vehicle;

public class VehicleTest {

    public static void main(String[] args) {
        Truck car = new Truck(1000,100.0,5.0);
// 초기 트럭의 정보를 출력한다.
        System.out.println(car);
// 50L 주유 후 트럭의 정보를 출력한다.
        car.addOil(50);
        System.out.println(car);
// 50Km 주행 후 트럭의 정보를 출력한다.
        car.moving(50);
        System.out.println(car);
// 100Kg을 적재한 후 트럭의 정보를 출력한다.
        car.addWeight(100);
        System.out.println(car);
// 30Km 주행 후 트럭의 정보를 출력한다.
        car.moving(30);
        System.out.println(car);
// 100Kg을 탑재하고 30Km를 주행하면 요금이 얼마인지 출력한다.
        System.out.println("요금: "+car.getCost(30)+"원");


    }
}
