package Work.WorkShop11.vehicle;

public class Vehicle {

    private int maxWeight;
    private double oilTankSize;
    private double efficiency;

    public Vehicle() {
    }

    public Vehicle(int maxWeight, double oilTankSize, double efficiency) {
        this.maxWeight = maxWeight;
        this.oilTankSize = oilTankSize;
        this.efficiency = efficiency;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getOilTankSize() {
        return oilTankSize;
    }

    public void setOilTankSize(double oilTankSize) {
        this.oilTankSize = oilTankSize;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }
    @Override
    public String toString() {
        return String.format(
                "최대적재중량: %-10s | 오일탱크 크기: %-10s | 연비: %-10s",
                this.maxWeight, this.oilTankSize, this.efficiency
        );
    }
}
