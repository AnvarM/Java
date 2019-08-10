public class PhNumberTransform {
    public static void main(String[] args){
        PhNumberTransform pht = new PhNumberTransform();
        pht.getDialString("+9(123)4567-4567");
    }

    public void getDialString(String rph) {
        String prefix = "callto://+";
        String code = rph.substring(1, rph.indexOf("("));
        String citycode = rph.substring(rph.indexOf("(")+1, rph.indexOf(")"));
        String firstnumberpart = rph.substring(rph.indexOf(")") + 1, rph.indexOf("-"));
        rph = rph.substring(rph.indexOf("-") + 1);
        String normalPhoneNumber = code + citycode + firstnumberpart + rph;
        if(rph.indexOf("-") != -1){
            rph = rph.substring(0, rph.indexOf("-")) + rph.substring(rph.indexOf("-") + 1);
            normalPhoneNumber = code + citycode + firstnumberpart + rph;
        }
        System.out.println(prefix+normalPhoneNumber);
    }
}
