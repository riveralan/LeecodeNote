public class Convert {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        StringBuilder[] temp = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            temp[i] = new StringBuilder();
        }
        int index = 0;
        int step = 1;
        for(char c: s.toCharArray()){
            temp[index].append(c);
            index+=step;
            if(index==0||index==numRows-1) step = -step;
        }
        for(int i=1;i<numRows;i++){
            temp[0].append(temp[i]);
        }
        return temp[0].toString();
    }

    public static void main(String[] args) {
        Convert test = new Convert();
        String result = test.convert("ABCD", 3);
        //PAHNAPLSIYYIIR
        System.out.println(result);
    }
}
