package wendy.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RecommendationUtils {
    static int HORROR_RANDOM = 3;
    static int NOTHORROR_RANDOM = 6;
    static int WANT_DETAIL = 1;

    public static void recommendHorror(Scanner scan, String searchRegion, List<HorrorDetails> horrorThemes) {
        List<HorrorDetails> recommendedThemes = new ArrayList<>();
        System.out.print("-> 공포 ( 1.스릴러(약공포) 2.공포 3.상관없음 ) : ");
        int wantHorror = Integer.parseInt(scan.next());
        if (wantHorror == HORROR_RANDOM) {
            wantHorror = (int) (Math.random() * 2) + 1;
        }
        switch (wantHorror) {
            case 1:
                System.out.println();
                System.out.println("******스릴러 테마******");
                for (HorrorDetails thrill : horrorThemes) {
                    if (thrill.getGenre().equals("스릴러") && thrill.getRegion().equals(searchRegion)) {
                        recommendedThemes.add(thrill);
                    }
                }
                break;
            case 2:
                System.out.println();
                System.out.println("******공포 테마******");
                for (HorrorDetails horror : horrorThemes) {
                    if (horror.getGenre().equals("공포") && horror.getRegion().equals(searchRegion)) {
                        recommendedThemes.add(horror);
                    }
                }
                break;
            default:
                System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
        }
        if (!recommendedThemes.isEmpty()) {
            Random random = new Random();
            HorrorDetails recommendedTheme = recommendedThemes.get(random.nextInt(recommendedThemes.size()));
            HorrorDetails(recommendedTheme, scan);
        } else {
            System.out.println("추천할 매장이 아직 없습니다.");
        }
    }
    public static void HorrorDetails(HorrorDetails recommendedTheme, Scanner scan){
        if (recommendedTheme != null) {
            System.out.println("추천 테마: " + recommendedTheme.getStorename() + "의 " + recommendedTheme.getThemename());
            System.out.print("-> 방탈출의 세부정보를 원하시면 1을 입력해주세요 (원하지 않을 시 0) : ");
            int moredetail = Integer.parseInt(scan.next());
            if (moredetail == WANT_DETAIL) {
                System.out.println("----------------------------------");
                System.out.println("매장 이름: " + recommendedTheme.getStorename());
                System.out.println("매장 위치: " + recommendedTheme.getRegion());
                System.out.println("테마 이름: " + recommendedTheme.getThemename());
                System.out.println("공포 지수: " + recommendedTheme.getFearIndex());
                System.out.println("1인당 가격: " + recommendedTheme.getPrice());
                System.out.println("----------------------------------");
            }
        }
    }

    public static void recommendNonHorror(Scanner scan, String name, String searchRegion, List<SubjectiveDetails> themes) {
        String searchTheme ="";
        int searchLevel;
        System.out.print("-> 공포 제외 ( 1.동화 2.코믹 3.판타지 4.어드벤처 5.감성 6.상관없음 ) : ");
        int wantNotHorror = Integer.parseInt(scan.next());
        if (wantNotHorror == NOTHORROR_RANDOM) {
            wantNotHorror = (int) (Math.random() * 5) + 1;
        }
        switch (wantNotHorror) {
            case 1:
                searchTheme = "동화";
                break;
            case 2:
                searchTheme = "코믹";
                break;
            case 3:
                searchTheme = "판타지";
                break;
            case 4:
                searchTheme = "어드벤처";
                break;
            case 5:
                searchTheme = "감성";
                break;
            default:
                System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");

        }
        System.out.print(name + "님 테마를 플레이할 인원을 알려주세요 : ");
        int wantPersonnel = Integer.parseInt(scan.next());
        if (wantPersonnel == 1) {
            System.out.println("혼방 추천 불가,,");

        }
        System.out.print("방탈출 경험 횟수를 입력해주세요(경험 없으면 0) : ");
        int playCount = Integer.parseInt(scan.next());
        if (playCount <= 50) {
            searchLevel = 2;
        } else if (playCount > 50 && playCount <= 150) {
            searchLevel = 3;
        } else {
            searchLevel = 4;
        }
        List<SubjectiveDetails> recommendedThemes = new ArrayList<>();
        System.out.println();
        System.out.println("***************추천 테마***************");
        for (SubjectiveDetails theme : themes) {
            if (theme.getGenre().equals(searchTheme) && theme.getRegion().equals(searchRegion) && theme.getPlayMember() == wantPersonnel && searchLevel <= theme.getSubjectiveDifficulty() && theme.getSubjectiveDifficulty() <= searchLevel + 1) {
                recommendedThemes.add(theme);
            }
        }
        if (!recommendedThemes.isEmpty()) {
            Random random = new Random();
            SubjectiveDetails recommendedTheme = recommendedThemes.get(random.nextInt(recommendedThemes.size()));
            ThemeDetails(recommendedTheme, scan);
        } else {
            System.out.println("추천할 테마가 없습니다.");
        }
    }
public static void ThemeDetails(SubjectiveDetails recommendedTheme, Scanner scan){
    if (recommendedTheme != null) {
        System.out.println("추천 테마: " + recommendedTheme.getStorename() + "의 " + recommendedTheme.getThemename());
        System.out.print("-> 방탈출의 세부정보를 원하시면 1을 입력해주세요 (원하지 않을 시 0) : ");
        int moredetail = Integer.parseInt(scan.next());
        if (moredetail == WANT_DETAIL) {
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
}
