package wendy.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<EscapeRoom> stores = new ArrayList<>();
        stores.add(new EscapeRoom("강남", "키이스케이프 강남점"));
        stores.add(new EscapeRoom("강남", "제로월드 강남점"));
        stores.add(new EscapeRoom("강남", "포인트나인 강남점"));
        stores.add(new EscapeRoom("홍대", "비트포비아 홍대던전"));
        stores.add(new EscapeRoom("홍대", "퀘스천마크 홍대점"));
        stores.add(new EscapeRoom("홍대", "포인트나인 홍대점"));
        stores.add(new EscapeRoom("건대", "비밀의 화원 포레스트점"));
        stores.add(new EscapeRoom("건대", "넥스트에디션 건대1호점"));
        List<Details> themes = new ArrayList<>();
        themes.add(new Details("강남", "키이스케이프 강남점", "그카지말라캤자나ㅋ","코믹",25000,4));
        themes.add(new Details("강남", "키이스케이프 강남점", "월야애담-영문병행표기","동화",24000,4));
        themes.add(new Details("강남", "우주라이크", "US","판타지",28000,3.5));
        themes.add(new Details("강남", "포인트나인", "시간이 멈춘 마을","??",27000,4));
        themes.add(new Details("강남", "포인트나인", "열쇠공의 이중생활","??",27000,4));
        themes.add(new Details("홍대", "오아시스 뮤지엄", "미씽 삭스 미스터리","어드벤처",27000,3));
        themes.add(new Details("홍대", "오아시스 뮤지엄", "업사이드 다운","어드벤처",28000,3));
        themes.add(new Details("건대", "비밀의 화원 포레스트", "새벽 베이커리","감성",22000,4));
        themes.add(new Details("건대", "비밀의 화원 포레스트", "미씽 스노우맨","감성",25000,2));


        System.out.println("안녕하세요. 방탈출 추천 프로그램입니다.");
        System.out.print("이름을 먼저 입력해주세요 : ");
        String name = scan.next();
        System.out.println(name + "님 이제부터 답변은 숫자만 입력해주세요");
        System.out.println("원하시는 추천을 선택해주세요");
        System.out.print("1.지역별 추천 2.본인 맞춤형 추천 -> ");
        int wanttype = Integer.parseInt(scan.next());
        switch (wanttype) {
            case 1:
                System.out.print(name + "님 원하는 지역을 선택해주세요. (1.강남 2.건대 3.홍대 4.랜덤) : ");
                int wantRegion = Integer.parseInt(scan.next());
                if (wantRegion == 4) {
                    wantRegion = (int) Math.random() * 3 + 1;
                }
                switch (wantRegion) {
                    case 1:
                        for (EscapeRoom store : stores) {
                            System.out.println("강남의 방탈출 랜덤 추천리스트");
                            if (store.getRegion().equals("강남")) {
                                System.out.println(store.storename);
                            }
                        }
                        break;
                    case 2:
                        for (EscapeRoom store : stores) {
                            System.out.println("건대의 방탈출 랜덤 추천리스트");
                            if (store.getRegion().equals("건대")) {
                                System.out.println(store.storename);
                            }
                        }
                        break;
                    case 3:
                        for (EscapeRoom store : stores) {
                            System.out.println("홍대의 방탈출 랜덤 추천리스트");
                            if (store.getRegion().equals("홍대")) {
                                System.out.println(store.storename);
                            }
                            break;
                        }
                }
                break;

            case 2:
                System.out.print("방탈출 경험 횟수를 입력해주세요(경험 없으면 0) : ");
                int playCount = Integer.parseInt(scan.next());
                System.out.print(name + "님 플레이를 원하는 지역을 선택해주세요. (1.강남 2.건대 3.홍대 4.그 외 지역) : ");
                wantRegion = Integer.parseInt(scan.next());
                System.out.print(name + "님 테마를 플레이할 인원을 알려주세요 : ");
                int wantPersonnel = Integer.parseInt(scan.next());
                System.out.print(name + "님 원하는 테마 장르가 있으신가요? (1.공포 2.공포 제외 3.상관없음) : ");
                int wantGenre = Integer.parseInt(scan.next());
                if (wantGenre == 1) {
                    System.out.println("공포를 원하시는 것을 확인했습니다");
                    System.out.print("1.스릴러(약공포) 2.공포 3.상관없음) : ");
                    int wantHorror = Integer.parseInt(scan.next());
                } else if (wantGenre == 2) {
                    System.out.print("공포가 아닌 테마를 원하시는 것을 확인했습니다");
                    System.out.print("1.동화 2.코믹 3.판타지 4.잠입 5.상관없음) : ");
                    int wantNotHorror = Integer.parseInt(scan.next());
                }
        }
    }
}
