import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> code = new ArrayList<>();
        code.add(0);
        //1<<n = 1*(n个2) =2^n
        for (int i = 0; i < (1 << n) - 1; i++) {
            int pre = code.get(i);
            if (i % 2 == 0) {
                pre ^= 1;
                code.add(pre);
            } else {
                int temp = pre;
                for (int j = 0; j < n; j++) {
                    if ((temp & 1) == 1) {
                        pre = pre ^ (1 << (j + 1));
                        code.add(pre);
                        break;
                    }
                    temp = temp >> 1;
                }
            }
        }
        return code;
    }

    public List<Integer> grayCode2(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        if(n==0) return result;
        result.add(1);
        if(n==1) return result;
        for(int i = 2;i<=n;i++){
            int len = result.size();
            for(int j = len-1;j>=0;j--){
                int a = result.get(j);
                int b = 1 << (i-1);
                result.add(a^b);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GrayCode test = new GrayCode();
        System.out.println(test.grayCode(2));
        System.out.println(test.grayCode2(2));
    }
}
