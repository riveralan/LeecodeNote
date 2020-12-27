public class IpCheck {
    public String validIPAddress(String IP) {
        if(IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validIPv4(IP);
        }

        if(IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validIPv6(IP);
        }
        return "Neither";
    }

    private String validIPv4(String ip){
        String[] arr = ip.split("\\.");
        String scope = "0123456789";
        if(arr.length==0 ||arr.length !=4){
            return "Neither";
        }
        for(String num : arr){
            char[] charArr = num.toCharArray();
            if(charArr.length>3||charArr.length == 0){
                return "Neither";
            }
            if(charArr[0] == '0' && charArr.length!=1){
                return "Neither";
            }

            for (Character ch : charArr) {
                if (scope.indexOf(ch) == -1) return "Neither";
            }
            if (Integer.parseInt(num) > 255) return "Neither";
        }
        return "IPv4";
    }

    private String validIPv6(String ip){
        String[] arr = ip.split("\\:");
        String scope = "0123456789abcdefABCDEF";
        if(arr.length==0 ||arr.length!=8){
            return "Neither";
        }
        for(String num : arr){
            char[] charArr = num.toCharArray();
            if(charArr.length>4||charArr.length==0){
                return "Neither";
            }
            for (Character ch : charArr) {
                if (scope.indexOf(ch) == -1) return "Neither";
            }
        }
        return "IPv6";
    }

    public static void main(String[] args) {
        String IP =
                "1.0.1.";
        IpCheck ipCheck =new IpCheck();
        ipCheck.validIPAddress(IP);
    }
}
