/*  
    Project: Software to calculate set operations
 */


import java.util.Arrays;

public class ProjectSets {
    // main
    public static void main(String[] arg) {
        int S[];
        int T[];
        S = new int[]{3, 10} ;
        T = new int[]{1, 2, 3};


        // PowerSet
        System.out.print("Power set: {");
        PowerSet(S, 0, "");
        System.out.println("}");

        //CartesianProduct
        System.out.print("CartesianProduct: {");
        CartesianProduct(S, T);
        System.out.println("}");

        //Intersection
        System.out.print("Intersection: {");
        Intersection(S, T);
        System.out.println("}");

        //Union
        System.out.print("Union: ");
        Union(S, T);
        System.out.println();

        //Difference
        System.out.print("Difference: {");
        Difference(S, T);
        System.out.println("}");

        //Complements
        System.out.print("Complements: ");
        Complements(S);
    }
    public static void PowerSet(int arr[], int index, String str) {
        if (index >= arr.length) {
            System.out.print("{" + str + "}" + ",");
            return;
        }
        System.out.print("{" + str + "}" + ",");
        for (int i = index; i < arr.length; i++) {
            String str2 = str + arr[i] + ",";
            PowerSet(arr, i + 1, str2);
        }

    }

    public static void Complements(int set[]) {

        System.out.print("All integers except : {");
        for (int i = 0; i < set.length; i++) {
            System.out.print(set[i] + ",");
        }
        System.out.print("}");
    }


    public static void Difference(int set1[], int set2[]) {
        for (int i = 0; i < set1.length - 2; i++) {
            for (int j = 0; j < set2.length; j++) {
                //if the last element do not print the ","
                if (set1[i] == set2[j]) {
                    i++;

                }
            }
            System.out.print("{" + set1[i] + "},");
        }
    }

    public static void Intersection(int set1[], int set2[]) {
        for (int i = 0; i < set1.length; i++)
            for (int j = 0; j < set2.length; j++) {
                //if the last element do not print the ","
                if (set1[i] == set2[j]) {
                    System.out.print("{" + set1[i] + "},");
                }
            }
    }


    public static void Union(int set1[], int set2[]) {
        int temp[] = new int[set1.length + set2.length];
        int index = 0;

        for (int i = 0; i < set1.length; i++) {
            temp[index] = set1[i];
            index++;
        }
        for (int j = 0; j < set2.length; j++) {
            temp[index++] = set2[j];
        }
        Arrays.sort(temp);
        System.out.print("{");
        for (int k = 0; k < temp.length; k++) {
            System.out.print(temp[k] + ",");
            while (k + 1 < temp.length) {
                if (temp[k] == temp[k + 1]) {
                    k++;

                }
                k++;
                System.out.print(temp[k] + ",");
            }
        }
        System.out.print("}");
    }


    public static void CartesianProduct(int set1[], int set2[]) {
        for (int i = 0; i < set1.length; i++)
            for (int j = 0; j < set2.length; j++) {
                //if the last element do not print the ","
                if (i == set1.length - 1 && j == set2.length - 1) {
                    System.out.print("{" + set1[i] + ", "
                            + set2[j] + "}");
                }
                // loop to print every element form the first set x every element from the second set
                else {
                    System.out.print("{" + set1[i] + ", "
                            + set2[j] + "}, ");
                }
            }
    }



}
