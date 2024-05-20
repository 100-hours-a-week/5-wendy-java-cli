package wendy.program;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("안녕하세요. 방탈출 추천 프로그램입니다.");
        System.out.print("이름을 먼저 입력해주세요 : ");
        String name = scan.next();
        System.out.print("방탈출 경험 횟수를 입력해주세요(경험 없으면 0) : ");
        int playCount = Integer.parseInt(scan.next());
        if(playCount < 0) {
            System.out.println("방탈출 경험 횟수를 다시 입력해주세요(경험 없을 시 0으로 입력) : ");
            playCount = Integer.parseInt(scan.next());
        } else if (name == null) {
            Askinfo user = new Askinfo(playCount);
        } else{Askinfo user = new Askinfo(playCount, name);}

        System.out.println(name+"님 안녕하세요");
        System.out.println("이제부터 답변은 숫자만 입력해주세요");
//        SubjectiveDetail theme = new SubjectiveDetail("en","ds","dsf");
        System.out.print(name+"님 플레이를 원하는 지역을 선택해주세요. (1.강남 2.건대 3.홍대 4.그 외 지역) : ");
        int wantRegion = Integer.parseInt(scan.next());
        System.out.print(name+"님 테마를 플레이할 인원을 알려주세요 : ");
        int wantPersonnel = Integer.parseInt(scan.next());
        System.out.print(name+"님 원하는 테마 장르가 있으신가요? (1.공포 2.공포 제외 3.상관없음) : ");
        int wantGenre = Integer.parseInt(scan.next());
        if(wantGenre == 1){
            System.out.print("공포를 원하시는 것을 확인했습니다");
            System.out.print("1.스릴러(약공포) 2.공포 3.상관없음) : ");
            int wantHorror = Integer.parseInt(scan.next());
        } else if (wantGenre == 2) {
            System.out.print("공포가 아닌 테마를 원하시는 것을 확인했습니다");
            System.out.print("1.감성 2.코믹 3.판타지 4.잠입 5.상관없음) : ");
            int wantNotHorror = Integer.parseInt(scan.next());
        }

    }
}
