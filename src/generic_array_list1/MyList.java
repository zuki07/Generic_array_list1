
/*TABLE OF CONTENTS
1. LARGEST METHOD
2. SMALLEST METHOD
3. TOTAL METHOD
4. AVERAGE METHOD
5. PRINT AS STRING METHOD
*/


package generic_array_list1;


import java.util.ArrayList;


public class MyList <T extends Number>{
    
    private ArrayList<T> list;                                                      //initiate generic array list
    
    public MyList(ArrayList<T> array_list){                                         //pass array list in constructor
        list=new ArrayList(array_list);                                             //define generic array list as passed in array list
    }
    
    
//                                   1. LARGEST METHOD
    public <S extends Comparable<S>> S largest(){
        S largest_value=(S)list.get(0);                                             //set generic largest_value to first item of generic array list
        
        for (int i=1; i<list.size(); i++){                                          //step through generic array list starting at second position
            if (((S)list.get(i)).compareTo(largest_value)>0){                       //if generic array list index is > than largest_value
                largest_value=(S)list.get(i);                                       //set largest_value to index of generic array list
            }
        }                                                                           //else, do nothing and move to next index
        return largest_value;   
    }
    
//                                    2. SMALLEST METHOD
    public <S extends Comparable<S>> S smallest(){
        S smallest_value=(S)list.get(0);                                            //set generic smallest_value to first item of generic array list
        
        for (int i=1; i<list.size(); i++){                                          //step through generic array list starting at second position
            if (((S)list.get(i)).compareTo(smallest_value)<0){                      //if generic array list index is < than smallest_value
                smallest_value=(S)list.get(i);                                      //set smallest_value to index of generic array list
            }
        }                                                                           //else, do nothing and move to next index
        return smallest_value;
    }
    
//                                    3. TOTAL METHOD  
    public T total(){
        if (list.get(0) instanceof Double){                                         //if generic array list first position is a double, do the following
            double total=0;
            for (int i=0; i<list.size(); i++){                                      //step through generic array list starting at first position
                total=total+list.get(i).doubleValue();                              //total equals total plus index(convert to double) of generic array
            }
            return (T) Double.valueOf(total);                                       //return total as a double
        }
        else if (list.get(0) instanceof Float){                                     //if generic array list first position is a float, do the following
            float total=0;
            for (int i=0; i<list.size(); i++){                                      //step through generic array list starting at first position
                total=total+list.get(i).floatValue();                               //total equals total plus index(convert to float) of generic array
            }
            return (T) Float.valueOf(total);                                        //return total as a float
        }
        else{                                                                       //else generic array list first position is a integer, do the following
            int total=0;
            for (int i=0; i<list.size(); i++){                                      //step through generic array list starting at first position
                total=total+list.get(i).intValue();                                 //total equals total plus index(convert to int) of generic array
            }
            return (T) Integer.valueOf(total);                                      //return total as a integer
        }
        
       
    }
    
//                                    4. AVERAGE METHOD
    public T average(){
         
        if (list.get(0) instanceof Double || list.get(0) instanceof Integer){       //if generic array is a double or int(for better precision), do the following
            double total=0;                                                         //set total as double and equal to 0
            
            for (int i=0; i<list.size(); i++){                                      //step through the generic array
                total=total+list.get(i).doubleValue();                              //total equals total plus index of generic array
            }
            total=total/list.size();                                                //total divide by length of generic array
            return (T) Double.valueOf(total);                                       //return total as a double
        }
        else{                                                                       //must be a float
            float total=0;                                                          //set total as float and equal to 0
            
            for (int i=0; i<list.size(); i++){                                      //step through the generic array
                total=total+list.get(i).floatValue();                               //total equals total plus index of generic array
            }   
            total=total/list.size();                                                //total divide by length of generic array                         
            return (T) Float.valueOf(total);                                        //return total as a float
        }
    }
    
//                                    5. PRINT AS STRING METHOD
    public String printAsString(){
        String str="";
        for (int index=0; index<list.size(); index++){                              //step through the generic array
            if (index==list.size()-1){                                              //if only 1 element or last element in generic array list, do the following
                str=str+list.get(index);                                            //set str to last element or only element of generic array list
            }
            else{                                                                   //all other elements in the generic array, do the following
                str=str+list.get(index)+", ";                                       //add first element in generic array to str and add comma with a space after it
            }
        }
        return str;
    }
    
}