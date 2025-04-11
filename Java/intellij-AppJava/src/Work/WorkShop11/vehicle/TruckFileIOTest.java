package Work.WorkShop11.vehicle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TruckFileIOTest {
    public static void main(String[] args) throws IOException {

        Truck truck = new Truck(1000,100,5);
        truck.addOil(50);
        truck.moving(50);
        truck.addWeight(100);
        truck.moving(30);

// Truck 상태 파일 저장 Files.writeString()
      String truckState = truck.toString();
      Path filePath = Path.of("truck.txt");
      Files.writeString(filePath, truckState);


//저장파일 읽기 Files.readString()
        System.out.println("파일에서 읽은 Truck 상태: ");
        System.out.println(Files.readAllLines(filePath));
    }
}
