package wendy.program;
import java.util.Scanner;

public class Main {
    public void main(String[] args){
        System.out.println("안녕하세요. 방탈출 추천 프로그램입니다.");
        System.out.println("이름과 방탈출 경험 횟수를 입력해주세요");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        int playCount = Integer.parseInt(scan.next());
        if(playCount >= 0) {
            System.out.println("이름과 방탈출 경험 횟수를 입력해주세요");
        } else if (name == null) {
            Askinfo user = new Askinfo(playCount);
        } else{Askinfo user = new Askinfo(playCount, name);}
    }
}
