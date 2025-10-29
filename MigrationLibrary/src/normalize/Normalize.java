package normalize;

public class Normalize {

    public static String localeString(String string){
        String returnnable = "";
        for(String base : string.split("_")){
            returnnable += base.split("")[0].toUpperCase()+base.substring(1);
        }
        return returnnable;
    }

    public static String cammelCase(String string){
        String returnable = "";
        if(string.contains("_")){
            boolean isFirst = true;
            for(String base : string.split("_")){
                if(isFirst){
                    returnable = base;
                    isFirst = false;
                }else{
                    returnable += base.split("")[0].toUpperCase()+base.substring(1);
                }
            }
            return returnable;
        }
        return string;
    }
}
