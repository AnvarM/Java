public class SplitString {
    public static void main(String[] args){
        String s = "world,world,fake,make.ca!ke,wor!!l1!d,count,u,,,,,...n.d.r.e.w.o.r.ld??????,worldworld,world";

        String[] words = s.split("\\W"); //\\W mean to split string with delimeters not letters,digits or _
        for (String t : words){
            System.out.println(t);
        }
    }
}
