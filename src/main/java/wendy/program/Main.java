package wendy.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<EscapeRoom> stores = new ArrayList<>();
        stores.add(new EscapeRoom("강남", "키이스케이프 강남점"));
        stores.add(new EscapeRoom("강남", "제로월드"));
        stores.add(new EscapeRoom("강남", "우주라이크"));
        stores.add(new EscapeRoom("강남", "포인트나인"));
        stores.add(new EscapeRoom("강남", "키이스케이프 메모리컴퍼니"));
        stores.add(new EscapeRoom("홍대", "비트포비아 홍대던전3"));
        stores.add(new EscapeRoom("홍대", "룸엘이스케이프 홍대점"));
        stores.add(new EscapeRoom("홍대", "퀘스천마크 홍대점"));
        stores.add(new EscapeRoom("홍대", "포인트나인 홍대점"));
        stores.add(new EscapeRoom("홍대", "디코더"));
        stores.add(new EscapeRoom("홍대", "키이스케이프 홍대점"));
        stores.add(new EscapeRoom("건대", "비밀의 화원 포레스트"));
        stores.add(new EscapeRoom("건대", "넥스트에디션 건대1호점"));
        stores.add(new EscapeRoom("건대", "드림이스케이프"));
        stores.add(new EscapeRoom("건대", "황금열쇠 건대유토피아호점"));

        List<HorrorDetails> horrorThemes = new ArrayList<>();
        horrorThemes.add(new HorrorDetails("강남", "제로월드", "포레스트", "공포", 27000, 4, 4.5));
        horrorThemes.add(new HorrorDetails("강남", "제로월드", "아이엠", "스릴러", 27000, 4, 1));
        horrorThemes.add(new HorrorDetails("강남", "제로월드", "콜러", "공포", 27000, 5, 5));
        horrorThemes.add(new HorrorDetails("강남", "마스터키", "도시괴담1", "공포", 27000, 5, 5));

        List<SubjectiveDetails> themes = new ArrayList<>();
        themes.add(new SubjectiveDetails("강남", "키이스케이프 강남점", "그카지말라캤자나ㅋ", "코믹", 25000, 4, 3, 3, 3));
        themes.add(new SubjectiveDetails("강남", "키이스케이프 강남점", "월야애담-영문병행표기", "동화", 24000, 4, 2, 3, 2));
        themes.add(new SubjectiveDetails("강남", "우주라이크", "US", "판타지", 28000, 3.5, 4, 5, 3));
        themes.add(new SubjectiveDetails("강남", "포인트나인", "시간이 멈춘 마을", "동화", 27000, 4, 4, 4.5, 3));
        themes.add(new SubjectiveDetails("강남", "포인트나인", "시간이 멈춘 마을(2)", "동화", 27000, 4, 4, 4.5, 3));
        themes.add(new SubjectiveDetails("강남", "포인트나인", "열쇠공의 이중생활", "동화", 27000, 4, 4.5, 4, 3));
        themes.add(new SubjectiveDetails("홍대", "오아시스 뮤지엄", "미씽 삭스 미스터리", "어드벤처", 27000, 3, 3.5, 3.5, 4));
        themes.add(new SubjectiveDetails("홍대", "오아시스 뮤지엄", "업사이드 다운", "어드벤처", 28000, 3, 3, 3.5, 3));
        themes.add(new SubjectiveDetails("홍대", "키이스케이프 홍대점", "삐릿-뽀", "어드벤처", 27000, 4, 4, 3, 4));
        themes.add(new SubjectiveDetails("홍대", "디코더", "템포루바토", "동화", 28000, 3.5, 3.5, 5, 2));
        themes.add(new SubjectiveDetails("건대", "비밀의 화원 포레스트", "새벽 베이커리", "감성", 22000, 4, 3.5, 3.5, 4));
        themes.add(new SubjectiveDetails("건대", "비밀의 화원 포레스트", "미씽 스노우맨", "감성", 25000, 2, 3, 4, 4));

        System.out.println("안녕하세요 방탈출 추천 프로그램입니다.");
        System.out.print("이름을 먼저 입력해주세요 : ");
        String name = scan.next();
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println(name + "님 이제부터 답변은 숫자만 입력해주세요");
        System.out.println("-----------------------------");
        System.out.println();
        System.out.println("원하시는 추천을 선택해주세요");
        System.out.print("1. 지역별 매장 추천 2. 개인 맞춤형 추천 -> ");
        int wanttype = Integer.parseInt(scan.next());
        System.out.println();
        switch (wanttype) {
            case 1:
                recommendByRegion(scan, name, stores);
                break;
            case 2:
                personalizedRecommendation(scan, name, horrorThemes, themes);
                break;
            default:
                System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
        }
    }

    private static void recommendByRegion(Scanner scan, String name, List<EscapeRoom> stores) {
        System.out.println("---------<지역별 매장 추천>---------");
        System.out.print(name + "님 추천받고 싶은 지역을 선택해주세요. (1.강남 2.건대 3.홍대 4.랜덤) : ");
        int wantRegion = Integer.parseInt(scan.next());
        if (wantRegion == 4) {
            wantRegion = (int) (Math.random() * 3) + 1;
        }
        System.out.println();
        List<EscapeRoom> filteredStores = new ArrayList<>();
        switch (wantRegion) {
            case 1:
                System.out.println("**강남의 방탈출 매장 랜덤 추천**");
                for (EscapeRoom store : stores) {
                    if (store.getRegion().equals("강남")) {
                        filteredStores.add(store);
                    }
                }
                break;
            case 2:
                System.out.println("**건대의 방탈출 매장 랜덤 추천**");
                for (EscapeRoom store : stores) {
                    if (store.getRegion().equals("건대")) {
                        filteredStores.add(store);
                    }
                }
                break;
            case 3:
                System.out.println("**홍대의 방탈출 매장 랜덤 추천**");
                for (EscapeRoom store : stores) {
                    if (store.getRegion().equals("홍대")) {
                        filteredStores.add(store);
                    }
                }
                break;
            default:
                System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
        }
        if (!filteredStores.isEmpty()) {
            Random random = new Random();
            EscapeRoom randomStore = filteredStores.get(random.nextInt(filteredStores.size()));
            System.out.println("추천 매장: " + randomStore.getStorename());
        } else {
            System.out.println("해당 지역에 추천할 매장이 없습니다.");
        }
    }

    private static void personalizedRecommendation(Scanner scan, String name, List<HorrorDetails> horrorThemes, List<SubjectiveDetails> themes) {
        String searchRegion = "";
        String searchTheme = "";
        int searchLevel;

        System.out.println("---------<본인 맞춤형 추천>---------");
        System.out.print("원하는 플레이 지역을 선택해주세요. (1.강남 2.건대 3.홍대 4.랜덤) : ");
        int wantRegion = Integer.parseInt(scan.next());
        if (wantRegion == 4) {
            wantRegion = (int) (Math.random() * 3) + 1;
        }
        switch (wantRegion) {
            case 1:
                searchRegion = "강남";
                break;
            case 2:
                searchRegion = "건대";
                break;
            case 3:
                searchRegion = "홍대";
                break;
            default:
                System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
                return;
        }
        System.out.print(name + "님 원하는 테마 장르가 있으신가요? (1.공포 2.공포 제외 3.상관없음) : ");
        int wantGenre = Integer.parseInt(scan.next());
        if (wantGenre == 3) {
            wantGenre = (int) (Math.random() * 2) + 1;
        }
        boolean isHorror = (wantGenre == 1);

        if (isHorror) {
            HorrorDetails recommendedTheme = RecommendUtils.recommendHorror(scan, searchRegion, horrorThemes);
            if (recommendedTheme != null) {
                System.out.println("추천 테마: " + recommendedTheme.getStorename() + "의 " + recommendedTheme.getThemename());
                System.out.print("-> 방탈출의 세부정보를 원하시면 1을 입력해주세요 (원하지 않을 시 0) : ");
                int moredetail = Integer.parseInt(scan.next());
                if (moredetail == 1) {
                    System.out.println("----------------------------------");
                    System.out.println("매장 이름: " + recommendedTheme.getStorename());
                    System.out.println("매장 위치: " + recommendedTheme.getRegion());
                    System.out.println("테마 이름: " + recommendedTheme.getThemename());
                    System.out.println("공포 지수: " + recommendedTheme.getFearIndex());
                    System.out.println("1인당 가격: " + recommendedTheme.getPrice());
                    System.out.println("----------------------------------");
                }
            }
        } else {
            SubjectiveDetails recommendedTheme = RecommendUtils.recommendNonHorror(scan, name, searchRegion, themes);
            if (recommendedTheme != null) {
                System.out.println("추천 테마: " + recommendedTheme.getStorename() + "의 " + recommendedTheme.getThemename());
                System.out.print("-> 방탈출의 세부정보를 원하시면 1을 입력해주세요 (원하지 않을 시 0) : ");
                int moredetail = Integer.parseInt(scan.next());
                if (moredetail == 1) {
                    System.out.println("----------------------------------");
                    System.out.println("매장 이름: " + recommendedTheme.getStorename());
                    System.out.println("매장 위치: " + recommendedTheme.getRegion());
                    System.out.println("테마 이름: " + recommendedTheme.getThemename());
                    System.out.println("난이도: " + recommendedTheme.getDifficulty());
                    System.out.println("1인당 가격: " + recommendedTheme.getPrice());
                    System.out.println("----------------------------------");
                }
            }
        }
        System.out.println("감사합니다. 다음에 또 이용해주세요.");
    }
}