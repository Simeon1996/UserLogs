import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UsersLogs {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);

        Map<String,TreeMap<String,Integer>> userLogs = new TreeMap();

        String[] input = reader.nextLine().replace(" ","=").split("=");

        while(!input[0].equals("end")){
            String userName = input[5];
            String userIP = input[1];

            if(!userLogs.containsKey(userName)){
                userLogs.put(userName,new TreeMap<>());
                userLogs.get(userName).put(userIP,1);
            } else {

                if(userLogs.get(userName).containsKey(userIP)){
                    Integer messageCounter = userLogs.get(userName).get(userIP);
                    userLogs.get(userName).put(userIP,++messageCounter);
                } else{
                    userLogs.get(userName).put(userIP,1);
                }
            }
            input = reader.nextLine().replace(" ","=").split("=");
        }

        for(String username : userLogs.keySet()){
            System.out.println(username + ":");

            for(String userip : userLogs.get(username).keySet()){
                System.out.printf("%s => %d",userip,userLogs.get(username).get(userip)).println();
            }
        }
    }
}
