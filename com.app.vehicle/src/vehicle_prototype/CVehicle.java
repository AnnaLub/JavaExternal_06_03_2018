package vehicle_prototype;

public abstract class CVehicle{
        private String name;
        private int degrees;
        private int minutes;
        private int seconds;
        private int price;
        private double speed;
        private int modelYear;
        EnginePrototype engine;
        TransmissionPrototype transmission;


    public CVehicle(String name, int degrees, int minutes, int seconds, int price, double speed, int modelYear, int id, TransmissionPrototype transmission) {
        this.name = name;
        this.degrees = degrees;
        this.minutes = minutes;
        this.seconds = seconds;
        this.price = price;
        this.speed = speed;
        this.modelYear = modelYear;
        this.engine = createEngine(id);
        this.transmission = this.createTransmission(id);
    }
    /*inner non-static#1*/
    class AutomaticTransmission extends TransmissionPrototype{
        public AutomaticTransmission(int id) {
            super(id);
        }

        @Override
        public String toString() {
            return "AutomaticTransmission";
        }
    }
    /*inner non-static#2*/
    class ManualTransmission extends TransmissionPrototype{
        public ManualTransmission(int id) {
            super(id);
        }

        @Override
        public String toString() {
            return "ManualTransmission";
        }

    }
    public TransmissionPrototype createTransmission(int id){
        if(isAutomatic(id)){
            return new AutomaticTransmission(id);
        }
        if(isManual(id)){
            return new ManualTransmission(id);
        }else{
            return null;
        }
    }

    private static boolean isAutomatic(int id){
        return id == 1;
    }
    private static boolean isManual(int id){
        return id == 2;
    }

    /*static inner class#2*/
    public static EnginePrototype createEngine(int id){

        class JetEngine extends EnginePrototype{

            public JetEngine(int id) {
                super(id);
            }

            @Override
            public void engineLaunch() {
                System.out.println("Jet engine launched");
            }

            @Override
            public String toString() {
                return "JetEngine";
            }
        }

        class HelicalEngine extends EnginePrototype{

            public HelicalEngine(int id) {
                super(id);
            }

            @Override
            public void engineLaunch() {
                System.out.println("Helical engine launched");
            }

            @Override
            public String toString() {
                return "HelicalEngine";
            }
        }

        class ICEngine extends EnginePrototype{
            public ICEngine(int id) {
                super(id);
            }

            @Override
            public void engineLaunch() {
                System.out.println("Internal combustion engine launched");
            }

            @Override
            public String toString() {
                return "ICEngine";
            }
        }
        if(isJetEngine(id)){
            return new JetEngine(id);
        }
        if(isHelicalEngine(id)){
            return new HelicalEngine(id);
        }
        if(isICEngine(id)){
            return new ICEngine(id);
        }
        else{
            return new EnginePrototype(id) {
                @Override
                public void engineLaunch() {
                    System.out.println("Engine prototype launched");
                }
            };
        }
    }

    private static boolean isJetEngine(int id){
        return id == 1;
    }
    private static boolean isHelicalEngine(int id){
        return id == 2;
    }
    private static boolean isICEngine(int id){
        return id == 3;
    }

    public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setCoordinates(int degrees, int minutes, int seconds) {
            this.degrees = degrees;
            this.minutes = minutes;
            this.seconds = seconds;
        }

        public int getDegrees() {
            return degrees;
        }

        public int getMinutes() {
            return minutes;
        }

        public int getSeconds() {
            return seconds;
        }

        public void getCoordinates(){
            System.out.println("Coordinates: degrees= "+ this.getDegrees() + ", minutes= " + this.getMinutes() +
                    ", seconds= " + this.getSeconds());
        }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSpeed(double speed) {
            this.speed = speed;
        }

        public void setModelYear(int modelYear) {
            this.modelYear = modelYear;
        }

    public int getPrice() {
        return price;
    }

    public double getSpeed() {
            return speed;
        }

        public int getModelYear() {
            return modelYear;
        }

        abstract void display();

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ",{Coordinates: degrees=" + degrees +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                "}, price=" + price +
                ", speed=" + speed +
                ", modelYear=" + modelYear +
                ", engine=" + engine+
                ", transmission=" + transmission.toString()+
                '}';
    }
}
