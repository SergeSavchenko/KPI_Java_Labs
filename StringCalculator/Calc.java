import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.Collections;

public class Calc {
    public static int Add(String numbers){
        String delimiter = ",";
        String negative_numbers = "";
        String split_numbers[];

        numbers = numbers.replaceAll(" ", ""); 

        if (numbers.isEmpty()) return 0; 

        int start_index = numbers.indexOf("//");
        int end_index = numbers.indexOf("\n");

        if (start_index != -1) {
            delimiter = numbers.substring(start_index + 2, end_index);
            numbers = numbers.substring(end_index + 1);

            if (delimiter.endsWith("]") && delimiter.indexOf("[") == 0) {
                delimiter = delimiter.substring(1, delimiter.length() - 1);

                String[] delArr = delimiter.split("\\]\\[");
                Arrays.sort(delArr, Collections.reverseOrder());

                for(int k = 0; k < delArr.length; k++){
                    numbers = numbers.replaceAll(Pattern.quote(delArr[k]), ",");
                }

                delimiter = ",";
            }

            if (numbers.indexOf("\n") != -1){
                numbers = numbers.replaceAll("\n", ",");
            }

            split_numbers = numbers.split(delimiter);
        }
        else{
            if (numbers.indexOf("\n") != -1){
                numbers = numbers.replaceAll("\n", ",");
            }
            split_numbers = numbers.split(Pattern.quote(delimiter)); 
        }


        int sum = 0;
        for (String n : split_numbers) {
            if (n.indexOf("-") == 0){
                negative_numbers += (String.valueOf(n) + " ");
            }
            else{
                Integer num = Integer.parseInt(n);
                if (num < 1001){
                    sum += num;
                }
            }
        }
       IfNegativeExists(negative_numbers);

        return sum;
    }

    public static void IfNegativeExists(String negative_numbers) {
        if (!negative_numbers.isEmpty()) {
            System.out.println("Negatives Not Allowed. Numbers are: " + negative_numbers);
        }
    }
    public static void main(String[] args){
        System.out.println(Add("//[^^:][?&][]\n52^^:1\n2,5?&1,4^^:5?&-10,1\n-5"));
    }
}