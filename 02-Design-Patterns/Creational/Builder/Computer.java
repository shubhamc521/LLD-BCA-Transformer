/**
 * Product class - Computer with many optional components
 */

public class Computer {
    // Required parameters
    private final String CPU;
    private final String RAM;
    
    // Optional parameters
    private final String storage;
    private final String graphicsCard;
    private final String motherboard;
    private final String powerSupply;
    private final String coolingSystem;
    private final boolean isWifiEnabled;
    private final boolean isBluetoothEnabled;
    
    // Private constructor - can only be created through Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.motherboard = builder.motherboard;
        this.powerSupply = builder.powerSupply;
        this.coolingSystem = builder.coolingSystem;
        this.isWifiEnabled = builder.isWifiEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Computer Configuration:\n");
        sb.append("  CPU: ").append(CPU).append("\n");
        sb.append("  RAM: ").append(RAM).append("\n");
        
        if (storage != null)
            sb.append("  Storage: ").append(storage).append("\n");
        if (graphicsCard != null)
            sb.append("  Graphics Card: ").append(graphicsCard).append("\n");
        if (motherboard != null)
            sb.append("  Motherboard: ").append(motherboard).append("\n");
        if (powerSupply != null)
            sb.append("  Power Supply: ").append(powerSupply).append("\n");
        if (coolingSystem != null)
            sb.append("  Cooling System: ").append(coolingSystem).append("\n");
        
        sb.append("  WiFi: ").append(isWifiEnabled ? "Enabled" : "Disabled").append("\n");
        sb.append("  Bluetooth: ").append(isBluetoothEnabled ? "Enabled" : "Disabled").append("\n");
        
        return sb.toString();
    }
    
    // Static inner Builder class
    public static class Builder {
        // Required parameters
        private final String CPU;
        private final String RAM;
        
        // Optional parameters - initialized to default values
        private String storage = "256GB SSD";
        private String graphicsCard = "Integrated";
        private String motherboard = "Standard";
        private String powerSupply = "500W";
        private String coolingSystem = "Air Cooling";
        private boolean isWifiEnabled = false;
        private boolean isBluetoothEnabled = false;
        
        // Builder constructor with required parameters
        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }
        
        // Fluent setter methods for optional parameters
        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }
        
        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }
        
        public Builder setMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }
        
        public Builder setPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }
        
        public Builder setCoolingSystem(String coolingSystem) {
            this.coolingSystem = coolingSystem;
            return this;
        }
        
        public Builder enableWifi() {
            this.isWifiEnabled = true;
            return this;
        }
        
        public Builder enableBluetooth() {
            this.isBluetoothEnabled = true;
            return this;
        }
        
        // Build method to create the Computer object
        public Computer build() {
            // Validation can be done here
            if (CPU == null || CPU.isEmpty()) {
                throw new IllegalStateException("CPU is required");
            }
            if (RAM == null || RAM.isEmpty()) {
                throw new IllegalStateException("RAM is required");
            }
            
            return new Computer(this);
        }
    }
}
