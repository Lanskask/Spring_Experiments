package hello;

public class SplitStrToArr {

    public static void main(String[] args) {
        SplitStrToArr splitStrToArr = new SplitStrToArr();
        splitStrToArr.run();
    }

    void run() {
//        System.out.println(this.testSplitWNum("45000000:17196"));
//        this.strBuilder();
//        this.strBuilder2();
        this.strFormat();
    }

    int testSplitWNum(String id) {
        String[] parts = id.split(":");
        int result = Integer.parseInt(parts[1]);
        return result;
    }

    void ifInOneLine(String id) {
//        if(stations[i].id.split(":"))
            String[] parts = id.split(":");
//        Integer.parseInt(stations[i].split(":")[1]) == 58701999;
        boolean result = Integer.parseInt(id.split(":")[1]) == 58701999;
        System.out.println(result);
    }

    void strBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append("&accept-language=");
        sb.append("&lat=");
        sb.append("&lon=");
        final String api = sb.toString();
        System.out.println("api.getClass() " + api.getClass() + ", api: " + api);
    }

    void strBuilder2() {
        final String api = "http://maps.googleapis.com/maps/api/geocode/json?sensor=false&language=ru&address=";
        StringBuilder sb = new StringBuilder();
        sb.append("http://maps.googleapis.com/maps/api/geocode/json?sensor=false");
        sb.append("&language=");
        sb.append("ru");
        sb.append("&address=");
        final String api2 = sb.toString();
        assert(api != api2);
    }

    void strFormat() {
        System.out.println(
            String.format("http://nominatim.openstreetmap.org/search?osm_type=W&countrycodes=ru&accept-language=%s&format=json&addressdetails=1&q=", "ru")
        );
    }
}
